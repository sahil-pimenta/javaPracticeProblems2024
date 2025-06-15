package practisesessionnov2024.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

class MinStack1
{
	Stack<Integer> stack;
	Stack<Integer> mstack;
	
	public MinStack1()
	{
		stack = new Stack<>();
		mstack = new Stack<>();
	}
	
	public void push(int val)
	{
		stack.push(val);
		
		if(mstack.isEmpty() || val <= mstack.peek())
		{
			mstack.push(val);
		}
	}
	
	public void pop()
	{
		int pop = stack.pop();
		
		if(mstack.peek()==pop)
		{
			mstack.pop();
		}
	}
	
	public int top()
	{
		return stack.peek();
	}
	
	public int getMin()
	{
		return mstack.peek();
	}
}

class TimeMap3 {

	Map<String, TreeMap<Integer,String>> map;
	
    public TimeMap3() {
    	map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key))
        {
        	TreeMap<Integer,String> mapEntry = new TreeMap<>();
        	mapEntry.put(timestamp, value);
        	map.put(key, mapEntry);
        }
        else
        {
        	map.get(key).put(timestamp,value);
        }
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key))return "";
        
        TreeMap<Integer,String> mapEntry = map.get(key);
        
        Entry<Integer,String> entry = mapEntry.floorEntry(timestamp);
        
        return entry!=null?entry.getValue():"";
    }
}

class ListNode9 {
	int val;
	ListNode9 next;

	ListNode9() {
	}

	ListNode9(int val) {
		this.val = val;
	}

	ListNode9(int val, ListNode9 next) {
		this.val = val;
		this.next = next;
	}
}

class Node10 {
    int val;
    Node10 next;
    Node10 random;

    public Node10(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class Node11 {
    int val;
    int key;
    Node11 next;
    Node11 prev;
    
    
    public Node11() {
    	
    }
    public Node11(int key,int val) {
        this.val = val;
        this.key = key;
        this.next = null;
        this.prev = null;
    }
}

class LRUCache3 {

	int capacity;
	Map<Integer,Node11> map;
	Node11 left;
	Node11 right;
	
    public LRUCache3(int capacity) {
        this.capacity=capacity;
        map= new HashMap<>();
        this.left=new Node11();
        this.right=new Node11();
        this.left.next=this.right;
        this.right.prev=this.left;
    }
    
    public int get(int key) {
        if(map.containsKey(key))
        {
        	remove(map.get(key));
        	insert(map.get(key));
        	return map.get(key).val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key))
        {
        	remove(map.get(key));
        	map.remove(key);
        }

        Node11 node=new Node11(key, value);
    	map.put(key, node);
    	insert(node);
        
        if(map.size()>capacity)
        {
        	Node11 lru = left.next;
        	remove(lru);
        	map.remove(lru.key);
        }
    }
    
    private void remove(Node11 node)
    {
    	Node11 nodeP=node.prev;
    	Node11 nodeN=node.next;
    	
    	nodeP.next=nodeN;
    	nodeN.prev=nodeP;
    }
    
    private void insert(Node11 node)
    {
    	Node11 nodeP=right.prev;
    	nodeP.next=node;
    	node.next=right;
    	right.prev=node;
    	node.prev=nodeP;
    }
}

class TreeNode14 {
	int val;
	TreeNode14 left;
	TreeNode14 right;

	TreeNode14() {
	}

	TreeNode14(int val) {
		this.val = val;
	}

	TreeNode14(int val, TreeNode14 left, TreeNode14 right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

class TreeNode15 {
	int val;
	List<TreeNode15> neighbors;
	boolean visited;

	TreeNode15() {
		this.neighbors = new ArrayList<>();
		this.visited=false;
	}

	TreeNode15(int val) {
		this.val = val;
		this.neighbors = new ArrayList<>();
		this.visited=false;
	}

	TreeNode15(int val, List<TreeNode15> neighbors) {
		this.val = val;
		this.neighbors = new ArrayList<>();
		this.neighbors.addAll(neighbors);
		this.visited=false;
	}
}

class Node12 {
    public int val;
    public List<Node12> neighbors;
    public Node12() {
        val = 0;
        neighbors = new ArrayList<Node12>();
    }
    public Node12(int _val) {
        val = _val;
        neighbors = new ArrayList<Node12>();
    }
    public Node12(int _val, ArrayList<Node12> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class RevisionFull01 
{
    public static boolean containsDuplicate(int[] nums) 
    {
        Set<Integer> set = new HashSet<Integer>();
        
        for(int n:nums)
        {
        	if(set.contains(n))return true;
        	
        	set.add(n);
        }
        return false;
    }
    
    public static boolean isAnagram(String s, String t) 
    {
        if(s.length()!=t.length())return false;
        
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        
        for(int i=0;i<s.length();i++)
        {
        	sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0)+1);
        	tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0)+1);
        }
        
        return sMap.equals(tMap);
    }
    
    public static boolean isAnagram2(String s, String t) 
    {
    	if(s.length()!=t.length())return false;
    	
    	int[] count=new int[26];
    	
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
    		if(n!=0)return false;
    	}
    	return true;
    }
    
    public static int[] twoSum(int[] nums, int target) 
    {
    	Map<Integer, Integer> map = new HashMap<>();
    	
        for(int i=0;i<nums.length;i++)
        {
        	map.put(nums[i], i);
        }
        
        for(int i=0;i<nums.length;i++)
        {
        	int diff = target-nums[i];
        	
        	if((map.containsKey(diff))
        			&& (i!=map.get(diff)))
        	{
        		return new int[] {i, map.get(diff)};
        	}
        }
        
        return new int[] {};
    }
	
    public static List<List<String>> groupAnagrams(String[] strs) 
    {
        Map<String, List<String>> map = new HashMap<>();
        
        for(String str : strs)
        {
        	int[] count = new int[26];
        	
        	for(char s : str.toCharArray())
        	{
        		count[s-'a']++;
        	}
        	
        	String key = Arrays.toString(count);
        	
        	map.putIfAbsent(key, new ArrayList<String>());
        	map.get(key).add(str);
        }
        
        return new ArrayList<>(map.values());
    }
    
    public static int[] topKFrequent(int[] nums, int k) 
    {
        Map<Integer,Integer> countMap = new HashMap<>();
        
        for(int n:nums)
        {
        	countMap.put(n, countMap.getOrDefault(n, 0)+1);
        }
        
        List<Integer>[] freqArr = new List[nums.length+1];
        
        for(int i=0;i<freqArr.length;i++)
        {
        	freqArr[i] = new ArrayList<>();
        }
        
        for(Entry<Integer, Integer> entry: countMap.entrySet())
        {
        	freqArr[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];
        int j=0;
        
        for(int i=freqArr.length-1;i>=0;i--)
        {
        	for(int n : freqArr[i])
        	{
        		res[j]=n;
        		j++;
        		
        		if(j==k)
        		{
        			return res;
        		}
        	}
        }
        
        return new int[] {};
    }
    

    public static String encode(List<String> strs) 
    {
    	StringBuilder sb = new StringBuilder();
    	
    	for(String str:strs)
    	{
    		sb.append(str.length()).append("#").append(str);
    	}
    	return sb.toString();
    }

    public static List<String> decode(String str) 
    {
    	List<String> res = new ArrayList<>();
    	
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
    		res.add(str.substring(i,j));
    		i=j;
    	}
    	return res;
    }
    
    public static int[] productExceptSelf(int[] nums) 
    {
        int[] pre = new int[nums.length];
        int[] suf = new int[nums.length];
        
        pre[0]=1;
        suf[nums.length-1]=1;
        
        for(int i=1;i<nums.length;i++)
        {
        	pre[i]=nums[i-1]*pre[i-1];
        }
        
        for(int i=nums.length-2;i>=0;i--)
        {
        	suf[i]=nums[i+1]*suf[i+1];
        }
        
        int[] res = new int[nums.length];
        for(int i=0;i<res.length;i++)
        {
        	res[i]=pre[i]*suf[i];
        }
        
        return res;
    }
    
    public static int longestConsecutive(int[] nums) 
    {
    	Set<Integer> set = new HashSet<>();
    	
    	for(int n:nums)
    	{
    		set.add(n);
    	}
    	
    	int maxLen=0;
    	for(int n:set)
    	{
    		if(!set.contains(n-1))
    		{
    			int len=1;
    			while(set.contains(n+len))
    			{
    				len++;
    			}
    			maxLen=Math.max(maxLen, len);
    		}
    	}
    	
    	return maxLen;
    }
    
