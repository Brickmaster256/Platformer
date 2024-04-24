package plat.inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import plat.main.GamePanel;

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
				panel.changeYDelta(-5);
				break;
			}	
			case KeyEvent.VK_A:
			{
				panel.changeXDelta(-5);
				break;
			}
			case KeyEvent.VK_S:
			{
				panel.changeYDelta(5);
				break;
			}
			case KeyEvent.VK_D:
			{	
				panel.changeYDelta(5);
				break;
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent released) 
	{
		// TODO Auto-generated method stub
		
	}
	
}
