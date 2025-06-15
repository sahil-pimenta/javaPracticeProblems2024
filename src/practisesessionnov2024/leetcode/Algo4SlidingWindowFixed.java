package practisesessionnov2024.leetcode;

public class Algo4SlidingWindowFixed {
	
	public static int slidingWinBruteForce(int[] array, int windowSize)
	{
		int best = 0;
		for(int i=0; i<=(array.length-windowSize); i++)
		{
			int sum=0;
			for(int j=i; j<=(i+windowSize-1); j++)
			{
				sum+=array[j];
			}
			
			if(sum>best)
			{
				best=sum;
			}
		}
		return best;
	}
	
	public static int slidingWin(int[] array, int windowSize)
	{
		int best=0;
		int sum=0;
		
		for(int i=0;i<windowSize;i++) 
		{
			sum+=array[i];
		}
		
		best=sum;
		
		for(int i=1; i<=(array.length-windowSize); i++)
		{
			sum = sum - array[i-1] + array[i+windowSize-1];
			
			if(sum>best)
			{
				best=sum;
			}
		}
		
		return best;
	}
	
	public static void main(String args[])
	{
		int[] array = {3,8,2,5,7,6,12};
		int windowSize = 4;
		
		int ans = slidingWin(array, windowSize);
		
		System.out.println("Answer= "+ans);
	}

}
