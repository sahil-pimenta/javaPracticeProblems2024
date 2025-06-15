package practisesessionnov2024.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class ListNode1
{
	int val;
	ListNode1 next;
	
	ListNode1(){};
	
	ListNode1(int val)
	{
		this.val=val;
	}
	
	ListNode1(int val, ListNode1 next)
	{
		this.val=val;
		this.next=next;
	}
}

class Node4
{
    int val;
    Node4 next;
    Node4 random;

    public Node4(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class Node5
{
	int key;
    int val;
    Node5 next;
    Node5 prev;
    
    Node5(int key, int val)
    {
    	this.key=key;
    	this.val=val;
    	this.next=null;
    	this.prev=null;
    }
}

class LRUCache1 
{
	int capacity;
	Map<Integer, Node5> map;
	Node5 left;
	Node5 right;
	
    public LRUCache1(int capacity) {
        this.capacity=capacity;
        this.map=new HashMap<>();
        this.left=new Node5(0,0);
        this.right=new Node5(0,0);
        this.left.next=this.right;
        this.right.prev=this.left;
    }
    
    private void remove(Node5 node)
    {
    	Node5 next_n=node.next;
    	Node5 prev_n=node.prev;
    	prev_n.next=next_n;
    	next_n.prev=prev_n;
    }
    
    private void insert(Node5 node)
    {
    	Node5 prev_n=right.prev;
    	prev_n.next=node;
    	node.next=right;
    	right.prev=node;
    	node.prev=prev_n;
    }
    
    public int get(int key) {
        if(map.containsKey(key))
        {
        	Node5 node=map.get(key);
        	remove(node);
        	insert(node);
        	return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key))
        {
        	Node5 node=map.get(key);
        	remove(node);
        	map.remove(key);
        }
        
        Node5 newNode = new Node5(key, value);
        map.put(key, newNode);
        insert(newNode);
        
        if(map.size()>capacity)
        {
        	Node5 lru=this.left.next;
        	remove(lru);
        	map.remove(lru.key);
        }
    }
}

public class Revision9 {

    public static ListNode1 reverseListRecursive(ListNode1 head) 
    {
        if(head==null)
        {
        	return null;
        }
        
        ListNode1 newHead=head;
        if(head.next!=null)
        {
        	newHead=reverseListRecursive(head.next);
        	head.next.next=head;
        }
        head.next=null;
        return newHead;
    }
    
    public static ListNode1 reverseList(ListNode1 head) 
    {
        ListNode1 curr=head;
        ListNode1 prev=null;
        
        while(curr!=null)
        {
        	ListNode1 tmp=curr.next;
        	curr.next=prev;
        	prev=curr;
        	curr=tmp;
        }
        
        return prev;
    }
    
    public static ListNode1 mergeTwoLists(ListNode1 list1, ListNode1 list2) 
    {
    	ListNode1 dummy=new ListNode1(0);
    	ListNode1 curr=dummy;
    	
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
    	
    	if(list1!=null)
    	{
    		curr.next=list1;
    	}
    	else
    	{
    		curr.next=list2;
    	}
    	
    	return dummy.next;
    }
    
    public static boolean hasCycleSet(ListNode1 head) 
    {
        Set<ListNode1> set = new HashSet<ListNode1>();
        
        ListNode1 curr=head;
        while(curr!=null)
        {
        	if(set.contains(curr))
        	{
        		return true;
        	}
        	set.add(curr);
        	curr=curr.next;
        }
        
        return false;
    }
    
    public static boolean hasCycle(ListNode1 head) 
    {
    	ListNode1 slow=head;
    	ListNode1 fast=head;
    	
    	while(fast!=null && fast.next!=null)
    	{
    		slow=slow.next;
    		fast=fast.next.next;
    		if(fast==slow)return true;
    	}
    	return false;
    }
    
    public static void reorderListBruteForce(ListNode1 head) 
    {
        List<ListNode1> list = new ArrayList<ListNode1>();
        
        ListNode1 curr=head;
        while(curr!=null)
        {
        	list.add(curr);
        	curr=curr.next;
        }
        
        int i=0, j=list.size()-1;
        while(i<j)
        {
        	list.get(i).next=list.get(j);
        	i++;
        	if(i>=j)
        	{
        		break;
        	}
        	list.get(j).next=list.get(i);
        	j--;
        }
        
        list.get(i).next=null;
    }
    
    public static void reorderList(ListNode1 head) 
    {
    	//Split
    	ListNode1 slow=head;
    	ListNode1 fast=head.next;
    	while(fast!=null && fast.next!=null)
    	{
    		slow=slow.next;
    		fast=fast.next.next;
    	}
    	
    	//Reverse
    	ListNode1 second=slow.next;
    	slow.next=null;
    	ListNode1 prev=null;
    	while(second!=null)
    	{
    		ListNode1 tmp=second.next;
    		second.next=prev;
    		prev=second;
    		second=tmp;
    	}
    	
    	//Merge
    	ListNode1 first=head;
    	second=prev;
    	while(second!=null)
    	{
    		ListNode1 tmp1=first.next;
    		ListNode1 tmp2=second.next;
    		first.next=second;
    		second.next=tmp1;
    		first=tmp1;
    		second=tmp2;
    	}
    }
    
