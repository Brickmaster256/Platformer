package plat.main;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import plat.inputs.KeyboardInputs;
import plat.inputs.MouseInputs;


public class GamePanel extends JPanel
{
	private MouseInputs mouseInputs;
	private double xDelta = 100, yDelta = 100;
	private BufferedImage img;
	
	public GamePanel() 
	{
		
		mouseInputs = new MouseInputs(this);
		
		
		importImg();
		
		setPanelSize();
		addKeyListener(new KeyboardInputs(this));
		addMouseListener(mouseInputs);
		addMouseMotionListener(mouseInputs);

	}
	
	private void importImg() {
		InputStream is = getClass().getResourceAsStream("/player_sprites.png");

		try 
		{
			img = ImageIO.read(is);
		} 
		catch (IOException error) 
		{
			error.printStackTrace();
		}

	}

	private void setPanelSize()
	{
		Dimension size = new Dimension(1280, 800);
		setMinimumSize(size);
		setPreferredSize(size);
		setMaximumSize(size);
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
		
		graphics.drawImage(img, 0, 0, null);
		
		
		
	}
	
	
}
