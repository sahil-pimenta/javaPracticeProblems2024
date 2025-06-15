package practisesessionnov2024.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode57PalindromePartitioning {

    public static List<List<String>> partition(String s) 
    {
        List<List<String>> res = new ArrayList<List<String>>();
        partitionHelper(s,0,new ArrayList<String>(),res);
        return res;
    }
    
    private static void partitionHelper(String s, int i, List<String> part, List<List<String>> res)
    {
    	if(i>=s.length())
    	{
    		res.add(new ArrayList<>(part));
    		return;
    	}
    	
    	for(int j=i;j<s.length();j++)
    	{
    		if(isPalindrome(s, i, j))
    		{
    			part.add(s.substring(i,j+1));
    			System.out.println("BEFORE:"+part.toString());
    			partitionHelper(s,j+1,part,res);
    			part.remove(part.size()-1);
    			System.out.println("AFTER:"+part.toString());
    		}
    	}
    }
    
    private static boolean isPalindrome(String s, int l, int r)
    {
    	while(l<r)
    	{
    		if(s.charAt(l)!=s.charAt(r))return false;
    		
    		l++;
    		r--;
    	}
    	
    	return true;
    }
	
	public static void main(String args[])
	{
		String s="aab";
		System.out.println(partition(s).toString());
	}
}
