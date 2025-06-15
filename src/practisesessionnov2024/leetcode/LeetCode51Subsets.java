package practisesessionnov2024.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode51Subsets {

    public static List<List<Integer>> subsets(int[] nums) 
    {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset=new ArrayList<>();
        
        subsetsHelper(nums, 0, subset, res);
        return res;
    }
    
    private static void subsetsHelper(int[] nums, int i, List<Integer> subset, List<List<Integer>> res)
    {
    	if(i>=nums.length)
    	{
    		res.add(new ArrayList<>(subset));
    		return;
    	}
    	
    	/*Add an item*/
    	subset.add(nums[i]);
    	subsetsHelper(nums,i+1,subset,res);
    	
    	/*Don't add or remove last item*/
    	subset.remove(subset.size()-1);
    	subsetsHelper(nums,i+1,subset,res);
    }
    
    public static void main(String args[])
    {
    	int[] nums= {1,2,3};
    	System.out.println(subsets(nums).toString());
    }
}
