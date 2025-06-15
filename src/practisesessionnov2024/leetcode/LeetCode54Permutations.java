package practisesessionnov2024.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode54Permutations {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permuteHelper(nums, new boolean[nums.length],new ArrayList<Integer>(), res);
        return res;
    }
    
    private static void permuteHelper(int[] nums, boolean[] pick, List<Integer> perm, List<List<Integer>> res)
    {
    	if(perm.size()==nums.length)
    	{
    		res.add(new ArrayList<>(perm));
    		return;
    	}
    	
    	for(int i=0;i<nums.length;i++)
    	{
    		if(!pick[i])
    		{
    			perm.add(nums[i]);
    			pick[i]=true;
    			permuteHelper(nums, pick, perm, res);
    			perm.remove(perm.size()-1);
    			pick[i]=false;
    		}
    	}
    	
    }
    
	public static void main(String args[])
	{
		int[] nums= {1,2,3};
		System.out.println(permute(nums).toString());
	}
}
