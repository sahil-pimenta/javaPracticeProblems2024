package practisesessionnov2024.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode163Sum {

    public static List<List<Integer>> threeSumBruteForce(int[] nums) {
        
    	List<List<Integer>> op = new ArrayList<List<Integer>>();
    	Arrays.sort(nums);
    	for(int i=0;i<nums.length;i++)
    	{
    		for(int j=i+1;j<nums.length;j++)
    		{
    			for(int k=j+1;k<nums.length;k++)
    			{
    				if(nums[i]+nums[j]+nums[k]==0)
    				{
    					List<Integer> tmp = Arrays.asList(nums[i], nums[j], nums[k]);
    					if(!op.contains(tmp))
    					{
        					op.add(tmp);
    					}
    				}
    			}
    		}
    	}
    	
    	return op;
    }
    
    public static List<List<Integer>> threeSum(int[] nums) {
    	List<List<Integer>> op = new ArrayList<>();
    	
    	Arrays.sort(nums);
    	
    	for(int i=0;i<nums.length;i++)
    	{
    		if(i>0 && nums[i]==nums[i-1])
    		{
    			continue;
    		}
    		
    		int j=i+1,k=nums.length-1;
    		while(j<k)
    		{
        		int sum=nums[i]+nums[j]+nums[k];
        		
        		if(sum>0)
        		{
        			k--;
        		}
        		else if(sum<0)
        		{
        			j++;
        		}
        		else
        		{
        			op.add(Arrays.asList(nums[i],nums[j],nums[k]));
        			j++;
        			
        			while(j<k && nums[j]==nums[j-1])
        			{
        				j++;
        			}
        		}
    		}    		
    	}
    	
    	return op;
    }
    
	public static void main(String args[])
	{
		int[] nums = {-1,0,1,2,-1,-4};
		System.out.println(threeSum(nums).toString());
	}
}
