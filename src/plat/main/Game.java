package plat.main;

import java.awt.Graphics;

import plat.entities.Player;
import plat.levels.LevelManager;

public class Game implements Runnable
{
	private GameFrame frame;
	private GamePanel panel;
	private Thread gameThread;
	private final int FPS_SET = 120;
	private final int UPS_SET = 200;
	
	private Player player;
	private LevelManager levelManager;
	
	public final static int TILES_DEFAULT_SIZE = 32;
	public final static float SCALE = 2f;
	public final static int TILES_IN_WIDTH = 26;
	public final static int TILES_IN_HEIGHT = 14;
	public final static int TILES_SIZE = (int) (TILES_DEFAULT_SIZE * SCALE);
	public final static int GAME_WIDTH = TILES_SIZE * TILES_IN_WIDTH;
	public final static int GAME_HEIGHT = TILES_SIZE * TILES_IN_HEIGHT;
	
	public Game() 
	{
		initClasses();
		panel = new GamePanel(this);
		frame = new GameFrame(panel);
		panel.requestFocus();
		
		
		startGameLoop();
		
	}
	
	private void initClasses()
	{
		levelManager = new LevelManager(this);
		player = new Player(200, 200, (int) (64 * SCALE), (int) (40 * SCALE));
		player.loadLevelData(levelManager.getCurrentLevel().getLevelData());
	}

	private void startGameLoop()
	{
		gameThread = new Thread(this);
		gameThread.start();
	}
	public void update()
	{
		
		levelManager.update();
		player.update();
	}
	
	public void render(Graphics graphics)
	{
		player.render(graphics);
		levelManager.draw(graphics);
	}

	@Override
	public void run() 
	{
		double timePerFrame = 1000000000.0 / FPS_SET;
		double timePerUpdate = 1000000000.0 / UPS_SET;
		
		long previousTime = System.nanoTime();
		
		int frames = 0;
		int updates = 0;
		long lastCheck = System.currentTimeMillis();
		
		double deltaU = 0;
		double deltaF = 0;
		
		while(true)
		{
			
			
			long currentTime = System.nanoTime();
			
			deltaU += (currentTime - previousTime) / timePerUpdate;
			deltaF += (currentTime - previousTime) / timePerFrame;
			previousTime = currentTime;
			
			if(deltaU >= 1)
			{
				update();
				updates++;
				deltaU--;
			}
			
			if(deltaF >= 1)
			{
				panel.repaint();
				frames++;
				deltaF--;
			}
		
			if(System.currentTimeMillis() - lastCheck >= 1000)
			{
				lastCheck = System.currentTimeMillis();
				System.out.println("FPS: " + frames + " | UPS: " + updates);
				frames = 0;
				updates = 0;
			}
			
		}
		
	}
	
	public void windowLostFocus()
	{
		player.resetDirBooleans();
	}
	
	public Player getPlayer()
	{
		return player;
	}
}
