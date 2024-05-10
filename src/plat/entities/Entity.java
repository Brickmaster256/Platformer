package plat.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
/**
 * class that defines all entities in the game
 */
public abstract class Entity 
{
	/**
	 * defines the position and size of the entity
	 */
	protected float x, y;
	protected int width, height;
	protected Rectangle2D.Float hitbox;

	/**
	 * Constructs the entities size and position
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public Entity(float x, float y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;

	}
	/**
	 * draws a hitbox if the dev needs to debug
	 * @param g
	 */
	protected void drawHitbox(Graphics g) {
		// For debugging the hitbox
		g.setColor(Color.PINK);
		g.drawRect((int) hitbox.x, (int) hitbox.y, (int) hitbox.width, (int) hitbox.height);

	}
	/**
	 * creates the hitbox for the entity
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	protected void initHitbox(float x, float y, int width, int height) {
		hitbox = new Rectangle2D.Float(x, y, width, height);
	}

	/**
	 * returns the hitbox of the entity
	 * @return
	 */
	public Rectangle2D.Float getHitbox() {
		return hitbox;
	}

}
