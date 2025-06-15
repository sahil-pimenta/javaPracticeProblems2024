package practisesessionnov2024.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;



public class Revision2 {
	
    public static boolean hasDuplicate(int[] nums) {
    	 Set<Integer> numset = new HashSet<Integer>();
    	 
    	 for(int n:nums)
    	 {
    		 if(numset.contains(n))
    		 {
    			 return true;
    		 }
    		 
    		 numset.add(n);
    	 }
    	 
    	 return false;
    }
    
    public static boolean isAnagram(String s, String t) {
    	if(s.length()!=t.length())
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
    	
    	for(int n:count)
    	{
    		if(n!=0)
    		{
    			return false;
    		}
    	}
    	
    	return true;
    }
    
    
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> numMap = new HashMap<Integer, Integer>();
        
        for(int i=0;i<nums.length;i++)
        {
        	numMap.put(nums[i], i);
        }
        
        for(int i=0;i<nums.length;i++)
        {
        	int complement = target-nums[i];
        	
        	if(numMap.containsKey(complement) && i!=numMap.get(complement))
        	{
        		return new int[] {i, numMap.get(complement)};
        	}
        	
        }
        
        return new int[] {};
        
    }
    
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> strMap = new HashMap<>();
        
        for(String s: strs)
        {
        	int[] count = new int[26];
        	
        	for(char c: s.toCharArray())
        	{
        		count[c-'a']++;
        	}
        	
        	String key = Arrays.toString(count);
        	
        	strMap.putIfAbsent(key, new ArrayList<String>());
        	strMap.get(key).add(s);
        }
        
        return new ArrayList<List<String>>(strMap.values());
    }
    
    public static int[] topKFrequentSort(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
        
        for(int n : nums)
        {
        	freqMap.put(n, freqMap.getOrDefault(n, 0)+1);
        }
        
        List<int[]> freqList = new ArrayList<int[]>();
        
        for(Map.Entry<Integer, Integer> entry: freqMap.entrySet())
        {
        	freqList.add(new int[] {entry.getValue(), entry.getKey()});
        }
        
        freqList.sort((a,b)->b[0]-a[0]);
        
        int[] op = new int[k];
        
        for(int i=0;i<k;i++)
        {
        	op[i] = freqList.get(i)[1];
        }
        
        return op;
    }
    
    public static int[] topKFrequent(int[] nums, int k) {
    	Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
    	
    	for(int n:nums)
    	{
    		freqMap.put(n, freqMap.getOrDefault(n, 0)+1);
    	}
    	
    	List<Integer>[] freqArr = new List[nums.length+1];
    	
    	for(int i=0;i<freqArr.length;i++)
    	{
    		freqArr[i]=new ArrayList<Integer>();
    	}
    	
    	for(Map.Entry<Integer, Integer> entry: freqMap.entrySet())
    	{
    		freqArr[entry.getValue()].add(entry.getKey());
    	}
    	
    	int [] op= new int[k];
    	int j=0;
    	
    	for(int i=freqArr.length-1;i>=0;i--)
    	{
    		for(int n:freqArr[i])
    		{
        		op[j] = n;
        		j++;
    		}
    		
    		if(j==k)
    		{
    			return op;
    		}
    		
    	}
    	
    	return new int[] {};
    }
	
    public static String encode(List<String> strs) {
    	
    	StringBuilder sb=new StringBuilder();
    	for(String s:strs)
    	{
    		sb.append(s.length()).append("#").append(s);
    	}
    	return sb.toString();
    }

    public static List<String> decode(String str) {
    	List<String> response = new ArrayList<String>();
    	
    	int i=0;
    	while(i<str.length())
    	{
    		int j = i;
    		
    		while(str.charAt(j)!='#')
    		{
    			j++;
    		}
    		
    		int len = Integer.parseInt(str.substring(i,j));
    		
    		i=j+1;
    		j=i+len;
    		response.add(str.substring(i,j));
    		i=j;
    	}
    	return response;
    }
    
    public static int[] productExceptSelf(int[] nums) {
    	
    	int[] pre=new int[nums.length];
    	int[] suf=new int[nums.length];
        
    	pre[0]=1;
    	suf[nums.length-1]=1;
    	
    	for(int i=1;i<nums.length;i++)
    	{
    		pre[i]= pre[i-1]*nums[i-1];
    	}
    	
    	for(int i=nums.length-2;i>=0;i--)
    	{
    		suf[i]=suf[i+1]*nums[i+1];
    	}
    	
    	int[] res = new int[nums.length];
    	for(int i=0;i<nums.length;i++)
    	{
    		res[i]=pre[i]*suf[i];
    	}
    	return res;
    }
    
    public static int longestConsecutive(int[] nums) {
        Set<Integer> numset = new HashSet<Integer>();
        
        for(int n:nums)
        {
        	numset.add(n);
        }
        
        int sequence=0;
        
        for(int n:numset)
        {
        	if(!numset.contains(n-1))
        	{
        		int len=1;
        		while(numset.contains(n+len))
        		{
        			len++;
        		}
        		sequence=Math.max(len, sequence);
        	}
        }
        return sequence;
    }
    
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        
        for(char c:s.toCharArray())
        {
        	if(c=='(' || c=='{' || c=='[')
        	{
        		stack.push(c);
        	}
        	else
        	{
        		if(stack.isEmpty())
        		{
        			return false;
        		}
        		
        		if((c==')' && stack.peek()=='(')
        				|| (c=='}' && stack.peek()=='{')
        				|| (c==']' && stack.peek()=='['))
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
    
	public static void main(String args[])
	{
//		int[] nums = {5,700,100,31,33};
//		System.out.println(hasDuplicate(nums));
		
//		String s="pot" , t="top";
//		System.out.println(isAnagram(s, t));
		
//		int[] nums = {3,4,5,6};
//		int target = 9;
//		System.out.println(Arrays.toString(twoSum(nums, target)));
		
//		String[] strs = {"act","pots","tops","cat","stop","hat"};
//		System.out.println(groupAnagrams(strs).toString());
		
//		int[] nums = {1,2,2,3,3,3};
//		int k = 2;
//		System.out.println(Arrays.toString(topKFrequent(nums, k)));
		
//		List<String> strs = Arrays.asList("neet","code","love","you");
//		String encodeStr = encode(strs);
//		System.out.println("Encoded String:"+encodeStr);
//		System.out.println("Decoded OP:"+decode(encodeStr).toString());
		
//		int[] nums = {1,2,4,6};
//		System.out.println(Arrays.toString(productExceptSelf(nums)));
		
//		int[] nums = {2,20,4,10,3,4,5};
//		System.out.println(longestConsecutive(nums));
		
//		String s="([{}])";
//		System.out.println(isValid(s));
		
		MinStack2 minStack = new MinStack2();
		minStack.push(1);
		minStack.push(2);
		minStack.push(0);
		System.out.println("min>"+minStack.getMin()); // return 0
		minStack.pop();
		System.out.println("top>"+minStack.top());    // return 2
		System.out.println("min>"+minStack.getMin()); // return 1
	}
}

class MinStack2 {

	Stack<Integer> stack;
	Stack<Integer> minStack;
	
    public MinStack2() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }
    
    public void push(int val) {
        stack.push(val);
        
        if(minStack.isEmpty() || val<=minStack.peek())
        {
        	minStack.push(val);
        }
    }
    
    public void pop() {
        int pop = stack.pop();
        if(pop==minStack.peek())
        {
        	minStack.pop();
        }
    }
    
    public int top() {
       return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

