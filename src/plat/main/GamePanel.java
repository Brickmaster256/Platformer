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
	
	private float deltaX = 100;
	private float deltaY = 100;
	private float xDir = 0.003f;
	private float yDir = 0.003f;
	private int frames = 0;
	private long lastCheck = 0;
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
		
		updateRectangle();
		graphics.setColor(Color.red);
		graphics.fillRect((int)deltaX, (int)deltaY, 200, 50);
		
		
		
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
		deltaX += xDir;
		if (deltaX > 400 || deltaX < 0)
		{
			deltaX *= -1;
		}
		
		deltaY += yDir;
		if(deltaY > 400 || deltaY < 0)
		{
			yDir *= -1;
		}
		
		
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
