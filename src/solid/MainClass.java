package solid;

import java.util.Arrays;
import java.util.List;

public class MainClass {
	public static void main(String[] args) {
		IAreaSumCalculator areaSum = new AreaSumCalculator();
		
		Shape circle = new Circle(10);
		Shape square = new Square(10);
		List<Shape> shapes = Arrays.asList(circle, square);
		
		PrintAreaSum print = new PrintAreaSum(areaSum);
		System.out.println(print.printSumJSON(shapes));
	}
}
