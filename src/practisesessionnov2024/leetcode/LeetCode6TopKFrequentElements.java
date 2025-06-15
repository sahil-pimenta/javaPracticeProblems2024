package practisesessionnov2024.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode6TopKFrequentElements {

    public static int[] topKFrequentSorting(int[] nums, int k) {
        
    	Map<Integer, Integer> numsMap = new HashMap<Integer, Integer>();
    	for(Integer num : nums)
    	{
    		numsMap.put(num, numsMap.getOrDefault(num, 0)+1);
    	}
    	
    	List<int[]> numsArr = new ArrayList<int[]>();
    	
    	for(Map.Entry<Integer, Integer> entry: numsMap.entrySet())
    	{
    		numsArr.add(new int[] {entry.getValue(), entry.getKey()});
    	}
    	
    	numsArr.sort((a,b)-> b[0]-a[0]);
    	
    	int[] op = new int[k];
    	
    	for(int i=0;i<k;i++)
    	{
    		op[i] = numsArr.get(i)[1];
    	}
    	
    	return op;
    }
    
    public static int[] topKFrequentBucketSort(int[] nums, int k) {
    	
    	Map<Integer,Integer> numsMap = new HashMap<Integer, Integer>();
    	
    	for(int num:nums)
    	{
    		numsMap.put(num, numsMap.getOrDefault(num, 0)+1);
    	}
    	
    	List<Integer>[] freqArr = new List[nums.length+1];
    	
    	for(int i=0;i<freqArr.length;i++)
    	{
    		freqArr[i] = new ArrayList<Integer>();
    	}
    	
    	for(Map.Entry<Integer, Integer> entry:numsMap.entrySet())
    	{
    		freqArr[entry.getValue()].add(entry.getKey());
    	}
    	
    	int[] op = new int[k];
    	int j=0;
    	for(int i=freqArr.length-1;i>=0;i--)
    	{
    		for(int n:freqArr[i])
    		{
        		op[j]=n;
        		j++;
    		}
    		if(j==k)
    		{
    			return op;
    		}
    	}
    	return new int[] {};
    }
    
	public static void main(String args[])
	{
		int[] nums = {1,2,2,3,3,3};
		int k = 2;
		
		int[] op = topKFrequentBucketSort(nums, k);
		
		System.out.println("OP: "+Arrays.toString(op));
	}
}
