package plat.utilz;

import plat.main.Game;

public class Constants
{
	public static class UI
	{
		public static class Buttons
		{
			public static final int B_WIDTH_DEFAULT = 140;
			public static final int B_HEIGHT_DEFAULT = 56;
			public static final int B_WIDTH = (int) (B_WIDTH_DEFAULT * Game.SCALE);
			public static final int B_HEIGHT = (int) (B_HEIGHT_DEFAULT * Game.SCALE);
		}
	}
	
	public static class Directions
	{
		public static final int LEFT = 0;
		public static final int UP = 1;
		public static final int RIGHT = 2;
		public static final int DOWN = 3;
	}
	public static class PlayerConstants
	{
		public static final int IDLE = 0;
		public static final int RUNNING = 1;
		public static final int JUMP = 2;
		public static final int FALLING = 3;
		public static final int GROUND = 4;
		public static final int HIT = 5;
		public static final int ATTACK_ONE = 6;
		public static final int ATTACK_JUMP_ONE = 7;
		public static final int ATTACK_JUMP_TWO = 8;
		
		public static int getSpriteAmount(int playerAction)
		{
			switch(playerAction)
			{
				case RUNNING:
				{
					return 6;
				}
				case IDLE:
				{
					return 5;
				}
				case HIT:
				{
					return 4;
				}
				case JUMP:
				case ATTACK_JUMP_ONE:
				case ATTACK_JUMP_TWO:
				{
					return 3;
				}
				case GROUND:
				{
					return 2;
				}
				case FALLING:
				default:
				{
					return 1;
				}
			}
		}
	}
}
