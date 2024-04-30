package plat.utilz;

import plat.main.Game;

public class HelpMethods
{
	public static boolean CanMoveHere(float xPosition, float yPosition, int width, int height, int[][] levelData)
	{
		
	}
	
	private static boolean IsSolid(float xPosition, float yPosition, int[][] levelData)
	{
		if(xPosition < 0 || xPosition > Game.GAME_WIDTH)
		{
			return true;
		}
		if(yPosition < 0 || yPosition > Game.GAME_HEIGHT) {
			return true;
		}
		
		float xIndex = xPosition / Game.TILES_SIZE;
		float yIndex = yPosition / Game.TILES_SIZE;
		
		int value = levelData[(int) xIndex][(int) yIndex];
		
		if(value >= 48 || value < 0 || value == 1)
		{
			return true;
		}
		return false;
	}
}
