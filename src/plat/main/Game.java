package plat.main;



public class Game implements Runnable
{
	private GameFrame window;
	private GamePanel panel;
	private Thread gameThread;
	private final int FPS_SET = 120;
	
	public Game()
	{
		this.window = new GameFrame(this);
		this.panel = new GamePanel(this);
		panel.requestFocus();
		startGameLoop();
	}
	public void start()
	{
		
	}
	
	private void startGameLoop()
	{
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	@Override
	public void run() 
	{
		double timePerFrame = 1000000000.0/ FPS_SET;
		long lastFrame = System.nanoTime();
		long now = System.nanoTime();
		
		
		while(true)
		{
			if(now - lastFrame >= timePerFrame)
			{
				panel.repaint();
				lastFrame = now;
			}
		}
		
	}
}
