package practisesessionnov2024.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode4ValidAnagram {

	
    public static boolean isAnagramMySolution(String s, String t) {

        char[] sArr = new char[s.length()];
        char[] tArr = new char[t.length()];

        for(int i=0;i<s.length();i++)
        {
            sArr[i]=s.charAt(i);
        }
        Arrays.sort(sArr);

        for(int i=0;i<t.length();i++)
        {
            tArr[i]=t.charAt(i);
        }
        Arrays.sort(tArr);

        return Arrays.toString(sArr).equals(Arrays.toString(tArr));
    }
    
    public static boolean isAnagramMySolutionOptimized(String s, String t) {
    	
    	if(s.length()!=t.length())
    	{
    		return false;
    	}
    	
    	char[] sArr = s.toCharArray();
    	char[] tArr = t.toCharArray();
    	
    	Arrays.sort(sArr);
    	Arrays.sort(tArr);
    	
    	return Arrays.equals(sArr, tArr);
    }
    
    public static boolean isAnagram(String s, String t) 
    {
        if (s.length() != t.length()) 
        {
            return false;
        }

        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) 
        {
        	sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
        	tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        
        return sMap.equals(tMap);
    }
    
    public static boolean isAnagramOptimal(String s, String t) 
    {
        if (s.length() != t.length()) 
        {
            return false;
        }
        
        int[] count = new int[26];
        
        for(char c:s.toCharArray())
        {
        	count[c-'a']++;
        }
        
        for(char c:t.toCharArray())
        {
        	count[c-'a']--;
        }
        
        for(int val: count)
        {
        	if(val!=0)
        	{
        		return false;
        	}
        }
        
        return true;
    }
	
	public static void main(String args[])
	{
		String s = "racecar";
		String t = "carrace";
		System.out.println("Answer: "+isAnagramOptimal(s, t));
	}
	
}
