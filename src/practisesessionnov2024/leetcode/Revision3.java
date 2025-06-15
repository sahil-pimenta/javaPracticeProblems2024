package practisesessionnov2024.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class MinStack3 {

	Stack<Integer> stack;
	Stack<Integer> minstack;
	
    public MinStack3() {
        stack=new Stack<>();
        minstack=new Stack<>();
    }
    
    public void push(int val) {
    	stack.push(val);
    	if(minstack.isEmpty() || val<=minstack.peek())
    	{
    		minstack.push(val);
    	}
    }
    
    public void pop() {
        int pop = stack.pop();
        if(minstack.peek()==pop)
        {
        	minstack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minstack.peek();
    }
}

public class Revision3 {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(char c:s.toCharArray())
        {
        	if(c=='{' || c=='(' || c=='[')
        	{
        		stack.push(c);
        	}
        	else
        	{
        		if(stack.isEmpty())
        		{
        			return false;
        		}
        		
        		if((c=='}' && stack.peek()=='{') || (c==')' && stack.peek()=='(') || (c==']' && stack.peek()=='['))
        		{
        			stack.pop();
        		}
        	}
        }
        return stack.isEmpty();
    }
    
    public static int evalRPN(String[] tokens) {
        Stack<Integer> operands = new Stack<>();
        
        for(String s:tokens)
        {
        	if(s.equals("+"))
        	{
        		int num2=operands.pop();
        		int num1=operands.pop();
        		operands.push(num1+num2);
        	}
        	else if(s.equals("-"))
        	{
        		int num2=operands.pop();
        		int num1=operands.pop();
        		operands.push(num1-num2);
        	}
        	else if(s.equals("*"))
        	{
        		int num2=operands.pop();
        		int num1=operands.pop();
        		operands.push(num1*num2);
        	}
        	else if(s.equals("/"))
        	{
        		int num2=operands.pop();
        		int num1=operands.pop();
        		operands.push(num1/num2);
        	}
        	else
        	{
        		operands.push(Integer.parseInt(s));
        	}
        }
        return operands.peek();
    }
    
    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] op = new int[temperatures.length];
        
        for(int i=0;i<temperatures.length;i++)
        {
        	while(!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()])
        	{
        		int idx = stack.pop();
        		op[idx]=i-idx;
        	}
        	stack.push(i);
        }
        
        return op;
    }
    
    public static boolean isPalindrome(String s) {
    	s=s.toLowerCase();
    	
        int l=0, r=s.length()-1;
        
        while(l<r)
        {
        	while(l<r && !isAlphaNum(s.charAt(l)))
        	{
        		l++;
        	}
        	
        	while(l<r && !isAlphaNum(s.charAt(r)))
        	{
        		r--;
        	}
        	
        	if(s.charAt(l)!=s.charAt(r))
        	{
        		return false;
        	}
        	
        	l++;
        	r--;
        }
        return true;
    }
    
    private static boolean isAlphaNum(char c)
    {
    	return ((c>='a' && c<='z') || (c>='0' && c<='9'));
    }
    
    public static int[] twoSum(int[] numbers, int target) {
        
    	int l=0, r=numbers.length-1;
    	
    	while(l<r)
    	{
    		int sum=numbers[l]+numbers[r];
    		
    		if(sum>target)
    		{
    			r--;
    		}
    		else if(sum<target)
    		{
    			l++;
    		}
    		else
    		{
    			return new int[] {l+1,r+1};
    		}
    		
    	}
    	return new int[] {};
    }
    
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> op = new ArrayList<>();
    	Arrays.sort(nums);
    	
    	for(int i=0;i<nums.length;i++)
    	{
    		if(nums[i]>0)break;
    		if(i>0 && nums[i]==nums[i-1])
    		{
    			continue;
    		}
    		
    		int j=i+1;
    		int k=nums.length-1;
    		
    		while(j<k)
    		{
    			int sum=nums[i]+nums[j]+nums[k];
    			
    			if(sum>0)
    			{
    				k--;
    			}
    			else if(sum<0)
    			{
    				j++;
    			}
    			else
    			{
    				op.add(Arrays.asList(nums[i],nums[j],nums[k]));
    				j++;
    				k--;
    				
    				while(j<k && nums[j]==nums[j-1])
    				{
    					j++;
    				}
    				
    				while(j<k && nums[k]==nums[k+1])
    				{
    					k--;
    				}
    				
    			}
    			
    		}
    	}
    	
		return op;
    }
	
    public static int maxArea(int[] heights) {
        int l=0,r=heights.length-1;
        int maxArea = 0;
        while(l<r)
        {
        	int area = Math.min(heights[l], heights[r]) * (r-l);
        	maxArea = Math.max(maxArea, area);
        	
        	if(heights[l]<=heights[r])
        	{
        		l++;
        	}
        	else
        	{
        		r--;
        	}
        }
        return maxArea;
    }
    
    public static int search(int[] nums, int target) {
        int l=0,r=nums.length-1;
        while(l<=r)
        {
        	int m=l+(r-l)/2;
        	if(nums[m]>target)
        	{
        		r=m-1;
        	}
        	else if(nums[m]<target)
        	{
        		l=m+1;
        	}
        	else
        	{
        		return m;
        	}
        }
        return -1;
    }
    
    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows=matrix.length, columns=matrix[0].length;
    	int top=0,bottom=rows-1;
    	
    	while(top<=bottom)
    	{
    		int m=(top+bottom)/2;
    		
    		if(target > matrix[m][columns-1])
    		{
    			top=m+1;
    		}
    		else if(target < matrix[m][0])
    		{
    			bottom=m-1;
    		}
    		else
    		{
    			break;
    		}
    	}
    	
    	if(!(top<=bottom))
    	{
    		return false;
    	}
    	
    	int row=(top+bottom)/2;
    	
    	int l=0,r=columns-1;
    	
    	while(l<=r)
    	{
    		int m=(l+r)/2;
    		
    		if(target>matrix[row][m])
    		{
    			l=m+1;
    		}
    		else if(target<matrix[row][m])
    		{
    			r=m-1;
    		}
    		else
    		{
    			return true;
    		}
    	}
    	return false;
    }
    
    public static int minEatingSpeed(int[] piles, int h) 
    {
    	int op=Integer.MAX_VALUE;
        int l=1;
        int r=Integer.MIN_VALUE;
        
        for(int n: piles)
        {
        	if(n>r)
        	{
        		r=n;
        	}
        }
        
        while(l<=r)
        {
        	int k=(l+r)/2;
        	
        	long time=0;
        	
        	for(int n:piles)
        	{
        		time+=Math.ceil((double)n/k);
        	}
        	
        	if(time<=h)
        	{
        		op=k;
        		r=k-1;
        	}
        	else
        	{
        		l=k+1;
        	}
        }
        return op;
    }
    
    public static int findMin(int[] nums) {
        int l=0,r=nums.length-1;
        
        while(l<r)
        {
        	int m=(l+r)/2;
        	
        	if(nums[m]>nums[r])
        	{
        		l=m+1;
        	}
        	else
        	{
        		r=m;
        	}
        }
        
        return nums[l];
    }
    
    public static int searchRotatedArr(int[] nums, int target) {
        int l=0,r=nums.length-1;
        
        while(l<r)
        {
        	int m =(l+r)/2;
        	
        	if(nums[m]>nums[r])
        	{
        		l=m+1;
        	}
        	else
        	{
        		r=m;
        	}
        }
        
        int min=l;
        l=0;
        r=nums.length-1;
        
        if(target>=nums[min] && target<=nums[r])
        {
        	l=min;
        }
        else
        {
        	r=min-1;
        }
        
        while(l<=r)
        {
        	int m=(l+r)/2;
        	
        	if(target>nums[m])
        	{
        		l=m+1;
        	}
        	else if(target<nums[m])
        	{
        		r=m-1;
        	}
        	else
        	{
        		return m;
        	}
        	
        }
        return -1;
    }
    
	public static void main(String args[])
	{
//		String s = "([{}])";
//		System.out.println(isValid(s));
		
//		MinStack3 minStack = new MinStack3();
//		minStack.push(1);
//		minStack.push(2);
//		minStack.push(0);
//		System.out.println(minStack.getMin()); // return 0
//		minStack.pop();
//		System.out.println(minStack.top());    // return 2
//		System.out.println(minStack.getMin()); // return 1
		
//		String[] tokens = {"1","2","+","3","*","4","-"};
//		System.out.println(evalRPN(tokens));
		
//		int[] temperatures = {30,38,30,36,35,40,28};
//		System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
		
//		String  s = "A man, a plan, a canal: Panama";
//		System.out.println(isPalindrome(s));
		
//		int[] numbers = {2,3,4};
//		int target = 6;
//		System.out.println(Arrays.toString(twoSum(numbers, target)));
		
//		int[] nums = {-1,0,1,2,-1,-4};
//		System.out.println(threeSum(nums).toString());
		
//		int[] height = {1,8,6,2,5,4,8,3,7};
//		System.out.println(maxArea(height));
		
//		int[] nums = {-1,0,2,4,6,8};
//		int target = 4;
//		System.out.println(search(nums, target));
		
//		int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
//		int target = 23;
//		System.out.println(searchMatrix(matrix, target));
		
//		int[] piles = {30,11,23,4,20};
//		int h = 6;
//		System.out.println(minEatingSpeed(piles, h));
		
//		int[] nums = {4,5,0,1,2,3};
//		System.out.println(findMin(nums));
		
		int[] nums = {4,5,6,7,0,1,2};
		int target = 6;
		System.out.println(searchRotatedArr(nums, target));
	}
}
