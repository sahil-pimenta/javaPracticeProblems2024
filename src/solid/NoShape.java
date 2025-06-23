package solid;

public class NoShape implements Shape {
	public double area() {
		throw new IllegalStateException("No shape, so no area");
	}
}
