package plat.main;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

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
		jframe.addWindowFocusListener(new WindowFocusListener()
		{
			public void windowLostFocus(WindowEvent lost)
			{
				panel.getGame().windowLostFocus();
			}
			
			public void windowGainedFocus(WindowEvent Gained)
			{
				
			}
		});
		
			
		


	}
}
