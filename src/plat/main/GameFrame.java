package plat.main;

import javax.swing.JFrame;

public class GameFrame extends JFrame
{
	private Game app;
	
	public GameFrame(Game app)
	{
		super();
		this.app = app;
		
		
	}
	private void setupFrame()
	{
		this.setContentPane(rootPane);
		this.setSize(400, 400);
	}
}
