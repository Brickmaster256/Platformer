package plat.utilz;

import java.util.ArrayList;

/**
 * suppose to turn the data into the a 2d array
 */
public class Utilz
{
	public static int[][] ArrayListTo2Dint(ArrayList<Integer> list, int ySize, int xSize)
	{
		int [][] newArray = new int[ySize][ySize];
		
		for (int row = 0; row < newArray.length; row++)
		{
			for (int col = 0; col < newArray[row].length; col++)
			{
				int index = row * ySize + col;
				newArray[row][col] = list.get(index);
			}
		}
		return newArray;
	}
}
