package plat.ui;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import plat.gamestates.Gamestate;
import plat.utilz.LoadSave;
import static plat.utilz.Constants.UI.Buttons.*;
/** 
 * creates the buttons for the  menu state
 */
public class MenuButton
{
	/**
	 * initializes the position, state, dimesions, and visuals of the buttons
	 */
	private int xPosition, yPosition, rowIndex, index;
	private int xOffsetCenter = B_WIDTH / 2;
	private Gamestate state;
	private BufferedImage[] images;
	private boolean mouseOver, mousePressed;
	private Rectangle bounds;
	
	public MenuButton(int xPosition, int yPosition, int rowIndex, Gamestate state)
	{
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.rowIndex = rowIndex;
		this.state = state;
		loadImages();
		initBounds();
		
	}

	/**
	 * establishes the bounds the of the button
	 */
	private void initBounds()
	{
		bounds = new Rectangle(xPosition - xOffsetCenter, yPosition, B_WIDTH, B_HEIGHT);
		
	}

	/**
	 * loads the visuals of the buttons
	 */
	private void loadImages()
	{
		images = new BufferedImage[3];
		BufferedImage temp = LoadSave.GetSpriteAtlas(LoadSave.MENU_BUTTONS);
		for( int index = 0; index  < images.length; index++)
		{
			images[index] = temp.getSubimage(index * B_WIDTH_DEFAULT, rowIndex * B_HEIGHT_DEFAULT, B_WIDTH_DEFAULT, B_HEIGHT_DEFAULT);
		}
	}
	
	/**
	 * draws the buttons
	 * @param graphics
	 */
	public void draw(Graphics graphics)
	{
		graphics.drawImage(images[index], xPosition - xOffsetCenter, yPosition, B_WIDTH, B_HEIGHT, null);
	}
	/**
	 * updates the buttons when mouse hovers or clicks it
	 */
	public void update()
	{
		index = 0;
		if(mouseOver)
		{
			index = 1;
		}
		if(mousePressed)
		{
			index = 2;
		}
	}
	/**
	 *	getters and setters
	 * @return
	 */
	public boolean isMouseOver()
	{
		return mouseOver;
	}

	public void setMouseOver(boolean mouseOver)
	{
		this.mouseOver = mouseOver;
	}
	
	public boolean isMousePressed()
	{
		return mousePressed;
	}

	public void setMousePressed(boolean mousePressed)
	{
		this.mousePressed = mousePressed;
	}
	
	public Rectangle getBounds()
	{
		return bounds;
	}
	
	public void applyGamestate()
	{
		Gamestate.state = state;
		
	}
	
	public void resetBools()
	{
		mouseOver = false;
		mousePressed = false;
	}
	
}
