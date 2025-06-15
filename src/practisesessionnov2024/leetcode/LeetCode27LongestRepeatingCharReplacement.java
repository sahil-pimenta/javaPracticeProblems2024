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
    
    /*The core logic for why maxCount is always max and not recalculated based on the chars present in current window is:
    window_length - popular_char_length <= k
    k is fixed
    window_length is the answer we want to maximise
    To maximise window_length, we need to keep max_char as high as possible.
    This is why we dont decrement the max_char, because it wouldnt increase window_length.

    You can go ahead and update the max variable even for decrements and it will still give you the answer.*/
    
	public static void main(String args[])
	{
		String s="AAABABB";
		int k=1;
		System.out.println(characterReplacement(s, k));
	}
}
