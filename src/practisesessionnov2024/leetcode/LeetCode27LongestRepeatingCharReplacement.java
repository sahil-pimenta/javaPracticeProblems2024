package practisesessionnov2024.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LeetCode27LongestRepeatingCharReplacement {

    public static int characterReplacement(String s, int k) 
    {
    	int[] count = new int[26];
    	int maxLen=0;
    	int maxCount=0;
    	int l=0;
    	
    	for(int r=0;r<s.length();r++)
    	{
    		System.out.println(s.substring(l,r-l+1));
    		count[s.charAt(r)-'A']++;
    		
    		maxCount=Math.max(maxCount, count[s.charAt(r)-'A']);
    		
    		while((r-l+1)-maxCount > k)
    		{
    			count[s.charAt(l)-'A']--;
    			l++;
    		}
    			
    		
    		int len = r-l+1;
    		maxLen=Math.max(maxLen, len);
    	}
    	
    	return maxLen;
    }
    
    /*Logic for Longest Repeating Character Replacement:
		- The value of maxCount might become outdated, but it still guarantees correctness.
		- If maxCount is too high, the condition (r - l + 1 - maxCount > k) might trigger a bit too early, shrinking the window sooner than needed.
		- That’s okay, because you’re still maintaining valid windows.
		- You're not trying to find all valid windows, just the longest one — and by only increasing r and adjusting l as needed, you’re checking all possible longest substrings.*/
    
	public static void main(String args[])
	{
		String s="AAABABB";
		int k=1;
		System.out.println(characterReplacement(s, k));
	}
}
