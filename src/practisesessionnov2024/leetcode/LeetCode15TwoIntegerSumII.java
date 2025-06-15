package practisesessionnov2024.leetcode;

import java.util.Arrays;

public class LeetCode15TwoIntegerSumII {

    public static int[] twoSumBinarySearch(int[] numbers, int target) {
    	
    	for(int i=0;i<numbers.length;i++)
    	{
    		int l=i+1, r=numbers.length-1;
    		int val = target-numbers[i];
    		
    		while(l<=r)
    		{
    			int mid = l+(r-l)/2;
    			
    			if(numbers[mid]>val)
    			{
    				r=mid-1;
    			}
    			else if(numbers[mid]<val)
    			{
    				l=mid+1;
    			}
    			else
    			{
    				return new int[] {i+1, mid+1};
    			}
    		}
    	}
    	return new int[] {};
    }
    
    public static int[] twoSum(int[] numbers, int target) {
    	
    	int l=0, r=numbers.length-1;
    	
    	while(l<r)
    	{
    		if(numbers[l]+numbers[r]>target)
    		{
    			r--;
    		}
    		else if(numbers[l]+numbers[r]<target)
    		{
    			l++;
    		}
    		else
    		{
    			return new int[] {l+1, r+1};
    		}
    	}
    	return new int[] {};
    }
    
    public static void main(String args[])
    {
    	int[] numbers = {2,3,4};
    	int target = 7;
    	System.out.println(Arrays.toString(twoSum(numbers, target)));
    }
}
