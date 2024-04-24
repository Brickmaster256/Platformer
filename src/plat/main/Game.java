package plat.main;



public class Game implements Runnable
{
	private GameFrame frame;
	private GamePanel panel;
	private Thread gameThread;
	private final int FPS_SET = 120;
	
	public Game() 
	{
		panel = new GamePanel();
		frame = new GameFrame(panel);
		panel.requestFocus();
		startGameLoop();

	}
	
	private void startGameLoop()
	{
		gameThread = new Thread(this);
		gameThread.start();
	}

	@Override
	public void run() 
	{
		double timePerFrame = 1000000000.0 / FPS_SET;
		long lastFrame = System.nanoTime();
		long now = System.nanoTime();
		while(true)
		{
			now = System.nanoTime();
			if(now - lastFrame >= timePerFrame)
			{
				panel.repaint();
				lastFrame = now;
			}
		}
		
	}
}