    public static ListNode1 removeNthFromEndBruteForce(ListNode1 head, int n) 
    {
        List<ListNode1> list = new ArrayList<>();
        
        ListNode1 curr=head;
        while(curr!=null)
        {
        	list.add(curr);
        	curr=curr.next;
        }
        
        int removeIdx=list.size()-n;
        
        if(removeIdx==0)
        {
        	return head.next;
        }
        
        list.get(removeIdx-1).next=list.get(removeIdx).next;
        
        return head;
    }
    
    public static ListNode1 removeNthFromEndTwoPass(ListNode1 head, int n) 
    {
        int len=0;
        
        ListNode1 curr=head;
        while(curr!=null)
        {
        	len++;
        	curr=curr.next;
        }
        
        int removeIdx=len-n;
        if(removeIdx==0)
        {
        	return head.next;
        }
        
        curr=head;
        for(int i=0;i<len;i++)
        {
        	if(i==(removeIdx-1))
        	{
        		curr.next=curr.next.next;
        		break;
        	}
        	curr=curr.next;
        }
        return head;
    }
    
    public static ListNode1 removeNthFromEndOnePass(ListNode1 head, int n) 
    {
        ListNode1 dummy = new ListNode1(0, head);
        
        ListNode1 left=dummy;
        ListNode1 right=head;
        
        while(n!=0)
        {
        	right=right.next;
        	n--;
        }
        
        while(right!=null)
        {
        	left=left.next;
        	right=right.next;
        }
        
        left.next=left.next.next;
        
        return dummy.next;
    }
    
    public static ListNode1 addTwoNumbers(ListNode1 l1, ListNode1 l2) 
    {
    	ListNode1 dummy=new ListNode1();
    	ListNode1 curr=dummy;
    	
    	int carry=0;
    	while(l1!=null || l2!=null || carry!=0)
    	{
    		int val1=l1!=null?l1.val:0;
    		int val2=l2!=null?l2.val:0;
    		
    		int val=val1+val2+carry;
    		carry=val/10;
    		val=val%10;
    		curr.next=new ListNode1(val);
    		
    		curr=curr.next;
    		l1=l1!=null?l1.next:null;
    		l2=l2!=null?l2.next:null;
    	}
    	
    	return dummy.next;
    }
    
    public static int findDuplicate(int[] nums) 
    {
        int slow = 0;
        int fast = 0;
        
        while(true)
        {
        	slow=nums[slow];
        	fast=nums[nums[fast]];
        	if(slow==fast)break;
        }
        
        int slow2=0;
        while(true)
        {
        	slow2=nums[slow2];
        	slow=nums[slow];
        	if(slow==slow2)
        	{
        		return slow;
        	}
        }

    }

    public static Node4 copyRandomList(Node4 head) 
    {
        Map<Node4, Node4> map=new HashMap<Node4, Node4>();
        
        map.put(null, null);
        
        Node4 node=head;
        while(node!=null)
        {
        	map.put(node, new Node4(node.val));
        	node=node.next;
        }
        
        node=head;
        while(node!=null)
        {
        	Node4 copy=map.get(node);
        	
        	copy.next=map.get(node.next);
        	copy.random=map.get(node.random);
        	
        	node=node.next;
        }
        
        return map.get(head);
    }
    
	public static void main(String args[])
	{
		ListNode1 ln3 = new ListNode1(3);
		ListNode1 ln2 = new ListNode1(4, ln3);
		ListNode1 ln1 = new ListNode1(2, ln2);
		
		
//		ListNode1 l2n3 = new ListNode1(4);
//		ListNode1 l2n2 = new ListNode1(6, l2n3);
//		ListNode1 l2n1 = new ListNode1(5, l2n2);
		
//		System.out.println("Before");
//		
//		ListNode1 curr=ln1;
//		while(curr!=null)
//		{
//			System.out.println(curr.val);
//			curr=curr.next;
//		}
		
//		System.out.println("After");
//		
//		ListNode1 curr=addTwoNumbers(ln1, l2n1);
//		while(curr!=null)
//		{
//			System.out.println(curr.val);
//			curr=curr.next;
//		}
		
//		int[] nums = {1,3,4,2,2};
//		System.out.println(findDuplicate(nums));
		
//		Node4 n1=new Node4(7);
//		Node4 n2=new Node4(13);
//		Node4 n3=new Node4(11);
//		Node4 n4=new Node4(10);
//		Node4 n5=new Node4(1);
//		
//		n1.next=n2;
//		n2.next=n3;
//		n3.next=n4;
//		n4.next=n5;
//		
//		n1.random=null;
//		n2.random=n1;
//		n3.random=n5;
//		n4.random=n3;
//		n5.random=n1;
//		
//		System.out.println("BEFORE:");
//		Node4 node=n1;
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
//		System.out.println("AFTER:");
//		Node4 op=copyRandomList(n1);
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
		
		LRUCache1 lRUCache = new LRUCache1(2);
		lRUCache.put(1, 1); // cache is {1=1}
		lRUCache.put(2, 2); // cache is {1=1, 2=2}
		System.out.println(lRUCache.get(1));    // return 1
		lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
		System.out.println(lRUCache.get(2));    // returns -1 (not found)
		lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
		System.out.println(lRUCache.get(1));    // return -1 (not found)
		System.out.println(lRUCache.get(3));    // return 3
		System.out.println(lRUCache.get(4));    // return 4
		
	}
}
