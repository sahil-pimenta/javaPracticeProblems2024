package practisesessionnov2024.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Revision6 {

	public static int maxSumSubarrayFixed(int[] nums, int w)
	{
		int sum=0;
		for(int i=0;i<w;i++)
		{
			sum+=nums[i];
		}
		int maxSum = sum;
		for(int j=1;j<=(nums.length-w);j++)
		{
			sum=sum-nums[j-1]+nums[j+w-1];
			if(sum>maxSum)
			{
				maxSum=sum;
			}
		}
		
		return maxSum;
	}
	
    public static int maxProfit(int[] prices) {
        int maxProfit=0;
        int l=0;
        
        for(int r=0;r<prices.length;r++)
        {
        	if(prices[r]<prices[l])
        	{
        		l=r;
        	}
        	
        	int profit=prices[r]-prices[l];
        	if(profit>maxProfit)
        	{
        		maxProfit=profit;
        	}
        }
        return maxProfit;
    }
    
    public static int minSubArrayLen(int target, int[] nums)
    {
        int minLen=Integer.MAX_VALUE;
        int l=0;
        int sum=0;
        
        for(int r=0;r<nums.length;r++)
        {
        	sum+=nums[r];
        	
        	while(sum>=target)
        	{
        		int len=r-l+1;
        		if(len<minLen)
        		{
        			minLen=len;
        		}
        		sum-=nums[l];
        		l++;
        	}
        }
        return minLen==Integer.MAX_VALUE?0:minLen;
    }
    
    public static int lengthOfLongestSubstring(String s)
    {
        int maxLen=Integer.MIN_VALUE;
        int l=0;
        Set<Character> set = new HashSet<Character>();
        
        for(int r=0;r<s.length();r++)
        {
        	while(set.contains(s.charAt(r)))
        	{
        		set.remove(s.charAt(l));
        		l++;
        	}
        	
        	int len=r-l+1;
        	if(len>maxLen)
        	{
        		maxLen=len;
        	}
        	set.add(s.charAt(r));
        }
        
        return maxLen==Integer.MIN_VALUE?0:maxLen;
    }
    
	public static void main(String args[])
	{
//		int[] nums= {3,8,2,5,7,6,12};
//		int w=4;
//		System.out.println(maxSumSubarrayFixed(nums, w));
		
//		int[] prices= {7,1,5,3,6,4};
//		System.out.println(maxProfit(prices));
		
//		int[] nums = {1,4,4};
//		int target=4;
//		System.out.println(minSubArrayLen(target, nums));
		
		String s = "pwwkew";
		System.out.println(lengthOfLongestSubstring(s));
	}
}
