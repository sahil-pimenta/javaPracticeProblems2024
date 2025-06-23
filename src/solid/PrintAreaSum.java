package solid;

import java.util.List;

public class PrintAreaSum {
	
	IAreaSumCalculator areaSum;
	
	public PrintAreaSum(IAreaSumCalculator areaSum)
	{
		this.areaSum=areaSum;
	}
	
	public String printSumJSON(List<Shape> shapes)
	{
		return "{sum:"+areaSum.sum(shapes)+"}";
	}
}
