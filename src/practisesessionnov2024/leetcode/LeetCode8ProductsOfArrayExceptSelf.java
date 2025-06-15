package practisesessionnov2024.leetcode;

import java.util.Arrays;

public class LeetCode8ProductsOfArrayExceptSelf {

    public static int[] productExceptSelfBruteForce(int[] nums) {
    	
    	int[] op = new int[nums.length];
    	
    	for(int i=0;i<nums.length;i++)
    	{
    		int product=1;
    		for(int j=0;j<nums.length;j++)
    		{
    			if(i!=j)
    			{
    				product = product * nums[j];
    			}
    		}
    		
    		op[i]=product;
    		
    	}
    	
    	return op;
    }
    
    public static int[] productExceptSelfDivision(int[] nums) {
    	int product=1;
    	int zeroCnt=0;
    	
    	for(int n:nums)
    	{
    		if(n!=0)
    		{
    			product*=n;
    		}
    		else
    		{
    			zeroCnt++;
    		}
    	}
    	
    	if(zeroCnt>1)
    	{
    		return new int[] {};
    	}
    	
    	int[] op = new int[nums.length];
    	
    	for(int i=0;i<nums.length;i++)
    	{
    		if(zeroCnt>0)
    		{
    			op[i] = nums[i]==0? product:0;
    		}
    		else
    		{
    			op[i]=product/nums[i];
    		}
    	}
    	
    	return op;
    }
    
    public static int[] productExceptSelf(int[] nums) {
    	
    	int[] op = new int[nums.length];
    	int[] prefix = new int[nums.length];
    	int[] suffix = new int[nums.length];
    	
    	prefix[0]=1;
    	suffix[nums.length-1]=1;
    	
    	for(int i=1;i<nums.length;i++)
    	{
    		prefix[i]=prefix[i-1]*nums[i-1];
    	}
    	
    	for(int i=nums.length-2;i>=0;i--)
    	{
    		suffix[i]=suffix[i+1]*nums[i+1];
    	}
    	
    	for(int i=0;i<nums.length;i++)
    	{
    		op[i]=prefix[i]*suffix[i];
    	}
    	
    	return op;
    }
	
	public static void main(String args[]) {
		int[] nums = {1,2,3,4};
		
		int[] op = productExceptSelf(nums);
		
		System.out.println(Arrays.toString(op));
	}
	
}
