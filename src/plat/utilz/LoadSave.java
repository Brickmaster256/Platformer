package plat.utilz;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class LoadSave
{
	public static final String PLAYER_ATLAS = "player_sprites.png";
	
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
}
