package practisesessionnov2024.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
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
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class MinStack6 {
	Stack<Integer> stack;
	Stack<Integer> mstack;
	
    public MinStack6() {
        stack=new Stack<>();
        mstack=new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(mstack.isEmpty() || val<=mstack.peek())
        {
        	mstack.push(val);
        }
    }
    
    public void pop() {
        int pop = stack.pop();
        if(mstack.peek()==pop)
        {
        	mstack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return mstack.peek();
    }
}

class TimeMap5 {

	Map<String, TreeMap<Integer, String>> map;
	
    public TimeMap5() {
    	map=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
    	
        if(map.containsKey(key))
        {
        	map.get(key).put(timestamp, value);
        }
        else
        {
        	TreeMap<Integer, String> tree=new TreeMap<>();
        	tree.put(timestamp, value);
        	map.put(key, tree);
        }
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key))return "";
        
        TreeMap<Integer, String> tree=map.get(key);
        
        Map.Entry<Integer, String> entry = tree.floorEntry(timestamp);
        
        return entry!=null?entry.getValue():"";
    }
}


class ListNode10 {
	int val;
	ListNode10 next;

	ListNode10() {
	}

	ListNode10(int val) {
		this.val = val;
	}

	ListNode10(int val, ListNode10 next) {
		this.val = val;
		this.next = next;
	}
}

class Node13 {
    int val;
    Node13 next;
    Node13 random;

