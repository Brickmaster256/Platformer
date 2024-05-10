package plat.main;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.JFrame;

public class GameFrame extends JFrame
{
	private JFrame jframe;
	private GamePanel panel;
	private Game game;
	
	public GameFrame(GamePanel panel) 
	{
		super();
		this.panel = panel;
		
		setupFrame();
		
		//oldSetupFrame(panel);
		

	}
	
	private void oldSetupFrame(GamePanel panel)
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
	
	private void setupFrame()
	{
		this.setContentPane(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		this.pack();
		this.addWindowFocusListener(new WindowFocusListener()
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
