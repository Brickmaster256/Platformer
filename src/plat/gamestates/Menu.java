package plat.gamestates;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import plat.main.Game;
import plat.ui.MenuButton;
import plat.utilz.LoadSave;

public class Menu extends State implements Statemethods
{
	private MenuButton[] buttons = new MenuButton[3];
	private BufferedImage backgroundImage;
	private int menuX, menuY, menuWidth, menuHeight;
	
	public Menu(Game game)
	{
		super(game);
		loadButtons();
		loadBackground();
	}

	private void loadBackground()
	{
		backgroundImage = LoadSave.GetSpriteAtlas(LoadSave.MENU_BACKGROUND);
		menuWidth = (int) (backgroundImage.getWidth() * Game.SCALE);
		menuHeight = (int) (backgroundImage.getHeight() * Game.SCALE);
		menuX = Game.GAME_WIDTH / 2 - menuWidth / 2;
		menuY = (int) (45 * Game.SCALE);
	}

	private void loadButtons()
	{
		buttons[0] = new MenuButton(Game.GAME_WIDTH / 2, (int) (150 * Game.SCALE), 0, Gamestate.PLAYING);
		buttons[1] = new MenuButton(Game.GAME_WIDTH / 2, (int) (220 * Game.SCALE), 1, Gamestate.OPTIONS);
		buttons[2] = new MenuButton(Game.GAME_WIDTH / 2, (int) (290 * Game.SCALE), 2, Gamestate.QUIT);
	}

	@Override
	public void update()
	{
		for(MenuButton menuButton : buttons)
		{
			menuButton.update();
		}
		
	}

	@Override
	public void draw(Graphics graphics)
	{
		graphics.drawImage(backgroundImage, menuX, menuY, menuWidth, menuHeight, null);
		
		for(MenuButton menuButton : buttons)
		{
			menuButton.draw(graphics);
		}
	}

	@Override
	public void mouseClicked(MouseEvent clicked)
	{
		
		
	}

	@Override
	public void mouseMoved(MouseEvent event)
	{
		for(MenuButton menuButton : buttons)
		{
			menuButton.setMouseOver(false);
		}
		
		for(MenuButton menuButton : buttons)
		{
			if(isIn(event, menuButton))
			{
				menuButton.setMouseOver(true);
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent event)
	{
		for(MenuButton menuButton : buttons)
		{
			if(isIn(event, menuButton))
			{
				if(menuButton.isMousePressed())
				{
					menuButton.applyGamestate();
				}
			}
		}
		
	}

	@Override
	public void mousePressed(MouseEvent event)
	{
		for(MenuButton menuButton : buttons)
		{
			if(isIn(event, menuButton))
			{
				menuButton.setMousePressed(true);
				break;
			}
		}
		resetButtons();
		
	}

	private void resetButtons()
	{
		for(MenuButton menuButton : buttons)
		{
			menuButton.resetBools();
		}
		
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
