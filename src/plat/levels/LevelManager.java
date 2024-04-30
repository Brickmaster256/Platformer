package plat.levels;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import plat.main.Game;
import plat.utilz.LoadSave;

public class LevelManager
{
	private Game game;
	private BufferedImage levelSprite;
	
	public LevelManager(Game game)
	{
		this.game = game;
		levelSprite = LoadSave.GetSpriteAtlas(LoadSave.LEVEL_ATLAS);
	}
	
	
	public void draw(Graphics graphics)
	{
		graphics.drawImage(levelSprite,  0, 0, null);
	}
	public void update()
	{
		
	}
}
