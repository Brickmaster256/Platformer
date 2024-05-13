package plat.main;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import static plat.main.Game.GAME_HEIGHT;
import static plat.main.Game.GAME_WIDTH;


import plat.inputs.KeyboardInputs;
import plat.inputs.MouseInputs;

import static plat.utilz.Constants.PlayerConstants.*;
import static plat.utilz.Constants.Directions.*;

/**
 * craets the panel that goes into the game
 */

public class GamePanel extends JPanel
{
	/**
	 * gets the game class and the mouseInputs
	 */
	private MouseInputs mouseInputs;
	private Game game;
	
	/**
	 * initializes the game and the panel along with creating a standard size
	 * @param game
	 */
	public GamePanel(Game game) 
	{
		
		mouseInputs = new MouseInputs(this);
		this.game = game;
		
		setPanelSize();
		addKeyListener(new KeyboardInputs(this));
		addMouseListener(mouseInputs);
		addMouseMotionListener(mouseInputs);

	}
	
	/**
	 * sets the size of the game
	 */
	private void setPanelSize()
	{
		Dimension size = new Dimension(GAME_WIDTH, GAME_HEIGHT);
		setPreferredSize(size);
		System.out.println("size: " + GAME_WIDTH + " : " +GAME_HEIGHT);
		
	}

	public void updateGame()
	{
		
	}
	/**
	 * creates then paint for the game
	 */
	@Override
	protected void paintComponent(Graphics graphics) 
	{
		super.paintComponent(graphics);
		
		game.render(graphics);
	}
	/**
	 * returns the game component
	 * @return
	 */
	public Game getGame()
	{
		return game;
	}

	
	
	
}
