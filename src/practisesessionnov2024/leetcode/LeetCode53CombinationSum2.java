package practisesessionnov2024.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode53CombinationSum2 
{
    public static  List<List<Integer>> combinationSum2(int[] candidates, int target) 
    {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(candidates);
        
        cs2Helper(candidates, 0, 0, target, subset, res);
        
        return res;
    }
    
    private static void cs2Helper(int[] candidates, int i, int sum, int target, List<Integer> subset, List<List<Integer>> res)
    {
    	if(sum==target)
    	{
    		res.add(new ArrayList<>(subset));
    		return;
    	}
    	
    	if(i>=candidates.length || sum>target)
    	{
    		return;
    	}
    	
    	/*Adding the same element*/
    	subset.add(candidates[i]);
    	cs2Helper(candidates, i+1, sum+candidates[i], target, subset, res);
    	
    	/*Removing the recently added element and adding the next element after checking for duplicate*/
    	subset.remove(subset.size()-1);
    	
    	while((i+1 < candidates.length) && (candidates[i]==candidates[i+1]))
    	{
    		i++;
    	}
    	
    	cs2Helper(candidates, i+1, sum, target, subset, res);
    }
    
    public static void main(String args[])
    {
    	int[] candidates= {10,1,2,7,6,1,5};
    	int target=8;
    	
    	System.out.println(combinationSum2(candidates, target).toString());
    }
}
