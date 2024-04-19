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
				panel.changeDeltaY(-5);
				break;
			}	
			case KeyEvent.VK_A:
			{
				panel.changeDeltaX(-5);
				break;
			}
			case KeyEvent.VK_S:
			{
				panel.changeDeltaY(5);
				break;
			}
			case KeyEvent.VK_D:
			{	
				panel.changeDeltaX(5);
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