    public Node13(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class Node14{
	int key;
	int val;
	Node14 next;
	Node14 prev;
	
	public Node14()
	{
		
	}
	
	public Node14(int key, int val)
	{
		this.key=key;
		this.val=val;
	}
	
	public Node14(int key, int val, Node14 next, Node14 prev)
	{
		this.key=key;
		this.val=val;
		this.next=next;
		this.prev=prev;
	}
	
}

class Node15 {
    public int val;
    public List<Node15> neighbors;
    public Node15() {
        val = 0;
        neighbors = new ArrayList<Node15>();
    }
    public Node15(int _val) {
        val = _val;
        neighbors = new ArrayList<Node15>();
    }
    public Node15(int _val, ArrayList<Node15> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

class LRUCache4 {
	int capacity;
	Map<Integer, Node14> map;
	Node14 left;
	Node14 right;
	
    public LRUCache4(int capacity) {
        this.capacity=capacity;
        map=new HashMap<>();
        left=new Node14();
        right=new Node14();
        left.next=right;
        right.prev=left;
        right.next=null;
        left.prev=null;
    }
    
    private void remove(Node14 node)
    {
    	Node14 prv=node.prev;
    	Node14 nxt=node.next;
    	prv.next=nxt;
    	nxt.prev=prv;
    }
    
    private void insert(Node14 node)
    {
    	Node14 prv=right.prev;
    	right.prev=node;
    	node.next=right;
    	node.prev=prv;
    	prv.next=node;
    }
    
    public int get(int key) {
        if(map.containsKey(key))
        {
        	Node14 node=map.get(key);
        	remove(node);
        	insert(node);
        	return node.val;
        }
        else
        {
        	return -1;
        }
    }
    
    public void put(int key, int value) {
        Node14 newNode=new Node14(key, value);
        
        if(map.containsKey(key))
        {
        	Node14 node=map.get(key);
        	remove(node);
        }
        
        map.put(key, newNode);
        insert(newNode);
        
        if(map.size()>capacity)
        {
        	Node14 lru = left.next;
        	map.remove(lru.key);
        	remove(lru);
        }
    }
}

class TreeNode16 {
	int val;
	TreeNode16 left;
	TreeNode16 right;

	TreeNode16() {
	}

	TreeNode16(int val) {
		this.val = val;
	}

	TreeNode16(int val, TreeNode16 left, TreeNode16 right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class RevisionFull02 {
	
	public static boolean containsDuplicate(int[] nums)
	{
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
    
    public static boolean isAnagram2(String s, String t) {
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
    
    public static int[] twoSum(int[] nums, int target) {
        
    	Map<Integer, Integer> map = new HashMap<>();
    	
    	for(int i=0;i<nums.length;i++)
    	{
    		map.put(nums[i], i);
    	}
    	
    	for(int i=0;i<nums.length;i++)
    	{
    		int diff = target - nums[i];
    		
    		if((map.containsKey(diff)) 
    				&& (map.get(diff)!=i))
    		{
    			return new int[] {i, map.get(diff)};
    		}
    	}
    	return new int[] {};
    }
    
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for(String s : strs)
        {
        	int[] count = new int[26];
        	
        	for(char c:s.toCharArray())
        	{
        		count[c-'a']++;
        	}
        	
        	String key = Arrays.toString(count);
        	map.putIfAbsent(key, new ArrayList<>());
        	map.get(key).add(s);
        }
        
        return new ArrayList<>(map.values());
    }
	
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int n : nums)
        {
        	map.put(n, map.getOrDefault(n, 0)+1);
        }
        
        List<Integer>[] freq = new List[nums.length+1];
        
        for(int i=0;i<freq.length;i++)
        {
        	freq[i]=new ArrayList<>();
        }
        
        for(Entry<Integer, Integer> entry : map.entrySet())
        {
        	freq[entry.getValue()].add(entry.getKey()); 
        }
        
        int[] op = new int[k];
        int j=0;
        
        for(int i=freq.length-1;i>=0;i--)
        {
        	for(int n: freq[i])
        	{
        		if(j==k)break;
        		
        		op[j]=n;
        		j++;
        	}
        }
        
        return op;
    }
    
    public static String encode(List<String> strs) {
    	StringBuilder sb = new StringBuilder();
    	
    	for(String str : strs)
    	{
    		sb.append(str.length()).append('#').append(str);
    	}
    	
    	return sb.toString();
    }

    public static List<String> decode(String str) {
    	
    	List<String> op = new ArrayList<>();
    	
    	int i=0;
    	int j=i;
    	
    	while(i<str.length())
    	{
    		while(str.charAt(j)!='#')
    		{
    			j++;
    		}
    		
    		int len = Integer.parseInt(str.substring(i,j));
    		
    		i=j+1;
    		j=i+len;
    		op.add(str.substring(i, j));
    		i=j;
    		j=i;
    	}
    	return op;
    }
    
    public static int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] pre = new int[n];
        int[] suf = new int[n];
        
        pre[0]=1;
        suf[n-1]=1;
        
        for(int i=1;i<pre.length;i++)
        {
        	pre[i]=nums[i-1]*pre[i-1];
        }
        
        for(int i=suf.length-2;i>=0;i--)
        {
        	suf[i]=nums[i+1]*suf[i+1];
        }
        
        int[] op = new int[n];
        
        for(int i=0;i<n;i++)
        {
        	op[i]=pre[i]*suf[i];
        }
        
        return op;
    }
    
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        for(int n: nums)
        {
        	set.add(n);
        }
        
        int maxSeq=0;
        
        for(int n:set)
        {
        	if(!set.contains(n-1))
        	{
        		int len=1;
        		
        		while(set.contains(n+len))
        		{
        			len++;
        		}
        		
        		if(len>maxSeq)
        		{
        			maxSeq=len;
        		}
        	}
        }
        return maxSeq;
    }
    
    public static boolean isValid(String s) {
    	Stack<Character> stack = new Stack<>();
    	
    	for(char c:s.toCharArray())
    	{
    		if(c=='(' || c=='{' || c=='[')
    		{
    			stack.push(c);
    		}
    		else
    		{
    			if(stack.isEmpty())return false;
    			
    			if((stack.peek()=='(' && c==')')
    					|| (stack.peek()=='{' && c=='}')
    					|| (stack.peek()=='[' && c==']'))
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
        Stack<Integer> stack = new Stack<>();
        
        for(String s:tokens)
        {
        	if(s.equals("+"))
        	{
        		int num2 = stack.pop();
        		int num1 = stack.pop();
        		stack.push(num1+num2);
        	}
        	else if(s.equals("-"))
        	{
        		int num2 = stack.pop();
        		int num1 = stack.pop();
        		stack.push(num1-num2);
        	}
        	else if(s.equals("*"))
        	{
        		int num2 = stack.pop();
        		int num1 = stack.pop();
        		stack.push(num1*num2);
        	}
        	else if(s.equals("/"))
        	{
        		int num2 = stack.pop();
        		int num1 = stack.pop();
        		stack.push(num1/num2);
        	}
        	else
        	{
        		stack.push(Integer.parseInt(s));
        	}
        }
        return stack.peek();
    }
    
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> stack=new Stack<>();
        
        for(int i=0;i<temperatures.length;i++)
        {
        	while(!stack.isEmpty() 
        			&& temperatures[i]>temperatures[stack.peek()])
        	{
        		int idx = stack.pop();
        		res[idx]=i-idx;
        	}
        	stack.push(i);
        }
        return res;
    }
    
    
    public static boolean isPalindrome(String s) {
        int l=0, r=s.length()-1;
        
        while(l<r)
        {
        	while((l<r) && (!isAlphaNum(s.charAt(l))))
        	{
        		l++;
        	}
        	
        	while((l<r) && (!isAlphaNum(s.charAt(r))))
        	{
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
    	return ((c>='A' && c<='Z')
    			|| (c>='a' && c<='z')
    			|| (c>='0' && c<='9'));
    }
    
    public static int[] twoSum2(int[] nums, int target) {
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
        		return new int[] {l+1, r+1};
        	}
        }
        return new int[] {};
    }
    
    public static List<List<Integer>> threeSum(int[] nums) {
        
    	List<List<Integer>> res = new ArrayList<>();
    	Arrays.sort(nums);
    	
    	for(int i=0;i<nums.length;i++)
    	{
    		if(i>0 && nums[i]==nums[i-1])continue;
    		
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
    			else
    			{
    				res.add(Arrays.asList(nums[i], nums[j], nums[k]));
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
    	return res;
    }
    
    
    public static int maxArea(int[] height) {
        int l=0, r=height.length-1;
        
        int maxArea=Integer.MIN_VALUE;
        while(l<r)
        {
        	int area = Math.min(height[l], height[r]) * (r-l);
        	maxArea = Math.max(maxArea, area);
        	
        	if(height[l] > height[r])
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
    
    public static int binarysearch(int[] nums, int target) {
        int l=0, r=nums.length-1;
        
        while(l<=r)
        {
        	int m = (l+r)/2;
        	
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
    
    public static boolean searchMatrix(int[][] matrix, int target) {
        int ROW=matrix.length;
        int COL=matrix[0].length;
        
        int l=0, r=ROW-1;
        
        while(l<=r)
        {
        	int m = (l+r)/2;
        	
        	if(target>matrix[m][COL-1])
        	{
        		l=m+1;
        	}
        	else if(target<matrix[m][0])
        	{
        		r=m-1;
        	}
        	else
        	{
        		break;
        	}
        }
        
        int row_f = (l+r)/2;
        
        l=0;
        r=COL-1;
        
        while(l<=r)
        {
        	int m= (l+r)/2;
        	
        	if(target>matrix[row_f][m])
        	{
        		l=m+1;
        	}
        	else if(target<matrix[row_f][m])
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
        int l=0;
        int r=0;
        
        for(int n:piles)
        {
        	if(n>r)
        	{
        		r=n;
        	}
        }
        
        int res = Integer.MAX_VALUE;
        while(l<=r)
        {
        	int k=(l+r)/2;
        	
        	long totalTime=0;
        	for(int n:piles)
        	{
        		totalTime+=Math.ceil((double)n/k);
        	}
        	
        	if(totalTime<=h)
        	{
        		r=k-1;
        		res=Math.min(res, k);
        	}
        	else
        	{
        		l=k+1;
        	}
        }
        
        return res;
    }
    
    public static int findMin(int[] nums) {
    	int l=0, r=nums.length-1;
    	int min=nums[0];
    	
    	while(l<=r)
    	{
    		if(nums[l]<nums[r])
    		{
    			min=Math.min(nums[l], min);
    			break;
    		}
    		
    		int m=(l+r)/2;
    		min=Math.min(nums[m], min);
    		
    		if(nums[m]>=nums[l])
    		{
    			l=m+1;
    		}
    		else
    		{
    			r=m-1;
    		}
    	}
    	return min;
    }
    
    public static int searchRotatedSortedArr(int[] nums, int target) {
        int l=0, r=nums.length-1;
        int minIdx=0;
        
        while(l<=r)
        {
        	if(nums[l]<nums[r])
        	{
        		if(nums[l]<nums[minIdx])
        		{
        			minIdx=l;
        		}
        		break;
        	}
        	
        	int m=(l+r)/2;
        	if(nums[m]<nums[minIdx])
        	{
        		minIdx=m;
        	}
        	
        	if(nums[m]>=nums[l])
        	{
        		l=m+1;
        	}
        	else
        	{
        		r=m-1;
        	}
        }
        
        if(target==nums[minIdx])return minIdx;
        
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
    
    public static int maxSubArrSumBruteForce(int[] nums, int w)
    {
    	int maxSum=0;
    	
    	for(int i=0;i<=nums.length-w;i++)
    	{
    		int sum=0;
    		for(int j=i;j<=(i+w-1);j++)
    		{
    			sum+=nums[j];
    		}
    		maxSum=Math.max(sum, maxSum);
    	}
    	return maxSum;
    }
    
    public static int maxSubArrSumSlidingWin(int[] nums, int w)
    {
    	int sum=0;
    	for(int i=0;i<w;i++)
    	{
    		sum+=nums[i];
    	}
    	
    	int maxSum=sum;
    	
    	for(int i=1;i<=nums.length-w;i++)
    	{
    		sum=sum-nums[i-1]+nums[i+w-1];
    		maxSum=Math.max(sum, maxSum);
    	}
    	
    	return maxSum;
    }
    
    public static int maxProfitBruteForce(int[] prices) {
        int maxProfit=0;
        
        for(int i=0;i<prices.length-1;i++)
        {
        	for(int j=i+1;j<prices.length-1;j++)
        	{
        		int profit=0;
        		profit=prices[j]-prices[i];
        		maxProfit=Math.max(profit, maxProfit);
        	}
        }
        return maxProfit;
    }
    
    public static int maxProfit(int[] prices) {
    	int l=0;
    	int maxProfit=0;
    	for(int r=0;r<prices.length;r++)
    	{
    		if(prices[r]<prices[l])
    		{
    			l=r;
    		}
    		
    		int profit=prices[r]-prices[l];
    		maxProfit=Math.max(profit, maxProfit);
    	}
    	return maxProfit;
    }
    
    public static int minSubArrayLen(int target, int[] nums) {
        int l=0;
        int minSize=Integer.MAX_VALUE;
        int sum=0;
        
        for(int r=0;r<nums.length;r++)
        {
        	sum+=nums[r];
        	
        	while(sum>=target)
        	{
        		minSize=Math.min((r-l)+1, minSize);
        		sum=sum-nums[l];
        		l++;
        	}
        }
        return minSize==Integer.MAX_VALUE?0:minSize;
    }
    
    public static int lengthOfLongestSubstring(String s) {
        int l=0;
        int maxLen=0;
        Set<Character> set = new HashSet<>();
        
        for(int r=0;r<s.length();r++)
        {
        	while(set.contains(s.charAt(r)))
        	{
        		set.remove(s.charAt(l));
        		l++;
        	}
        	
        	maxLen=Math.max((r-l)+1, maxLen);
        	set.add(s.charAt(r));
        }
        return maxLen;
    }
    
    public static int characterReplacement(String s, int k) {
        int l=0;
        int maxLen=0;
        int[] count=new int[26];
        int freq=0;
        
        for(int r=0;r<s.length();r++) //O(n)
        {
        	count[s.charAt(r)-'A']++;
        	
        	freq=Math.max(count[s.charAt(r)-'A'], freq);
        	        	
        	while((((r-l)+1)-freq)>k)
        	{
        		count[s.charAt(l)-'A']--;
        		l++;
        	}
        	
        	maxLen=Math.max((r-l)+1, maxLen);
        }
        return maxLen;
    }
    
    public static boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length())return false;
        
        Map<Character,Integer> s1Map=new HashMap<>();
        Map<Character,Integer> s2Map=new HashMap<>();
        
        for(int i=0;i<s1.length();i++)
        {
        	s1Map.put(s1.charAt(i), s1Map.getOrDefault(s1.charAt(i), 0)+1);
        	s2Map.put(s2.charAt(i), s2Map.getOrDefault(s2.charAt(i), 0)+1);
        }
        
        if(s1Map.equals(s2Map))return true;
        
        int l=0;
        
        for(int r=s1.length();r<s2.length();r++)
        {
        	s2Map.put(s2.charAt(r), s2Map.getOrDefault(s2.charAt(r),0)+1);
        	
        	s2Map.put(s2.charAt(l), s2Map.getOrDefault(s2.charAt(l),0)-1);
        	
        	if(s2Map.get(s2.charAt(l))<=0)
        	{
        		s2Map.remove(s2.charAt(l));
        	}
    		l++;

        	if(s2Map.equals(s1Map))return true;
        }
        
        return false;
    }
    
    public static ListNode10 reverseList(ListNode10 head) {
    	ListNode10 cur=head;
    	ListNode10 prev=null;
    	
    	while(cur!=null)
    	{
    		ListNode10 tmp=cur.next;
    		cur.next=prev;
    		prev=cur;
    		cur=tmp;
    	}
    	return prev;
    }
    
    public static ListNode10 mergeTwoLists(ListNode10 list1, ListNode10 list2) {
    	ListNode10 dummy=new ListNode10();
    	ListNode10 cur=dummy;
    	
    	while(list1!=null && list2!=null)
    	{
    		if(list1.val<list2.val)
    		{
    			cur.next=list1;
    			list1=list1.next;
    		}
    		else
    		{
    			cur.next=list2;
    			list2=list2.next;
    		}
    		cur=cur.next;
    	}
    	
    	if(list1!=null)
    	{
    		cur.next=list1;
    	}
    	else
    	{
    		cur.next=list2;
    	}
    	
    	return dummy.next;
    }
    
    public static boolean hasCycle(ListNode10 head) {
    	ListNode10 slow=head;
    	ListNode10 fast=head;
    	
    	while(fast!=null && fast.next!=null)
    	{
    		slow=slow.next;
    		fast=fast.next.next;
    		
    		if(slow==fast)return true;
    	}
    	
    	return false;
    }
    
    public static void reorderList(ListNode10 head) {
    	//Split
    	ListNode10 slow=head;
    	ListNode10 fast=head;
    	
    	while(fast!=null && fast.next!=null)
    	{
    		slow=slow.next;
    		fast=fast.next.next;
    	}
    	
    	ListNode10 second=slow.next;
    	slow.next=null;
    	
    	//reverse
    	ListNode10 prev=null;
    	
    	while(second!=null)
    	{
    		ListNode10 tmp=second.next;
    		second.next=prev;
    		prev=second;
    		second=tmp;
    	}

    	//merge
    	ListNode10 first=head;
    	second=prev;
    	
    	while(second!=null)
    	{
    		ListNode10 tmp1=first.next;
    		ListNode10 tmp2=second.next;
    		first.next=second;
    		second.next=tmp1;
    		first=tmp1;
    		second=tmp2;
    	}
    	
    }
    
    public static ListNode10 removeNthFromEnd(ListNode10 head, int n) {
        int size=0;
        ListNode10 cur=head;
        while(cur!=null)
        {
        	size++;
        	cur=cur.next;
        }
        
        int removeIdx=size-n;
        
        if(removeIdx==0)return head.next;
        
        cur=head;
        int i=0;
        
        while(cur!=null)
        {
        	if(i==(removeIdx-1))
        	{
        		cur.next=cur.next.next;
        		break;
        	}
        	
        	i++;
        	cur=cur.next;
        }
        return head;
    }
    
    
    public static ListNode10 addTwoNumbers(ListNode10 l1, ListNode10 l2) {
    	ListNode10 dummy=new ListNode10();
    	ListNode10 cur=dummy;
    	int carry=0;
    	
    	while(l1!=null || l2!=null || carry!=0)
    	{
    		int val1=l1!=null?l1.val:0;
    		int val2=l2!=null?l2.val:0;
    		
    		int val=val1+val2+carry;
    		carry=val/10;
    		int rem=val%10;
    		cur.next=new ListNode10(rem);
    		
    		cur=cur.next;
    		l1=l1!=null?l1.next:null;
    		l2=l2!=null?l2.next:null;
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
        
        while(slow2!=slow)
        {
        	slow=nums[slow];
        	slow2=nums[slow2];
        }
        
        return slow2;
    }
    
    public static Node13 copyRandomList(Node13 head) {
        Map<Node13,Node13> map=new HashMap<>();
        map.put(null, null);
        
        Node13 cur=head;
        while(cur!=null)
        {
        	map.put(cur, new Node13(cur.val));
        	cur=cur.next;
        }
        
        cur=head;
        while(cur!=null)
        {
        	Node13 copy=map.get(cur);
        	copy.next=map.get(cur.next);
        	copy.random=map.get(cur.random);
        	cur=cur.next;
        }
        return map.get(head);
    }
    
    public static TreeNode16 invertTreeRecursion(TreeNode16 root) {
        if(root==null)return null;
        
        TreeNode16 node=new TreeNode16(root.val);
        
        node.left=invertTreeRecursion(root.right);
        node.right=invertTreeRecursion(root.left);
        return node;
    }
    
    public static TreeNode16 invertTreeIterative(TreeNode16 root) 
    {
    	if(root==null)return null;
    	Stack<TreeNode16> s1=new Stack<>();
    	Stack<TreeNode16> s2=new Stack<>();
    	s1.push(root);
    	TreeNode16 newNode=new TreeNode16(root.val);
    	s2.push(newNode);
    	
    	while(!s1.isEmpty() && !s2.isEmpty())
    	{
    		TreeNode16 n1=s1.pop();
    		TreeNode16 n2=s2.pop();
    		
    		if(n1.left!=null)
    		{
    			s1.push(n1.left);
    			n2.right=new TreeNode16(n1.left.val);
    			s2.push(n2.right);
    		}
    		
    		if(n1.right!=null)
    		{
    			s1.push(n1.right);
    			n2.left=new TreeNode16(n1.right.val);
    			s2.push(n2.left);
    		}
    	}
    	return newNode;
    }
    
    public static int maxDepth(TreeNode16 root) {
        if(root==null)return 0;
        
        return 1+Math.max(maxDepth(root.left), maxDepth(root.right));
    }
    
    public static int maxDepthBFS(TreeNode16 root) {
    	if(root==null)return 0;
    	
    	Queue<TreeNode16> q=new LinkedList<>();
    	q.offer(root);
    	
    	int len=0;
    	
    	while(!q.isEmpty())
    	{
    		int size=q.size();
    		
    		for(int i=0;i<size;i++)
    		{
    			TreeNode16 node=q.poll();
    			
    			if(node.left!=null)
    			{
    				q.offer(node.left);
    			}
    			
    			if(node.right!=null)
    			{
    				q.offer(node.right);
    			}
    		}
    		len++;
    	}
    	return len;
    }
    
    public static int diameterOfBinaryTree(TreeNode16 root) {
        int[] res=new int[1];
        diameterOfBinaryTreeH(root, res);
        return res[0];
    }
    
    private static int diameterOfBinaryTreeH(TreeNode16 node, int[] res)
    {
    	if(node==null)return 0;
    	
    	int left=diameterOfBinaryTreeH(node.left, res);
    	int right=diameterOfBinaryTreeH(node.right, res);
    	
    	res[0]=Math.max(left+right, res[0]);
    	
    	return 1+Math.max(left, right);
    }
    
    public static boolean isBalanced(TreeNode16 root) {
    	return isBalancedH(root)[0]==1;
    }
    
    
    private static int[] isBalancedH(TreeNode16 node) {
    	if(node==null)return new int[] {1,0};
    	
    	int[] left=isBalancedH(node.left);
    	int[] right=isBalancedH(node.right);
    	
    	boolean isBalanced=left[0]==1 && right[0]==1 && (Math.abs(left[1]-right[1])<=1);
    	int height=1+Math.max(left[1], right[1]);
    	return new int[] {isBalanced?1:0, height};
    }
    
    
    public static boolean isSameTreeDfsRecursive(TreeNode16 p, TreeNode16 q) {
    	if(p==null && q==null)return true;
    	
    	if(p==null || q==null || p.val!=q.val)return false;
    	
    	return isSameTreeDfsRecursive(p.left, q.left) && isSameTreeDfsRecursive(p.right, q.right);
    }
    
    public static boolean isSubtree(TreeNode16 root, TreeNode16 subRoot) {
        if(subRoot==null) return true;
        
        if(root==null)return false;
        
        if(isSameTree1(root,subRoot))return true;
        
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    
    private static boolean isSameTree1(TreeNode16 root, TreeNode16 subRoot)
    {
    	if(root==null && subRoot==null)return true;
    	
    	if(root==null || subRoot==null || root.val!=subRoot.val)return false;
    	
    	return isSameTree1(root.left,subRoot.left) && isSameTree1(root.right,subRoot.right);
    }
    
    public static TreeNode16 lowestCommonAncestor(TreeNode16 root, TreeNode16 p, TreeNode16 q) {
    	TreeNode16 cur=root;
    	
    	while(cur!=null)
    	{
    		if(p.val<cur.val && q.val<cur.val)
    		{
    			cur=cur.left;
    		}
    		else if(p.val>cur.val && q.val>cur.val)
    		{
    			cur=cur.right;
    		}
    		else
    		{
    			return cur;
    		}
    	}
    	return null;
    }
    
    public static List<List<Integer>> levelOrder(TreeNode16 root) {
        if(root==null)return new ArrayList<>();
        
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode16> q=new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty())
        {
        	List<Integer> list=new ArrayList<>();
        	int size=q.size();
        	
        	for(int i=0;i<size;i++)
        	{
        		TreeNode16 node=q.poll();
        		list.add(node.val);
        		
        		if(node.left!=null)
        		{
        			q.offer(node.left);
        		}
        		
        		if(node.right!=null)
        		{
        			q.offer(node.right);
        		}
        	}
        	if(list.size()>0)
        	{
        		res.add(list);
        	}
        }
        return res;
    }
    
    public static List<Integer> rightSideView(TreeNode16 root) {
        if(root==null)return new ArrayList<>();
        
        List<Integer> res=new ArrayList<>();
        Queue<TreeNode16> q=new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty())
        {
        	int size=q.size();
        	TreeNode16 tmp=null;
        	for(int i=0;i<size;i++)
        	{
        		TreeNode16 node=q.poll();
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
    
    public static int goodNodes(TreeNode16 root) {
        return goodNodesH(root, root.val);
    }
    
    private static int goodNodesH(TreeNode16 node, int maxVal)
    {
    	if(node==null)return 0;
    	
    	int res=node.val>=maxVal?1:0;
    	maxVal=node.val>maxVal?node.val:maxVal;
    	res+=goodNodesH(node.left, maxVal);
    	res+=goodNodesH(node.right, maxVal);
    	return res;
    }
    
    public static boolean isValidBST(TreeNode16 root) {
        return isValidBSTH(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private static boolean isValidBSTH(TreeNode16 node, long left, long right)
    {
    	if(node==null)return true;
    	
    	if(!(node.val>left && node.val<right))return false;
    	
    	return isValidBSTH(node.left, left, node.val) && isValidBSTH(node.right, node.val, right);
    }
    
    
    public static int kthSmallest(TreeNode16 root, int k) {
        List<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);
        return list.get(k-1);
    }
    
    private static void inorderTraversal(TreeNode16 node, List<Integer> list)
    {
    	if(node!=null)
    	{
    		inorderTraversal(node.left, list);
    		list.add(node.val);
    		inorderTraversal(node.right, list);
    	}
    }
    
    static int preorderIdx=0;
    static Map<Integer, Integer> inorderMap=new HashMap<>();
    public static TreeNode16 buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++)
        {
        	inorderMap.put(inorder[i], i);
        }
        return buildTreeH(preorder, 0, inorder.length-1);
    }
    
    private static TreeNode16 buildTreeH(int[] preorder, int l, int r)
    {
    	if(l>r)return null;
    	
    	int nodeVal=preorder[preorderIdx];
    	TreeNode16 node = new TreeNode16(nodeVal);
    	preorderIdx++;
    	int mid=inorderMap.get(nodeVal);
    	node.left=buildTreeH(preorder, l, mid-1);
    	node.right=buildTreeH(preorder, mid+1, r);
    	return node;
    }
    
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        subsetsH(nums, 0, new ArrayList<>(), res);
        return res;
    }
    
    private static void subsetsH(int[] nums, int i, List<Integer> subset, List<List<Integer>> res)
    {
    	if(i>=nums.length)
    	{
    		res.add(new ArrayList<>(subset));
    		return;
    	}
    	
    	subset.add(nums[i]);
    	subsetsH(nums, i+1, subset, res);
    	subset.remove(subset.size()-1);
    	subsetsH(nums, i+1, subset, res);
    }
    
    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res=new ArrayList<>();
        combinationSumH(nums, 0, 0, target, new ArrayList<>(), res);
        return res;
    }
    
    private static void combinationSumH(int[] nums, int i, int sum, int target, List<Integer> subset, List<List<Integer>> res)
    {
    	if(sum==target)
    	{
    		res.add(new ArrayList<>(subset));
    		return;
    	}
    	
    	if(i>=nums.length || sum>target)return;
    	
    	subset.add(nums[i]);
    	combinationSumH(nums, i, sum+nums[i], target, subset, res);
    	subset.remove(subset.size()-1);
    	combinationSumH(nums, i+1, sum, target, subset, res);
    }
    
    public static List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
    	List<List<Integer>> res=new ArrayList<>();
    	combinationSum2H(nums,0,0,target,new ArrayList<>(),res);
    	return res;
    }
    
    private static void combinationSum2H(int[] nums, int i, int sum, int target, List<Integer> subset, List<List<Integer>> res)
    {
    	if(sum==target)
    	{
    		res.add(new ArrayList<>(subset));
    		return;
    	}
    	
    	if(i>=nums.length || sum>target)return;
    	
    	subset.add(nums[i]);
    	combinationSum2H(nums,i+1,sum+nums[i],target,subset,res);
    	subset.remove(subset.size()-1);
    	while(i+1<nums.length && nums[i]==nums[i+1])
    	{
    		i++;
    	}
    	combinationSum2H(nums,i+1,sum,target,subset,res);
    }
    
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permuteH(nums, new boolean[nums.length], new ArrayList<>(), res);
        return res;
    }
    
    private static void permuteH(int[] nums, boolean[] visited, List<Integer> perm, List<List<Integer>> res)
    {
    	if(perm.size()==nums.length)
    	{
    		res.add(new ArrayList<>(perm));
    		return;
    	}
    	
    	for(int i=0;i<nums.length;i++)
    	{
    		if(!visited[i])
    		{
    			perm.add(nums[i]);
    			visited[i]=true;
    			permuteH(nums, visited, perm, res);
    			perm.remove(perm.size()-1);
    			visited[i]=false;
    		}
    	}
    }
    
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
        subsetsWithDupH(nums,0,new ArrayList<>(),res);
        return res;
    }
    
    private static void subsetsWithDupH(int[] nums, int i, List<Integer> subset, List<List<Integer>> res)
    {
    	if(i>=nums.length)
    	{
    		res.add(new ArrayList<>(subset));
    		return;
    	}
    	
    	subset.add(nums[i]);
    	subsetsWithDupH(nums,i+1,subset,res);
    	subset.remove(subset.size()-1);
    	
    	while(i+1<nums.length && nums[i]==nums[i+1])
    	{
    		i++;
    	}
    	subsetsWithDupH(nums,i+1,subset,res);
    }
    
    public static boolean exist(char[][] board, String word) {
        int ROW=board.length;
        int COL=board[0].length;
        boolean[][] visited=new boolean[ROW][COL];
        
        for(int r=0;r<ROW;r++)
        {
        	for(int c=0;c<COL;c++)
        	{
        		if(board[r][c]==word.charAt(0))
        		{
        			if(wordCheck(board, visited, r, c, 0, word))
        			{
        				return true;
        			}
        		}
        	}
        }
        
        return false;
    }
    
    private static boolean wordCheck(char[][] board, boolean[][] visited, int row, int col, int i, String word)
    {
    	if(i>=word.length()-1)
    	{
    		return true;
    	}
    	
    	visited[row][col]=true;
    	
    	int[][] dirs= {{1,0},{-1,0},{0,1},{0,-1}};
    	
    	for(int[] dir : dirs)
    	{
    		int r=row+dir[0];
    		int c=col+dir[1];
    		
    		if(r<0||r>board.length-1
    				|| c<0||c>board[0].length-1 
    				|| visited[r][c] || board[r][c]!=word.charAt(i+1))
    			continue;
    		
    		if(wordCheck(board, visited, r, c, i+1, word))return true;
    	}
    	visited[row][col]=false;
    	return false;
    }
    
    public static List<List<String>> partition(String s) {
    	List<List<String>> res = new ArrayList<>();
    	partitionH(s,0,new ArrayList<>(),res);
    	return res;
    }
    
    private static void partitionH(String s, int i, List<String> part, List<List<String>> res)
    {
    	if(i>=s.length())
    	{
    		res.add(new ArrayList<>(part));
    		return;
    	}
    	
    	for(int j=i;j<s.length();j++)
    	{
    		if(isPalindrome(s,i,j))
    		{
    			part.add(s.substring(i,j+1));
    			partitionH(s, j+1, part, res);
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
    
    static String[] digitsMap= {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public static List<String> letterCombinations(String digits) {
    	if(digits.length()==0)return new ArrayList<>();
    	List<String> res=new ArrayList<>();
    	letterCombinationsH(digits, "", 0, res);
    	return res;
    }
    
    private static void letterCombinationsH(String digits, String ans, int i, List<String> res)
    {
    	if(ans.length()==digits.length())
    	{
    		res.add(ans);
    		return;
    	}
    	
    	for(char c: digitsMap[digits.charAt(i)-'0'].toCharArray())
    	{
    		letterCombinationsH(digits, ans+c, i+1, res);
    	}
    }
    
    public static int numIslands(char[][] grid) {
        int ROW=grid.length;
        int COL=grid[0].length;
        boolean[][] visited=new boolean[ROW][COL];
        int islands=0;
        
        for(int r=0;r<ROW;r++)
        {
        	for(int c=0;c<COL;c++)
        	{
        		if((!visited[r][c]) && grid[r][c]=='1')
        		{
        			numIslandsH(grid, visited, r, c);
        			islands++;
        		}
        	}
        }
        
        return islands;
    }
    
    private static void numIslandsH(char[][] grid, boolean[][] visited, int row, int col)
    {
    	visited[row][col]=true;
    	
    	int[][] dirs= {{1,0},{-1,0},{0,1},{0,-1}};
    	for(int[] dir:dirs)
    	{
    		int r=row+dir[0];
    		int c=col+dir[1];
    		
    		if(r<0||r>=grid.length || c<0||c>=grid[0].length || visited[r][c] || grid[r][c]!='1') continue;
    		
    		numIslandsH(grid, visited, r, c);
    	}
    }
    
    public static int maxAreaOfIsland(int[][] grid) {
        int ROW=grid.length;
        int COL=grid[0].length;
        boolean[][] visited=new boolean[ROW][COL];
        int maxArea=0;
        
        for(int r=0;r<ROW;r++)
        {
        	for(int c=0;c<COL;c++)
        	{
        		if((!visited[r][c]) && grid[r][c]==1)
        		{
        			int area=getArea(grid, visited, r, c);
        			maxArea=Math.max(area, maxArea);
        		}
        	}
        }
        return maxArea;
    }
    
    private static int getArea(int[][] grid, boolean[][] visited, int row, int col)
    {
    	int area=1;
    	visited[row][col]=true;
    	
    	int[][] dirs= {{1,0},{-1,0},{0,1},{0,-1}};
    	for(int[] dir:dirs)
    	{
    		int r=row+dir[0];
    		int c=col+dir[1];
    		
    		if(r<0||r>=grid.length || c<0||c>=grid[0].length || visited[r][c] || grid[r][c]!=1)continue;
    		
    		area+=getArea(grid, visited, r, c);
    	}
    	return area;
    }
    
    public static Node15 cloneGraph(Node15 node) {
    	Map<Node15, Node15> map=new HashMap<>();
    	cloneGraphH(node, map);
    	return map.get(node);
    }
    
    private static void cloneGraphH(Node15 node, Map<Node15, Node15> map)
    {
    	if(node==null)return;
    	
    	Node15 copy=new Node15(node.val);
    	map.put(node, copy);
    	
    	for(Node15 nei:node.neighbors)
    	{
    		if(!map.containsKey(nei))
    		{
    			cloneGraphH(nei, map);
    		}
    		map.get(node).neighbors.add(map.get(nei));
    	}
    }
    
    public static void islandsAndTreasure(int[][] grid) {
        int ROW=grid.length;
        int COL=grid[0].length;
        Queue<int[]> q=new LinkedList<>();
        
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
        
        int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};
        
        while(!q.isEmpty())
        {
        	int[] pos=q.poll();
        	int row=pos[0];
        	int col=pos[1];
        	
        	for(int[] dir:dirs)
        	{
        		int r=row+dir[0];
        		int c=col+dir[1];
        		
        		if(r<0||r>=ROW || c<0||c>=COL || grid[r][c]!=Integer.MAX_VALUE)continue;
        		
        		grid[r][c]=grid[row][col]+1;
        		q.offer(new int[] {r,c});
        	}
        }
    }
    
    public static int orangesRotting(int[][] grid) {
        int ROW=grid.length;
        int COL=grid[0].length;
        int fresh=0;
        int maxtime=0;
        Queue<int[]> q=new LinkedList<>();
        
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
        
        int[][] dirs= {{1,0},{-1,0},{0,1},{0,-1}};
        
        while(!q.isEmpty() && fresh>0)
        {
        	int size=q.size();
        	
        	for(int i=0;i<size;i++)
        	{
        		int[] pos=q.poll();
        		int row=pos[0];
        		int col=pos[1];
        		
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
        	maxtime++;
        }
        return fresh>0?-1:maxtime;
    }
    
    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROW=heights.length;
        int COL=heights[0].length;
        boolean[][] pacific=new boolean[ROW][COL];
        boolean[][] atlantic=new boolean[ROW][COL];
        List<List<Integer>> res=new ArrayList<>();
        
        //pacific
        for(int r=0;r<ROW;r++)
        {
        	pacificAtlanticH(pacific, heights, r, 0);
        }
        
        for(int c=0;c<COL;c++)
        {
        	pacificAtlanticH(pacific, heights, 0, c);
        }
        
        //atlantic
        for(int r=0;r<ROW;r++)
        {
        	pacificAtlanticH(atlantic, heights, r, COL-1);
        }
        
        for(int c=0;c<COL;c++)
        {
        	pacificAtlanticH(atlantic, heights, ROW-1, c);
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
    
    private static void pacificAtlanticH(boolean[][] ocean, int[][] heights, int row, int col)
    {
    	ocean[row][col]=true;
    	
    	int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};
    	for(int[] dir:dirs)
    	{
    		int r=row+dir[0];
    		int c=col+dir[1];
    		
    		if(r<0||r>=ocean.length || c<0||c>=ocean[0].length || ocean[r][c] || heights[row][col]>heights[r][c])continue;
    		
    		pacificAtlanticH(ocean, heights, r, c);
    	}
    }
    
    public static void solve(char[][] board) {
        int ROW=board.length;
        int COL=board[0].length;
        
        for(int r=0;r<ROW;r++)
        {
        	solveH(board, r, 0);
        	solveH(board, r, COL-1);
        }
        
        for(int c=0;c<COL;c++)
        {
        	solveH(board, 0, c);
        	solveH(board, ROW-1, c);
        }
        
        for(int r=0;r<ROW;r++)
        {
            for(int c=0;c<COL;c++)
            {
            	if(board[r][c]=='O')
            	{
            		board[r][c]='X';
            	}
            	else if(board[r][c]=='A')
            	{
            		board[r][c]='O';
            	}
            }
        }
    }
    
    private static void solveH(char[][] board, int row, int col)
    {
    	if(board[row][col]!='O')return;
    	
    	board[row][col]='A';
    	
    	int[][] dirs= {{1,0},{-1,0},{0,1},{0,-1}};
    	for(int[] dir:dirs)
    	{
    		int r=row+dir[0];
    		int c=col+dir[1];
    		
    		if(r<0||r>=board.length || c<0||c>=board[0].length || board[r][c]!='O')continue;
    		solveH(board, r, c);
    	}
    }
    
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> preMap=new HashMap<>();
        Set<Integer> taken=new HashSet<>();
        Set<Integer> ongoing=new HashSet<>();
        
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
        	if(!canFinishH(i, taken, ongoing, preMap))return false;
        }
        
        return taken.size()==numCourses;
    }
    
    private static boolean canFinishH(int course, Set<Integer> taken, Set<Integer> ongoing, Map<Integer, List<Integer>> preMap)
    {
    	if(ongoing.contains(course))return false;
    	
    	if(taken.contains(course))return true;
    	
    	ongoing.add(course);
    	
    	for(int nextCourse:preMap.get(course))
    	{
    		if(!canFinishH(nextCourse, taken, ongoing, preMap))return false;
    	}
    	ongoing.remove(course);
    	taken.add(course);
    	return true;
    }
    
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> preMap=new HashMap<>();
        Set<Integer> taken=new HashSet<>();
        Set<Integer> ongoing=new HashSet<>();
        List<Integer> order=new ArrayList<>();
        
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
        	if(!findOrderH(i, taken, ongoing, preMap, order))
        	{
        		return new int[] {};
        	}
        }
        
    	int[] res=new int[order.size()];
        if(order.size()==numCourses)
        {
        	for(int i=0;i<order.size();i++)
        	{
        		res[i]=order.get(i);
        	}
        }
        
        return res;
    }
    
    private static boolean findOrderH(int course, Set<Integer> taken, Set<Integer> ongoing, Map<Integer, List<Integer>> preMap, List<Integer> order)
    {
    	if(ongoing.contains(course))return false;
    	
    	if(taken.contains(course))return true;
    	
    	ongoing.add(course);
    	
    	for(int nextCourse:preMap.get(course))
    	{
    		if(!findOrderH(nextCourse, taken, ongoing, preMap, order))return false;
    	}
    	ongoing.remove(course);
    	taken.add(course);
    	order.add(course);
    	return true;
    }
    
    public static boolean validTree(int n, int[][] edges) {
    	if(edges.length>=n)return false;
    	
    	Map<Integer, List<Integer>> emap=new HashMap<>();
    	Set<Integer> visited=new HashSet<>();
    	
    	for(int i=0;i<n;i++)
    	{
    		emap.put(i, new ArrayList<>());
    	}
    	
    	for(int[] edge:edges)
    	{
    		emap.get(edge[0]).add(edge[1]);
    		emap.get(edge[1]).add(edge[0]);
    	}
    	
		if(!validTreeH(0, -1, visited, emap))
		{
			return false;
		}
		
		return visited.size()==n;
    }
    
    private static boolean validTreeH(int node, int prevNode, Set<Integer> visited, Map<Integer, List<Integer>> emap)
    {
    	if(visited.contains(node))return false;
    	
    	visited.add(node);
    	
    	for(int nxtNode:emap.get(node))
    	{
    		if(nxtNode!=prevNode)
    		{
    			if(!validTreeH(nxtNode, node, visited, emap))
    			{
    				return false;
    			}
    		}
    	}
    	return true;
    }
    
    public static int countComponents(int n, int[][] edges) {
    	int num=0;
    	Map<Integer, List<Integer>> emap=new HashMap<>();
    	Set<Integer> visited=new HashSet<>();
    	
    	for(int i=0;i<n;i++)
    	{
    		emap.put(i, new ArrayList<>());
    	}
    	
    	for(int edge[]:edges)
    	{
    		emap.get(edge[0]).add(edge[1]);
    		emap.get(edge[1]).add(edge[0]);
    	}
    	
    	for(int i=0;i<n;i++)
    	{
    		if(!visited.contains(i))
    		{
    			countComponentsH(i, visited, emap);
    			num++;
    		}
    	}
    	
    	return num;
    }
    
    private static void countComponentsH(int node, Set<Integer> visited, Map<Integer, List<Integer>> emap)
    {
    	if(visited.contains(node))return;
    	
    	visited.add(node);
    	
    	for(int nextNode:emap.get(node))
    	{    		
    		countComponentsH(nextNode, visited, emap);
    	}
    }
    
    public static int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        List<List<Integer>> adj=new ArrayList<>();
        Set<Integer> visited=new HashSet<>();
        
        for(int i=1;i<=n;i++)
        {
        	adj.add(new ArrayList<>());
        }
        
        for(int[] edge:edges)
        {
        	adj.get(edge[0]).add(edge[1]);
        	adj.get(edge[1]).add(edge[0]);
        	
        	if(hasCycle(edge[0], -1, visited, adj))
        	{
        		return edge;
        	}
        	visited.clear();
        }
        return new int[] {};
    }
    
    private static boolean hasCycle(int node, int prevNode, Set<Integer> visited, List<List<Integer>> adj)
    {
    	if(visited.contains(node))return true;
    	
    	visited.add(node);
    	
    	for(int nextNode:adj.get(node))
    	{
    		if(nextNode==prevNode)continue;
    		
    		if(hasCycle(nextNode, node, visited, adj))
    		{
    			return true;
    		}
    	}
    	return false;
    }
    
    public static int abc(int[] nums, int a)
    {
    	int sum=Arrays.stream(nums).filter(x->x%2==0).map(x->x*a).sum();
    	List<Integer> list=Arrays.stream(nums).filter(x->x%2==0).map(x->x*a).boxed().collect(Collectors.toList());
    	return sum;
    }
    
    public static int[] dailyTemperatures2(int[] temperatures) {
        int[] res=new int[temperatures.length];
        Stack<Integer> stack=new Stack<>();
        
        for(int i=0;i<temperatures.length;i++)
        {
        	while(!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()])
        	{
        		int idx=stack.pop();
        		res[idx]=i-idx;
        	}
        	stack.push(i);
        }
        return res;
    }
    
    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
        
        for(int i=0;i<nums.length;i++)
        {
        	if(i-1>0 && nums[i-1]==nums[i])continue;
        	
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
        		else
        		{
        			res.add(Arrays.asList(nums[i],nums[j],nums[k]));
        			
        			j++;
        			k--;
        			
        			while(j<k && nums[j-1]==nums[j])
        			{
        				j++;
        			}
        			
        			while(j<k && nums[k+1]==nums[k])
        			{
        				k--;
        			}
        		}
        	}
        }
        return res;
    }
    
    public static int findMin2(int[] nums) {
    	int l=0, r=nums.length-1;
    	int min=nums[0];
    	
    	while(l<=r)
    	{
    		if(nums[l]<nums[r])
    		{
    			min=Math.min(nums[l], min);
    			break;
    		}
    		
    		int m=(l+r)/2;
    		min=Math.min(nums[m], min);
    		
    		if(nums[m]>=nums[l])
    		{
    			l=m+1;
    		}
    		else
    		{
    			r=m-1;
    		}
    	}
    	return min;
    }
    
    public static int characterReplacement2(String s, int k) {
        int maxlen=0;
        int maxCount=0;
        int[] count=new int[26];
        int l=0;
        
        for(int r=0;r<s.length();r++)
        {
        	count[s.charAt(r)-'A']++;
        	
        	maxCount=Math.max(count[s.charAt(r)-'A'], maxCount);
        	
        	while((r-l+1)-maxCount > k)
        	{
        		count[s.charAt(l)-'A']--;
        		l++;
        	}
        	
        	maxlen=Math.max(r-l+1, maxlen);
        }
        return maxlen;
    }
    
    
	public static ListNode10 reverseList2(ListNode10 head) {
		ListNode10 cur = head;
		ListNode10 prev = null;
		while (cur != null) {
			ListNode10 tmp=cur.next;
			cur.next=prev;
			prev=cur;
			cur=tmp;
		}
		return prev;
	}
	
    public static ListNode10 addTwoNumbers2(ListNode10 l1, ListNode10 l2) {
    	ListNode10 dummy=new ListNode10();
    	ListNode10 cur=dummy;
    	int carry=0;
    	
    	while(l1!=null || l2!=null || carry!=0)
    	{
    		int val1=l1!=null?l1.val:0;
    		int val2=l2!=null?l2.val:0;
    		int val=val1+val2+carry;
    		carry=val/10;
    		val=val%10;
    		cur.next=new ListNode10(val);
    		
    		cur=cur.next;
    		l1=l1!=null?l1.next:null;
    		l2=l2!=null?l2.next:null;
    	}
    	return dummy.next;
    }
    
    public static boolean isBalanced2(TreeNode16 root) {
        return isBalanced2H(root)[0]==1;
    }
    
    private static int[] isBalanced2H(TreeNode16 node)
    {
    	if(node==null)return new int[] {1,0};
    	
    	int[] left=isBalanced2H(node.left);
    	int[] right=isBalanced2H(node.right);
    	
    	boolean isBalanced=left[0]==1 && right[0]==1 && (Math.abs(left[1]-right[1]) <= 1);
    	int height=1+Math.max(left[1], right[1]);
    	return new int[] {isBalanced?1:0, height};
    }
    
    public static TreeNode16 lowestCommonAncestor2(TreeNode16 root, TreeNode16 p, TreeNode16 q) {
    	TreeNode16 cur=root;
    	
    	while(cur!=null)
    	{
    		if(p.val<cur.val && q.val<cur.val)
    		{
    			cur=cur.left;
    		}
    		else if(p.val>cur.val && q.val>cur.val)
    		{
    			cur=cur.right;
    		}
    		else
    		{
    			return cur;
    		}
    	}
    	return null;
    }
    
    public static int goodNodes2(TreeNode16 root) {
        return goodNodes2H(root, root.val);
    }
    
    private static int goodNodes2H(TreeNode16 node, int maxVal)
    {
    	if(node==null)return 0;
    	
    	int res=node.val>=maxVal?1:0;
    	maxVal=Math.max(node.val, maxVal);
    	res+=goodNodes2H(node.left, maxVal);
    	res+=goodNodes2H(node.right, maxVal);
    	return res;
    }
    
    static int preIdx=0;
    static Map<Integer,Integer> inorderMap2=new HashMap<>();
    public static TreeNode16 buildTree2(int[] preorder, int[] inorder) {

        for(int i=0;i<inorder.length;i++)
        {
        	inorderMap2.put(inorder[i], i);
        }
        
        return buildTree2H(preorder, 0, inorder.length-1);
    }
    
    private static TreeNode16 buildTree2H(int[] preorder, int l, int r)
    {
    	if(l>r)return null;
    	
    	int nodeVal=preorder[preIdx];
    	TreeNode16 node=new TreeNode16(nodeVal);
    	preIdx++;
    	int m=inorderMap2.get(nodeVal);
    	node.left=buildTree2H(preorder, l, m-1);
    	node.right=buildTree2H(preorder, m+1, r);
    	return node;
    }
    
    public static List<List<String>> partition2(String s) {
    	List<List<String>> res=new ArrayList<>();
    	partition2H(s, 0, new ArrayList<>(), res);
    	return res;
    }
    
    private static void partition2H(String s, int i, List<String> part, List<List<String>> res)
    {
    	if(i>=s.length())
    	{
    		res.add(new ArrayList<>(part));
    		return;
    	}
    	
    	for(int j=i;j<s.length();j++)
    	{
    		if(isPallindrome2(s,i,j))
    		{
    			part.add(s.substring(i,j+1));
    			partition2H(s, j+1, part, res);
    			part.remove(part.size()-1);
    		}
    	}
    }
    
    private static boolean isPallindrome2(String s, int l, int r)
    {
    	while(l<r)
    	{
    		if(s.charAt(l)!=s.charAt(r))return false;
    		l++;
    		r--;
    	}
    	return true;
    }
    
    public static List<String> letterCombinations2(String digits) {
        List<String> res=new ArrayList<>();
        if(digits.length()==0)return res;
        String[] alphaMap={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        letterCombinations2H(digits, "", 0, alphaMap, res);
        return res;
    }
    
    private static void letterCombinations2H(String digits, String comb, int i, String[] alphaMap, List<String> res)
    {
    	if(comb.length()==digits.length())
    	{
    		res.add(comb);
    		return;
    	}
    	
    	for(char c: alphaMap[digits.charAt(i)-'0'].toCharArray())
    	{
    		letterCombinations2H(digits, comb+c, i+1, alphaMap, res);
    	}
    }
    
    public static Node15 cloneGraph2(Node15 node) {
        Map<Node15, Node15> map=new HashMap<>();
        cloneGraph2H(node, map);
        return map.get(node);
    }
    
    private static void cloneGraph2H(Node15 node, Map<Node15, Node15> map)
    {
    	if(node==null)return;
    	
    	Node15 copy=new Node15(node.val);
    	map.put(node, copy);
    	
    	for(Node15 nei:node.neighbors)
    	{
    		if(!map.containsKey(nei))
    		{
    			cloneGraph2H(nei, map);
    		}
    		map.get(node).neighbors.add(map.get(nei));
    	}
    }
    
    public static boolean validTree2(int n, int[][] edges) {
    	if(n<=edges.length)return false;
    	
    	Map<Integer, List<Integer>> emap=new HashMap<>();
    	Set<Integer> visited=new HashSet<>();
    	
    	for(int i=0;i<n;i++)
    	{
    		emap.put(i, new ArrayList<>());
    	}
    	
    	for(int[] edge: edges)
    	{
    		emap.get(edge[0]).add(edge[1]);
    		emap.get(edge[1]).add(edge[0]);
    	}
    	
    	if(!validTree2H(0, -1, visited, emap))
    	{
    		return false;
    	}
    	
    	return visited.size()==n;
    }
    
    private static boolean validTree2H(int node, int prevNode, Set<Integer> visited, Map<Integer, List<Integer>> emap)
    {
    	if(visited.contains(node))return false;
    	
    	visited.add(node);
    	
    	for(int nextNode:emap.get(node))
    	{
    		if(nextNode==prevNode)continue;
    		
    		if(!validTree2H(nextNode, node, visited, emap))
    		{
    			return false;
    		}
    	}
    	return true;
    }
    
    public static int[] findRedundantConnection2(int[][] edges) {
        List<List<Integer>> adj=new ArrayList<>();
        Set<Integer> visited=new HashSet<>();
        int n=edges.length;
        
        for(int i=0;i<=n;i++)
        {
        	adj.add(new ArrayList<>());
        }
        
        for(int[] edge:edges)
        {
        	adj.get(edge[0]).add(edge[1]);
        	adj.get(edge[1]).add(edge[0]);
        	
    		if(isCycleH(edge[0], -1, visited, adj))
    		{
    			return edge;
    		}
    		visited.clear();
        }
        return new int[] {};
    }
    
    private static boolean isCycleH(int node, int prevNode, Set<Integer> visited, List<List<Integer>> adj)
    {
    	if(visited.contains(node))return true;
    	
    	visited.add(node);
    	
    	for(int nextNode:adj.get(node))
    	{
    		if(nextNode==prevNode)continue;
    		
    		if(isCycleH(nextNode, node, visited, adj))
    		{
    			return true;
    		}
    	}
    	return false;
    }
    
	public static void main(String[] args) {
		
//		int[] nums = {1,2,3,4};
//		System.out.println(containsDuplicate(nums));
		
//		String s = "rat", t = "car";
//		System.out.println(isAnagram2(s, t));
		
//		int[] nums = {3,3};
//		int target = 6;
//		System.out.println(Arrays.toString(twoSum(nums, target)));
		
//		String[] strs = {"eat","tea","tan","ate","nat","bat"};
//		System.out.println(groupAnagrams(strs).toString());
		
//		int[] nums = {1,1,1,2,2,3,3,3,3,3};
//		int k = 2;
//		System.out.println(Arrays.toString(topKFrequent(nums, k)));
		
//		List<String> strs = Arrays.asList("neet","code#","#love#","you");
//		
//		String encode=encode(strs);
//		System.out.println("encoded str>>"+encode);
//		System.out.println("decoded list>>"+decode(encode).toString());
		
//		int[] nums = {-1,1,0,-3,3};
//		System.out.println(Arrays.toString(productExceptSelf(nums)));
		
//		int[] nums = {1,0,1,2};
//		System.out.println(longestConsecutive(nums));
		
//		String s = "([])";
//		System.out.println(isValid(s));
		
//		MinStack6 minStack = new MinStack6();
//		minStack.push(-2);
//		minStack.push(0);
//		minStack.push(-3);
//		System.out.println("min>"+minStack.getMin());
//		minStack.pop();
//		System.out.println("top>"+minStack.top());
//		System.out.println("min>"+minStack.getMin());
		
//		String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
//		System.out.println(evalRPN(tokens));
		
//		int[] temperatures = {73,74,75,71,69,72,76,73};
//		System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
		
//		String s = "Was it a car or a cat I saw?";
//		System.out.println(isPalindrome(s));
		
//		int[] nums = {2,3,4};
//		int target = 6;
//		System.out.println(Arrays.toString(twoSum2(nums, target)));
		
//		int[] nums = {-1,0,1,2,-1,-4};
//		System.out.println(threeSum(nums).toString());
		
//		int[] height = {1,1};
//		System.out.println(maxArea(height));
		
//		int[] nums = {-1,0,3,5,9,12};
//		int target = -1;
//		System.out.println(binarysearch(nums, target));
		
//		int[][] matrix = {{1}};
//		int target = 3;
//		System.out.println(searchMatrix(matrix, target));
		
//		int[] piles = {30,11,23,4,20};
//		int h = 5;
//		System.out.println(minEatingSpeed(piles, h));
		
//		int[] nums = {4,5,6,7,0,1,2};
//		System.out.println(findMin(nums));
		
//		int[] nums = {4,5,6,7,0,1,2};
//		int target = 1;
//		System.out.println(searchRotatedSortedArr(nums, target));
		
//		TimeMap5 timeMap = new TimeMap5();
//		timeMap.set("foo", "bar", 1);  // store the key "foo" and value "bar" along with timestamp = 1.
//		System.out.println(timeMap.get("foo", 1));         // return "bar"
//		System.out.println(timeMap.get("foo", 3));         // return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
//		timeMap.set("foo", "bar2", 4); // store the key "foo" and value "bar2" along with timestamp = 4.
//		System.out.println(timeMap.get("foo", 4));         // return "bar2"
//		System.out.println(timeMap.get("foo", 5));         // return "bar2"
		
//		int[] nums= {3,8,2,5,7,6,12};
//		int w=4;
//		System.out.println(maxSubArrSumSlidingWin(nums, w));
		
//		int[] nums={7,1,5,3,6,4};
//		System.out.println(maxProfit(nums));
		
//		int[] nums = {1,4,4};
//		int target = 1;
//		System.out.println(minSubArrayLen(target, nums));
		
//		String s = "abcabcbb";
//		System.out.println(lengthOfLongestSubstring(s));
		
//		String s = "ABAB";
//		int k = 2;
//		System.out.println(characterReplacement(s, k));
		
//		String s1 = "ab", s2 = "eidbaooo";
//		System.out.println(checkInclusion(s1, s2));
		
//		ListNode10 a1=new ListNode10(2);
//		ListNode10 a2=new ListNode10(4);
//		ListNode10 a3=new ListNode10(3);
//		ListNode10 a4=new ListNode10(4);
//		ListNode10 a5=new ListNode10(5);
		
//		a1.next=a2;
//		a2.next=a3;
//		a3.next=a4;
//		a4.next=a5;
		
//		ListNode10 b1=new ListNode10(5);
//		ListNode10 b2=new ListNode10(6);
//		ListNode10 b3=new ListNode10(4);
//		ListNode10 b4=new ListNode10(3);
		
//		b1.next=b2;
//		b2.next=b3;
//		b3.next=b4;
		
//		System.out.println("BEFORE:");
//		ListNode10 cur=a1;
//		while(cur!=null)
//		{
//			System.out.println(cur.val);
//			cur=cur.next;
//		}
		
//		System.out.println("AFTER:");
//		ListNode10 cur=addTwoNumbers(a1, b1);
//		while(cur!=null)
//		{
//			System.out.println(cur.val);
//			cur=cur.next;
//		}
		
//		System.out.println(hasCycle(a1));
		
//		int[] nums = {3,1,3,4,2};
//		System.out.println(findDuplicate(nums));
		
//		LRUCache4 lRUCache = new LRUCache4(2);
//		lRUCache.put(1, 1); // cache is {1=1}
//		lRUCache.put(2, 2); // cache is {1=1, 2=2}
//		System.out.println(lRUCache.get(1));    // return 1
//		lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
//		System.out.println(lRUCache.get(2));    // returns -1 (not found)
//		lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
//		System.out.println(lRUCache.get(1));     // return -1 (not found)
//		System.out.println(lRUCache.get(3));     // return 3
//		System.out.println(lRUCache.get(4));     // return 4
		
//		TreeNode16 n3=new TreeNode16(3);
//		TreeNode16 n9=new TreeNode16(9);
//		TreeNode16 n20=new TreeNode16(20);
//		TreeNode16 n15=new TreeNode16(15);
//		TreeNode16 n7=new TreeNode16(7);
//
//		n3.left=n9;
//		n3.right=n20;
//		n20.left=n15;
//		n20.right=n7;
		
//		System.out.println("BEFORE:");
//		traverse(n4);
		
//		System.out.println("AFTER:");
//		TreeNode16 n=invertTreeIterative(n4);
//		traverse(n);
		
//		System.out.println(kthSmallest(n5, 3));
		
//		int[] preorder = {3,9,20,15,7};
//		int[] inorder = {9,3,15,20,7};
//		TreeNode16 n=buildTree(preorder, inorder);
//		traverse("PREORDER", n);
		
//		int[] nums= {1,2,3};
//		System.out.println(subsets(nums));
		
//		int[] nums= {10,1,2,7,6,1,5};
//		int target=8;
//		System.out.println(combinationSum2(nums, target));
		
//		int[] nums= {1,2,2};
//		System.out.println(subsetsWithDup(nums));
		
//		char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//		String word = "ABFCSEEDB";
//		System.out.println(exist(board, word));
		
//		String s = "aab";
//		System.out.println(partition(s));
		
//		String digits = "23";
//		System.out.println(letterCombinations(digits));
		
//		int[][] grid={{0,0,1,0,0,0,0,1,0,0,0,0,0},
//				{0,0,0,0,0,0,0,1,1,1,0,0,0},
//				{0,1,1,0,1,0,0,0,0,0,0,0,0},
//				{0,1,0,0,1,1,0,0,1,0,1,0,0},
//				{0,1,0,0,1,1,0,0,1,1,1,0,0},
//				{0,0,0,0,0,0,0,0,0,0,1,0,0},
//				{0,0,0,0,0,0,0,1,1,1,0,0,0},
//				{0,0,0,0,0,0,0,1,1,0,0,0,0}};
//		System.out.println(maxAreaOfIsland(grid));
		
//		int[][] grid={
//				  {2147483647,-1,0,2147483647},
//				  {2147483647,2147483647,2147483647,-1},
//				  {2147483647,-1,2147483647,-1},
//				  {0,-1,2147483647,2147483647}
//				};
//		
//		islandsAndTreasure(grid);
//		
//		for(int r=0;r<grid.length;r++)
//		{
//			for(int c=0;c<grid[0].length;c++)
//			{
//				System.out.print(grid[r][c]+" ");
//			}
//			System.out.println();
//		}
		
//		int[][] grid={{2,1,1},{1,1,0},{0,1,1}};
//		System.out.println(orangesRotting(grid));
		
//		int[][] heights = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
//		System.out.println(pacificAtlantic(heights));
		
//		char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
//		solve(board);
//		for(int r=0;r<board.length;r++)
//		{
//			for(int c=0;c<board[0].length;c++)
//			{
//				System.out.print(board[r][c]+" ");
//			}
//			System.out.println();
//		}
		
//		int numCourses = 2;
//		int[][] prerequisites = {{1,0},{0,1}};
//		System.out.println(canFinish(numCourses, prerequisites));
		
//		int numCourses = 4;
//		int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
//		System.out.println(Arrays.toString(findOrder(numCourses, prerequisites)));
		
//		int n = 5;
//		int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
//		System.out.println(validTree(n, edges));
		
//		int n = 6;
//		int[][] edges = {{0,1}, {1,2}, {2,3}, {4,5}};
//		System.out.println(countComponents(n, edges));
		
//		int[][] edges = {{1,2},{2,3},{3,4},{1,4},{1,5}};
//		System.out.println(Arrays.toString(findRedundantConnection(edges)));
		
//		int[] temperatures = {30,60,90};
//		System.out.println(Arrays.toString(dailyTemperatures2(temperatures)));
		
//		int[] nums = {-1,0,1,2,-1,-4};
//		System.out.println(threeSum2(nums));
		
//		int[] nums = {11,13,15,17};
//		System.out.println(findMin2(nums));
		
//		String s = "AABABBA";
//		int k = 1;
//		System.out.println(characterReplacement2(s, k));
		
//		TreeNode16 n1=new TreeNode16(1);
//		TreeNode16 n1_1=new TreeNode16(1);
//		TreeNode16 n3=new TreeNode16(3);
//		TreeNode16 n3_1=new TreeNode16(3);
//		TreeNode16 n4=new TreeNode16(4);
//		TreeNode16 n5=new TreeNode16(5);
		
//		TreeNode16 n6=new TreeNode16(6);
//		TreeNode16 n7=new TreeNode16(7);
//		TreeNode16 n8=new TreeNode16(8);
//		TreeNode16 n9=new TreeNode16(9);

		
//		n3.left=n1;
//		n3.right=n4;
//		n1.left=n3_1;
//		n4.left=n1_1;
//		n4.right=n5;
//		
//		System.out.println(goodNodes2(n3));
		
//		int[] preorder = {3,9,20,15,7};
//		int[] inorder = {9,3,15,20,7};
//		TreeNode16 node=buildTree2(preorder, inorder);
//		traverse("PREORDER", node);
		
//		String s = "aab";
//		System.out.println(partition2(s));
		
//		String digits = "23";
//		System.out.println(letterCombinations2(digits));
		
//		int n = 5;
//		int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};
//		System.out.println(validTree2(n, edges));
		
		int[][] edges = {{1,2},{1,3},{2,3}};
		System.out.println(Arrays.toString(findRedundantConnection2(edges)));
	}
	
	
	
	
	public static void traverse(String type, TreeNode16 node)
	{
		if(node!=null)
		{
			if(type.equals("INORDER"))
			{
				traverse(type, node.left);
				System.out.println("Node:"+node.val);
				traverse(type, node.right);
			}
			else if(type.equals("PREORDER"))
			{
				System.out.println("Node:"+node.val);
				traverse(type, node.left);
				traverse(type, node.right);
			}
		}
	}
}
