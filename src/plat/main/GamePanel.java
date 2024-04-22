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
	private Game app;
	private MouseInputs mouse;
	
	private float deltaX = 100;
	private float deltaY = 100;
	private float xDir =1f;
	private float yDir = 1f;
	private Color color = new Color(0,0,0);
	private int frames = 0;
	private long lastCheck = 0;
	private Random random;
	
	public GamePanel(Game app)
	{
		super();
		
		this.mouse = new MouseInputs(this);
		this.random = new Random();
		setupPanel();
		setupListeners();
		setupLayout();
	}
	
	@Override
	protected void paintComponent(Graphics graphics)
	{
		super.paintComponent(graphics);
		
		updateRectangle();
		graphics.setColor(color);
		graphics.fillRect((int)deltaX, (int)deltaY, 200, 50);
		
		
		
		
		repaint();
		
	}
	private void updateRectangle()
	{
		deltaX += xDir;
		if (deltaX > 400 || deltaX < 0)
		{
			xDir*= -1;
			color = getRandomColor();
			
		}
		
		deltaY += yDir;
		if(deltaY > 400 || deltaY < 0)
		{
			yDir *= -1;
			color = getRandomColor();
		}
		
		
	}
	private Color getRandomColor()
	{
		int red = random.nextInt(255);
		int blue = random.nextInt(255);
		int green = random.nextInt(255);
		
		return new Color(red, green, blue);
				
				
	}
	
	public void changeDeltaX(int value)
	{
		this.deltaX += value;
		
	}
	public void changeDeltaY(int value)
	{
		this.deltaY += value;
		
	}
	public void setRectPos(int xPos, int yPos)
	{
		this.deltaX = xPos;
		this.deltaY = yPos;
		
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
