package plat.utilz;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;

import plat.main.Game;

public class LoadSave
{
	public static final String PLAYER_ATLAS = "player_sprites.png";
	public static final String LEVEL_ATLAS = "outside_sprites.png";
	public static final String LEVEL_ONE_DATA = "level_one_data.png";
	public static final String MENU_BUTTONS = "button_atlas.png";
	public static final String MENU_BACKGROUND = "menu_background.png";
	
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
				int value = color.getRed();
				if (value >= 48)
				{
					value = 0;
				}
				
				levelData[height][width] = value;
			}
		}
		
		return levelData;
	}
	
	private static ArrayList<Integer> ReadFromFile(File file)
	{
		ArrayList<Integer> list = new ArrayList<>();
		
		try
		{
			Scanner scanner = new Scanner(file);
			
			while(scanner.hasNextLine())
			{
				list.add(scanner.nextInt());
			}
			scanner.close();
		}
		catch (FileNotFoundException error)
		{
			error.printStackTrace();
		}
		
		return list;
	}
	
	public static int[][] GetLevelData(String name)
	{
		File levelFile = new File("res/" + name + ".txt");
		
		if (levelFile.exists()) 
		{
			ArrayList<Integer> list = ReadFromFile(levelFile);
			return Utilz.ArrayListTo2Dint(list, 20, 20);
		}
		else
		{
			System.out.println("File: " + name + " does not exists! ");
			return null;
		}
		
		
		
		
	}
	
	

}
