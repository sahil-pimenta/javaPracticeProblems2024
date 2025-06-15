package practisesessionnov2024.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode52CombinationSum {

    public static List<List<Integer>> combinationSum(int[] nums, int target) 
    {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> comb=new ArrayList<>();
        combSumHelper(nums, 0, 0, target, comb, res);
        return res;
    }
    
    private static void combSumHelper(int[] nums, int i, int goal, int target, List<Integer> comb, List<List<Integer>> res)
    {
    	if(goal==target)
    	{
    		res.add(new ArrayList<>(comb));
    		return;
    	}
    	
    	if(i>=nums.length || goal>target)
    	{
    		return;
    	}
    	
    	//Add item on same index, till its exhausted and can't be added
    	comb.add(nums[i]);
    	combSumHelper(nums, i, goal+nums[i], target, comb, res);
    	
    	//Remove the item that was just added and then add item on next index
    	comb.remove(comb.size()-1);
    	combSumHelper(nums, i+1, goal, target, comb, res);
    }
	
	public static void main(String args[])
	{
		int[] nums= {2,3,6,7};
		int target=7;
		System.out.println(combinationSum(nums, target).toString());
	}
}
