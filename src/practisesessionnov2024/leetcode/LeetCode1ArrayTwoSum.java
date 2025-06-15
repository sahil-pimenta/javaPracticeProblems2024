package practisesessionnov2024.leetcode;
import java.util.HashMap;
import java.util.Map;

public class LeetCode1ArrayTwoSum {
	
    public void twoSum(int[] nums, int target) {
        
    	for(int i=0; i<nums.length; i++)
    	{
    		for(int j=i+1;j<nums.length;j++)
    		{
    			if((nums[i]+nums[j])== target)
    			{
    				System.out.println("["+i+","+j+"]");
    				break;
    			}
    		}
    	}
    }
    
    
    public int[] betterTwoSum(int[] nums, int target) {
        
    	Map<Integer, Integer> numsmap = new HashMap<Integer, Integer>();
    	
    	for(int i=0; i<nums.length; i++)
    	{
    		numsmap.put(nums[i], i);
    	}
    	
    	for(int i=0; i<nums.length; i++)
    	{
    		int complement = target - nums[i];
    		
    		if(numsmap.containsKey(complement) && (numsmap.get(complement)!= i))
    		{
    			return new int[] {i, numsmap.get(complement)};
    		}
    	}
    	
    	return new int[] {};
    }
    
    public static void main(String args[])
    {
    	int[] nums = {3,2,4};
    	int target = 6;
    	
    	LeetCode1ArrayTwoSum abc = new LeetCode1ArrayTwoSum();
    	abc.twoSum(nums, target);
    }
}
