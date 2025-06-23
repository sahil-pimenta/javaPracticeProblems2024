package solid;

public class Square implements Shape{
	private int side;
	
	public Square(int side)
	{
		this.side=side;
	}
	
	public int getSide()
	{
		return this.side;
	}
	
	public double area()
	{
		return Math.pow(getSide(),2);
	}
}
