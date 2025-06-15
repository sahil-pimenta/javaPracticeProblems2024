package practisesessionnov2024.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LeetCode10ValidParentheses {
    
    public static boolean isValidAlt(String s) {
    	Stack<Character> stack = new Stack<Character>();
    	
    	for(char c: s.toCharArray())
    	{
    		if(c=='{' || c=='[' || c=='(')
    		{
    			stack.push(c);
    		}
    		else
    		{
    			//closing bracket
    			if(stack.isEmpty())
    			{
    				return false;
    			}
    			
    			if((c=='}' && stack.peek()=='{')
    					|| (c==']' && stack.peek()=='[')
    					|| (c==')' && stack.peek()=='('))
    			{
    				stack.pop();
    			}
    			else
    			{
    				return false;
    			}
    			
    		}
    	}
    	return stack.isEmpty();
    }
	
    public static boolean isValid(String s) {
        
    	Stack<Character> stack = new Stack<Character>();
    	
    	Map<Character, Character> sMap = new HashMap<Character, Character>();
    	sMap.put(')', '(');
    	sMap.put('}', '{');
    	sMap.put(']', '[');
    	
    	for(char c: s.toCharArray())
    	{
    		if(sMap.containsKey(c))
    		{
    			//closing bracket
    			if(!stack.isEmpty() && stack.peek()==sMap.get(c))
    			{
    				stack.pop();
    			}
    			else
    			{
    				return false;
    			}
    		}
    		else
    		{
    			//opening bracket
    			stack.push(c);
    		}
    	}
    	
    	return stack.isEmpty();
    	
    }
    
    public static void main(String args[])
    {
    	String s = "([{}])";
    	
    	System.out.println(isValidAlt(s));
    }
}
