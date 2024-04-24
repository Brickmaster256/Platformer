package plat.main;

import javax.swing.JFrame;

public class GameFrame 
{
	private JFrame jframe;
	public GameFrame(GamePanel panel) 
	{
		jframe = new JFrame();
		
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.add(panel);
		jframe.setLocationRelativeTo(null);
		jframe.setResizable(false);
		jframe.pack();
		jframe.setVisible(true);



	}
}
