package plat.entities;

import static plat.utilz.Constants.Directions.DOWN;
import static plat.utilz.Constants.Directions.LEFT;
import static plat.utilz.Constants.Directions.RIGHT;
import static plat.utilz.Constants.Directions.UP;
import static plat.utilz.Constants.PlayerConstants.IDLE;
import static plat.utilz.Constants.PlayerConstants.RUNNING;
import static plat.utilz.Constants.PlayerConstants.getSpriteAmount;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class Player extends Entity
{
	private BufferedImage[][] animations;
	private int animationTick, animationIndex, animationSpeed = 15;
	private int playerAction = IDLE;
	private int playerDir = -1;
	private boolean moving = false;
	public Player(float xDelta, float yDelta)
	{
		super(xDelta, yDelta);
		loadAnimations();
	}
	
	public void update()
	{
		updateAnimationTick();
		setAnimation();
		updatePosition();
	}
	
	public void render(Graphics graphics)
	{
		graphics.drawImage(animations[playerAction][animationIndex], (int)xDelta, (int)yDelta, 128, 80, null);
	}
	
	private void loadAnimations()
	{
		InputStream inputStream = getClass().getResourceAsStream("/res/player_sprites.png");

		try 
		{
			BufferedImage image = ImageIO.read(inputStream);
			
			animations = new BufferedImage[9][6];
			for(int outerIndex = 0; outerIndex < animations.length; outerIndex++)
			{
				for(int index = 0; index < animations[outerIndex].length; index++)
				{
					animations[outerIndex][index] = image.getSubimage( index * 64, outerIndex * 40, 64, 40);
				}
			}
		} 
		catch (IOException error) 
		{
			error.printStackTrace();
		}
		
		
		
		
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
	
	private void updatePosition()
	{
		if(moving)
		{
			switch(playerDir)
			{
				case LEFT:
				{
					xDelta -= 3;
					break;
				}	
				case UP:
				{
					yDelta -= 3;
					break;
				}
				case RIGHT:
				{
					xDelta += 3;
					break;
				}
				case DOWN:
				{
					yDelta += 3;
					break;
				}
					
			}
		}
		
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
