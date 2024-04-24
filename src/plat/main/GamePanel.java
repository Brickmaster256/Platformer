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
	private double xDelta = 100, yDelta = 100;
	private double xDir = 0.003f, yDir = 0.003f;
	private int frames = 0;
	private long lastCheck = System.currentTimeMillis();
	private Random random;
	private Color color = new Color(0,0,0);

	public GamePanel() 
	{
		random = new Random();
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
	
	@Override
	protected void paintComponent(Graphics graphics) 
	{
		super.paintComponent(graphics);
		
		updateRectangle();
		graphics.setColor(color);
		graphics.fillRect((int)xDelta, (int)yDelta, 200, 50);

		frames++;
		if(System.currentTimeMillis() - lastCheck >= 1000)
		{
			lastCheck = System.currentTimeMillis();
			System.out.println("FPS: " + frames);
			frames = 0;
		}
		
		repaint();
	}
	
	private void updateRectangle()
	{
		xDelta += xDir;
		if(xDelta > 400 || xDelta < 0)
		{
			xDir *= -1;
			color = getRandomColor();
		}
		
		yDelta += yDir;
		if(yDelta > 400 || yDelta < 0)
		{
			yDir *= -1;
		}
	}
	
	private Color getRandomColor()
	{
		int red = random.nextInt(255);
		int green = random.nextInt(255);
		int blue = random.nextInt(255);
		
		
		return new Color(red, green, blue);
	}
}
