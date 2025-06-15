package practisesessionnov2024.leetcode;

public class LeetCode25MinimumSizeSubarraySum {
	
    public static int minSubArrayLenBruteForce(int target, int[] nums) 
    {
    	int minLen=Integer.MAX_VALUE;
    	
    	for(int i=0;i<nums.length;i++)
    	{
    		int sum=0;
    		int len=0;
    		for(int j=i;j<nums.length;j++)
    		{
    			sum+=nums[j];
    			len++;
    			
    			if(sum>=target)
    			{
    				minLen = Math.min(len, minLen);
    				
    				System.out.print("[");
    				for(int k=i;k<=j;k++)
    				{
    					System.out.print(nums[k]+",");
    				}
    				
    				System.out.print("] || minlen="+minLen);
    				System.out.println();
    				break;
    			}
    		}
    	}
    	
    	return minLen==Integer.MAX_VALUE?0:minLen;
    }
    
    public static int minSubArrayLen(int target, int[] nums) 
    {
    	int minLen = Integer.MAX_VALUE;
    	int sum=0;
    	int l=0;
    	
    	for(int r=0;r<nums.length;r++)
    	{
    		sum+=nums[r];
    		
    		while(sum>=target)
    		{
    			int len=r-l+1;
    			minLen=Math.min(minLen, len);
    			
    			sum=sum-nums[l];
    			l++;
    		}
    	}
    	
    	return minLen==Integer.MAX_VALUE?0:minLen;
    }
	
	public static void main(String args[])
	{
		int[] nums= {2,3,1,2,4,3};
		int target = 7;
		System.out.println(minSubArrayLen(target, nums));
	}
}
