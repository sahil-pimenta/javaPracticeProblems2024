package practisesessionnov2024.leetcode;

public class LeetCode20KokoEatingBananas {

	private static int minEatingSpeed(int[] piles, int h) {
		int minSpeed=1;
		int maxSpeed=Integer.MIN_VALUE;
		for(int n:piles)
		{
			if(n>maxSpeed)
			{
				maxSpeed=n;
			}
		}
		
		int op=Integer.MAX_VALUE;
		
		while(minSpeed<=maxSpeed)
		{
			int k=(minSpeed+maxSpeed)/2;
			
			long timeTaken=0;
			
			for(int n:piles)
			{
				timeTaken+=Math.ceil((double)n/k);
			}
			
			if(timeTaken<=h)
			{
				op=k;
				maxSpeed=k-1;
			}
			else
			{
				minSpeed=k+1;
			}
		}
		return op;
	}
    
	
    public static void main(String args[])
    {
    	int[] piles = {30,11,23,4,20};
    	int h=6;
    	System.out.println(minEatingSpeed(piles, h));
    }

}
