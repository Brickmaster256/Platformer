package plat.entities;

public abstract class Entity
{
	protected float xDelta, yDelta;
	protected int width, height;
	
	public Entity(float xDelta, float yDelta, int width, int height)
	{
		this.xDelta = xDelta;
		this.yDelta = yDelta;
		this.width = width;
		this.height = height;
	}
}
