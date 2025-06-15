package practisesessionnov2024.leetcode;

import java.util.Stack;

public class LeetCode12EvaluateReversePolishNotation {

    public static int evalRPN(String[] tokens) {    	
    	
    	Stack<Integer> operands = new Stack<Integer>();
    	
    	for(String s:tokens)
    	{
    		if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))
    		{
    			int num2 = operands.pop();
    			int num1 = operands.pop();
    			if(s.equals("+"))
    			{
    				operands.push(num1+num2);
    			}
    			else if(s.equals("-"))
    			{
    				operands.push(num1-num2);
    			}
    			else if(s.equals("*"))
    			{
    				operands.push(num1*num2);
    			}
    			else
    			{
    				operands.push(num1/num2);
    			}
    		}
    		else
    		{
    			int n = Integer.parseInt(s);
    			operands.push(n);
    		}
    	}
    	
    	return operands.peek();
    }
    
	public static void main(String args[])
	{
		String [] tokens = {"1","2","+","3","*","4","-"};
		
		System.out.println(evalRPN(tokens));
	}
}
