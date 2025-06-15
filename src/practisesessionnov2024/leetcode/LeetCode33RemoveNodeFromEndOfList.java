package practisesessionnov2024.leetcode;

import java.util.ArrayList;
import java.util.List;

class ListNode6 {
	int val;
	ListNode6 next;

	ListNode6() {
	}

	ListNode6(int val) {
		this.val = val;
	}

	ListNode6(int val, ListNode6 next) {
		this.val = val;
		this.next = next;
	}
}

public class LeetCode33RemoveNodeFromEndOfList {

    public static ListNode6 removeNthFromEndBruteForce(ListNode6 head, int n)
    {
    	List<ListNode6> list = new ArrayList<ListNode6>();
    	
    	ListNode6 node=head;
    	while(node!=null)
    	{
    		list.add(node);
    		node=node.next;
    	}
    	
    	int idx=list.size()-n;
    	
    	if(idx==0)
    	{
    		return head.next;
    	}
    	
    	list.get(idx-1).next=list.get(idx).next;
    	
    	return head;
    }
    
    public static ListNode6 removeNthFromEndTwoPass(ListNode6 head, int n)
    {
    	int len=0;
    	ListNode6 node=head;
    	while(node!=null)
    	{
    		len++;
    		node=node.next;
    	}
    	
    	int removeIdx=len-n;
    	
    	if(removeIdx==0)
    	{
    		return head.next;
    	}
    	
    	ListNode6 curr=head;
    	for(int i=0; i<len; i++)
    	{
    		if(i==removeIdx-1)
    		{
    			curr.next=curr.next.next;
    			break;
    		}
    		curr = curr.next;
    	}
    	
    	return head;
    }
    
    public static ListNode6 removeNthFromEndOnePass(ListNode6 head, int n)
    {
    	ListNode6 dummy=new ListNode6(0,head);
    	ListNode6 left=dummy;
    	ListNode6 right=head;
    	
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
    	return dummy.next;
    }
    
	public static void main(String args[])
	{
		ListNode6 ln4 = new ListNode6(4);
		ListNode6 ln3 = new ListNode6(3,ln4);
		ListNode6 ln2 = new ListNode6(2,ln3);
		ListNode6 ln1 = new ListNode6(1,ln2);
		
		System.out.println("BEFORE:");
		
		ListNode6 curr=ln1;
		while(curr!=null)
		{
			System.out.println(curr.val);
			curr=curr.next;
		}
		
		System.out.println("AFTER:");
		
		int n=2;
		ListNode6 node = removeNthFromEndOnePass(ln1, n);
		ListNode6 curr1=node;
		while(curr1!=null)
		{
			System.out.println(curr1.val);
			curr1=curr1.next;
		}
		
	}
}
