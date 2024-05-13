package plat.utilz;

import java.awt.geom.Rectangle2D;

import plat.main.Game;

/**
 * this class has different methods used to help process 
 */
public class HelpMethods 
{
	/**
	 * checks if the the ground is solid or not
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param lvlData
	 * @return
	 */
	public static boolean CanMoveHere(float x, float y, float width, float height, int[][] lvlData) {
		if (!IsSolid(x, y, lvlData))
			if (!IsSolid(x + width, y + height, lvlData))
				if (!IsSolid(x + width, y, lvlData))
					if (!IsSolid(x, y + height, lvlData))
						return true;
		return false;
	}
	/**
	 * checks if a direction is solid
	 * @param x
	 * @param y
	 * @param lvlData
	 * @return
	 */
	private static boolean IsSolid(float x, float y, int[][] lvlData) 
	{
		if (x < 0 || x >= Game.GAME_WIDTH)
		{
			return true;
		}
			
		if (y < 0 || y >= Game.GAME_HEIGHT)
		{
			return true;
		}
			
		float xIndex = x / Game.TILES_SIZE;
		float yIndex = y / Game.TILES_SIZE;
		int value = lvlData[(int) yIndex][(int) xIndex];
		if (value >= 48 || value < 0 || value != 11)
		{
			return true;
		}
			
		return false;
	}

	/**
	 * check is there is an entity next to the wall
	 * @param hitbox
	 * @param xSpeed
	 * @return
	 */
	public static float GetEntityXPosNextToWall(Rectangle2D.Float hitbox, float xSpeed) 
	{
		int currentTile = (int) (hitbox.x / Game.TILES_SIZE);
		if (xSpeed > 0) 
		{
			// Right
			int tileXPos = currentTile * Game.TILES_SIZE;
			int xOffset = (int) (Game.TILES_SIZE - hitbox.width);
			return tileXPos + xOffset - 1;
		} else
		{
			// Left
			return currentTile * Game.TILES_SIZE;
		}
			
	}
	/**
	 * checks if the floor ends or not
	 * @param hitbox
	 * @param airSpeed
	 * @return
	 */
	public static float GetEntityYPosUnderRoofOrAboveFloor(Rectangle2D.Float hitbox, float airSpeed) 
	{
		int currentTile = (int) (hitbox.y / Game.TILES_SIZE);
		if (airSpeed > 0){
			// Falling - touching floor
			int tileYPos = currentTile * Game.TILES_SIZE;
			int yOffset = (int) (Game.TILES_SIZE - hitbox.height);
			return tileYPos + yOffset - 1;
		} else
		{
			// Jumping
			return currentTile * Game.TILES_SIZE;
		}
			

	}

	/**
	 * checks it the entity is on  the floor
	 * @param hitbox
	 * @param lvlData
	 * @return
	 */
	public static boolean IsEntityOnFloor(Rectangle2D.Float hitbox, int[][] lvlData){
		// Check the pixel below bottomleft and bottomright
		if (!IsSolid(hitbox.x, hitbox.y + hitbox.height + 1, lvlData))
		{
			if (!IsSolid(hitbox.x + hitbox.width, hitbox.y + hitbox.height + 1, lvlData))
			{
				return false;
			}

		}
			

		return true;

	}

}
