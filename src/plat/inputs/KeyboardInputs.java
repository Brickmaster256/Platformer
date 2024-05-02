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
		
		
	}
	
	@Override
	public void keyReleased(KeyEvent released) 
	{
		
	}
	
}
