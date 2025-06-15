package practisesessionnov2024.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

class ListNode8 {
	int val;
	ListNode8 next;

	ListNode8() {
	}

	ListNode8(int val) {
		this.val = val;
	}

	ListNode8(int val, ListNode8 next) {
		this.val = val;
		this.next = next;
	}
}

class Node6 
{
    int val;
    Node6 next;
    Node6 random;

    public Node6(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class Node7
{
	int key;
	int val;
	Node7 next;
	Node7 prev;
	
	public Node7(int key, int val)
	{
		this.key=key;
		this.val=val;
		this.next=null;
		this.prev=null;
	}
}

class TreeNode13 {
	int val;
	TreeNode13 left;
	TreeNode13 right;

	TreeNode13() {
	}

	TreeNode13(int val) {
		this.val = val;
	}

	TreeNode13(int val, TreeNode13 left, TreeNode13 right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

class LRUCache2
{
	int capacity;
	Map<Integer, Node7> map;
	Node7 left;
	Node7 right;
	
	public LRUCache2(int capacity)
	{
		this.capacity=capacity;
		this.map=new HashMap<>();
		this.left=new Node7(0,0);
		this.right=new Node7(0,0);
		this.left.next=this.right;
		this.right.prev=this.left;
	}
	
	public int get(int key)
	{
		if(map.containsKey(key))
		{
			Node7 node=map.get(key);
			remove(node);
			insert(node);
			return node.val;
		}
		
		return -1;
	}
	
	public void put(int key, int val)
	{
		if(map.containsKey(key))
		{
			Node7 node=map.get(key);
			remove(node);
			map.remove(key);
		}
		
		Node7 newNode=new Node7(key,val);
		insert(newNode);
		map.put(key, newNode);
		
		if(map.size()>capacity)
		{
			Node7 lru=left.next;
			remove(lru);
			map.remove(lru.key);
		}
	}
	
	private void remove(Node7 node)
	{
		Node7 nextN=node.next;
		Node7 prevN=node.prev;
		
		prevN.next=nextN;
		nextN.prev=prevN;
	}
	
	private void insert(Node7 node)
	{
		Node7 prevN=right.prev;
		node.prev=prevN;
		prevN.next=node;
		node.next=right;
		right.prev=node;
	}
}

public class Revision10 
{

	public static int minSumSubarray(int[] nums, int w)
	{
		int sum = 0;
		for(int i=0;i<w;i++)
		{
			sum+=nums[i];
		}
		
		int maxSum=sum;
		
		for(int i=1;i<=nums.length-w;i++)
		{
			sum=sum-nums[i-1]+nums[i+w-1];
			
			if(sum>maxSum)
			{
				maxSum=sum;
			}
		}
		
		return maxSum;
	}
	
	public static int maxProfit(int[] prices) 
	{
		int maxProfit=0;
		int l=0;
		for(int r=0;r<prices.length;r++)
		{
			if(prices[r]<prices[l])
			{
				l=r;
			}
			
			int profit=prices[r]-prices[l];
			if(profit>maxProfit)
			{
				maxProfit=profit;
			}
		}
		
		return maxProfit;
	}
	
    public static int minSubArrayLenBruteForce(int target, int[] nums) 
    {
    	int minLen=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++)
        {
        	int sum=0;
        	int len=0;
        	for(int j=i;j<nums.length;j++)
        	{
        		sum+=nums[j];
        		len++;
        		if(sum<target)
        		{
        			continue;
        		}
        		
        		minLen=Math.min(minLen, len);
        		break;
        	}
        }
        
        return minLen;
    }
    
    public static int minSubArrayLen(int target, int[] nums) 
    {
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
    
    public static int lengthOfLongestSubstringBruteForce(String s) 
    {
        Set<Character> set = new HashSet<Character>();
        int maxLen = Integer.MIN_VALUE;
        
        for(int i=0;i<s.length();i++)
        {
        	for(int j=i;j<s.length();j++)
        	{
        		if(set.contains(s.charAt(j)))
        		{
        			int len=set.size();
        			maxLen=Math.max(maxLen, len);
        			set.clear();
        			break;
        		}
        		else
        		{
        			set.add(s.charAt(j));
        		}
        	}
        }
        
        return maxLen==Integer.MIN_VALUE?0:maxLen;
    }
    
    public static int lengthOfLongestSubstring(String s) 
    {
    	Set<Character> set = new HashSet<>();
    	int maxLen=Integer.MIN_VALUE;
    	int l=0;
    	
    	for(int r=0;r<s.length();r++)
    	{
    		while(set.contains(s.charAt(r)))
    		{
    			set.remove(s.charAt(l));
    			l++;
    		}
    		
    		set.add(s.charAt(r));	
    		int len=r-l+1;
    		maxLen=Math.max(maxLen, len);
    	}
    	return maxLen==Integer.MIN_VALUE?0:maxLen;
    }
	
    public static int characterReplacement(String s, int k) 
    {
    	int maxLen=0;
    	int[] count=new int[26];
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
    
    public static boolean checkInclusion(String s1, String s2) 
    {
        if(s1.length()>s2.length()) return false;
        
        Map<Character, Integer> map1=new HashMap<Character, Integer>();
        Map<Character, Integer> map2=new HashMap<Character, Integer>();
        
        for(int i=0;i<s1.length();i++)
        {
        	map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i),0)+1);
        	map2.put(s2.charAt(i), map2.getOrDefault(s2.charAt(i),0)+1);
        }
        
        if(map1.equals(map2)) return true;
        
        int l=0;
        
        for(int r=s1.length();r<s2.length();r++)
        {
        	map2.put(s2.charAt(r), map2.getOrDefault(s2.charAt(r), 0)+1);
        	map2.put(s2.charAt(l), map2.getOrDefault(s2.charAt(l), 0)-1);
        	if(map2.get(s2.charAt(l))==0)
        	{
        		map2.remove(s2.charAt(l));
        	}
        	l++;
        	
        	if(map1.equals(map2)) return true;
        }
        
        return false;
    }
    
    public static ListNode8 reverseList(ListNode8 head) 
    {
        if(head==null)return null;
        
        ListNode8 prev=null;
        ListNode8 cur=head;
        
        while(cur!=null)
        {
        	ListNode8 tmp = cur.next;
        	cur.next=prev;
        	prev=cur;
        	cur=tmp;
        }
        
        return prev;
    }
    
    public static ListNode8 mergeTwoLists(ListNode8 list1, ListNode8 list2) 
    {
    	ListNode8 dummy = new ListNode8(0);
    	ListNode8 cur=dummy;
    	
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
    
    public static boolean hasCycle(ListNode8 head) 
    {
    	ListNode8 slow=head;
    	ListNode8 fast=head;
    	
    	while(fast!=null && fast.next!=null)
    	{
    		slow=slow.next;
    		fast=fast.next.next;
    		
    		if(slow==fast)return true;
    	}
    	
    	return false;
    }
    
    public static void reorderList(ListNode8 head) 
    {
        //Mid point
    	ListNode8 slow=head;
    	ListNode8 fast=head.next;
    	
    	while(fast!=null && fast.next!=null)
    	{
    		slow=slow.next;
    		fast=fast.next.next;
    	}
    	
    	//Split
    	ListNode8 second=slow.next;
    	slow.next=null;
    	ListNode8 prev=null;
    	
    	while(second!=null)
    	{
    		ListNode8 tmp=second.next;
    		second.next=prev;
    		prev=second;
    		second=tmp;
    	}
    	
    	//Merging
    	ListNode8 first=head;
    	second=prev;
    	
    	while(second!=null)
    	{
    		ListNode8 tmp1=first.next;
    		ListNode8 tmp2=second.next;
    		first.next=second;
    		second.next=tmp1;
    		first=tmp1;
    		second=tmp2;
    	}
    }
    
    public static ListNode8 removeNthFromEnd2Pass(ListNode8 head, int n) 
    {
        int len=0;
        ListNode8 cur=head;
        while(cur!=null)
        {
        	len++;
        	cur=cur.next;
        }
        
        int removeIdx=len-n;
        
        if(removeIdx==0)return head.next;
        
        cur=head;
        for(int i=0;i<len;i++)
        {
        	if(i==(removeIdx-1))
        	{
        		cur.next=cur.next.next;
        		break;
        	}
        	cur=cur.next;
        }
        return head;
    }
    
    
    public static ListNode8 removeNthFromEnd(ListNode8 head, int n) 
    {
    	ListNode8 dummy = new ListNode8(0,head);
    	ListNode8 left=dummy;
    	ListNode8 right=head;
    	
    	while(n>0)
    	{
    		right=right.next;
    		n--;
    	}
    	
    	while(right!=null)
    	{
    		right=right.next;
    		left=left.next;
    	}
    	
    	left.next=left.next.next;
    	
    	return head;
    }
    
    public static ListNode8 addTwoNumbers(ListNode8 l1, ListNode8 l2) 
    {
    	ListNode8 dummy = new ListNode8(0);
    	ListNode8 cur=dummy;
    	
    	int carry=0;
    	while(l1!=null || l2!=null || carry!=0)
    	{
    		int val1=l1!=null?l1.val:0;
    		int val2=l2!=null?l2.val:0;
    		
    		int val=val1+val2+carry;
    		carry=val/10;
    		val=val%10;
    		cur.next=new ListNode8(val);
    		
    		cur=cur.next;
    		l1=l1!=null?l1.next:null;
    		l2=l2!=null?l2.next:null;
    	}
    	
    	return dummy.next;
    }
    
    public static int findDuplicate(int[] nums) 
    {
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
    
    public static Node6 copyRandomList(Node6 head) 
    {
        Map<Node6, Node6> map = new HashMap<Node6, Node6>();
        map.put(null, null);
        
        Node6 cur=head;
        while(cur!=null)
        {
        	map.put(cur, new Node6(cur.val));
        	cur=cur.next;
        }
        
        cur=head;
        while(cur!=null)
        {
        	Node6 copy = map.get(cur);
        	
        	copy.next=map.get(cur.next);
        	copy.random=map.get(cur.random);
        	
        	cur=cur.next;
        }
        
        return map.get(head);
    }
    
    public static TreeNode13 invertTreeDfsRecursive(TreeNode13 root) 
    {
        if(root==null)
        {
        	return null;
        }
        
        TreeNode13 node = new TreeNode13(root.val);
        
        node.left=invertTreeDfsRecursive(root.right);
        node.right=invertTreeDfsRecursive(root.left);
        return node;
    }
    
    public static TreeNode13 invertTreeDfsIterative(TreeNode13 root) 
    {
    	if(root==null)
    	{
    		return null;
    	}
    	
    	Stack<TreeNode13> stack=new Stack<>();
    	stack.push(root);
    	
    	while(!stack.isEmpty())
    	{
    		TreeNode13 node=stack.pop();
    		
    		TreeNode13 tmp=node.left;
    		node.left=node.right;
    		node.right=tmp;
    		
    		if(node.left!=null)
    		{
    			stack.push(node.left);
    		}
    		
    		if(node.right!=null)
    		{
    			stack.push(node.right);
    		}
    	}
    	
    	return root;
    }
    
    public static TreeNode13 invertTreeBfs(TreeNode13 root) 
    {
    	if(root==null)
    	{
    		return null;
    	}
    	
    	Queue<TreeNode13> queue=new LinkedList<>();
    	queue.offer(root);
    	
    	while(!queue.isEmpty())
    	{
    		TreeNode13 node=queue.poll();
    		
    		TreeNode13 tmp=node.left;
    		node.left=node.right;
    		node.right=tmp;
    		
    		if(node.left!=null)
    		{
    			queue.offer(node.left);
    		}
    		
    		if(node.right!=null)
    		{
    			queue.offer(node.right);
    		}
    	}
    	
    	return root;
    }
    
    public static int maxDepthDfsRecursive(TreeNode13 root) 
    {
        if(root==null)
        {
        	return 0;
        }
        
        return 1+(Math.max(maxDepthDfsRecursive(root.left), maxDepthDfsRecursive(root.right)));
    }
    
    public static int maxDepthBfs(TreeNode13 root) 
    {
    	if(root==null)
    	{
    		return 0;
    	}
    	
    	Queue<TreeNode13> q=new LinkedList<TreeNode13>();
    	q.offer(root);
    	
    	int level=0;
    	while(!q.isEmpty())
    	{
    		int size=q.size();
    		
    		for(int i=0;i<size;i++)
    		{
    			TreeNode13 node=q.poll();
    			
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
    
    public static int diameterOfBinaryTree(TreeNode13 root) 
    {
        int[] res= new int[1];
        dfsHelper(root, res);
        return res[0];
    }
    
    private static int dfsHelper(TreeNode13 node, int[] res)
    {
    	if(node==null)return 0;
    	
    	int left=dfsHelper(node.left, res);
    	int right=dfsHelper(node.right, res);
    	res[0]=Math.max(res[0], left+right);
    	return 1+Math.max(left, right);
    }
    
    public static boolean isBalanced(TreeNode13 root) 
    {
        return dfs(root)[0]==1;
    }
    
    private static int[] dfs(TreeNode13 node)
    {
    	if(node==null)
    	{
    		return new int[] {1,0};
    	}
    	
    	int[]left=dfs(node.left);
    	int[]right=dfs(node.right);
    	
    	boolean isBalanced = (left[0]==1 && right[0]==1) && ((Math.abs(left[1]-right[1])<=1));
    	
    	int height = 1 + Math.max(left[1], right[1]);
    	
    	return new int[] {isBalanced?1:0,height};
    }
    
    public static boolean isSameTreeDfs(TreeNode13 p, TreeNode13 q) 
    {
        if(p==null && q==null)
        {
        	return true;
        }
        
        if(p!=null && q!=null && p.val==q.val)
        {
        	return isSameTreeDfs(p.left, q.left) && isSameTreeDfs(p.right, q.right);
        }
        else
        {
        	return false;
        }
    }
    
    public static boolean isSameTreeBfs(TreeNode13 p, TreeNode13 q) 
    {
    	Queue<TreeNode13> q1= new LinkedList<>();
    	Queue<TreeNode13> q2= new LinkedList<>();
    	q1.offer(p);
    	q2.offer(q);
    	
    	while(!q1.isEmpty() && !q2.isEmpty())
    	{
    		for(int i=0;i<q1.size();i++)
    		{
    			TreeNode13 pNode=q1.poll();
    			TreeNode13 qNode=q2.poll();
    			
    			if(pNode==null && qNode==null) continue;
    			
    			if(pNode==null || qNode==null || pNode.val!=qNode.val)
    			{
    				return false;
    			}
    			
    			q1.offer(pNode.left);
    			q1.offer(pNode.right);
    			q2.offer(qNode.left);
    			q2.offer(qNode.right);
    		}
    	}
    	return true;
    }
    
    public static boolean isSubtree(TreeNode13 root, TreeNode13 subRoot) 
    {
        if(root==null)return false;
        if(subRoot==null)return true;
        
        if(isSameTree(root,subRoot)) return true;
        
        return isSameTree(root.left,subRoot) || isSameTree(root.right,subRoot);
    }
    
    private static boolean isSameTree(TreeNode13 node1, TreeNode13 node2)
    {
    	if(node1==null && node2==null)return true;
    	
    	if(node1!=null && node2!=null && node1.val==node2.val)
    	{
    		return isSameTree(node1.left, node2.left) && isSameTree(node1.right, node2.right);
    	}
    	
    	return false;
    }
    
    public static TreeNode13 lowestCommonAncestor(TreeNode13 root, TreeNode13 p, TreeNode13 q) 
    {
    	TreeNode13 cur=root;
    	
    	while(cur!=null)
    	{
    		if(p.val>cur.val && q.val>cur.val)
    		{
    			cur=cur.right;
    		}
    		else if(p.val<cur.val && q.val<cur.val)
    		{
    			cur=cur.left;
    		}
    		else
    		{
    			return cur;
    		}
    	}
    	
    	return null;
    }
    
    
    public static List<List<Integer>> levelOrder(TreeNode13 root) 
    {
        List<List<Integer>> res = new ArrayList<>();
        
        Queue<TreeNode13> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty())
        {
        	int size=q.size();
        	List<Integer> list = new ArrayList<>();
        	
        	for(int i=0;i<size;i++)
        	{
        		TreeNode13 node=q.poll();
        		
        		if(node!=null)
        		{
        			list.add(node.val);
        			q.offer(node.left);
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
    
    public static List<Integer> rightSideView(TreeNode13 root) 
    {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode13> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty())
        {
        	int size=q.size();
        	TreeNode13 rightNode=null;
        	
        	for(int i=0;i<size;i++)
        	{
        		TreeNode13 node = q.poll();
        		
        		if(node!=null)
        		{
        			rightNode=node;
        			q.offer(node.left);
        			q.offer(node.right);
        		}
        	}
        	
        	if(rightNode!=null)
        	{
        		res.add(rightNode.val);
        	}
        }
        
        return res;
    }
    
    public static int goodNodes(TreeNode13 root) 
    {
        return goodNodesHelper(root, root.val);
    }
    
    private static int goodNodesHelper(TreeNode13 node, int maxVal)
    {
    	if(node==null)
    	{
    		return 0;
    	}
    	
    	int res = node.val>=maxVal?1:0;
    	maxVal=Math.max(maxVal, node.val);
    	res+=goodNodesHelper(node.left, maxVal);
    	res+=goodNodesHelper(node.right, maxVal);
    	return res;
    }
    
    public static boolean isValidBST(TreeNode13 root) 
    {
        return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private static boolean isValidBSTHelper(TreeNode13 node, long left, long right)
    {
    	if(node==null)return true;
    	
    	if(!(node.val>left && node.val<right))return false;
    	
    	return isValidBSTHelper(node.left, left, node.val) && isValidBSTHelper(node.right, node.val, right);
    }
    
    public static int kthSmallest(TreeNode13 root, int k) 
    {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        return list.get(k-1);
    }
    
    private static void inOrder(TreeNode13 node, List<Integer> list)
    {
    	if(node==null)return;
    	
    	inOrder(node.left, list);
    	list.add(node.val);
    	inOrder(node.right, list);
    }
    
    static int preorder_idx=0;
    static Map<Integer,Integer> inorderMap=new HashMap<>();
    
    public static TreeNode13 buildTree(int[] preorder, int[] inorder) 
    {   
        for(int i=0;i<inorder.length;i++)
        {
        	inorderMap.put(inorder[i], i);
        }
        
        return buildTreeHelper(preorder, 0, inorder.length-1);
    }
    
    public static TreeNode13 buildTreeHelper(int[] preorder, int left, int right)
    {
    	if(left>right)return null;
    	
    	int root_val = preorder[preorder_idx];
    	TreeNode13 root=new TreeNode13(root_val);
    	preorder_idx++;
    	
    	int mid=inorderMap.get(root_val);
    	root.left=buildTreeHelper(preorder, left, mid-1);
    	root.right=buildTreeHelper(preorder, mid+1, right);
    	return root;
    }
    
	public static void main(String args[])
	{
//		int[] nums = {3,8,2,5,7,6,12};
//		int w=4;
//		System.out.println(minSumSubarray(nums, w));
				
//		int[] prices = {7,1,5,3,6,4};
//		System.out.println(maxProfit(prices));
		
//		int target = 7;
//		int[] nums = {2,3,1,2,4,3};
//		System.out.println(minSubArrayLen(target, nums));
		
//		String s="pwwkew";
//		System.out.println(lengthOfLongestSubstring(s));
		
//		String s = "AABABBA";
//		int k = 1;
//		System.out.println(characterReplacement(s, k));
		
//		String s1 = "ab";
//		String s2 = "eidboaoo";
//		System.out.println(checkInclusion(s1, s2));
		
//		ListNode8 n2 = new ListNode8(2);
//		ListNode8 n4 = new ListNode8(4);
//		ListNode8 n3 = new ListNode8(3);
//
//		ListNode8 n5_1 = new ListNode8(5);
//		ListNode8 n6_1 = new ListNode8(6);
//		ListNode8 n4_1 = new ListNode8(4);
//		
//		n2.next=n4;
//		n4.next=n3;
//		
//		n5_1.next=n6_1;
//		n6_1.next=n4_1;
		
		
//		System.out.println("BEFORE:");
//		ListNode8 cur=n1;
//		while(cur!=null)
//		{
//			System.out.println(cur.val);
//			cur=cur.next;
//		}		
		
//		reorderList(n1);
//		System.out.println("AFTER:");
		
//		ListNode8 res = addTwoNumbers(n2, n5_1);
//		while(res!=null)
//		{
//			System.out.println(res.val);
//			res=res.next;
//		}
		
//		int[] nums = {3,3,3,3,3};
//		System.out.println(findDuplicate(nums));
		
//		Node6 n7 = new Node6(7);
//		Node6 n13 = new Node6(13);
//		Node6 n11 = new Node6(11);
//		Node6 n10 = new Node6(10);
//		Node6 n1 = new Node6(1);
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
//		
//		System.out.println("Original List:");
//		Node6 cur=n7;
//		while(cur!=null)
//		{
//			String nodeVal=String.valueOf(cur.val);
//			String next=cur.next!=null?String.valueOf(cur.next.val):null;
//			String random=cur.random!=null?String.valueOf(cur.random.val):null;
//			
//			System.out.println("Node>>"+nodeVal+"|Next>>"+next+"|Random>>"+random);
//			cur=cur.next;
//		}
//		
//		System.out.println("Deep Copy List:");
//		cur = copyRandomList(n7);
//		while(cur!=null)
//		{
//			String nodeVal=String.valueOf(cur.val);
//			String next=cur.next!=null?String.valueOf(cur.next.val):null;
//			String random=cur.random!=null?String.valueOf(cur.random.val):null;
//			
//			System.out.println("Node>>"+nodeVal+"|Next>>"+next+"|Random>>"+random);
//			cur=cur.next;
//		}
		
		
//		LRUCache2 lRUCache = new LRUCache2(2);
//		lRUCache.put(1, 1); // cache is {1=1}
//		lRUCache.put(2, 2); // cache is {1=1, 2=2}
//		System.out.println(lRUCache.get(1));    // return 1
//		lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
//		System.out.println(lRUCache.get(2));    // returns -1 (not found)
//		lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
//		System.out.println(lRUCache.get(1));   // return -1 (not found)
//		System.out.println(lRUCache.get(3));    // return 3
//		System.out.println(lRUCache.get(4));    // return 4
		
		

//		TreeNode13 n3 = new TreeNode13(3);
//		TreeNode13 n9 = new TreeNode13(9);
//		TreeNode13 n20 = new TreeNode13(20);
//		TreeNode13 n15 = new TreeNode13(15);
//		TreeNode13 n7 = new TreeNode13(7);
//		
//		n3.left=n9;
//		n3.right=n20;
//		
//		n20.left=n15;
//		n20.right=n7;
		
		int[] preorder = {3,9,20,15,7};
		int[] inorder = {9,3,15,20,7};
		
		TreeNode13 root=buildTree(preorder, inorder);
		
		traverse(root, "INORDER");
		
//		System.out.println("BEFORE:");
//		traverse(n4, "PREORDER");
//		
//		System.out.println("AFTER:");
//		TreeNode13 n4_op = invertTreeDfsRecursive(n4);
//		
//		traverse(n4_op, "PREORDER");
	}
	
	public static void traverse(TreeNode13 node, String traversalType)
	{
		if(node!=null)
		{
			if(traversalType.equals("INORDER"))
			{
				traverse(node.left, traversalType);
				System.out.println(node.val);
				traverse(node.right, traversalType);
			}
			else if(traversalType.equals("PREORDER"))
			{
				System.out.println(node.val);
				traverse(node.left, traversalType);
				traverse(node.right, traversalType);
			}
			else
			{
				traverse(node.left, traversalType);
				traverse(node.right, traversalType);
				System.out.println(node.val);
			}
		}
	}
}
