package plat.ui;

import plat.gamestates.Gamestate;

public class MenuButton
{
	private int xPosition, yPosition, rowIndex;
	private Gamestate state;
	
	public MenuButton(int xPosition, int yPosition, int rowIndex, Gamestate state)
	{
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.rowIndex = rowIndex;
		this.state = state;
	}
}