    public static boolean isValidParentheses(String s) {        
        Stack<Character> stack = new Stack<>();
        
        for(char c : s.toCharArray())
        {
        	if(c=='(' || c=='{' || c=='[')
        	{
        		stack.push(c);
        	}
        	else
        	{
        		if(stack.isEmpty()) return false;
        		
        		char pop = stack.pop();
        		
        		if(!((pop=='(' && c==')')
        				|| (pop=='{' && c=='}')
        				|| (pop=='[' && c==']')))
        		{
        			return false;
        		}
        	}
        }
        
        return stack.isEmpty();
    }
    
    public static int evalRPN(String[] tokens) {
        Stack<Integer> operand = new Stack<>();
        
        for(String s:tokens)
        {
        	if(s.equals("+"))
        	{
        		int b = operand.pop();
        		int a = operand.pop();
        		operand.push(a+b);
        	}
        	else if(s.equals("-"))
        	{
        		int b = operand.pop();
        		int a = operand.pop();
        		operand.push(a-b);
        	}
        	else if(s.equals("*"))
        	{
        		int b = operand.pop();
        		int a = operand.pop();
        		operand.push(a*b);
        	}
        	else if(s.equals("/"))
        	{
        		int b = operand.pop();
        		int a = operand.pop();
        		operand.push(a/b);
        	}
        	else
        	{
            	operand.push(Integer.parseInt(s));
        	}
        }
        
        return operand.peek();
    }
    
