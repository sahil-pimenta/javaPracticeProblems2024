package practisesessionnov2024.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Revision7 {

	public static int maxSumSubarray(int[] nums, int w)
	{
		int sum = 0;
		for(int i=0;i<w;i++)
		{
			sum+=nums[i];
		}
		int maxSum=sum;
		
		for(int i=1;i<=(nums.length-w);i++)
		{
			sum=sum-nums[i-1]+nums[i+w-1];
			
			maxSum=Math.max(maxSum, sum);
		}
		return maxSum;
	}
	
    public static int maxProfit(int[] prices) 
    {
        int maxProfit=Integer.MIN_VALUE;
        int l=0;
        
        for(int r=0;r<prices.length;r++)
        {
        	while(prices[r]<prices[l])
        	{
        		l=r;
        	}
        	
        	int profit=prices[r]-prices[l];
        	maxProfit=Math.max(maxProfit, profit);
        }
        return maxProfit;
    }
	
    public static int minSubArrayLen(int target, int[] nums) {
        int minLen=Integer.MAX_VALUE;
        int sum=0;
        int l=0;
        
        for(int r=0;r<nums.length;r++)
        {
        	sum+=nums[r];
        	
        	while(sum>=target)
        	{
        		int len=r-l+1;
        		minLen=Math.min(minLen, len);
        		
        		sum-=nums[l];
        		l++;
        	}
        }
        return minLen==Integer.MAX_VALUE?0:minLen;
    }
    
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int maxLen=Integer.MIN_VALUE;
        int l=0;
        
        for(int r=0;r<s.length();r++)
        {
        	while(set.contains(s.charAt(r)))
        	{
        		set.remove(s.charAt(l));
        		l++;
        	}
        	
        	int len=r-l+1;
        	maxLen=Math.max(maxLen,len);
        	
        	set.add(s.charAt(r));
        }
        
        return maxLen==Integer.MIN_VALUE?0:maxLen;
    }
    
    public static int characterReplacement(String s, int k) 
    {
    	int maxLen = Integer.MIN_VALUE;
    	int[] count=new int[26];
    	int maxCount=0;
    	int l=0;
    	
    	for(int r=0;r<s.length();r++)
    	{
    		count[s.charAt(r)-'A']++;
    		
    		maxCount = Math.max(maxCount, count[s.charAt(r)-'A']);
    		
    		while((r-l+1)-maxCount > k)
    		{
    			count[s.charAt(l)-'A']--;
    			l++;
    		}
    		
    		int len=r-l+1;
    		maxLen=Math.max(maxLen, len);
    	}
    	
    	return maxLen==Integer.MIN_VALUE?0:maxLen;
    }
    
    public static boolean checkInclusion(String s1, String s2) 
    {
        if(s1.length()>s2.length())return false;
        
        Map<Character, Integer> map1=new HashMap<>();
        Map<Character, Integer> map2=new HashMap<>();
        
        for(int i=0;i<s1.length();i++)
        {
        	map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i), 0)+1);
        	map2.put(s2.charAt(i), map2.getOrDefault(s2.charAt(i), 0)+1);
        }
        
        if(map1.equals(map2)) return true;
        
        int l=0;
        for(int r=s1.length();r<s2.length();r++)
        {
        	map2.put(s2.charAt(r), map2.getOrDefault(s2.charAt(r), 0)+1);
        	
        	map2.put(s2.charAt(l), map2.getOrDefault(s2.charAt(l),0)-1);
        	if(map2.get(s2.charAt(l))==0)
        	{
        		map2.remove(s2.charAt(l));
        	}
        	l++;
        	
        	if(map1.equals(map2))return true;
        }
        
        return false;
    }
    
	public static void main(String args[])
	{
//		int[] nums= {3,8,2,5,7,6,12};
//		int w=4;
//		System.out.println(maxSumSubarray(nums, w));
		
//		int[]prices = {7,6,4,3,1};
//		System.out.println(maxProfit(prices));
		
//		int[] nums = {1,4,4};
//		int target = 4;
//		System.out.println(minSubArrayLen(target, nums));
		
//		String s = "pwwkew";
//		System.out.println(lengthOfLongestSubstring(s));
		
//		String s = "ABAB";
//		int k = 2;
//		System.out.println(characterReplacement(s, k));
		
		String s1 = "ab";
		String s2 = "eidboaoo";
		System.out.println(checkInclusion(s1, s2));
	}
}
