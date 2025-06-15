package practisesessionnov2024.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode58LetterCombinationsOfPhoneNo {

	List<String> res = new ArrayList<String>();
	String [] digitsToChars = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	
    public List<String> letterCombinations(String digits) 
    {
        if(digits.isEmpty())return res;
        
        mapNos(digits, "", 0);
        return res;
    }
    
    private void mapNos(String digits, String comb, int i)
    {
    	if(comb.length()==digits.length())
    	{
    		res.add(comb);
    		return;
    	}
    	
    	String chars=digitsToChars[digits.charAt(i)-'0'];
    	for(char c : chars.toCharArray())
    	{
    		mapNos(digits, comb+c, i+1);
    	}
    }
    
    public static void main(String args[])
    {
    	String digits = "23";
    	System.out.println(new LeetCode58LetterCombinationsOfPhoneNo().letterCombinations(digits).toString());
    }
}
