package plat.entities;

import static plat.utilz.Constants.Directions.DOWN;
import static plat.utilz.Constants.Directions.LEFT;
import static plat.utilz.Constants.Directions.RIGHT;
import static plat.utilz.Constants.Directions.UP;
import static plat.utilz.Constants.PlayerConstants.*;

import static plat.utilz.Constants.PlayerConstants.getSpriteAmount;
import static plat.utilz.HelpMethods.CanMoveHere;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import plat.main.Game;
import plat.utilz.LoadSave;

public class Player extends Entity
{
	private BufferedImage[][] animations;
	private int animationTick, animationIndex, animationSpeed = 30;
	private int playerAction = IDLE;
	private boolean moving = false, attacking = false;;
	private boolean left, right, up, down;
	private float playerSpeed = 1.0f;
	private int[][] levelData;
	private float xDrawOffset = 21 * Game.SCALE;
	private float yDrawOffset = 4 * Game.SCALE;
	
	
	public Player(float xDelta, float yDelta, int width, int height)
	{
		super(xDelta, yDelta, width, height);
		loadAnimations();
		initHitbox(xDelta, yDelta, 20 * Game.SCALE, 28 * Game.SCALE);
	}
	
	public void update()
	{
		updatePosition();
		
		updateAnimationTick();
		setAnimation();
		
	}
	
	public void render(Graphics graphics)
	{
		graphics.drawImage(animations[playerAction][animationIndex], (int)(hitbox.x - xDrawOffset), (int)(hitbox.y - yDrawOffset), width, height, null);
		drawHitbox(graphics);
	}
	
	private void loadAnimations()
	{
		
			BufferedImage image = LoadSave.GetSpriteAtlas(LoadSave.PLAYER_ATLAS);
			
			animations = new BufferedImage[9][6];
			for(int outerIndex = 0; outerIndex < animations.length; outerIndex++)
			{
				for(int index = 0; index < animations[outerIndex].length; index++)
				{
					animations[outerIndex][index] = image.getSubimage( index * 64, outerIndex * 40, 64, 40);
				}
			}
		
		
		
		
	}
	public void loadLevelData(int[][] levelData)
	{
		this.levelData = levelData;
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
		if (!left && !right && !up && !down)
		{
			return;
		}
		
		float xSpeed = 0, ySpeed = 0;
		
		if(left && !right)
		{
			xSpeed -= playerSpeed;
			
		}
		else if (right && !left)
		{
			xSpeed += playerSpeed;
			
		}
		
		if (up && !down)
		{
			ySpeed -= playerSpeed;
			
		}
		else if (down && !up)
		{
			ySpeed += playerSpeed;
			
		}
		
		if(CanMoveHere(hitbox.x + xSpeed, hitbox.y + ySpeed, hitbox.width, hitbox.height, levelData))
		{
			hitbox.x += xSpeed;
			hitbox.y += ySpeed;
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
