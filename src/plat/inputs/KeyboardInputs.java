package plat.inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInputs implements KeyListener 
{

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
			System.out.println("W");
			break;
		case KeyEvent.VK_A:
			System.out.println("A");
			break;
		case KeyEvent.VK_S:
			System.out.println("S");
			break;
		case KeyEvent.VK_D:
			System.out.println("D");
			break;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent released) 
	{
		// TODO Auto-generated method stub
		
	}
	
}
