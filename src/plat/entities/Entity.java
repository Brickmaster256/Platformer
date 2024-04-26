package plat.entities;

public abstract class Entity
{
	protected float xDelta, yDelta;
	
	public Entity(float xDelta, float yDelta)
	{
		this.xDelta = xDelta;
		this.yDelta = yDelta;
	}
}
