package plat.levels;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import plat.main.Game;
import plat.utilz.LoadSave;
/**
 * manages the level
 */

public class LevelManager
{
	/**
	 * creates data members that the get the level and visuals for the level
	 */
	private Game game;
	private BufferedImage[] levelSprite;
	private Level levelOne;
	
	/**
	 * initializes the spects of the level
	 * @param game
	 */
	public LevelManager(Game game)
	{
		this.game = game;
		importOutsideSprites();
		levelOne = new Level(LoadSave.GetLevelData());
	}
	
	/**
	 * grabs thes sprites used for the levle
	 */
	private void importOutsideSprites()
	{
		levelSprite = new BufferedImage[48];
		BufferedImage image = LoadSave.GetSpriteAtlas(LoadSave.LEVEL_ATLAS);
		for(int firstIndex = 0; firstIndex < 4; firstIndex++)
		{
			for(int secondIndex = 0; secondIndex < 12; secondIndex++)
			{
				int index = firstIndex * 12 + secondIndex;
				levelSprite[index] = image.getSubimage(secondIndex * 32, firstIndex * 32, 32, 32);
			}
		}
	}
	
	
	/**
	 * draws the level
	 * @param graphics
	 */
	public void draw(Graphics graphics)
	{
		for(int height = 0; height < Game.TILES_IN_HEIGHT; height++)
		{
			for(int width = 0; width < Game.TILES_IN_WIDTH; width++)
			{
				int index = levelOne.getSpriteIndex(width, height);
				graphics.drawImage(levelSprite[index],  Game.TILES_SIZE * width, Game.TILES_SIZE * height, Game.TILES_SIZE, Game.TILES_SIZE, null);
			}
		}
		
	}
	/**
	 * updates the level
	 */
	public void update()
	{
		
	}
	/**
	 * returns the level data
	 * @return
	 */
	public Level getCurrentLevel()
	{
		return levelOne;
				
	}
}
