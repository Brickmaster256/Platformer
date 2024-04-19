package plat.main;

import javax.swing.JPanel;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import plat.inputs.KeyboardInputs;
import plat.inputs.MouseInputs;


public class GamePanel extends JPanel
{
	private Game app;
	private MouseInputs mouse;
	
	private int deltaX = 0;
	private int deltaY = 0;
	
	public GamePanel(Game app)
	{
		super();
		
		this.mouse = new MouseInputs(this);
		
		setupPanel();
		setupListeners();
		setupLayout();
	}
	
	@Override
	protected void paintComponent(Graphics graphics)
	{
		super.paintComponent(graphics);
		graphics.fillRect(100 + deltaX, 100 + deltaY, 200, 50);
	}
	
	public void changeDeltaX(int value)
	{
		this.deltaX += value;
		repaint();
	}
	public void changeDeltaY(int value)
	{
		this.deltaY += value;
		repaint();
	}
	
	public void setRectPos(int xPos, int yPos)
	{
		
	}
	
	private void setupPanel()
	{
		
	}
	private void setupListeners()
	{
		addKeyListener(new KeyboardInputs(this));
		addMouseListener(mouse);
		addMouseMotionListener(mouse);
	}
	private void setupLayout()
	{
		
	}
}
