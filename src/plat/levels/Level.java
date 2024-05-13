package plat.levels;

/**
 * creates a simple level layout with the dimesions and the data type
 */

public class Level
{
	private int[][] levelData;
			
			
	public Level(int[][] levelData)
	{
		this.levelData = levelData;
	}
	
	public int getSpriteIndex(int height, int width)
	{
		return levelData[width][height];
	}
	public int[][] getLevelData()
	{
		return levelData;
	}
}
