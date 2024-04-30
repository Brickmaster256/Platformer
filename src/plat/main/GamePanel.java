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

public class GamePanel extends JPanel
{
	private MouseInputs mouseInputs;
	private Game game;
	
	public GamePanel(Game game) 
	{
		
		mouseInputs = new MouseInputs(this);
		this.game = game;
		
		setPanelSize();
		addKeyListener(new KeyboardInputs(this));
		addMouseListener(mouseInputs);
		addMouseMotionListener(mouseInputs);

	}
	
	
	private void setPanelSize()
	{
		Dimension size = new Dimension(GAME_WIDTH, GAME_HEIGHT);
		setPreferredSize(size);
		System.out.println("size: " + GAME_WIDTH + " : " +GAME_HEIGHT);
		
	}

	public void updateGame()
	{
		
	}

	@Override
	protected void paintComponent(Graphics graphics) 
	{
		super.paintComponent(graphics);
		
		game.render(graphics);
	}

	public Game getGame()
	{
		return game;
	}

	
	
	
}
