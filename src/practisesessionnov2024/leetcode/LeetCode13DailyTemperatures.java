package practisesessionnov2024.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class LeetCode13DailyTemperatures {

    public static int[] dailyTemperaturesBruteForce(int[] temperatures) 
    {    
    	int[] op =new int[temperatures.length];
    	for(int i=0;i<temperatures.length;i++)
    	{
    		int count=0;
    		for(int j=i+1;j<temperatures.length;j++)
    		{
    			count++;
    			if(temperatures[j]>temperatures[i])
    			{
    	    		op[i]=count;
    				break;
    			}
    		}
    	}
    	return op;
    }
    
    public static int[] dailyTemperatures(int[] temperatures) 
    {
    	int[] res = new int[temperatures.length];
    	Stack<Integer> stack = new Stack<>();
    	
    	for(int i=0;i<temperatures.length;i++)
    	{
    		while(!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()])
    		{
    			int idx = stack.pop();
    			res[idx]=i-idx;
    		}
    		
    		stack.push(i);
    	}
    	return res;
    }
    
    public static void main(String args[])
    {
    	int[] temperatures= {30,38,30,36,35,40,28};
    	System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
    }
}
