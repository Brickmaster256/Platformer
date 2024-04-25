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

import static plat.utilz.Constants.PlayerConstants.*;
import static plat.utilz.Constants.Directions.*;

public class GamePanel extends JPanel
{
	private MouseInputs mouseInputs;
	private double xDelta = 100, yDelta = 100;
	private BufferedImage image, subImage;
	private BufferedImage[][] animations;
	private int animationTick, animationIndex, animationSpeed = 15;
	private int playerAction = IDLE;
	private int playerDir = -1;
	private boolean moving = false;
	
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

	
	public void setDirection(int direction)
	{
		this.playerDir = direction;
		moving = true;
	}
	
	public void setMoving(boolean moving)
	{
		this.moving = moving;
	}
	
	
	public void updateAnimationTick()
	{
		animationTick++;
		if (animationTick >= animationSpeed)
		{
			animationTick = 0;
			animationIndex++;
			if(animationIndex >= getSpriteAmount(playerAction))
				{
					animationIndex = 0;
				}
		}
	}
	
	@Override
	protected void paintComponent(Graphics graphics) 
	{
		super.paintComponent(graphics);
		
		updateAnimationTick();
		setAnimation();
		
		graphics.drawImage(animations[playerAction][animationIndex], (int)xDelta, (int)yDelta, 128, 80, null);
		
		
		
	}

	private void setAnimation()
	{
		if(moving)
		{
			playerAction = RUNNING;
		}
		else
		{
			playerAction = IDLE;
		}
		
	}
	
	
}
