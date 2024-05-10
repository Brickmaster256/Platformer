package plat.main;

import java.awt.Graphics;


import plat.gamestates.Gamestate;
import plat.gamestates.Playing;
import plat.utilz.LoadSave;
import plat.gamestates.Menu;

/**
 *  the class is basically the controller.
 *  it is responsible for calling the update functions and standardizing the frames and updates
 */
public class Game implements Runnable
{
	/**
	 * data member that get the other components of classes
	 */
	private GameFrame frame;
	private GamePanel panel;
	private Thread gameThread;
	private final int FPS_SET = 120;
	private final int UPS_SET = 200;
	
	private Playing playing;
	private Menu menu;
	
	/**
	 * grates the size standard for the game
	 */
	public final static int TILES_DEFAULT_SIZE = 32;
	public final static float SCALE = 1.5f;
	public final static int TILES_IN_WIDTH = 26;
	public final static int TILES_IN_HEIGHT = 14;
	public final static int TILES_SIZE = (int) (TILES_DEFAULT_SIZE * SCALE);
	public final static int GAME_WIDTH = TILES_SIZE * TILES_IN_WIDTH;
	public final static int GAME_HEIGHT = TILES_SIZE * TILES_IN_HEIGHT;
	
	/**
	 * initializes the frame and panel and calls the initClasses method
	 */
	public Game() 
	{
		initClasses();
		panel = new GamePanel(this);
		frame = new GameFrame(panel);
		panel.requestFocus();
		
		
		startGameLoop();
		
	}
	/**
	 * initializes the classes
	 */
	private void initClasses()
	{
		menu = new Menu(this);
		playing = new Playing(this);
	}
	/**
	 * creates a game thread and starts the game
	 */
	private void startGameLoop()
	{
		gameThread = new Thread(this);
		gameThread.start();
	}
	/**
	 * calls the other update functions
	 */
	public void update()
	{
		
		
		
		switch(Gamestate.state) 
		{
			case MENU:
			{
				menu.update();
				break;
			}
			case PLAYING:
			{
				playing.update();
				break;
			}
			case OPTIONS:
			{
				
			}
			case QUIT:
			{
				System.exit(0);
				break;
			}
			default:
			{
				break;
			}
		}
	}
	/**
	 * calls all the other draw/render functions the entities and states have
	 * @param graphics
	 */
	public void render(Graphics graphics)
	{
		
		switch(Gamestate.state) 
		{
			case MENU:
			{
				menu.draw(graphics);
				break;
			}
			case PLAYING:
			{
				playing.draw(graphics);
			
				break;
			}
			default:
			{
				break;
			}
		}
		
	}
	/**
	 * creates the frame rate and update rate
	 */
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
	/**
	 * suspends the game if focus is lost
	 */
	public void windowLostFocus()
	{
		if(Gamestate.state == Gamestate.PLAYING) 
		{
			playing.getPlayer().resetDirBooleans();
		}
	}
	
	/**
	 * the getters of the components
	 * @return
	 */
	public Menu getMenu()
	{
		return menu;
	}
	
	public Playing getPlaying()
	{
		return playing;
	}

	public GameFrame getFrame()
	{
		// TODO Auto-generated method stub
		return frame;
	}
	
	
}
