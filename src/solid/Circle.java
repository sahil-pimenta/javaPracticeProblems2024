package solid;

public class Circle implements Shape{

	private int radius;
	
	public Circle(int radius)
	{
		this.radius=radius;
	}
	
	public int getRadius()
	{
		return this.radius;
	}
	
	public double area()
	{
		return Math.PI*Math.pow(getRadius(),2);
	}
}
