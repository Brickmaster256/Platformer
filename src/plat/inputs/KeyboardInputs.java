package plat.inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import plat.main.GamePanel;
import static plat.utilz.Constants.Directions.*;

public class KeyboardInputs implements KeyListener 
{
	private GamePanel panel;
	
	public KeyboardInputs(GamePanel panel)
	{
		this.panel = panel;
	}
	
	@Override
 	public void keyTyped(KeyEvent typed) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent pressed) 
	{
		switch(pressed.getKeyCode())
		{
		
			case KeyEvent.VK_W:
			{
				panel.setDirection(UP);
				break;
			}	
			case KeyEvent.VK_A:
			{
				panel.setDirection(LEFT);
				break;
			}
			case KeyEvent.VK_S:
			{
				panel.setDirection(DOWN);
				break;
			}
			case KeyEvent.VK_D:
			{	
				panel.setDirection(RIGHT);
				break;
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent released) 
	{
		switch(released.getKeyCode())
		{
		
			case KeyEvent.VK_W:
			case KeyEvent.VK_A:
			case KeyEvent.VK_S:
			case KeyEvent.VK_D:
			{	
				panel.setMoving(false);
			}
		}
	}
	
}
