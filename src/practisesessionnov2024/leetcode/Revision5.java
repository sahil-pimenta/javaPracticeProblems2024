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

class MinStack5 {
	Stack<Integer> stack;
	Stack<Integer> mStack;
	
    public MinStack5() {
    	stack = new Stack<>();
    	mStack = new Stack<>();
    }
    
    public void push(int val) {
    	stack.push(val);
    	
    	if(mStack.isEmpty() || val<=mStack.peek())
    	{
    		mStack.push(val);
    	}
    }
    
    public void pop() {
    	if(stack.isEmpty())return;
    	
    	int  pop = stack.pop();
    	if(mStack.peek()==pop)
    	{
    		mStack.pop();
    	}
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return mStack.peek();
    }
}

class TimeMap1 {

	Map<String, TreeMap<Integer,String>> timeMap;
	
    public TimeMap1() {
        timeMap= new TreeMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(timeMap.containsKey(key))
        {
        	timeMap.get(key).put(timestamp, value);
        }
        else
        {
        	TreeMap<Integer,String> map = new TreeMap<>();
        	map.put(timestamp, value);
        	timeMap.put(key, map);
        }
    }
    
    public String get(String key, int timestamp) {
        if(!timeMap.containsKey(key))
        {
        	return "";
        }
        
        TreeMap<Integer,String> map = timeMap.get(key);
        
        Map.Entry<Integer, String> entry = map.floorEntry(timestamp);
        
        if(entry!=null)
        {
        	return entry.getValue();
        }
        
        return "";
    }
}

public class Revision5 {
	
    public static boolean hasDuplicate(int[] nums) {
    	 Set<Integer> numSet = new HashSet<Integer>();
    	 
    	 for(int n:nums)
    	 {
    		 if(!numSet.contains(n))
    		 {
    			 numSet.add(n);
    		 }
    		 else
    		 {
    			 return true;
    		 }
    	 }
    	 
    	 return false;
    }
    
