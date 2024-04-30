package plat.utilz;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class LoadSave
{
	public static BufferedImage GetPlayerAtlas()
	{
		BufferedImage image = null;
		InputStream inputStream = LoadSave.class.getResourceAsStream("/res/player_sprites.png");

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
