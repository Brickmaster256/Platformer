package plat.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Entity
{
	protected float xDelta, yDelta;
	protected int width, height;
	protected Rectangle hitbox;
	
	public Entity(float xDelta, float yDelta, int width, int height)
	{
		this.xDelta = xDelta;
		this.yDelta = yDelta;
		this.width = width;
		this.height = height;
		
		initHitbox();
	}
	protected void drawHitbox(Graphics graphics)
	{
		graphics.setColor(Color.pink);
		graphics.drawRect(hitbox.x, hitbox.y, hitbox.width, hitbox.height);
	}

	private void initHitbox()
	{
		hitbox = new Rectangle((int) xDelta, (int) yDelta, width, height);
		
		
	}
	
	public void updateHitbox()
	{
		hitbox.x = (int) xDelta;
		hitbox.y = (int) yDelta;
	}
	
	public Rectangle getRectangle()
	{
		return hitbox;
	}
}
