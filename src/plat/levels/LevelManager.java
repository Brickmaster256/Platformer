package plat.levels;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import plat.main.Game;
import plat.utilz.LoadSave;

public class LevelManager
{
	private Game game;
	private BufferedImage[] levelSprite;
	
	public LevelManager(Game game)
	{
		this.game = game;
//		levelSprite = LoadSave.GetSpriteAtlas(LoadSave.LEVEL_ATLAS);
		
		importOutsideSprites();
	}
	
	
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


	public void draw(Graphics graphics)
	{
		graphics.drawImage(levelSprite[2],  0, 0, null);
	}
	public void update()
	{
		
	}
}
