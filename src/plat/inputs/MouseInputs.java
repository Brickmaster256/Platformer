package plat.inputs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import plat.main.GamePanel;

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
		
	}

	@Override
	public void mouseClicked(MouseEvent clicked) 
	{
		System.out.println("mouse clicked");
		
	}

	@Override
	public void mousePressed(MouseEvent pressed) 
	{
	
		
	}

	@Override
	public void mouseReleased(MouseEvent released) 
	{
		
		
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
