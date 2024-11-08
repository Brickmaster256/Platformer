package plat.entities;



import static plat.utilz.Constants.PlayerConstants.*;
import static plat.utilz.Constants.PlayerConstants.getSpriteAmount;

import static plat.utilz.HelpMethods.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import plat.main.Game;
import plat.utilz.LoadSave;

/**
 * this class process the player and its actions
 */

public class Player extends Entity 
{
	/**
	 * Data members responsible for animation
	 */
	private BufferedImage[][] animations;
	private int animationTick, animationIndex, animationSpeed = 25;
	private int playerAction = IDLE;
	private boolean moving = false, attacking = false;
	
	/**
	 * data members responsible for movement
	 */
	private boolean left, up, right, down, jump;
	private float playerSpeed = 1.0f * Game.SCALE;
	private int[][] lvlData;
	private float xDrawOffset = 21 * Game.SCALE;
	private float yDrawOffset = 4 * Game.SCALE;

	// Jumping / Gravity
	private float airSpeed = 0f;
	private float gravity = 0.04f * Game.SCALE;
	private float jumpSpeed = -2.25f * Game.SCALE;
	private float fallSpeedAfterCollision = 0.5f * Game.SCALE;
	private boolean inAir = false;

	/**
	 * initializes the player
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public Player(float x, float y, int width, int height) 
	{
		super(x, y, width, height);
		loadAnimations();
		
		initHitbox(x, y,(int) (20 * Game.SCALE),(int) (27 * Game.SCALE));

	}
	
	/**
	 * calls all the update functions
	 */
	public void update() 
	{
		updatePos();
		updateAnimationTick();
		setAnimation();
	}
	
	/**
	 * renders the character
	 * @param graphics
	 */
	public void render(Graphics graphics) 
	{
		graphics.drawImage(animations[playerAction][animationIndex], (int) (hitbox.x - xDrawOffset), (int) (hitbox.y - yDrawOffset), width, height, null);
		
//		drawHitbox(g);
	}
	/**
	 * cycles through animation
	 */
	private void updateAnimationTick()
{
		animationTick++;
		if (animationTick >= animationSpeed) 
		{
			animationTick = 0;
			animationIndex++;
			if (animationIndex >= getSpriteAmount(playerAction)) 
			{
				animationIndex = 0;
				attacking = false;
			}
		}
	}
	
	/**
	 * switches animation
	 */
	private void setAnimation() 
	{
		int startAni = playerAction;
		if (moving)
		{
			playerAction = RUNNING;
		}	
		else
		{
			playerAction = IDLE;
		}
		
		if (inAir) 
		{
			if (airSpeed < 0)
			{
				playerAction = JUMP;
			}	
			else
			{
				playerAction = FALLING;	
			}	
		}

		if (attacking)
		{
			playerAction = ATTACK_ONE;
		}
			

		if (startAni != playerAction)
		{
			resetanimationTick();
		}
			
	}
	
	/**
	 * resets animation loop
	 */
	private void resetanimationTick() 
	{
		animationTick = 0;
		animationIndex = 0;
	}

	/**
	 * updates the position of the sprite and hitbox
	 */
	private void updatePos() 
	{
		moving = false;
		

		if (jump)
		{
			jump();
		}
		if (!left && !right && !inAir)
		{
			
			return;
		}

		
		float xSpeed = 0;

		if (left)
		{
			xSpeed -= playerSpeed;
		}
		if (right)
		{
			xSpeed += playerSpeed;
		}

		if (!inAir)
		{
			if (!IsEntityOnFloor(hitbox, lvlData))
			{
				inAir = true;
			}
		}

		if (inAir) 
		{
			if (CanMoveHere(hitbox.x, hitbox.y + airSpeed, hitbox.width, hitbox.height, lvlData)) 
			{
				hitbox.y += airSpeed;
				airSpeed += gravity;
				updateXPos(xSpeed);
			} 
			else
			{
				hitbox.y = GetEntityYPosUnderRoofOrAboveFloor(hitbox, airSpeed);
				if (airSpeed > 0)
					resetInAir();
				else
					airSpeed = fallSpeedAfterCollision;
				updateXPos(xSpeed);
			}

		} 
		else
		{
			updateXPos(xSpeed);
		}
		moving = true;
	}
	
	/**
	 * lets the character to jump
	 */
	private void jump() 
	{
		if (inAir)
			return;
		inAir = true;
		airSpeed = jumpSpeed;
	}
	
	
	/**
	 * resets fall speed
	 */
	private void resetInAir()
	{
		inAir = false;
		airSpeed = 0;
	}
		
	/**
	 * updates the fallspeed 
	 * @param xSpeed
	 */
	private void updateXPos(float xSpeed) 
	{
		if (CanMoveHere(hitbox.x + xSpeed, hitbox.y, hitbox.width, hitbox.height, lvlData)) 
		{
			hitbox.x += xSpeed;
			
		} 
		else 
		{
			hitbox.x = GetEntityXPosNextToWall(hitbox, xSpeed);
		}

	}
	
	/**
	 * loads the character animation
	 */
	private void loadAnimations() 
	{
		BufferedImage img = LoadSave.GetSpriteAtlas(LoadSave.PLAYER_ATLAS);
		animations = new BufferedImage[9][6];
		for (int j = 0; j < animations.length; j++)
		{
			for (int i = 0; i < animations[j].length; i++)
			{
				animations[j][i] = img.getSubimage(i * 64, j * 40, 64, 40);
			}
		}
	}
	
	/**
	 * loads the current level
	 * @param lvlData
	 */
	public void loadLevelData(int[][] lvlData) 
	{
		this.lvlData = lvlData;
		if (!IsEntityOnFloor(hitbox, lvlData))
		{
			inAir = true;
		}

	}
	/**
	 * resets the direction of the character
	 */
	public void resetDirBooleans() 
	{
		left = false;
		right = false;
		up = false;
		down = false;
	}
	
	/**
	 * getters and setters
	 * @param attacking
	 */
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
	public boolean isUp() 
	{
		return up;
	}
	public void setUp(boolean up) 
	{
		this.up = up;
	}
	public boolean isRight() 
	{
		return right;
	}
	public void setRight(boolean right) 
	{
		this.right = right;
	}
	public boolean isDown() 
	{
		return down;
	}
	public void setDown(boolean down) 
	{
		this.down = down;
	}


	public void setJump(boolean jump) 
	{
		this.jump = jump;
	}

}
