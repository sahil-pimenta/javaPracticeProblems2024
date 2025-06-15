package practisesessionnov2024.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

class MinStack4 {

	Stack<Integer> stack;
	Stack<Integer> min;
	
    public MinStack4() {
        stack=new Stack<>();
        min=new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(min.isEmpty() || val<=min.peek())
        {
        	min.push(val);
        }
    }
    
    public void pop() {
    	if(stack.isEmpty()) return;
    	
        int pop = stack.pop();
        
        if(min.peek()==pop)
        {
        	min.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}

class TimeMap2 {

	Map<String, TreeMap<Integer,String>> map;
	
    public TimeMap2() {
    	map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(map.containsKey(key))
        {
        	TreeMap<Integer,String> tree=map.get(key);
        	tree.put(timestamp, value);
        	map.put(key, tree);
        }
        else
        {
        	TreeMap<Integer,String> tree=new TreeMap<>();
        	tree.put(timestamp, value);
        	map.put(key, tree);
        }
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key))return "";
        
        TreeMap<Integer,String> tree = map.get(key);
        
        Map.Entry<Integer, String> entry = tree.floorEntry(timestamp);
        
        if(entry!=null)
        {
        	return entry.getValue();
        }
        
        return "";
    }
}

public class Revision4 {

    public static boolean hasDuplicate(int[] nums) {
    	 Set<Integer> set = new HashSet<Integer>();
    	 
    	 for(int n:nums)
    	 {
    		 if(set.contains(n))
    		 {
    			 return true;
    		 }
    		 
    		 set.add(n);
    	 }
    	 return false;
    }
    
    public static boolean isAnagram(String s, String t) {
    	
    	if(s.length()!=t.length())
    	{
    		return false;
    	}
    	
    	int[] count = new int[26];
    	
    	for(char c : s.toCharArray())
    	{
    		count[c-'a']++;
    	}
    	
    	for(char c : t.toCharArray())
    	{
    		count[c-'a']--;
    	}
    	
    	for(int n: count)
    	{
    		if(n!=0)
    		{
    			return false;
    		}
    	}
    	
    	return true;
    }
    
