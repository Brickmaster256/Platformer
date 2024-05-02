package plat.utilz;

import java.awt.geom.Rectangle2D;

import plat.main.Game;

public class HelpMethods
{
	public static boolean CanMoveHere(float xPosition, float yPosition, float width, float height, int[][] levelData)
	{
		if (!IsSolid(xPosition, xPosition, levelData))
		{
			if(!IsSolid(xPosition + width, yPosition + height, levelData))
			{
				if(!IsSolid(xPosition + width, yPosition, levelData))
				{
					if(!IsSolid(xPosition, yPosition + height, levelData))
					{
						return true;
					}
				}
			}
		}
		return false;
	}
	
	private static boolean IsSolid(float xPosition, float yPosition, int[][] levelData)
	{
		if(xPosition < 0 || xPosition >= Game.GAME_WIDTH)
		{
			return true;
		}
		if(yPosition < 0 || yPosition >= Game.GAME_HEIGHT) {
			return true;
		}
		
		float xIndex = xPosition / Game.TILES_SIZE;
		float yIndex = yPosition / Game.TILES_SIZE;
		
		int value = levelData[(int) yIndex][(int) xIndex];
		
		if(value >= 48 || value < 0 || value != 11)
		{
			return true;
		}
		return false;
	}
	
	public static float GetEntityXPosNextToWall(Rectangle2D.Float hitbox, float xSpeed)
	{
		int currentTile = (int)(hitbox.x / Game.SCALE);
		if (xSpeed > 0)
		{
			//Right
			int tileXPos = currentTile * Game.TILES_SIZE;
			int xOffset = (int)(Game.TILES_SIZE - hitbox.width);
			return tileXPos + xOffset - 1;
		}
		else
		{
			//Left
			return currentTile * Game.TILES_SIZE;
		}
	}

	public static float GetEntityYPosUnderRoofOrAboveFloor(Rectangle2D.Float hitbox, float airSpeed)
	{
		int currentTile = (int)(hitbox.y / Game.TILES_SIZE);
		if(airSpeed > 0)
		{
			//Falling - toyching floor
			int tileYPos = currentTile * Game.TILES_SIZE;
			int yOffset = (int)(Game.TILES_SIZE - hitbox.height);
			return tileYPos + yOffset - 1;
		}
		else
		{
			//Jumping
			return currentTile * Game.TILES_SIZE;
		}
	}
}
