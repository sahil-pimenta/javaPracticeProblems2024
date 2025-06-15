package practisesessionnov2024.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode3ContainsDuplicate {
	
    public static boolean hasDuplicateMySolution(int[] nums) 
    {
        List<Integer> numsList = new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            numsList.add(nums[i]);
        }

        boolean elemFound = false;
        for(int i=0;i<nums.length;i++)
        {
            numsList.remove(i);
            if(numsList.contains(nums[i]))
            {
                elemFound = true;
                break;
            }
            else
            {
                numsList.add(i, nums[i]);
            }
        }
        return elemFound;
    }
    
    public static boolean hasDuplicate(int[] nums) {
    	Set<Integer> numsSet = new HashSet<Integer>();
    	
    	for(Integer num : nums)
    	{
    		if(numsSet.contains(num))
    		{
    			return true;
    		}
    		
    		numsSet.add(num);
    	}
    	
    	return false;
    }
	
	public static void main(String args[])
	{
		int[] nums1 = {1, 2, 3, 4};
		System.out.println("OP is: "+hasDuplicate(nums1));
	}
}
