package plat.utilz;

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
}
