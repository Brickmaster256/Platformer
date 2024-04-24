package plat.main;



public class Game 
{
	private GameFrame frame;
	private GamePanel panel;
	
	public Game() 
	{
		panel = new GamePanel();
		frame = new GameFrame(panel);
		panel.requestFocus();


	}
}
