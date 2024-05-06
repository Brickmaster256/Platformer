package plat.gamestates;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import plat.main.Game;
import plat.ui.MenuButton;

public class Menu extends State implements Statemethods
{
	private MenuButton[] buttons = new MenuButton[3];
	
	public Menu(Game game)
	{
		super(game);
		loadButtons();
	}

	private void loadButtons()
	{
		buttons[0] = new MenuButton(Game.GAME_WIDTH / 2, (int) (150 * Game.SCALE), 0, Gamestate.PLAYING);
		buttons[0] = new MenuButton(Game.GAME_WIDTH / 2, (int) (150 * Game.SCALE), 0, Gamestate.OPTIONS);
		buttons[0] = new MenuButton(Game.GAME_WIDTH / 2, (int) (150 * Game.SCALE), 0, Gamestate.QUIT);
	}

	@Override
	public void update()
	{
		System.out.println("");
		
	}

	@Override
	public void draw(Graphics graphics)
	{
		graphics.setColor(Color.black);
		graphics.drawString("MENU", Game.GAME_WIDTH / 2, 200);
	}

	@Override
	public void mouseClicked(MouseEvent clicked)
	{
		
		
	}

	@Override
	public void mouseMoved(MouseEvent event)
	{
		
	}

	@Override
	public void mouseReleased(MouseEvent event)
	{
		
		
	}

	@Override
	public void mousePressed(MouseEvent event)
	{
		
		
	}

	@Override
	public void keyPressed(KeyEvent event)
	{
		if(event.getKeyCode() == KeyEvent.VK_ENTER)
		{
			Gamestate.state = Gamestate.PLAYING;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent released)
	{
		
		
	}

	
	
}
