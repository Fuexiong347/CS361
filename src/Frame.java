public class Frame {
	
	private int pinCount;
	private int firstThrow;
	private int secondThrow;
	
	
	public Frame()
	{
		this.pinCount = 10;
		this.firstThrow = -1;
		this.secondThrow = -1;
	}
	
	public int getFirstThrow()
	{
		return firstThrow;
	}
	
	public int getSecondThrow()
	{
		return secondThrow;
	}
	
	public String toString()
	{
		return "" + firstThrow + secondThrow;
	}

}
