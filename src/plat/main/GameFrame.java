package plat.main;

import javax.swing.JFrame;

public class GameFrame extends JFrame
{
	private Game app;
	private GamePanel panel;
	
	public GameFrame(Game app)
	{
		super();
		this.app = app;
		this.panel = new GamePanel(this.app);
		setupFrame();
		
	}
	private void setupFrame()
	{
		this.setContentPane(panel);
		this.setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Platformer");
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
