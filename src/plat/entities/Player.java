package plat.entities;

import static plat.utilz.Constants.Directions.DOWN;
import static plat.utilz.Constants.Directions.LEFT;
import static plat.utilz.Constants.Directions.RIGHT;
import static plat.utilz.Constants.Directions.UP;
import static plat.utilz.Constants.PlayerConstants.*;

import static plat.utilz.Constants.PlayerConstants.getSpriteAmount;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class Player extends Entity
{
	private BufferedImage[][] animations;
	private int animationTick, animationIndex, animationSpeed = 30;
	private int playerAction = IDLE;
	private boolean moving = false, attacking = false;;
	private boolean left, right, up, down;
	private float playerSpeed = 1.0f;
	
	
	public Player(float xDelta, float yDelta)
	{
		super(xDelta, yDelta);
		loadAnimations();
	}
	
	public void update()
	{
		updatePosition();
		updateAnimationTick();
		setAnimation();
		
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
	
	private void setAnimation()
	{
		int startAnimation = playerAction;
		
		
		if(moving)
		{
			playerAction = RUNNING;
		}
		else
		{
			playerAction = IDLE;
		}
		
		if(attacking)
		{
			playerAction = ATTACK_ONE;
		}
		
		if(startAnimation != playerAction)
		{
			resetAnimationTick();
		}
		
	}
	
	private void resetAnimationTick()
	{
		animationTick = 0;
		animationIndex = 0;
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
				attacking = false;
			}
		}
	}
	
	private void updatePosition()
	{
		moving = false;
		
		if(left && !right)
		{
			xDelta -= playerSpeed;
			moving = true;
		}
		else if (right && !left)
		{
			xDelta += playerSpeed;
			moving = true;
		}
		
		if (up && !down)
		{
			yDelta -= playerSpeed;
			moving = true;
		}
		else if (down && !up)
		{
			yDelta += playerSpeed;
			moving = true;
		}
		
	}
	
	public void resetDirBooleans()
	{
		left = false;
		right = false;
		up = false;
		down = false;
	}
	
	public void setAttacking(boolean attacking)
	{
		this.attacking = attacking;
	}
	
	public boolean isLeft()
	{
		return left;
	}

	public void setLeft(boolean left)
	{
		this.left = left;
	}

	public boolean isRight()
	{
		return right;
	}

	public void setRight(boolean right)
	{
		this.right = right;
	}

	public boolean isUp()
	{
		return up;
	}

	public void setUp(boolean up)
	{
		this.up = up;
	}

	public boolean isDown()
	{
		return down;
	}

	public void setDown(boolean down)
	{
		this.down = down;
	}

	
}