    public static int[] dailyTemperatures(int[] temperatures) 
    {
        Stack<Integer> stack = new Stack<>();
        int[] op = new int[temperatures.length];
        
        for(int i=0;i<temperatures.length;i++)
        {
        	while(!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()])
        	{
        		int res = stack.pop();
        		op[res] = i-res;
        	}
        	
        	stack.push(i);
        }
        return op;
    }
    
    public static boolean isPalindrome(String s) 
    {
        int l=0;
        int r=s.length()-1;
        
        while(l<r)
        {
        	while(l<r && !isAlphaNum(s.charAt(l))) {
        		l++;
        	}
        	
        	while(l<r && !isAlphaNum(s.charAt(r))) {
        		r--;
        	}
        	
        	if(Character.toLowerCase(s.charAt(l))!=Character.toLowerCase(s.charAt(r)))
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
    	return ((c>='a'&&c<='z')
    			|| (c>='A'&&c<='Z')
    			|| (c>='0'&&c<='9'));
    }
    
    public static int[] twoSum2(int[] nums, int target) 
    {
        int l=0, r=nums.length-1;
        
        while(l<r)
        {
        	int sum=nums[l]+nums[r];
        	
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
        List<List<Integer>> res = new ArrayList<>();
    	Arrays.sort(nums);
        
        for(int i=0;i<nums.length;i++)
        {
        	if(i-1>=0 && nums[i]==nums[i-1])continue;
        	
        	int j=i, k=nums.length-1;
        	
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
            		res.add(Arrays.asList(nums[i],nums[j],nums[k]));
            		
            		j++;
            		k--;
            		
            		while((j<k) && (nums[j]==nums[j-1]))
            		{
            			j++;
            		}
            		
            		while((j<k) && (nums[k]==nums[k+1]))
            		{
            			k--;
            		}
            	}
        	}
        }
        return res;
    }
    
    public static int maxAreaWaterContainer(int[] height) {
        int l=0, r=height.length-1;
        
        int maxArea = Integer.MIN_VALUE;
        
        while(l<r)
        {
        	int area = Math.min(height[l], height[r]) * (r-l);
        	maxArea = Math.max(maxArea, area);
        	
        	if(height[r]>=height[l])
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
        int l=0, r=nums.length-1;
        
        while(l<=r)
        {
        	int m=(l+r)/2;
        	
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
        int ROW=matrix.length;
        int COL=matrix[0].length;
        int rowFound=-1;
        
        int l=0, r=ROW-1;
        
        while(l<=r)
        {
        	int m = (l+r)/2;
        	
        	if(target > matrix[m][COL-1])
        	{
        		l=m+1;
        	}
        	else if(target < matrix[m][0])
        	{
        		r=m-1;
        	}
        	else
        	{
        		rowFound=m;
        		break;
        	}
        }
        
        if(rowFound==-1)return false;
        
        l=0;
        r=COL-1;
        
        while(l<=r)
        {
        	int m = (l+r)/2;
        	
        	if(target > matrix[rowFound][m])
        	{
        		l=m+1;
        	}
        	else if(target < matrix[rowFound][m])
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
    	int minTime=Integer.MAX_VALUE;
        int l = 0;
        
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
        	int k = (l+r)/2;
        	
        	long totalTime=0;
        	for(int n:piles)
        	{
        		totalTime+=Math.ceil((double)n/k);
        	}
        	
        	if(totalTime>h)
        	{
        		l=k+1;
        	}
        	else
        	{
        		minTime=Math.min(minTime, k);
        		r=k-1;
        	}
        }
        
        return minTime;
    }
    
    public static int findMin(int[] nums) {
        int l=0, r=nums.length-1;
        
        while(l<r)
        {
        	int m = (l+r)/2;
        	
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
    
    public static int searchRotatedArray(int[] nums, int target) {
        int l=0, r=nums.length-1;

        while(l<r)
        {
        	int m = (l+r)/2;
        	
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
        if(nums[minIdx]==target)return minIdx;
        
        l=0;
        r=nums.length-1;
        
        if(target>nums[minIdx] && target<=nums[r])
        {
        	l=minIdx+1;
        }
        else
        {
        	 r=minIdx-1;
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
    
    public static int maxSumSubarrayFL(int[] nums, int w)
    {
    	int sum=0;
    	for(int i=0;i<w;i++)
    	{
    		sum+=nums[i];
    	}
    	
    	int maxSum=sum;
    	
    	for(int i=1;i<=nums.length-w;i++)
    	{
    		sum = sum-nums[i-1]+nums[i+w-1];
    		
    		if(sum>maxSum)
    		{
    			maxSum=sum;
    		}
    	}
    	return maxSum;
    }
    
    public static int maxProfit(int[] prices) {
        int maxProfit=0;
        int l=0;
        
        for(int r=0;r<prices.length;r++)
        {
        	if(prices[r]<prices[l])
        	{
        		l=r;
        	}
        	
        	int profit = prices[r]-prices[l];
        	maxProfit=Math.max(maxProfit, profit);
        }
        return maxProfit;
    }
    
    public static int minSubArrayLen(int target, int[] nums) {
        int minLen=Integer.MAX_VALUE;
        int sum=0;
        int l=0;
        
        for(int r=0;r<nums.length;r++)
        {
        	sum+=nums[r];
        	
        	while(sum>=target)
        	{
        		int len=r-l+1;
        		minLen=Math.min(minLen, len);
        		
        		sum=sum-nums[l];
        		l++;
        	}
        }
        return minLen==Integer.MAX_VALUE?0:minLen;
    }
    
    public static int lengthOfLongestSubstring(String s) {
        int maxLen=0;
        int l=0;
        Set<Character> set = new HashSet<Character>();
        
        for(int r=0;r<s.length();r++)
        {
        	while(set.contains(s.charAt(r)))
        	{
        		set.remove(s.charAt(l));
        		l++;
        	}
        	
    		int len = r-l+1;
    		maxLen=Math.max(maxLen, len);
        	
        	set.add(s.charAt(r));
        }
        
        return maxLen;
    }
    
    public static int characterReplacement(String s, int k) {
        int[] count=new int[26];
        int maxLen=Integer.MIN_VALUE;
        int maxCount=0;
        int l=0;
        
        for(int r=0;r<s.length();r++)
        {
        	count[s.charAt(r)-'A']++;
        	maxCount=Math.max(maxCount, count[s.charAt(r)-'A']);
        	
        	while(((r-l+1)-maxCount) > k)
        	{
        		count[s.charAt(l)-'A']--;
        		l++;
        	}
        	
        	int len=r-l+1;
        	maxLen=Math.max(maxLen, len);
        }
        
        return maxLen;
    }
    
    public static boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length())return false;
        
        Map<Character,Integer> map1 = new HashMap<>();
        Map<Character,Integer> map2 = new HashMap<>();
        
        for(int i=0;i<s1.length();i++)
        {
        	map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i), 0)+1);
        	map2.put(s2.charAt(i), map2.getOrDefault(s2.charAt(i), 0)+1);
        }
        
        if(map1.equals(map2))return true;
        
        int l=0;
        
        for(int r=s1.length();r<s2.length();r++)
        {
        	map2.put(s2.charAt(r), map2.getOrDefault(s2.charAt(r),0)+1);
        	
        	map2.put(s2.charAt(l), map2.get(s2.charAt(l))-1);
        	
        	if(map2.get(s2.charAt(l))<=0)
        	{
        		map2.remove(s2.charAt(l));
        	}
        	l++;
        	
        	if(map1.equals(map2))return true;
        }
        return false;
    }
    
    public static ListNode9 reverseList(ListNode9 head) {
    	ListNode9 prev=null;
    	ListNode9 curr=head;
    	
    	while(curr!=null)
    	{
    		ListNode9 temp = curr.next;
    		curr.next=prev;
    		prev=curr;
    		curr=temp;
    	}
    	return prev;
    }
    
    public static ListNode9 mergeTwoLists(ListNode9 list1, ListNode9 list2) {
        ListNode9 dummy = new ListNode9(0);
        ListNode9 curr=dummy;
        
        while(list1!=null && list2!=null)
        {
        	if(list1.val<list2.val)
        	{
        		curr.next=list1;
        		list1=list1.next;
        	}
        	else
        	{
        		curr.next=list2;
        		list2=list2.next;
        	}
        	curr=curr.next;
        }
        
        if(list1==null)
        {
        	curr.next=list2;
        }
        else
        {
        	curr.next=list1;
        }
        return dummy.next;
    }
    
    public static boolean hasCycle(ListNode9 head) {
        ListNode9 slow=head;
        ListNode9 fast=head;
        
        while(fast!=null && fast.next!=null)
        {
        	slow=slow.next;
        	fast=fast.next.next;
        	
        	if(slow==fast)return true;
        }
        
        return false;
    }
    
    public static void reorderList(ListNode9 head) {
        //Split
    	ListNode9 slow=head;
        ListNode9 fast=head;
        
        while(fast!=null && fast.next!=null)
        {
        	slow=slow.next;
        	fast=fast.next.next;
        }
        
        //Reverse 2nd list
        ListNode9 second = slow.next;
        slow.next=null;
        ListNode9 prev=null;
        ListNode9 curr=second;
        
        while(curr!=null)
        {
        	ListNode9 tmp = curr.next;
        	curr.next=prev;
        	prev=curr;
        	curr=tmp;
        }
        
        //Reorder
        ListNode9 first=head;
        second=prev;
        
        while(second!=null)
        {
        	ListNode9 tmp1=first.next; 
        	ListNode9 tmp2=second.next; 
        	first.next=second; 
        	second.next=tmp1; 
        	first=tmp1;
        	second=tmp2;
        }
    }
    
    public static ListNode9 removeNthFromEnd(ListNode9 head, int n) {
    	ListNode9 dummy = new ListNode9(0);
    	dummy.next=head;
    	ListNode9 slow=dummy;
    	ListNode9 fast=head;
    	
    	while(n>0)
    	{
    		fast=fast.next;
    		n--;
    	}
    	
    	while(fast!=null)
    	{
    		slow=slow.next;
    		fast=fast.next;
    	}
    	
    	slow.next=slow.next.next;
    	
    	return head;
    }
    
    public static ListNode9 removeNthFromEndTwoPass(ListNode9 head, int n) 
    {
    	int len=0;
    	ListNode9 curr=head;
    	while(curr!=null)
    	{
    		len++;
    		curr=curr.next;
    	}
    	
    	int rmvIdx=len-n;
    	
    	if(rmvIdx==0)
    	{
    		return head.next;
    	}
    	
    	curr=head;
    	int  i=0;
    	
    	while(curr!=null)
    	{
    		
    		if(i==(rmvIdx-1))
    		{
    			curr.next=curr.next.next;
    			break;
    		}
    		
    		i++;
    		curr=curr.next;
    	}
    	
    	return head;
    }
    
    public static ListNode9 addTwoNumbers(ListNode9 l1, ListNode9 l2) 
    {
    	ListNode9 dummy = new ListNode9(0);
    	ListNode9 curr=dummy;
    	
    	int carry=0;
    	while(l1!=null || l2!=null || carry!=0)
    	{
    		int val1 = l1!=null?l1.val:0;
    		int val2 = l2!=null?l2.val:0;
    		
    		int sum = val1+val2+carry;
    		carry=sum/10;
    		int rem=sum%10;
    		curr.next=new ListNode9(rem);
    		
    		l1=l1!=null?l1.next:null;
    		l2=l2!=null?l2.next:null;
    		curr=curr.next;
    	}
    	return dummy.next;
    }
    
    public static int findDuplicate(int[] nums) {
        int slow=nums[0];
        int fast=nums[0];
        
        while(true)
        {
        	slow=nums[slow];
        	fast=nums[nums[fast]];
        	if(slow==fast)break;
        }
        
        int slow2=nums[0];
        
        while(slow!=slow2)
        {
        	slow=nums[slow];
        	slow2=nums[slow2];
        }
        return slow;
    }
    
    public static Node10 copyRandomList(Node10 head) {
        Map<Node10,Node10> copyMap = new HashMap<>();
        copyMap.put(null, null);
        
        Node10 curr=head;
        while(curr!=null)
        {
        	copyMap.put(curr, new Node10(curr.val));
        	curr=curr.next;
        }
        
        curr=head;
        while(curr!=null)
        {
        	Node10 copy=copyMap.get(curr);
        	
        	copy.next=copyMap.get(curr.next);
        	copy.random=copyMap.get(curr.random);
        	curr=curr.next;
        }
        
        return copyMap.get(head);
    }
    
    private static void basicBfs(TreeNode14 root)
    {
    	if(root==null)return;
    	
    	Queue<TreeNode14> q = new LinkedList<TreeNode14>();
    	q.offer(root);
    	
    	while(!q.isEmpty())
    	{
    		TreeNode14 node = q.poll();
    		System.out.println("Visited: "+node.val);
    		
    		if(node.left!=null)
    		{
    			q.offer(node.left);
    		}
    		
    		if(node.right!=null)
    		{
    			q.offer(node.right);
    		}
    	}
    }
    
    private static void basicDfsIterative(TreeNode14 root)
    {
    	if(root==null)return;
    	
    	Stack<TreeNode14> stack = new Stack<TreeNode14>();
    	stack.push(root);
    	
    	while(!stack.isEmpty())
    	{
    		TreeNode14 node = stack.pop();
    		System.out.println("Visited: "+node.val);
    		
    		if(node.right!=null)
    		{
    			stack.push(node.right);
    		}
    		
    		if(node.left!=null)
    		{
    			stack.push(node.left);
    		}
    	}
    }
    
    private static void basicDfsRecursive(TreeNode14 node)
    {
    	if(node==null)return;
    	
    	System.out.println("Visited: "+node.val);
    	
    	basicDfsRecursive(node.left);
    	basicDfsRecursive(node.right);
    }
    
    private static void basicBfsUndir(TreeNode15 root)
    {
    	Queue<TreeNode15> q = new LinkedList<>();    	
    	q.offer(root);
    	
    	while(!q.isEmpty())
    	{
    		TreeNode15 node = q.poll();
    		node.visited=true;
    		System.out.println("Visited: "+node.val);
    		
    		for(TreeNode15 nei:node.neighbors)
    		{
    			if(!nei.visited)
    			{
    				q.offer(nei);
    			}
    		}
    	}
    }
    
    private static void basicDfsIterativeUndir(TreeNode15 root)
    {
    	Stack<TreeNode15> stack = new Stack<>();    	
    	stack.push(root);
    	
    	while(!stack.isEmpty())
    	{
    		TreeNode15 node = stack.pop();
    		node.visited=true;
    		System.out.println("Visited: "+node.val);
    		
    		for(TreeNode15 nei:node.neighbors)
    		{
    			if(!nei.visited)
    			{
    				stack.push(nei);
    			}
    		}
    	}
    }
    
    private static void basicDfsRecursiveUndir(TreeNode15 node)
    {
    	if(node==null)return;
    	
    	System.out.println("Visisted: "+node.val);
    	node.visited=true;
    	
    	for(TreeNode15 nei:node.neighbors)
    	{
    		if(!nei.visited)
    		{
    			basicDfsRecursiveUndir(nei);
    		}
    	}
    }
    
    private static TreeNode14 getMaxBST(TreeNode14 node)
    {
    	if(node==null)return null;
    	
    	while(node.right!=null)
    	{
    		node=node.right;
    	}
    	return node;
    }
    
    private static TreeNode14 getMinBST(TreeNode14 node)
    {
    	if(node==null)return null;
    	
    	while(node.left!=null)
    	{
    		node=node.left;
    	}
    	return node;
    }
    
    private static TreeNode14 insertBST(int data, TreeNode14 root)
    {
    	root=insertBSThelper(data, root);
    	return root;		
    }
    
    private static TreeNode14 insertBSThelper(int data, TreeNode14 node)
    {
    	if(node==null)
    	{
    		return new TreeNode14(data);
    	}
    	
    	if(data<node.val)
    	{
    		node.left=insertBSThelper(data, node.left);
    	}
    	else if(data>node.val)
    	{
    		node.right=insertBSThelper(data, node.right);
    	}
    	
    	return node;
    }
    
    private static TreeNode14 deleteBST(int data, TreeNode14 root)
    {
    	root=deleteBSThelper(data, root);
    	return root;
    }
    
    private static TreeNode14 deleteBSThelper(int data, TreeNode14 node)
    {
    	if(node==null)return null;
    	
    	if(data<node.val)
    	{
    		node.left=deleteBSThelper(data, node.left);
    	}
    	else if(data>node.val)
    	{
    		node.right=deleteBSThelper(data, node.right);
    	}
    	else
    	{
    		if(node.left==null)
    		{
    			return node.right;
    		}
    		else if(node.right==null)
    		{
    			return node.left;
    		}
    		
    		node.val=getMaxBST(node.left).val; //predecessor
    		node.left=deleteBSThelper(node.val, node.left);
    	}
    	
    	return node;
    }
    
    public static TreeNode14 invertTreeBFS(TreeNode14 root) 
    {
        if(root==null)return null;
        
        Queue<TreeNode14> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty())
        {
        	TreeNode14 node = q.poll();
        	
        	TreeNode14 tmp = node.left;
        	node.left=node.right;
        	node.right=tmp;
        	
        	if(node.left!=null)
        	{
        		q.offer(node.left);
        	}
        	
        	if(node.right!=null)
        	{
        		q.offer(node.right);
        	}
        }
        return root;
    }
    
    public static TreeNode14 invertTreeDFS(TreeNode14 root) 
    {
    	if(root==null)return null;
    	
    	TreeNode14 node = new TreeNode14(root.val);
    	node.left=invertTreeDFS(root.right);
    	node.right=invertTreeDFS(root.left);
    	return node;
    }
    
    public static int maxDepthBFS(TreeNode14 root) {
        if(root==null)return 0;
        
        Queue<TreeNode14> q = new LinkedList<>();
        q.offer(root);
        
        int level=0;
        while(!q.isEmpty())
        {
        	int size=q.size();
        	for(int i=0;i<size;i++)
        	{
        		TreeNode14 node=q.poll();
        		
        		if(node.left!=null)
        		{
        			q.offer(node.left);
        		}
        		
        		if(node.right!=null)
        		{
        			q.offer(node.right);
        		}
        	}
        	level++;
        }
        return level;
    }
    
    public static int maxDepthDFS(TreeNode14 root) {
    	if(root==null)return 0;
    	
    	return 1+(Math.max(maxDepthDFS(root.left), maxDepthDFS(root.right)));
    }
    
    public static int diameterOfBinaryTree(TreeNode14 root) {
        int[] res = new int[1];
        diameterOfBinaryTreeHelper(root, res);
        return res[0];
    }
    
    private static int diameterOfBinaryTreeHelper(TreeNode14 node, int[] res)
    {
    	if(node==null)return 0;
    	
    	int left = diameterOfBinaryTreeHelper(node.left, res);
    	int right = diameterOfBinaryTreeHelper(node.right, res);
    	
    	res[0] = Math.max(res[0], left+right);
    	return 1+Math.max(left, right);
    }
    
    public static boolean isBalanced(TreeNode14 root) {
        int[]res=new int[2];
        return isBalancedHelper(root, res)[0]==1;
    }
    
    private static int[] isBalancedHelper(TreeNode14 node, int[] res)
    {
    	if(node==null)return new int[] {1,0};
    	
    	int[] left = isBalancedHelper(node.left, res);
    	int[] right = isBalancedHelper(node.right, res);
    	
    	res[0] = (left[0]==1 && right[0]==1 && (Math.abs(left[1]-right[1])<=1))?1:0;
    	res[1] = 1+Math.max(left[1], right[1]);
    	return res;
    }
    
    public static boolean isSameTreeBFS(TreeNode14 p, TreeNode14 q) 
    {
    	Queue<TreeNode14> pQueue=new LinkedList<>();
    	Queue<TreeNode14> qQueue=new LinkedList<>();
    	pQueue.offer(p);
    	qQueue.offer(q);
    	
    	while((!pQueue.isEmpty()) || (!qQueue.isEmpty()))
    	{
    		TreeNode14 pNode=pQueue.poll();
    		TreeNode14 qNode=qQueue.poll();
    		
    		if(pNode==null || qNode==null || pNode.val!=qNode.val)return false;
    		
    		if(pNode.left!=null)
    		{
        		pQueue.offer(pNode.left);
    		}
    		if(pNode.right!=null)
    		{
        		pQueue.offer(pNode.right);
    		}


    		if(qNode.left!=null)
    		{
        		qQueue.offer(qNode.left);
    		}

    		if(qNode.right!=null)
    		{
        		qQueue.offer(qNode.right);
    		}

    	}
    	
    	return true;
    }
    
    public static boolean isSameTreeDFS(TreeNode14 p, TreeNode14 q) 
    {
    	if(p==null && q==null)return true;
    	
    	if(p!=null && q!=null && p.val==q.val)
    	{
    		return (isSameTreeDFS(p.left, q.left) && isSameTreeDFS(p.right, q.right));
    	}
    	
    	return false;
    }
    
    public static boolean isSubtree(TreeNode14 root, TreeNode14 subRoot) {
        if(subRoot==null)return true;
        
        if(root==null)return false;
        
        if(isSameTree(root, subRoot))return true;
        
        return isSameTree(root.left, subRoot) || isSameTree(root.right, subRoot);
    }
    
    private static boolean isSameTree(TreeNode14 node1, TreeNode14 node2)
    {
    	if(node1==null && node2==null)return true;
    	
    	if(node1!=null && node2!=null && node1.val==node2.val)
    	{
    		return isSameTree(node1.left, node2.left) && isSameTree(node1.right, node2.right);
    	}
    	return false;
    }

    public static TreeNode14 lowestCommonAncestor(TreeNode14 root, TreeNode14 p, TreeNode14 q) {
    	
        TreeNode14 curr=root;
        
        while(curr!=null)
        {
        	if(p.val>curr.val && q.val>curr.val)
        	{
        		curr=curr.right;
        	}
        	else if(p.val<curr.val && q.val<curr.val)
        	{
        		curr=curr.left;
        	}
        	else
        	{
        		return curr;
        	}
        }
        
        return curr;
    }
    
    public static List<List<Integer>> levelOrder(TreeNode14 root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode14> q  = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty())
        {
        	int qSize = q.size();
        	List<Integer> list = new ArrayList<>();
        	for(int i=0;i<qSize;i++)
        	{
        		TreeNode14 node = q.poll();
        		
        		if(node.left!=null)
        		{
        			q.offer(node.left);
        		}
        		
        		if(node.right!=null)
        		{
        			q.offer(node.right);
        		}
            	list.add(node.val);
        	}
        	if(list.size()>0)
        	{
            	res.add(list);
        	}
        }
        return res;
    }
    
    public static List<Integer> rightSideView(TreeNode14 root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode14> q=new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty())
        {
        	int  qSize=q.size();
        	
        	TreeNode14 tmp=null;
        	
        	for(int i=0;i<qSize;i++)
        	{
        		TreeNode14 node = q.poll();
        		
        		tmp=node;
        		
        		if(node.left!=null)
        		{
        			q.offer(node.left);
        		}
        		if(node.right!=null)
        		{
        			q.offer(node.right);
        		}
        	}
        	if(tmp!=null)
        	{
        		res.add(tmp.val);
        	}
        }
        return res;
    }
    
    public static int goodNodes(TreeNode14 root) {
        return goodNodesHelper(root, root.val);
    }
    
    private static int goodNodesHelper(TreeNode14 node, int max)
    {
    	if(node==null)return 0;
    	
    	int res = node.val>=max?1:0;
    	max=Math.max(max, node.val);
    	res+=goodNodesHelper(node.left, max);
    	res+=goodNodesHelper(node.right, max);
    	return res;
    }
    
    public static boolean isValidBST(TreeNode14 root) {
        return isValidBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private static boolean isValidBSTHelper(TreeNode14 node, int left, int right)
    {
    	if(node==null)return true;
    	
    	if(node.val>left && node.val<right)
    	{
    		return isValidBSTHelper(node.left, left, node.val)
    				&& isValidBSTHelper(node.right, node.val, right);
    	}
    	return false;
    }
    
    public static int kthSmallest(TreeNode14 root, int k) {
    	
        List<Integer> res = new ArrayList<>();
        inOrderTraversal(root, res);
        return res.size()>0?res.get(k-1):-1;
    }
    
    private static void inOrderTraversal(TreeNode14 node, List<Integer> res)
    {
    	if(node==null)return;
    	inOrderTraversal(node.left, res);
    	res.add(node.val);
    	inOrderTraversal(node.right, res);
    }
    

    Map<Integer, Integer> inorderMap = new HashMap<>();
    int pre_idx=0;
    
    public TreeNode14 buildTree(int[] preorder, int[] inorder) 
    {
        for(int i=0;i<inorder.length;i++)
        {
        	inorderMap.put(inorder[i],i);
        }
        return buildTreeHelper(preorder, 0, inorder.length-1);
    }
    
    private TreeNode14 buildTreeHelper(int[] preorder, int l, int r)
    {
    	if(l>r)return null;
    	
    	int nodeVal = preorder[pre_idx];
    	TreeNode14 node = new TreeNode14(nodeVal);
    	pre_idx++;
    	
    	int m = inorderMap.get(nodeVal);
    	
    	node.left=buildTreeHelper(preorder, l, m-1);
    	node.right=buildTreeHelper(preorder, m+1, r);
    	return node;
    }
    
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        subsetsHelper(nums, 0, new ArrayList<>(), res);
        return res;
    }
    
    private static void subsetsHelper(int[] nums, int i, List<Integer> subset, List<List<Integer>> res)
    {
    	if(i>=nums.length)
    	{
    		res.add(new ArrayList<>(subset));
    		return;
    	}
    	
    	subset.add(nums[i]);
    	subsetsHelper(nums, i+1, subset, res);
    	subset.remove(subset.size()-1);
    	subsetsHelper(nums, i+1, subset, res);
    }
    
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    	List<List<Integer>> res = new ArrayList<>();
    	csHelper(candidates,0,0,target,new ArrayList<>(),res);
    	return res;
    }
    
    private static void csHelper(int[] nums, int i, int sum, int target, List<Integer> subset, List<List<Integer>> res)
    {
    	if(sum==target)
    	{
    		res.add(new ArrayList<>(subset));
    		return;
    	}
    	
    	if(i>nums.length-1 || sum>target)return;
    	
    	subset.add(nums[i]);
    	csHelper(nums,i,sum+nums[i],target,subset,res);
    	subset.remove(subset.size()-1);
    	csHelper(nums,i+1,sum,target,subset,res);
    }
    
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
    	List<List<Integer>> res = new ArrayList<>();
    	Arrays.sort(candidates);
    	cs2Helper(candidates, 0, 0, target, new ArrayList<>(), res);
    	return res;
    }
    
    private static void cs2Helper(int[] nums, int i, int sum, int target, List<Integer> subset, List<List<Integer>> res)
    {
    	if(sum==target)
    	{
    		res.add(new ArrayList<>(subset));
    		return;
    	}
    	
    	if(i>nums.length-1 || sum>target)return;
    	
    	subset.add(nums[i]);
    	cs2Helper(nums, i+1, sum+nums[i], target, subset, res);
    	
    	subset.remove(subset.size()-1);
    	
    	while(i+1<=nums.length-1 && nums[i]==nums[i+1])
    	{
    		i++;
    	}
    	cs2Helper(nums, i+1, sum, target, subset, res);
    }
    
    public static List<List<Integer>> permute(int[] nums) {
    	List<List<Integer>> res = new ArrayList<>();
    	permuteHelper(nums, new boolean[nums.length], new ArrayList<>(), res);
    	return res;
    }
    
    private static void permuteHelper(int[] nums, boolean[] pick, List<Integer> perm, List<List<Integer>> res)
    {
    	if(perm.size()==nums.length)
    	{
    		res.add(new ArrayList<>(perm));
    		return;
    	}
    	
    	for(int i=0;i<nums.length;i++)
    	{
    		if(!pick[i])
    		{
    			perm.add(nums[i]);
    			pick[i]=true;
    			permuteHelper(nums, pick, perm, res);
    			perm.remove(perm.size()-1);
    			pick[i]=false;
    		}
    	}
    	
    }
    
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
    	List<List<Integer>> res = new ArrayList<>();
    	subsetWdHelper(nums, 0, new ArrayList<>(), res);
    	return res;
    }
    
    private static void subsetWdHelper(int[] nums, int i, List<Integer> subset, List<List<Integer>> res)
    {
    	if(i>=nums.length)
    	{
    		res.add(new ArrayList<>(subset));
    		return;
    	}
    	
    	subset.add(nums[i]);
    	subsetWdHelper(nums, i+1, subset, res);
    	subset.remove(subset.size()-1);
    	
    	while(i+1<nums.length && nums[i]==nums[i+1])
    	{
    		i++;
    	}
    	
    	subsetWdHelper(nums, i+1, subset, res);
    }
    
    public static boolean exist(char[][] board, String word) {
        int ROW = board.length;
        int COL = board[0].length;
        
        boolean[][] visited = new boolean[ROW][COL];
        
        for(int r=0;r<ROW;r++)
        {
        	for(int c=0;c<COL;c++)
        	{
    			if(existHelper(board, 0, r, c, word, visited))
    			{
    				return true;
    			}
        	}
        }
        return false;
    }
    
    private static boolean existHelper(char[][] board, int i, int row, int col, String word, boolean[][] visited)
    {
    	if(i==word.length())return true;
    	
		if(row<0||row>=board.length || col<0||col>=board[0].length 
				|| visited[row][col] || board[row][col]!=word.charAt(i))return false;
		
    	visited[row][col]=true;
    	
    	boolean res=existHelper(board, i+1, row+1, col, word, visited) ||
    			existHelper(board, i+1, row-1, col, word, visited) ||
    			existHelper(board, i+1, row, col+1, word, visited) ||
    			existHelper(board, i+1, row, col-1, word, visited);
    	
		visited[row][col]=false;
    	return res;
    }
    
    public static List<List<String>> partition(String s) {
    	List<List<String>> res = new ArrayList<>();
    	partHelper(s, 0, new ArrayList<>(), res);
    	return res;
    }
    
    private static void partHelper(String s, int i, List<String> part, List<List<String>> res)
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
    			part.add(s.substring(i, j+1));
    			partHelper(s, j+1, part, res);
    			part.remove(part.size()-1);
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
    
    public static List<String> letterCombinations(String digits) {
    	List<String> res = new ArrayList<>();
    	String [] map = {"", "", "abc", "def", "ghi","jkl","mno","pqrs","tuv","wxyz"};
    	lcHelper(digits,0,"",map,res);
    	return res;
    }
    
    private static void lcHelper(String digits, int i, String comb, String [] map, List<String> res)
    {
    	if(comb.length()==digits.length())
    	{
    		res.add(comb);
    		return;
    	}
    	
    	String chars = map[digits.charAt(i)-'0'];
    	for(char c: chars.toCharArray())
    	{
    		lcHelper(digits, i+1, comb+c, map, res);
    	}
    }
    
    public static int numIslands(char[][] grid) 
    {
        int ROW=grid.length;
        int COL=grid[0].length;
        
        int islands=0;
        
        for(int r=0;r<ROW;r++)
        {
        	for(int c=0;c<COL;c++)
        	{
        		if(grid[r][c]=='1')
        		{
        			numIslandsDfs(grid, r, c);
        			islands++;
        		}
        	}
        }
        return islands;
    }
    
    private static void numIslandsDfs(char[][] grid, int row, int col)
    {    	
    	grid[row][col]='0';
    	int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    	
    	for(int[] dir:dirs)
    	{
    		int r=row+dir[0];
    		int c=col+dir[1];
    		
    		if(r<0||r>=grid.length || c<0||c>=grid[0].length || grid[r][c]!='1')continue;
    		
    		numIslandsDfs(grid, r, c);
    	}
    }
    
    public static int maxAreaOfIsland(int[][] grid) {
        int ROW=grid.length;
        int COL=grid[0].length;
        
        int maxArea=0;
        for(int r=0;r<ROW;r++)
        {
        	for(int c=0;c<COL;c++)
        	{
        		if(grid[r][c]==1)
        		{
            		int area=maxAreaDfs(grid, r, c, 0);
            		maxArea=Math.max(maxArea, area);
        		}
        	}
        }
        return maxArea;
    }
    
    private static int maxAreaDfs(int[][] grid, int row, int col, int area)
    {
    	grid[row][col]=0;
    	area++;
    	int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    	
    	for(int[] dir:dirs)
    	{
    		int r=row+dir[0];
    		int c=col+dir[1];
    		
    		if(r<0||r>=grid.length || c<0||c>=grid[0].length || grid[r][c]!=1)continue;
    		
    		area=maxAreaDfs(grid, r, c, area);
    	}
    	
    	return area;
    }
    
    public static Node12 cloneGraph(Node12 node) {
        Map<Node12, Node12> map = new HashMap<>();
        cloneGraphHlper(node, map);
        return map.get(node);
    }
    
    private static void cloneGraphHlper(Node12 node, Map<Node12, Node12> map)
    {
    	if(node==null)return;
    	
    	Node12 copy = new Node12(node.val);
    	map.put(node, copy);
    	
    	for(Node12 nei:node.neighbors)
    	{
    		if(!map.containsKey(nei))
    		{
    			Node12 neiCopy = new Node12(nei.val);
    			map.put(nei, neiCopy);
        		cloneGraphHlper(nei, map);
    		}
			map.get(node).neighbors.add(map.get(nei));
    	}
    	
    }
    
    public static void islandsAndTreasure(int[][] grid) {
        int ROW=grid.length;
        int COL=grid[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        
        for(int r=0;r<ROW;r++)
        {
        	for(int c=0;c<COL;c++)
        	{
        		if(grid[r][c]==0)
        		{
        			q.offer(new int[] {r,c});
        		}
        	}
        }
        
        while(!q.isEmpty())
        {
        	int[] pos = q.poll();
        	int row=pos[0];
        	int col=pos[1];
        	
        	int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        	
        	for(int[] dir:dirs)
        	{
        		int r=row+dir[0];
        		int c=col+dir[1];
        		
        		if(r<0||r>=grid.length || c<0||c>=grid[0].length || grid[r][c]!=2147483647)continue;
        		grid[r][c]=grid[row][col]+1;
        		
        		q.offer(new int[] {r,c});
        	}
        }
    }
    
    public static int orangesRotting(int[][] grid) {
        int ROW=grid.length;
        int COL=grid[0].length;
        int fresh=0;
        int time=0;
        Queue<int[]> q = new LinkedList<>();
        
        for(int r=0;r<ROW;r++)
        {
        	for(int c=0;c<COL;c++)
        	{
        		if(grid[r][c]==1)
        		{
        			fresh++;
        		}
        		else if(grid[r][c]==2)
        		{
        			q.offer(new int[] {r,c});
        		}
        	}
        }
        
        while((!q.isEmpty()) && (fresh>0))
        {
        	int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        	
        	int qSize = q.size();
        	
        	for(int i=0;i<qSize;i++)
        	{
        		int[] rotten = q.poll();
        		
        		int row=rotten[0];
        		int col=rotten[1];
        		
        		for(int[] dir:dirs)
        		{
        			int r=row+dir[0];
        			int c=col+dir[1];
        			
        			if(r<0||r>=ROW || c<0||c>=COL || grid[r][c]!=1)continue;
        			
        			grid[r][c]=2;
        			fresh--;
        			
        			q.offer(new int[] {r,c});
        		}
        	}
        	time++;
        }
        return fresh==0?time:-1;
    }
    
    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        int ROW=heights.length;
        int COL=heights[0].length;
        boolean[][] pacific = new boolean[ROW][COL];
        boolean[][] atlantic = new boolean[ROW][COL];
        
        for(int c=0;c<COL;c++)
        {
        	pacificAtlanticHelper(heights, pacific, 0, c);
        	pacificAtlanticHelper(heights, atlantic, ROW-1, c);
        }
        
        for(int r=0;r<ROW;r++)
        {
        	pacificAtlanticHelper(heights, pacific, r, 0);
        	pacificAtlanticHelper(heights, atlantic, r, COL-1);
        }
        
        for(int r=0;r<ROW;r++)
        {
        	for(int c=0;c<COL;c++)
        	{
        		if(pacific[r][c] && atlantic[r][c])
        		{
        			res.add(Arrays.asList(r,c));
        		}
        	}
        }
        return res;
    }
    
    
    private static void pacificAtlanticHelper(int[][] heights, boolean[][] ocean, int row, int col)
    {
    	ocean[row][col]=true;
    	
    	int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    	
    	for(int dir[]:dirs)
    	{
    		int r=row+dir[0];
    		int c=col+dir[1];
    		
    		if(r<0||r>=heights.length || c<0||c>=heights[0].length || ocean[r][c] || heights[row][col]>heights[r][c])continue;
    		
    		pacificAtlanticHelper(heights, ocean, r, c);
    	}
    }
    
    
    public static void solve(char[][] board) {
        int ROW=board.length;
        int COL=board[0].length;
        
        for(int r=0;r<ROW;r++)
        {
        	if(board[r][0]=='O')
        	{
        		solveHelper(board, r, 0);
        	}
        	
        	if(board[r][COL-1]=='O')
        	{
            	solveHelper(board, r, COL-1);
        	}
        }
        
        for(int c=0;c<COL;c++)
        {
        	if(board[0][c]=='O')
        	{
            	solveHelper(board, 0, c);
        	}

        	if(board[ROW-1][c]=='O')
        	{
            	solveHelper(board, ROW-1, c);
        	}
        }
        
        for(int r=0;r<ROW;r++)
        {
        	for(int c=0;c<COL;c++)
        	{
        		if(board[r][c]=='O')
        		{
        			board[r][c]='X';
        		}
        		else if(board[r][c]=='T')
        		{
        			board[r][c]='O';
        		}
        	}
        }
    }
    
    private static void solveHelper(char[][] board, int row, int col)
    {
    	board[row][col]='T';
    	
    	int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};
    	
    	for(int[] dir:dirs)
    	{
    		int r=row+dir[0];
    		int c=col+dir[1];
    		
    		if(r<0||r>=board.length || c<0||c>=board[0].length || board[r][c]!='O')continue;
    		
    		solveHelper(board, r, c);
    	}
    }
    
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> preMap = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        Set<Integer> finished = new HashSet<>();
        
        for(int i=0;i<numCourses;i++)
        {
        	preMap.put(i, new ArrayList<>());
        }
        
        for(int[] pre:prerequisites)
        {
        	preMap.get(pre[0]).add(pre[1]);
        }
        
        for(int i=0;i<numCourses;i++)
        {
        	if(!canFinishHelper(i, preMap, visited, finished))
        	{
        		return false;
        	}
        }
        
        return finished.size()==numCourses;
    }
    
    private static boolean canFinishHelper(int course, Map<Integer, List<Integer>> preMap, Set<Integer> visited, Set<Integer> finished)
    {
    	if(visited.contains(course)) return false;
    	
    	if(finished.contains(course)) return true;
    	    	
    	visited.add(course);
    	
    	for(int nextCourse: preMap.get(course))
    	{
    		if(!canFinishHelper(nextCourse, preMap, visited, finished))
    		{
    			return false;
    		}
    	}
    	
    	visited.remove(course);
    	finished.add(course);
    	
    	return true;
    }
    
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> preMap = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        Set<Integer> done = new HashSet<>();
        List<Integer> orderList = new ArrayList<>();
        
        for(int i=0;i<numCourses;i++)
        {
        	preMap.put(i, new ArrayList<>());
        }
        
        for(int[] preReq: prerequisites)
        {
        	preMap.get(preReq[0]).add(preReq[1]);
        }
        
        for(int i=0;i<numCourses;i++)
        {
        	if(!findOrderH(i, preMap, visited, done, orderList))
        	{
        		return new int[] {};
        	}
        }
        
        int[] res = new int[numCourses];
        
        for(int i=0;i<numCourses;i++)
        {
        	res[i]=orderList.get(i);
        }
        
        return res;
    }
    
    private static boolean findOrderH(int course, Map<Integer, List<Integer>> preMap, Set<Integer> visited, Set<Integer> done, List<Integer> orderList)
    {
    	if(visited.contains(course))return false;
    	
    	if(done.contains(course))return true;
    	
    	visited.add(course);
    	
    	for(int nextC : preMap.get(course))
    	{
    		if(!findOrderH(nextC , preMap, visited, done, orderList))
    		{
    			return false;
    		}
    	}
    	visited.remove(course);
    	done.add(course);
    	orderList.add(course);
    	
    	return true;
    }
    
    public static boolean validTree(int n, int[][] edges) {
    	
    	if(edges.length>=n)return false;
    	
    	Map<Integer, List<Integer>> eMap = new HashMap<>();
    	Set<Integer> visited = new HashSet<>();
    	
    	for(int i=0;i<n;i++)
    	{
    		eMap.put(i,  new ArrayList<>());
    	}
    	
    	for(int[] edge:edges)
    	{
    		eMap.get(edge[0]).add(edge[1]);
    		eMap.get(edge[1]).add(edge[0]);
    	}
    	
		if(!validTreeHelper(0, -1, eMap, visited))
		{
			return false;
		}
    	
    	return visited.size()==n;
    }
    
    private static boolean validTreeHelper(int node, int parent, Map<Integer, List<Integer>> eMap, Set<Integer> visited)
    {
    	if(visited.contains(node))return false;
    	
    	visited.add(node);
    	
    	for(int nextNode:eMap.get(node))
    	{
    		if(nextNode==parent)continue;
    		
    		if(!validTreeHelper(nextNode, node, eMap, visited))
    		{
    			return false;
    		}
    	}
    	
    	return true;
    }
    
    
    public static int countComponents(int n, int[][] edges) {
    	Map<Integer, List<Integer>> eMap = new HashMap<>();
    	Set<Integer> visited = new HashSet<>();
    	
    	for(int i=0;i<n;i++)
    	{
    		eMap.put(i, new ArrayList<>());
    	}
    	
    	for(int[] edge:edges)
    	{
    		eMap.get(edge[0]).add(edge[1]);
    		eMap.get(edge[1]).add(edge[0]);
    	}
    	
    	int res=0;
    	for(int i=0;i<n;i++)
    	{
    		if(!visited.contains(i))
    		{
    			ccHelper(i, -1, eMap, visited);
    			res++;
    		}
    	}
    	return res;
    }
    
    private static void ccHelper(int node, int parent, Map<Integer, List<Integer>> eMap, Set<Integer> visited)
    {
    	if(visited.contains(node))return;
    	
    	visited.add(node);
    	
    	for(int nextNode:eMap.get(node))
    	{
    		if(nextNode==parent)continue;
    		
    		ccHelper(nextNode, node, eMap, visited);
    	}
    }
    
    public static int[] findRedundantConnection(int[][] edges) {
        Map<Integer, List<Integer>> eMap = new HashMap<>();
        
        int n=edges.length;
        
        for(int i=0;i<=n;i++)
        {
        	eMap.put(i, new ArrayList<>());
        }
        
        for(int[] edge:edges)
        {
        	eMap.get(edge[0]).add(edge[1]);
        	eMap.get(edge[1]).add(edge[0]);
        	
        	Set<Integer> visited = new HashSet<>();
        	
        	if(!frcHelper(edge[0], -1, eMap, visited))
        	{
        		return edge;
        	}
        }
        
        return new int[] {};
    }
    
    private static boolean frcHelper(int node, int parent, Map<Integer, List<Integer>> eMap, Set<Integer> visited)
    {
    	if(visited.contains(node))return false;
    	
    	visited.add(node);
    	
    	for(int nextNode:eMap.get(node))
    	{
    		if(nextNode==parent)continue;
    		
    		if(!frcHelper(nextNode, node, eMap, visited))
    		{
    			return false;
    		}
    	}
    	return true;
    }

	public static void main(String args[])
	{
//		int[] nums = {1,1,1,3,3,4,3,2,4,2};
//		System.out.println(containsDuplicate(nums));
		
//		String s = "anagram", t = "nagaram";
//		System.out.println(isAnagram2(s, t));
		
//		int[] nums = {3,2,4};
//		int target = 6;
//		System.out.println(Arrays.toString(twoSum(nums, target)));
		
//		String [] strs = {"eat","tea","tan","ate","nat","bat"};
//		System.out.println(groupAnagrams(strs).toString());
		
//		int[] nums = {1,1,1,2,2,3};
//		int k = 2;
//		System.out.println(Arrays.toString(topKFrequent(nums, k)));
		
//		List<String> strs = new ArrayList<>(Arrays.asList("neet","code","love","you"));
//		String encodedStr = encode(strs);
//		System.out.println("Encode>>"+encodedStr);
//		System.out.println(decode(encodedStr).toString());
		
//		int[] nums = {1,2,3,4};
//		System.out.println(Arrays.toString(productExceptSelf(nums)));
		
//		int[] nums = {0,3,7,2,5,8,4,6,0,1};
//		System.out.println(longestConsecutive(nums));
		
//		 String s = "([])";
//		 System.out.println(isValidParentheses(s));
				
//		MinStack1 minStack = new MinStack1();
//		minStack.push(-2);
//		minStack.push(0);
//		minStack.push(-3);
//		System.out.println(minStack.getMin()); // return -3
//		minStack.pop();
//		System.out.println(minStack.top());   // return 0
//		System.out.println(minStack.getMin()); // return -2
		
//		String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
//		System.out.println(evalRPN(tokens));
		
//		int[] temperatures = {73,74,75,71,69,72,76,73};
//		System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
		
//		String s = "race a car";
//		System.out.println(isPalindrome(s));
		
//		int[] numbers = {2,3,4};
//		int target = 6;
//		System.out.println(Arrays.toString(twoSum2(numbers, target)));
		
//		int[] nums = {-1,0,1,2,-1,-4};
//		System.out.println(threeSum(nums).toString());
		
//		int[] height = {1,8,6,2,5,4,8,3,7};
//		System.out.println(maxAreaWaterContainer(height));
		
//		int[] nums = {-1,0,3,5,9,12};
//		int target = 9;
//		System.out.println(binarySearch(nums, target));
		
//		int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
//		int target = 3;
//		System.out.println(searchMatrix(matrix, target));
		
//		int[] piles = {3,6,7,11};
//		int h = 8;
//		System.out.println(minEatingSpeed(piles, h));
		
//		int[] nums = {11,13,15,17};
//		System.out.println(findMin(nums));
		
//		int[] nums = {3,1};
//		int target = 3;
//		System.out.println(searchRotatedArray(nums, target));
		
//		TimeMap3 timeMap = new TimeMap3();
//		timeMap.set("foo", "bar", 1);  // store the key "foo" and value "bar" along with timestamp = 1.
//		System.out.println(timeMap.get("foo", 1));         // return "bar"
//		System.out.println(timeMap.get("foo", 3));        // return "bar", since
//		timeMap.set("foo", "bar2", 4); // store the key "foo" and value "bar2" along with timestamp = 4.
//		System.out.println(timeMap.get("foo", 4));         // return "bar2"
//		System.out.println(timeMap.get("foo", 5));         // return "bar2"
		
//		int[] nums={3,8,2,5,7,6,12};
//		int w=4;
//		System.out.println(maxSumSubarrayFL(nums, w));
		
//		int[] prices={7,6,4,3,1};
//		System.out.println(maxProfit(prices));
		
//		int[] nums= {1,4,4};
//		int target=4;
//		System.out.println(minSubArrayLen(target, nums));
		
//		String s = "bbbbb";
//		System.out.println(lengthOfLongestSubstring(s));
		
//		String s = "AABABBA";
//		int k = 1;
//		System.out.println(characterReplacement(s, k));
		
//		String s1 = "ab", s2 = "eidboaoo";
//		System.out.println(checkInclusion(s1, s2));
		
//		Node10 n7 = new Node10(7);
//		Node10 n13 = new Node10(13);
//		Node10 n11 = new Node10(11);
//		Node10 n10 = new Node10(10);
//		Node10 n1 = new Node10(1);
//		
//
//		n7.next=n13;
//		n7.random=null;
//		
//		n13.next=n11;
//		n13.random=n7;
//		
//		n11.next=n10;
//		n11.random=n1;
//		
//		n10.next=n1;
//		n10.random=n11;
//		
//		n1.next=null;
//		n1.random=n7;
		
		//BEFORE
//		System.out.println("BEFORE:");
//		Node10 node=n7;
//		int nodeNo=0;
//		while(node!=null)
//		{
//			nodeNo++;
//			String val = Integer.toString(node.val);
//			String next = (node.next!=null)?Integer.toString(node.next.val):null;
//			String random = (node.random!=null)?Integer.toString(node.random.val):null;
//			System.out.println("N"+nodeNo+": val="+val+", next="+next+", random="+random);
//			node=node.next;
//		}
//		
//		//AFTER
//		System.out.println("AFTER:");
//		Node10 op=copyRandomList(n7);
//		nodeNo=0;
//		while(op!=null)
//		{
//			nodeNo++;
//			String val = Integer.toString(op.val);
//			String next = (op.next!=null)?Integer.toString(op.next.val):null;
//			String random = (op.random!=null)?Integer.toString(op.random.val):null;
//			System.out.println("N"+nodeNo+": val="+val+", next="+next+", random="+random);
//			op=op.next;
//		}
		
		
//		System.out.println("Before:");
//		ListNode9 curr=n1;
//		
//		while(curr!=null)
//		{
//			System.out.println(curr.val);
//			curr=curr.next;
//		}
//		
//		System.out.println("After:");
//		ListNode9 curr=addTwoNumbers(n1, n4);
		
//		while(curr!=null)
//		{
//			System.out.println(curr.val);
//			curr=curr.next;
//		}
		
//		int[] nums = {3,3,3,3,3};
//		System.out.println(findDuplicate(nums));
		
//		LRUCache3 lRUCache = new LRUCache3(2);
//		lRUCache.put(1, 10);  // cache: {1=10}
//		System.out.println(lRUCache.get(1));      // return 10
//		lRUCache.put(2, 20);  // cache: {1=10, 2=20}
//		lRUCache.put(3, 30);  // cache: {2=20, 3=30}, key=1 was evicted
//		System.out.println(lRUCache.get(2));      // returns 20 
//		System.out.println(lRUCache.get(1));      // return -1 (not found)
		
		
//		TreeNode15 n1 = new TreeNode15(1);
//		TreeNode15 n2 = new TreeNode15(2);
//		TreeNode15 n3 = new TreeNode15(3);
//		TreeNode15 n4 = new TreeNode15(4);
//		TreeNode15 n6 = new TreeNode15(6);
//		TreeNode15 n7 = new TreeNode15(7);
//		TreeNode15 n9 = new TreeNode15(9);
//		
//		n4.neighbors.addAll(Arrays.asList(n2,n7));
//		n2.neighbors.addAll(Arrays.asList(n4,n1,n3));
//		n1.neighbors.addAll(Arrays.asList(n2));
//		n3.neighbors.addAll(Arrays.asList(n2));
//		n7.neighbors.addAll(Arrays.asList(n4,n6,n9));
//		n6.neighbors.addAll(Arrays.asList(n7));
//		n9.neighbors.addAll(Arrays.asList(n7));
//		
//		basicDfsRecursiveUndir(n4);
		
//		TreeNode14 n3=new TreeNode14(3);
//		TreeNode14 n7=new TreeNode14(7);
//		TreeNode14 n9=new TreeNode14(9);
//		TreeNode14 n15=new TreeNode14(15);
//		TreeNode14 n20=new TreeNode14(20);
		
//		TreeNode14 n6=new TreeNode14(6);
//		TreeNode14 n7=new TreeNode14(7);
//		TreeNode14 n8=new TreeNode14(8);
//		TreeNode14 n9=new TreeNode14(9);

		
//		n3.left=n9;
//		n3.right=n20;
//				
//		n20.left=n15;
//		n20.right=n7;
		
//		System.out.println("BEFORE");
//		traversal(n4, "preorder");
//		
//		TreeNode14 node=invertTreeDFS(n4);
//		
//		System.out.println("AFTER");
//		traversal(node, "preorder");
		
		
//		int[] preorder = {3,9,20,15,7};
//		int[] inorder = {9,3,15,20,7};
//		
//		TreeNode14 node = new RevisionFull01().buildTree(preorder, inorder);
//		
//		traversal(node, "preorder");
		
//		int[] nums = {1,2,3};
//		System.out.println(subsets(nums).toString());
		
//		int[] candidates  = {2,3,6,7};
//		int target=7;
//		System.out.println(combinationSum(candidates, target).toString());
		
//		int[] candidates  = {10,1,2,7,6,1,5};
//		int target=8;
//		System.out.println(combinationSum2(candidates, target).toString());
		
//		int[] nums  = {1,2,3};
//		System.out.println(permute(nums).toString());
		
//		int[] nums  = {1,2,2};
//		System.out.println(subsetsWithDup(nums).toString());
		
//		char[][] board = {
//				{'A','B','C','E'},
//				{'S','F','C','S'},
//				{'A','D','E','E'}};
//		String word = "ABCCED";
//		System.out.println(exist(board, word));
		
//		String s = "aab";
//		System.out.println(partition(s).toString());
		
//		String digits = "23";
//		System.out.println(letterCombinations(digits).toString());
		
//		char[][] grid = {
//		                 {'1','1','0','0','0'},
//		                 {'1','1','0','0','0'},
//		                 {'0','0','1','0','0'},
//		                 {'0','0','0','1','1'}
//		               };
//		System.out.println(numIslands(grid));
		
//		int[][] grid = {
//				{0,0,1,0,0,0,0,1,0,0,0,0,0},
//				{0,0,0,0,0,0,0,1,1,1,0,0,0},
//				{0,1,1,0,1,0,0,0,0,0,0,0,0},
//				{0,1,0,0,1,1,0,0,1,0,1,0,0},
//				{0,1,0,0,1,1,0,0,1,1,1,0,0},
//				{0,0,0,0,0,0,0,0,0,0,1,0,0},
//				{0,0,0,0,0,0,0,1,1,1,0,0,0},
//				{0,0,0,0,0,0,0,1,1,0,0,0,0}};
//		System.out.println(maxAreaOfIsland(grid));
		
//		Node12 n1 = new Node12(1);
//		Node12 n2 = new Node12(2);
//		Node12 n3 = new Node12(3);
//		Node12 n4 = new Node12(4);
//		
//		n1.neighbors.addAll(Arrays.asList(n2, n4));
//		n2.neighbors.addAll(Arrays.asList(n1, n3));
//		n3.neighbors.addAll(Arrays.asList(n2, n4));
//		n4.neighbors.addAll(Arrays.asList(n1, n3));
//		
//		System.out.println("BEFORE");
//		traverse(n1);
//		
//		System.out.println("AFTER");
//		Node12 copy = cloneGraph(n1);
//		traverse(copy);		
		
		
//		int[][] grid={
//		              {2147483647,-1,0,2147483647},
//		              {2147483647,2147483647,2147483647,-1},
//		              {2147483647,-1,2147483647,-1},
//		              {0,-1,2147483647,2147483647}
//		              };
//		islandsAndTreasure(grid);
//		
//		for(int r=0;r<grid.length;r++)
//		{
//			for(int c=0;c<grid[0].length;c++)
//			{
//				System.out.print(grid[r][c]+"   ");
//			}
//			System.out.println();
//		}
		
//		int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
//		System.out.println(orangesRotting(grid));
		
//		int[][] heights = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
//		System.out.println(pacificAtlantic(heights).toString());
		
//		char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
//		solve(board);
//		for(int r=0;r<board.length;r++)
//		{
//			for(int c=0;c<board[0].length;c++)
//			{
//				System.out.print(board[r][c]+"   ");
//			}
//			System.out.println();
//		}
		
//		int[][] prerequisites = {{1,0}};
//		int numCourses = 2;
//		System.out.println(canFinish(numCourses, prerequisites));
		
//		int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
//		int numCourses = 4;
//		System.out.println(Arrays.toString(findOrder(numCourses, prerequisites)));
		
//		int[][] edges = {{0, 1}, {0, 2}};
//		int n=3;
//		System.out.println(countComponents(n, edges));
		
		
		int[][] edges = {{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};
		System.out.println(Arrays.toString(findRedundantConnection(edges)));
		System.out.println(edges.hashCode());
		
		
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(109, "Sahil");
		
	}
	
	private static void traverse(Node12 node)
	{
		List<Node12> visited = new ArrayList<>();
		
		dfsTraverse(node, visited);
	}
	
	private static void dfsTraverse(Node12 node, List<Node12> visited)
	{
		System.out.println(node.val);
		visited.add(node);
		
		for(Node12 nei : node.neighbors)
		{
			System.out.println("nei>>"+nei.val);
		}
		
		for(Node12 nei : node.neighbors)
		{			
			if(!visited.contains(nei))
			{
				dfsTraverse(nei, visited);
			}
		}
	}
	
	private static void traversal(TreeNode14 root, String type)
	{
		if(root==null)return;
		if(type.equals("inorder"))
		{
			traversal(root.left, "inorder");
			System.out.println(root.val);
			traversal(root.right, "inorder");
		}
		else if(type.equals("preorder"))
		{
			System.out.println(root.val);
			traversal(root.left, "preorder");
			traversal(root.right, "preorder");
		}
		else if(type.equals("postorder"))
		{
			traversal(root.left, "postorder");
			traversal(root.right, "postorder");
			System.out.println(root.val);
		}
	}
}
