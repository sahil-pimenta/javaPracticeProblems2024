package practisesessionnov2024.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Revision {
	
	public static int[] twoSum(int[] array, int target)
	{
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i=0;i<array.length;i++)
		{
			map.put(array[i], i);
		}
		
		for(int i=0;i<array.length;i++)
		{
			int complement = target - array[i];
			
			if(map.containsKey(complement) && (map.get(complement)!=i))
			{
				return new int[] {i, map.get(complement)};
			}
		}
		
		return new int[] {};
	}
	
    public static boolean hasDuplicate(int[] nums) {
        
        List<Integer> numsList = new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            numsList.add(nums[i]);
        }

        boolean elemFound = false;
        for(int i=0;i<nums.length;i++)
        {
            numsList.remove(i);
            if(numsList.contains(nums[i]))
            {
                elemFound = true;
                break;
            }
            else
            {
                numsList.add(i, nums[i]);
            }
        }
        return elemFound;
    }
    
    public static String encode(List<String> strs)
    {
    	StringBuilder res = new StringBuilder();
    	
    	for(String s: strs)
    	{
    		res.append(s.length()).append("#").append(s);
    	}
    	return res.toString();
    }
    
    public static List<String> decode(String str)
    {
    	List<String> res = new ArrayList<String>();
    	
    	int i=0;
    	while(i<str.length())
    	{
    		int j=i;
    		
    		while(str.charAt(j)!='#')
    		{
    			j++;
    		}
    		
    		int size = Integer.parseInt(str.substring(i,j));
    		
    		i=j+1;
    		j=i+size;
    		
    		res.add(str.substring(i,j));
    		
    		i=j;
    	}
    	
    	return res;
    }
	
    public static int[] productExceptSelf(int[] nums) {
    	
    	int[] pre = new int[nums.length];
    	int[] suf = new int[nums.length];
    	
    	pre[0]=1;
    	suf[nums.length-1]=1;
    	
    	for(int i=1;i<nums.length;i++)
    	{
    		pre[i] = pre[i-1]*nums[i-1];
    	}
    	
    	for(int i=nums.length-2;i>=0;i--)
    	{
    		suf[i]=suf[i+1]*nums[i+1];
    	}
    	
    	int[] op=new int[nums.length];
    	for(int i=0;i<nums.length;i++)
    	{
    		op[i]=pre[i]*suf[i];
    	}
    	return op;
    }
    
    public static int longestConsecutive(int[] nums) {
    	Set<Integer> numset = new HashSet<Integer>();
    	
    	for(int n:nums)
    	{
    		numset.add(n);
    	}
    	
    	int longest=0;
    	
    	for(int n:nums)
    	{
    		if(!numset.contains(n-1))
    		{
    			int len=1;
    			
    			while(numset.contains(n+len))
    			{
    				len++;
    			}
    			longest=Math.max(len, longest);
    		}
    	}
    	
    	return longest;
    }
    

	private static boolean isValidAlt(String s) {
		
		Stack<Character> stack = new Stack<Character>();
		
		for(char c: s.toCharArray())
		{
			if(c=='(' || c=='{' || c=='[')
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
				
				if((c==')' && stack.peek()=='(')
						|| ((c=='}' && stack.peek()=='{'))
						|| ((c==']' && stack.peek()=='[')))
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
				int n= Integer.parseInt(s);
				operands.push(n);
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
    
    public static int[] twoSumBinarySearch(int[] numbers, int target) {
        
    	for(int i=0;i<numbers.length;i++)
    	{
    		int l=i+1, r=numbers.length-1;
    		int val=target-numbers[i];
    		
    		while(l<=r)
    		{
    			int mid=l+(r-l)/2;
    			
    			if(numbers[mid]>val)
    			{
    				r=mid-1;
    			}
    			else if(numbers[mid]<val)
    			{
    				l=mid+1;
    			}
    			else
    			{
    				return new int[] {i+1,mid+1};
    			}
    		}
    	}
    	return new int[] {};
    }
    
    public static int[] twoSumII(int[] numbers, int target) {
    	
    	int l=0, r=numbers.length-1;
    	
    	while(l<r)
    	{
    		int sum = numbers[l]+numbers[r];
    		
    		if(sum<target)
    		{
    			l++;
    		}
    		else if(sum>target)
    		{
    			r--;
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
    		
    		int j=i+1, k=nums.length-1;
    		
    		while(j<k)
    		{
    			int sum = nums[i]+nums[j]+nums[k];
    			
    			if(sum>0)
    			{
    				k--;
    			}
    			else if(sum<0)
    			{
    				j++;
    			}
    			else {
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
    
	
	public static void main(String args[])
	{
//		int[] nums1 = {1,2,3,4};
//		System.out.println("OP is:"+hasDuplicate(nums1));
		
//		List<String> inputList = Arrays.asList("sahil","is","a","cool", "dude");
//		
//		String encodeStr = encode(inputList);
//		
//		System.out.println("encodeStr>>"+encodeStr);
//		
//		List<String> decodedList = decode(encodeStr);
//		
//		System.out.println("decodedList>>"+decodedList.toString());
		
//		int[] nums = {1,2,4,6};
//		System.out.println("OP is:"+Arrays.toString(productExceptSelf(nums)));
		
//		int[] nums = {1,2,3,4};
//		
//		int[] op = productExceptSelf(nums);
//		
//		System.out.println(Arrays.toString(op));
		
//		int[] nums = {2,20,6,4,10,3,4,5};
//		
//		System.out.println("OP>>"+longestConsecutive(nums));
		
//    	String s = "([{}])";
//    	System.out.println(isValidAlt(s));
		
//		String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
//		System.out.println(evalRPN(tokens));
		
//		int[] temperatures  = {73,74,75,71,69,72,76,73};
//		System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
		
//		String s="A man, a plan, a canal: Panama";
//		System.out.println(isPalindrome(s));
		
//		int[] numbers  = {2,3,4};
//		int target=6;
//		System.out.println(Arrays.toString(twoSumII(numbers, target)));
		
		int[] nums  = {-1,0,1,2,-1,-4};
		System.out.println(threeSum(nums).toString());
	}

}
