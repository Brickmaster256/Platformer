package plat.gamestates;

import java.awt.event.MouseEvent;

import plat.main.Game;
import plat.ui.MenuButton;

public class State
{
	
	protected Game game;
	
	public State(Game game)
	{
		this.game = game;
	}
	
	public boolean isIn(MouseEvent event, MenuButton menuButton)
	{
		return menuButton.getBounds().contains(event.getX(), event.getY());
	}
	
	public Game getGame()
	{
		return game;
	}
}
