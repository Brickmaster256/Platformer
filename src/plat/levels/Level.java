package plat.levels;

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
}
