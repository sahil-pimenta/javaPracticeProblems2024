package practisesessionnov2024.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode5GroupAnagrams {
	
    public static List<List<String>> groupAnagramsaa(String[] strs) 
    {
    	List<List<String>> op = new ArrayList<List<String>>();
    	
        List<String> strList = Arrays.asList(strs);
        
        for(int i=0;i<strList.size();i++)
        {
        	char[] strArr = strList.get(i).toCharArray();
        	Arrays.sort(strArr);
        	
        	List<String> grp = new ArrayList<String>();
        	
    		grp.add(strList.get(i));
    		
        	for(int j=i+1;j<strList.size();j++)
        	{
            	char[] str1Arr = strList.get(j).toCharArray();
            	Arrays.sort(str1Arr);
            	
            	if(Arrays.equals(strArr, str1Arr))
            	{
            		grp.add(strList.get(j));
            	}
        	}
        	
    		op.add(grp);
        }
        
        return op;
    }
    
    
    public static List<List<String>> groupAnagramsAlternative(String[] strs)
    {
    	Map<String, List<String>> response = new HashMap<String, List<String>>();
    	
    	for(String s:strs)
    	{
    		char[] c = s.toCharArray();
    		
    		Arrays.sort(c);
    		
    		String key = Arrays.toString(c);
    		
    		response.putIfAbsent(key, new ArrayList<>());
    		response.get(key).add(s);
    	}
    	
    	return new ArrayList<>(response.values());
    }

    public static List<List<String>> groupAnagrams(String[] strs)
    {
    	Map<String, List<String>> response = new HashMap<String, List<String>>();
    	
    	for(String s: strs)
    	{
    		int[] count = new int[26];
    		
    		for(char c: s.toCharArray())
    		{
    			count[c-'a']++;
    		}
    		
    		String key = Arrays.toString(count);
    		
    		response.putIfAbsent(key, new ArrayList<>());
    		response.get(key).add(s);
    	}
    	
    	return new ArrayList<>(response.values());
    	
    }


	public static void main(String args[])
	{
		String[] strs = {"act","pots","tops","cat","stop","hat"};
		
		List<List<String>> op = groupAnagrams(strs);
		
		System.out.println("Output is: "+op.toString()); 
	}
	
}
