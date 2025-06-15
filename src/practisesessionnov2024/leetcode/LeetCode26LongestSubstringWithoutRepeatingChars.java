package practisesessionnov2024.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LeetCode26LongestSubstringWithoutRepeatingChars {

    public static int lengthOfLongestSubstringBruteForce(String s) {

    	Set<Character> set = new HashSet<Character>();
    	int maxSize=Integer.MIN_VALUE;
    	
    	for(int i=0;i<s.length();i++)
    	{
    		for(int j=i;j<s.length();j++)
    		{
    			if(set.contains(s.charAt(j)))
    			{
    				int len = set.size();
    				if(len>maxSize)
    				{
    					maxSize=len;
    				}
    				set.clear();
    				break;
    			}
    			else
    			{
    				set.add(s.charAt(j));
    			}
    		}
    	}
    	
    	return maxSize;
    	
    }
    
    public static int lengthOfLongestSubstring(String s) 
    {
    	Set<Character> set = new HashSet<>();
    	int maxLen=Integer.MIN_VALUE;
    	int l=0;
    	
    	for(int r=0;r<s.length();r++)
    	{
    		while(set.contains(s.charAt(r)))
    		{
    			set.remove(s.charAt(l));
    			l++;
    		}
    		set.add(s.charAt(r));
    		int len=r-l+1;
    		if(len>maxLen)
    		{
    			maxLen=len;
    		}
    	}
    	
    	return maxLen==Integer.MIN_VALUE?0:maxLen;
    }
	
	public static void main(String args[])
	{
		String s="abcabcbb";
		System.out.println(lengthOfLongestSubstring(s));
	}
}
