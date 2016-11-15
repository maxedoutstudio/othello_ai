public class GameMoves
{
	private int x;
	private int y;
	private int value;
	
		public GameMoves()
	{
		x = -1;
		y = -1;
		value = 0;
	}
	public GameMoves(int x, int y)
	{
		this.x = x;
		this.y = y;
		this.value = -1;
	}
	
	public GameMoves(int value)
	{
		this.x = -1;
		this.y = -1;
		this.value = value;
	}
	
	public GameMoves(int x, int y, int value)
	{
		this.x = x;
		this.y = y;
		this.value = value;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public int getValue()
	{
		return value;
	}
	
	public void setX(int x)
	{
		this.x = x;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
	
	public void setValue(int value)
	{
		this.value = value;
	}
}
