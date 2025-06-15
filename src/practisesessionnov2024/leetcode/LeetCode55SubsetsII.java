package practisesessionnov2024.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode55SubsetsII 
{

    public static List<List<Integer>> subsetsWithDup(int[] nums) 
    {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        subsetsHelper(nums, 0, new ArrayList<Integer>(), res);
        return res;
    }
    
    private static void subsetsHelper(int[] nums, int i, List<Integer> subset, List<List<Integer>> res)
    {
    	if(i>=nums.length)
    	{
    		res.add(new ArrayList<>(subset));
    		return;
    	}
    	
    	subset.add(nums[i]);
    	subsetsHelper(nums, i+1, subset, res);
    	
    	subset.remove(subset.size()-1);
    	
    	while((i+1<nums.length) && (nums[i]==nums[i+1]))
    	{
    		i++;
    	}
    	subsetsHelper(nums, i+1, subset, res);
    }
    
	public static void main(String args[])
	{
		int[] nums = {1,2,2};
		System.out.println(subsetsWithDup(nums).toString());
	}
}
