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
				panel.getGame().getPlayer().setUp(true);
				break;
			}	
			case KeyEvent.VK_A:
			{
				panel.getGame().getPlayer().setLeft(true);
				break;
			}
			case KeyEvent.VK_S:
			{
				panel.getGame().getPlayer().setDown(true);
				break;
			}
			case KeyEvent.VK_D:
			{	
				panel.getGame().getPlayer().setRight(true);
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
			{	
				panel.getGame().getPlayer().setUp(false);
			}
			case KeyEvent.VK_A:
			{	
				panel.getGame().getPlayer().setLeft(false);
			}
			case KeyEvent.VK_S:
			{	
				panel.getGame().getPlayer().setDown(false);
			}
			case KeyEvent.VK_D:
			{	
				panel.getGame().getPlayer().setRight(false);
			}
		}
	}
	
}
