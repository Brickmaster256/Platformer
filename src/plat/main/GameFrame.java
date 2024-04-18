package plat.main;

import javax.swing.JFrame;

public class GameFrame extends JFrame
{
	private Game app;
	
	public GameFrame(Game app)
	{
		super();
		this.app = app;
		
		setupFrame();
		
	}
	private void setupFrame()
	{
		
		this.setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Platformer");
		this.setVisible(true);
	}
}