    public static boolean isAnagramUsingMap(String s, String t) {
    	
    	if(s.length()!=t.length())
    	{
    		return false;
    	}
    	
    	Map<Character, Integer> sMap = new HashMap<>();
    	Map<Character, Integer> tMap = new HashMap<>();
    	
    	for(int i=0;i<s.length(); i++)
    	{
    		sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0)+1);
    		tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0)+1);
    	}
    	
    	return sMap.equals(tMap);
    }
    
    
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i=0;i<nums.length;i++)
        {
        	map.put(nums[i], i);
        }
        
        for(int i=0;i<nums.length;i++)
        {
        	int diff = target - nums[i];
        	
        	if(map.containsKey(diff) && (map.get(diff)!=i))
        	{
        		return new int[] {i, map.get(diff)};
        	}
        }
        return new int[] {};
    }
    
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for(String s:strs)
        {
        	int[] count = new int[26];
        	
        	for(char c : s.toCharArray())
        	{
        		count[c-'a']++;
        	}
        	
        	String key = Arrays.toString(count);
        	map.putIfAbsent(key, new ArrayList<String>());
        	map.get(key).add(s);
        }
        
        return new ArrayList<List<String>>(map.values());
    }
    
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int n:nums) {
        	map.put(n, map.getOrDefault(n, 0)+1);
        }
        
        List<Integer>[] freqArr = new List[nums.length+1];
        
        for(int i=0;i<freqArr.length;i++)
        {
        	freqArr[i] = new ArrayList<>();
        }
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet())
        {
        	freqArr[entry.getValue()].add(entry.getKey());
        }
        
        int[] op = new int[k];
        int j=0;
        
        for(int i=nums.length-1;i>=0;i--)
        {
        	for(int n:freqArr[i])
        	{
        		op[j]=n;
        		j++;
        		
            	if(j==k)
            	{
            		return op;
            	}
        	}
        }
        return new int[] {};
    }
    
    public static String encode(List<String> strs) {
    	StringBuilder sb = new StringBuilder();
    	for(String s:strs)
    	{
    		sb.append(s.length()).append('#').append(s);
    	}
    	
    	return sb.toString();
    }

    public static List<String> decode(String str) {
    	List<String> resp = new ArrayList<>();
    	
    	int i=0;
    	
    	while(i<str.length())
    	{
    		int j=i;
    		
    		while(str.charAt(j)!='#')
    		{
    			j++;
    		}
    		
    		int len = Integer.parseInt(str.substring(i,j));
    		i=j+1;
    		j=i+len;
    		
    		resp.add(str.substring(i,j));
    		i=j;
    	}
    	return resp;
    }
    
    public static int[] productExceptSelf(int[] nums) {
        
    	int[] prefix = new int[nums.length];
    	int[] suffix = new int[nums.length];
    	
    	prefix[0]=1;
    	suffix[nums.length-1]=1;
    	
    	for(int i=1;i<nums.length;i++)
    	{
    		prefix[i] = prefix[i-1] * nums[i-1];
    	}
    	
    	for(int i=nums.length-2;i>=0;i--)
    	{
    		suffix[i] = suffix[i+1] * nums[i+1];
    	}
    	
    	for(int i=0;i<nums.length;i++)
    	{
    		nums[i] = prefix[i] * suffix[i];
    	}
    	
    	return nums;
    }
    
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        for(int n:nums)
        {
        	set.add(n);
        }
    	
        int longestSeq = 0;
        
        for(int n : set)
        {
        	if(!set.contains(n-1))
        	{
        		int len=1;
        		
        		while(set.contains(n+len))
        		{
        			len++;
        		}
        		
            	longestSeq = Math.max(len, longestSeq);
        	}
        }
        return longestSeq;
    }
    
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(char c : s.toCharArray())
        {
        	if(c=='(' || c=='{' || c=='[')
        	{
        		stack.push(c);
        	}
        	else
        	{
        		//closing brackets
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
    
    public static int evalRPN(String[] tokens) {
        Stack<Integer> operands = new Stack<>();
        
        for(String s: tokens)
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
        int[] op = new int[temperatures.length];
    	Stack<Integer> stack = new Stack<>();
    	
    	for(int i=0;i<temperatures.length;i++)
    	{
    		while(!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()])
    		{
    			int idx=stack.pop();
    			op[idx]=i-idx;
    		}
    		
    		stack.push(i);
    	}
    	return op;
    }
    
    public static boolean isPalindrome(String s) {
    	s=s.toLowerCase();
        int l=0,r=s.length()-1;
        
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
    	return ((c>='a' && c<='z')
    			|| (c>='0' && c<='9'));
    }
    
    public static int[] twoSumII(int[] numbers, int target) {
        int l=0, r=numbers.length-1;
        
        while(l<r)
        {
        	int sum = numbers[l]+numbers[r];
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
        		return new int[] {l+1, r+1};
        	}
        }
        
        return new int[] {};
    }
    
    
    public static List<List<Integer>> threeSum(int[] nums) {
        
    	List<List<Integer>> resp = new ArrayList<>();
    	
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
    			int sum=nums[i]+nums[j]+nums[k];
    			
    			if(sum>0)
    			{
    				k--;
    			}
    			else if(sum<0)
    			{
    				j++;
    			}
    			else {
    				resp.add(Arrays.asList(nums[i],nums[j],nums[k]));
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
    	
    	return resp;
    }
    
    public static int maxArea(int[] heights) {
        int l=0,r=heights.length-1;
        
        int maxArea = Integer.MIN_VALUE;
        
        while(l<r)
        {
        	int area = Math.min(heights[l],heights[r]) * (r-l);
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
    
    public static int binarySearch(int[] nums, int target) {
        int l=0,r=nums.length-1;
        
        while(l<=r)
        {
        	int m= l+(r-l)/2;
        	
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
        int rows=matrix.length;
        int cols=matrix[0].length;
        
        int top=0, bottom=rows-1;
        
        while(top<=bottom)
        {
        	int m=(top+bottom)/2;
        	
        	if(target>matrix[m][cols-1])
        	{
        		top=m+1;
        	}
        	else if(target<matrix[m][0])
        	{
        		bottom=m-1;
        	}
        	else
        	{
        		break;
        	}
        }
        
        int row=(top+bottom)/2;
        
        int l=0, r=cols-1;
        
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
    
    public static int minEatingSpeed(int[] piles, int h) {
    	int op=Integer.MAX_VALUE;
    	
        int l=1;
        int r=Integer.MIN_VALUE;
        for(int n:piles)
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
        		r--;
        	}
        	else
        	{
        		l++;
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
        	int m = l+(r-l)/2;
        	
        	if(nums[m]>nums[r])
        	{
        		l=m+1;
        	}
        	else
        	{
        		r=m;
        	}
        }
        
        int minIdx=l;
        
        if(nums[minIdx]==target)
        {
        	return minIdx;
        }
        
        l=0;
        r=nums.length-1;
        
        if(target>=nums[minIdx] && target<=nums[r])
        {
        	l=minIdx;
        }
        else
        {
        	r=minIdx-1;
        }
        
        while(l<=r)
        {
        	int m =l+(r-l)/2;
        	
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
    
    public static void main(String args[])
    {
//    	int[] nums = {1, 2, 3, 3};
//    	System.out.println(hasDuplicate(nums));
    	
//    	String s = "racecar", t = "carrace";
//    	System.out.println(isAnagramUsingMap(s, t));
    	
//    	int[] nums = {3,4,5,6};
//    	int target=7;
//    	System.out.println(Arrays.toString(twoSum(nums, target)));
    	
//    	String[] strs = {"act","pots","tops","cat","stop","hat"};
//    	System.out.println(groupAnagrams(strs).toString());
    	
//    	int[] nums = {1,2,2,3,3,3,2,1,1};
//    	int k = 2;
//    	System.out.println(Arrays.toString(topKFrequent(nums, k)));
    	
//    	List<String> strs = Arrays.asList("neet","coders","loves","you");
//    	String str = encode(strs);
//    	System.out.println("encoded>>"+str);
//    	System.out.println(decode(str).toString());
    	
//    	int[] nums = {-1,0,1,2,3};
//    	System.out.println(Arrays.toString(productExceptSelf(nums)));
    	
//    	int[] nums = {0,3,2,5,4,6,1,1};
//    	System.out.println(longestConsecutive(nums));
    	
//    	String s = "([{}])";
//    	System.out.println(isValid(s));
    	
//    	MinStack4 minStack = new MinStack4();
//    	minStack.push(1);
//    	minStack.push(2);
//    	minStack.push(0);
//    	System.out.println(minStack.getMin()); // return 0
//    	minStack.pop();
//    	System.out.println(minStack.top());    // return 2
//    	System.out.println(minStack.getMin()); // return 1
    	
//    	String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
//    	System.out.println(evalRPN(tokens));
    	
//    	int[] temperatures = {30,38,30,36,35,40,28};
//    	System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
    	
//    	String s = "A man, a plan, a canal: Panama";
//    	System.out.println(isPalindrome(s));
    	
//    	int[] numbers = {2,3,4};
//    	int target = 6;
//    	System.out.println(Arrays.toString(twoSumII(numbers, target)));
    	
//    	int[] nums = {-1,0,1,2,-1,-4};
//    	System.out.println(threeSum(nums).toString());
    	
//    	int[] height = {1,1};
//    	System.out.println(maxArea(height));
    	
//    	int[] nums = {-1,0,2,4,6,8};
//    	int target = 6;
//    	System.out.println(binarySearch(nums, target));
    	
//    	int[][] matrix = {{1,2,4,8},{10,11,12,13},{14,20,30,40}};
//    	int target = 14;
//    	System.out.println(searchMatrix(matrix, target));
    	
//    	int[] piles = {30,11,23,4,20};
//    	int h = 6;
//    	System.out.println(minEatingSpeed(piles, h));
    	
//    	int[] nums = {4,5,0,1,2,3};
//    	System.out.println(findMin(nums));
    	
//    	int[] nums = {3,4,5,6,1,2};
//    	int target=1;
//    	System.out.println(searchRotatedArr(nums, target));
    	
    	TimeMap2 timeMap = new TimeMap2();
    	timeMap.set("alice", "happy", 1);  // store the key "alice" and value "happy" along with timestamp = 1.
    	System.out.println(timeMap.get("alice", 1));           // return "happy"
    	System.out.println(timeMap.get("alice", 2));           // return "happy", there is no value stored for timestamp 2, thus we return the value at timestamp 1.
    	timeMap.set("alice", "sad", 3);    // store the key "alice" and value "sad" along with timestamp = 3.
    	System.out.println(timeMap.get("alice", 3));           // return "sad"
    }
}
