package plat.main;



public class Game 
{
	private GameFrame window;
	
	
	public Game()
	{
		this.window = new GameFrame(this);
	}
	public void start()
	{
		System.out.println("Hi");
	}
}
