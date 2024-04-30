package plat.utilz;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import plat.main.Game;

public class LoadSave
{
	public static final String PLAYER_ATLAS = "player_sprites.png";
	public static final String LEVEL_ATLAS = "outside_sprites.png";
	public static final String LEVEL_ONE_DATA = "level_one_data.png";
	
	public static BufferedImage GetSpriteAtlas(String fileName)
	{
		BufferedImage image = null;
		InputStream inputStream = LoadSave.class.getResourceAsStream("/res/" + fileName);

		try 
		{
			image = ImageIO.read(inputStream);
			
		} 
		catch (IOException error) 
		{
			error.printStackTrace();
		}
		finally
		{
			try
			{
				inputStream.close();
			}
			catch (IOException error)
			{
				error.printStackTrace();
			}
		}
		
		return image;
	}
	public static int[][] GetLevelData()
	{
		int[][] levelData = new int[Game.TILES_IN_HEIGHT][Game.TILES_IN_WIDTH];
		BufferedImage image = GetSpriteAtlas(LEVEL_ONE_DATA);
		
		for(int height = 0; height < image.getHeight(); height++)
		{
			for(int width = 0; width < image.getWidth(); width++)
			{
				Color color = new Color(image.getRGB(width,  height));
				levelData[height][width] = color.getRed();
			}
		}
		
		return levelData;
	}

}
