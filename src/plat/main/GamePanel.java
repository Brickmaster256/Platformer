package plat.main;

import javax.swing.JPanel;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import plat.inputs.KeyboardInputs;
import plat.inputs.MouseInputs;


public class GamePanel extends JPanel
{
	private MouseInputs mouseInputs;
	private int xDelta = 100, yDelta = 100;

	public GamePanel() 
	{

		mouseInputs = new MouseInputs(this);
		addKeyListener(new KeyboardInputs(this));
		addMouseListener(mouseInputs);
		addMouseMotionListener(mouseInputs);

	}

	public void changeXDelta(int value) 
	{
		this.xDelta += value;
		
	}

	public void changeYDelta(int value) 
	{
		this.yDelta += value;
		
	}

	public void setRectPos(int xValue, int yValue) 
	{
		this.xDelta = xValue;
		this.yDelta = yValue;
		
	}

	public void paintComponent(Graphics graphics) 
	{
		super.paintComponent(graphics);
		graphics.fillRect(xDelta, yDelta, 200, 50);

		repaint();
	}
	
	
}