    public static boolean isAnagram(String s, String t) {
    	
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
    
    public static boolean isAnagram2(String s, String t) {
    	if(s.length()!=t.length())
    	{
    		return false;
    	}
    	
    	Map<Character, Integer> sMap = new HashMap<Character, Integer>();
    	Map<Character, Integer> tMap = new HashMap<Character, Integer>();
    	
    	for(int i=0;i<s.length();i++)
    	{
    		sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0)+1);
    		tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0)+1);
    	}
    	
    	return sMap.equals(tMap);
    }
    
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i=0;i<nums.length;i++)
        {
        	map.put(nums[i], i);
        }
        
        for(int i=0;i<nums.length;i++)
        {
            int diff=target-nums[i];
            if(map.containsKey(diff) && i!=map.get(diff))
            {
            	return new int[] {i, map.get(diff)};
            }
        }
        return new int[] {};
    }
    
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> resp = new HashMap<>();
        
        for(String s : strs)
        {
        	int[] count = new int[26];
        	for(char c : s.toCharArray())
        	{
        		count[c-'a']++;
        	}
        	
        	String key = Arrays.toString(count);
        	resp.putIfAbsent(key, new ArrayList<String>());
        	resp.get(key).add(s);
        }
        
        return new ArrayList<>(resp.values());
    }
    
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int n:nums)
        {
        	map.put(n, map.getOrDefault(n, 0)+1);
        }
        
        List<int[]> freqArr = new ArrayList<>();
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet())
        {
        	freqArr.add(new int[] {entry.getValue(), entry.getKey()});
        }
        
        freqArr.sort((a,b)->b[0]-a[0]);
        
        int op[] = new int[k];
        
        for(int i=0;i<k;i++)
        {
        	op[i]=freqArr.get(i)[1];
        }
        
        return op;
    }
    
    public static int[] topKFrequent2(int[] nums, int k) {
    	Map<Integer, Integer> map = new HashMap<>();
    	
    	for(int n:nums)
    	{
    		map.put(n, map.getOrDefault(n, 0)+1);
    	}
    	
    	List<Integer>[] freqList = new List[nums.length+1];
    	
    	for(int i=0;i<freqList.length;i++)
    	{
    		freqList[i] = new ArrayList<>();
    	}
    	
    	for(Map.Entry<Integer, Integer> entry: map.entrySet())
    	{
    		freqList[entry.getValue()].add(entry.getKey());
    	}
    	
    	int[] op = new int[k];
    	int j=0;
    	for(int i=freqList.length-1;i>=0;i--)
    	{
    		for(int n: freqList[i])
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
    	List<String> resp = new ArrayList<String>();
    	
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
    		resp.add(str.substring(i,j));
    		i=j;
    	}
    	
    	return resp;
    }
    
    public static int[] productExceptSelf(int[] nums) {
    	int len = nums.length;
        int[] op = new int[len];
        int[] prefix = new int[len];
        int[] suffix = new int[len];
        
        prefix[0]=1;
        suffix[len-1]=1;
        
        for(int i=1;i<nums.length;i++)
        {
        	prefix[i]=prefix[i-1] * nums[i-1];
        }
        
        for(int i=nums.length-2;i>=0;i--)
        {
        	suffix[i]=suffix[i+1]*nums[i+1];
        }
        
        for(int i=0;i<nums.length;i++)
        {
        	op[i]=prefix[i]*suffix[i];
        }
        
        return op;
    }
    
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        for(int n:nums)
        {
        	set.add(n);
        }
        
        int longestSeq = 0;
        
        for(int n:set)
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
    
    public static boolean isValidParentheses(String s) {
        Stack<Character> stack = new Stack<Character>();
        
        for(char c : s.toCharArray())
        {
        	if(c=='(' || c=='{' || c=='[')
        	{
        		stack.add(c);
        	}
        	else
        	{
        		//closing bracket
        		
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
        Stack<Integer> operands=new Stack<>();
        
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
    			int result = stack.pop();
    			op[result] = i-result;
    		}
    		
    		stack.push(i);
    	}
    	
    	return op;
    }
    
    public static boolean isPalindrome(String s) {
        int l=0, r=s.length()-1;
        
        while(l<r)
        {
        	while(l<r && !isAplhaNum(s.charAt(l)))
        	{
        		l++;
        	}
        	
        	while(l<r && !isAplhaNum(s.charAt(r)))
        	{
        		r--;
        	}
        	
        	if(Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r)))
        	{
        		return false;
        	}
        	
        	l++;
        	r--;
        }
        
        return true;
    }
    
    public static boolean isAplhaNum(char c)
    {
    	return (c>='a' && c<='z') || (c>='A' && c<='Z') || (c>='0' && c<='9');
    }
    
    public static int[] twoSum2(int[] numbers, int target) {
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
        Arrays.sort(nums);
        
        List<List<Integer>> op = new ArrayList<>();
        
        for(int i=0;i<nums.length;i++)
        {
        	if(nums[i]>0)break;
        	if(i>0 && nums[i]==nums[i-1])continue;
        	
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
    
    public static int maxArea(int[] height) {
        int l=0, r=height.length-1;
        
        int maxArea = Integer.MIN_VALUE;
        
        while(l<r)
        {
        	int area = Math.min(height[l],  height[r]) * (r-l) ;
        	maxArea = Math.max(maxArea, area);
        	
        	if(height[l]>=height[r])
        	{
        		r--;
        	}
        	else
        	{
        		l++;
        	}
        }
        return maxArea;
    }
    
    
    public static int binarySearch(int[] nums, int target) {
        int l=0, r=nums.length-1;
        
        while(l<=r)
        {
        	int m = l+(r-l)/2;
        	
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
        int rows=matrix.length-1, cols = matrix[0].length-1;
        
        int l=0, r=rows;
        
        while(l<=r)
        {
        	int m = (l+r)/2;
        	
        	if(target > matrix[m][cols])
        	{
        		l=m+1;
        	}
        	else if(target < matrix[m][0])
        	{
        		r=m-1;
        	}
        	else
        	{
        		break;
        	}
        }
        
        int row = (l+r)/2;
        
        l=0;
        r=cols; //matrix[row].length
        
        while(l<=r)
        {
        	int m = (l+r)/2;
        	
        	if(target > matrix[row][m])
        	{
        		l=m+1;
        	}
        	else if(target < matrix[row][m])
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
        int l=1;
        int r = Integer.MIN_VALUE;
        for(int p:piles)
        {
        	if(p>r)
        	{
        		r=p;
        	}
        }
        
        int minSpeed = Integer.MAX_VALUE;
        
        while(l<=r)
        {
        	int k = l+(r-l)/2;
        	
        	long time=0;
        	for(int n:piles)
        	{
        		time+=Math.ceil((double)n/k);
        	}
        	
        	if(time <= h)
        	{
        		minSpeed = k;
        		r=k-1;
        	}
        	else
        	{
        		l=k+1;
        	}
        }
        return minSpeed;
    }
    
    public static int findMinRotatedSortedArr(int[] nums) {
        int l=0, r=nums.length-1;
        
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
    
    public static int searchRotatedSortedArr(int[] nums, int target) {
        int l=0, r=nums.length-1;
        
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
        
        int minIdx = l;
        l=0;
        r=nums.length-1;
        
        if((target>=nums[minIdx]) && (target<=nums[r]))
        {
        	l=minIdx;
        }
        else
        {
        	r=minIdx-1;
        }
        	
        while(l<=r)
        {
        	int m = (l+r)/2;
        	
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
    
    public static int slidingWinBruteForce(int[] nums, int w)
    {
    	int maxSum=Integer.MIN_VALUE;
    	
    	for(int i=0;i<=(nums.length-w);i++)
    	{
    		int sum=0;
    		for(int j=i;j<=(i+w-1);j++)
    		{
    			sum+=nums[j];
    		}
    		maxSum=Math.max(maxSum, sum);
    	}
    	
    	return maxSum;
    }
    
    public static int slidingWin(int[] nums, int w)
    {
    	int sum=0;
    	for(int i=0;i<w;i++)
    	{
    		sum+=nums[i];
    	}
    	
    	int maxSum = sum;
    	
    	for(int i=1;i<=(nums.length-w);i++)
    	{
    		sum=sum-nums[i-1]+nums[i+w-1];
    		
        	if(sum>maxSum)
        	{
        		maxSum=sum;
        	}
    	}
    	
    	return maxSum;
    }
    
	public static void main(String args[])
	{
//		int[] nums = {1, 2, 3, 4};
//		System.out.println(hasDuplicate(nums));
		
//		String s = "racecar", t = "carrace";
//		System.out.println(isAnagram2(s, t));
		
//		int[] nums = {3,2,4};
//		int target = 6;
//		System.out.println(Arrays.toString(twoSum(nums, target)));
		
//		String [] strs = {"act","pots","tops","cat","stop","hat"};
//		System.out.println(groupAnagrams(strs).toString());
		
//		int[] nums = {1,1,1,2,2,3};
//		int k = 2;
//		System.out.println(Arrays.toString(topKFrequent2(nums, k)));
		
//		List<String> strs = Arrays.asList("neet","code","love","you");
//		String encodedStr = encode(strs);
//		System.out.println(encodedStr);
//		System.out.println(decode(encodedStr).toString());
		
//		int[] nums = {-1,1,0,-3,3};
//		System.out.println(Arrays.toString(productExceptSelf(nums)));
		
//		int[] nums = {0,3,7,2,5,8,4,6,0,1};
//		System.out.println(longestConsecutive(nums));
		
//		String s = "([{}])";
//		System.out.println(isValidParentheses(s));
		
//		MinStack5 minStack = new MinStack5();
//		minStack.push(1);
//		minStack.push(2);
//		minStack.push(0);
//		System.out.println(minStack.getMin()); // return 0
//		minStack.pop();
//		System.out.println(minStack.top());    // return 2
//		System.out.println(minStack.getMin()); // return 1
		
//		String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
//		System.out.println(evalRPN(tokens));
		
//		int[] temperatures = {73,74,75,71,69,72,76,73};
//		System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
		
//		String s = "A man, a plan, a canal: Panama";
//		System.out.println(isPalindrome(s));
		
//		int[] numbers = {2,3,4};
//		int target = 6;
//		System.out.println(Arrays.toString(twoSum2(numbers, target)));
		
//		int[] nums = {-1,0,1,2,-1,-4};
//		System.out.println(threeSum(nums).toString());
		
//		int[] height = {2,2,2};
//		System.out.println(maxArea(height));
		
//		int[] nums = {-1,0,3,5,9,12};
//		int target = 12;
//		System.out.println(binarySearch(nums, target));
		
//		int[][] matrix = {{1,3,5,7}, {10,11,16,20}, {23,30,34,60}};
//		int target = 21;
//		System.out.println(searchMatrix(matrix, target));
		
//		int[] piles = {3,6,7,11};
//		int h = 8;
//		System.out.println(minEatingSpeed(piles, h));
		
//		int[] nums = {11,13,15,17};
//		System.out.println(findMinRotatedSortedArr(nums));
		
//		int[] nums = {3,4,5,6,1,2};
//		int target=4;
//		System.out.println(searchRotatedSortedArr(nums, target));
		
//		TimeMap1 timeMap = new TimeMap1();
//		timeMap.set("foo", "bar", 1);  // store the key "foo" and value "bar" along with timestamp = 1.
//		System.out.println(timeMap.get("foo", 1));         // return "bar"
//		System.out.println(timeMap.get("foo", 3));         // return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
//		timeMap.set("foo", "bar2", 4); // store the key "foo" and value "bar2" along with timestamp = 4.
//		System.out.println(timeMap.get("foo", 4));         // return "bar2"
//		System.out.println(timeMap.get("foo", 5));         // return "bar2"
		
		int[] nums= {3,8,2,5,7,6,12};
		int w=4;
		System.out.println(slidingWin(nums, w));
	}
}
