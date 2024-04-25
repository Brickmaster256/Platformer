package plat.main;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;



import plat.inputs.KeyboardInputs;
import plat.inputs.MouseInputs;


public class GamePanel extends JPanel
{
	private MouseInputs mouseInputs;
	private double xDelta = 100, yDelta = 100;
	private BufferedImage image, subImage;
	private BufferedImage[][] animations;
	private int animationTick, animationIndex, animationSpeed = 15;
	
	
	public GamePanel() 
	{
		
		mouseInputs = new MouseInputs(this);
		
		
		importImg();
		loadAnimations();
		
		setPanelSize();
		addKeyListener(new KeyboardInputs(this));
		addMouseListener(mouseInputs);
		addMouseMotionListener(mouseInputs);

	}
	
	private void loadAnimations()
	{
		animations = new BufferedImage[9][6];
		for(int outerIndex = 0; outerIndex < animations.length; outerIndex++)
		{
			for(int index = 0; index < animations[outerIndex].length; index++)
			{
				animations[outerIndex][index] = image.getSubimage( index * 64, outerIndex * 40, 64, 40);
			}
		}
		
		
	}
	
	private void importImg() {
		InputStream inputStream = getClass().getResourceAsStream("/res/player_sprites.png");

		try 
		{
			image = ImageIO.read(inputStream);
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
	
	
	public void updateAnimationTick()
	{
//		animationTick++;
//		if (animationTick >= animationSpeed)
//		{
//			animationTick = 0;
//			animationIndex++;
//			if(animationIndex >= animations.length)
//				{
//					animationIndex = 0;
//				}
//		}
	}
	
	@Override
	protected void paintComponent(Graphics graphics) 
	{
		super.paintComponent(graphics);
		
		updateAnimationTick();
		
//		subImage = image.getSubimage(1 * 64, 8 * 40, 64, 40);
		graphics.drawImage(animations[7][1], (int)xDelta, (int)yDelta, 128, 80, null);
		
		
		
	}
	
	
}
