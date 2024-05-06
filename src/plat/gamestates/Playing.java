package plat.gamestates;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import plat.entities.Player;
import plat.levels.LevelManager;
import plat.main.Game;
import plat.utilz.LoadSave;

public class Playing extends State implements Statemethods
{
	private Player player;
	private LevelManager levelManager;
	
	public Playing(Game game)
	{
		super(game);
		
		initClasses();
	}
	
	private void initClasses()
	{
		levelManager = new LevelManager(game);
		player = new Player(200, 200, (int) (64 * Game.SCALE), (int) (40 * Game.SCALE));
		player.loadLevelData(levelManager.getCurrentLevel().getLevelData());
	}
	
	
	@Override
	public void update()
	{
		levelManager.update();
		player.update();
		
	}

	@Override
	public void draw(Graphics graphics)
	{
		levelManager.draw(graphics);
		player.render(graphics);
		
	}
	private void loadDefaultLevel()
	{
		
	}

	@Override
	public void mouseClicked(MouseEvent clicked)
	{
		if(clicked.getButton() == MouseEvent.BUTTON1)
		{
			player.setAttacking(true);
		}
		
	}

	@Override
	public void mouseMoved(MouseEvent event)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent event)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent event)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent pressed)
	{
		switch(pressed.getKeyCode())
		{
			case KeyEvent.VK_A:
			{
				player.setLeft(true);
				break;
			}
			case KeyEvent.VK_D:
			{	
				player.setRight(true);
				break;
			}
			case KeyEvent.VK_BACK_SPACE:
			{
				Gamestate.state = Gamestate.MENU;
			}
			case KeyEvent.VK_SPACE:
			{
				player.setJump(true);
			}
			
		}
		
	}

	@Override
	public void keyReleased(KeyEvent released)
	{
		switch(released.getKeyCode())
		{
			case KeyEvent.VK_A:
			{	
				player.setLeft(false);
			}
			case KeyEvent.VK_D:
			{	
				player.setRight(false);
			}
			case KeyEvent.VK_SPACE:
			{
				player.setJump(false);
			}
		}
		
	}
	
	public void windowFocusLost()
	{
		player.resetDirBooleans();
	}
	
	
	public Player getPlayer()
	{
		return player;
	}

}
