package plat.inputs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import plat.gamestates.Gamestate;
import plat.main.GamePanel;

/**
 * this class is responsible for processing some of the mouse inputs
 */

public class MouseInputs implements MouseListener, MouseMotionListener
{
	private GamePanel panel;
	
	public MouseInputs(GamePanel panel)
	{
		this.panel = panel;
	}

	@Override
	public void mouseDragged(MouseEvent dragged) 
	{
		
		
	}

	@Override
	public void mouseMoved(MouseEvent moved) 
	{
		switch(Gamestate.state) 
		{
			case MENU:
			{
				 panel.getGame().getMenu().mouseMoved(moved);
				break;
			}
			case PLAYING:
			{
				panel.getGame().getPlaying().mouseMoved(moved);
				break;
			}
			
			default:
			{
				break;
			}
		
		}
	}

	@Override
	public void mouseClicked(MouseEvent clicked) 
	{
		switch(Gamestate.state) 
		{
			
			case PLAYING:
			{
				panel.getGame().getPlaying().mouseClicked(clicked);
				break;
			}
			
			default:
			{
				break;
			}
		
		}
	}

	@Override
	public void mousePressed(MouseEvent pressed) 
	{
		switch(Gamestate.state) 
		{
			case MENU:
			{
				 panel.getGame().getMenu().mousePressed(pressed);
				break;
			}
			case PLAYING:
			{
				panel.getGame().getPlaying().mousePressed(pressed);
				break;
			}
			
			default:
			{
				break;
			}
		
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent released) 
	{
		switch(Gamestate.state) 
		{
			case MENU:
			{
				 panel.getGame().getMenu().mouseReleased(released);
				break;
			}
			case PLAYING:
			{
				panel.getGame().getPlaying().mouseReleased(released);
				break;
			}
			
			default:
			{
				break;
			}
		
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent entered) 
	{
		
		
	}

	@Override
	public void mouseExited(MouseEvent exited) 
	{
		
		
	}
	
}
