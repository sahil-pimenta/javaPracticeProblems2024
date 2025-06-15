package practisesessionnov2024.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode28PermutationInString {

    public static boolean checkInclusionBruteForce(String s1, String s2) 
    {
    	char[] s1Arr = s1.toCharArray();
    	Arrays.sort(s1Arr);
    	s1 = new String(s1Arr);
    	
    	for(int i=0;i<s2.length();i++)
    	{
    		for(int j=i;j<s2.length();j++)
    		{
    	    	char[] strArr = s2.substring(i,j+1).toCharArray();
    	    	Arrays.sort(strArr);
    	    	String str = new String(strArr);
    			if(str.equals(s1))
    			{
    				return true;
    			}
    		}
    	}
    	return false;
    }
    
    public static boolean checkInclusionUsingCountArr(String s1, String s2) 
    {
    	int n1=s1.length();
    	int n2=s2.length();
    	
    	if(n1>n2)return false;
    	
    	int[] count1=new int[26];
    	int[] count2=new int[26];
    	
    	for(int i=0;i<n1;i++)
    	{
    		count1[s1.charAt(i)-'a']++;
    		count2[s2.charAt(i)-'a']++;
    	}
    	
    	if(Arrays.equals(count1, count2))return true;
    	
    	for(int i=n1;i<n2;i++)
    	{
    		count2[s2.charAt(i)-'a']++;
    		count2[s2.charAt(i-n1)-'a']--;
    		
    		if(Arrays.equals(count1, count2))return true;
    	}
    	
    	return false;
    }
    
    public static boolean checkInclusion(String s1, String s2) 
    {
    	if(s1.length()>s2.length())return false;
    	
    	Map<Character, Integer> map1=new HashMap<Character, Integer>();
    	Map<Character, Integer> map2=new HashMap<Character, Integer>();
    	
    	for(int i=0;i<s1.length();i++)
    	{
    		map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i), 0)+1);
    		map2.put(s2.charAt(i), map2.getOrDefault(s2.charAt(i), 0)+1);
    	}
    	
    	if(map1.equals(map2))return true;
    	
    	int l=0;
    	
    	for(int r=s1.length();r<s2.length();r++)
    	{
    		map2.put(s2.charAt(r), map2.getOrDefault(s2.charAt(r), 0)+1);
    		
    		map2.put(s2.charAt(l), map2.getOrDefault(s2.charAt(l), 0)-1);
    		if(map2.get(s2.charAt(l))==0)
    		{
    			map2.remove(s2.charAt(l));
    		}
    		
    		l++;
    		
    		if(map1.equals(map2))return true;
    	}
    	
    	return false;
    }
    
	public static void main(String args[])
	{
		String s1 = "ab";
		String s2 = "eidboaoo";
		System.out.println(checkInclusion(s1, s2));
	}
}
