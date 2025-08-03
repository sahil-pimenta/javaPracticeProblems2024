package practise;

public class SqrtOfANo {

	public static double sqrt(double x)
	{
		double l=1, r=x<0?1:x;
		double sqrt=1.0;
		
		while(l<=r)
		{
			double m = (l+r)/2;
			double val = m*m;
			
			if(val<=x)
			{
				sqrt=m;
				l=m+0.1;
			}
			else if(val>x)
			{
				r=m-0.1;
			}
		}
		return sqrt;
	}
	
	public static void main(String[] args) {
		double x = 38.0;
		
		System.out.println(sqrt(x));
	}
}
