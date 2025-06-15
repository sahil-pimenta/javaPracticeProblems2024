package practisesessionnov2024.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode9LongestConsecutiveSequence {

	public static int longestConsecutiveSequence(int[] nums)
	{
		Set<Integer> numsSet = new HashSet<Integer>();
		for(int n:nums)
		{
			numsSet.add(n);
		}
		
		int longest = 0;
		
		for(int num:numsSet)
		{
			if(!numsSet.contains(num-1))
			{
				int length=1;
				while(numsSet.contains(num+length))
				{
					length++;
				}
				longest = Math.max(length, longest);
			}
			
		}
		return longest;
	}
	

	
	public static void main(String args[])
	{
		int[] nums = {2,20,4,10,3,4,5};
		
		System.out.println("OP>>"+longestConsecutiveSequence(nums));
	}
}
