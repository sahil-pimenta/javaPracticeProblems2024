package practisesessionnov2024.leetcode;

class ListNode3
{
	int val;
	ListNode3 next;
	ListNode3() {}
	ListNode3(int val) { this.val = val; }
	ListNode3(int val, ListNode3 next) { this.val = val; this.next = next; }
}

public class Revision8 {

    public static ListNode3 reverseList(ListNode3 head) 
    {
    	ListNode3 prev=null;
    	ListNode3 curr=head;
    	
    	while(curr!=null)
    	{
    		ListNode3 temp = curr.next;
    		curr.next=prev;
    		prev=curr;
    		curr=temp;
    	}
    	return prev;
    }
    
    public static ListNode3 reverseListRecursive(ListNode3 head) 
    {
    	if(head==null)
    	{
    		return null;
    	}
    	
    	ListNode3 newHead=head;
    	if(head.next!=null)
    	{
    		newHead=reverseListRecursive(head.next);
    		head.next.next=head;
    	}
    	head.next=null;
    	
    	return newHead;
    }
    
    public static ListNode3 mergeTwoLists(ListNode3 list1, ListNode3 list2) 
    {
    	ListNode3 dummy = new ListNode3(0);
    	ListNode3 node=dummy;
        
    	while(list1!=null && list2!=null) 
    	{
    		if(list1.val < list2.val)
    		{
    			node.next=list1;
    			list1=list1.next;
    		}
    		else
    		{
    			node.next=list2;
    			list2=list2.next;
    		}
    		node=node.next;
    	}
    	
    	if(list1!=null)
    	{
    		node.next=list1;
    	}
    	else
    	{
    		node.next=list2;
    	}
    	
    	return dummy.next;
    }
	
	public static void main(String args[])
	{
		ListNode3 ln4=new ListNode3(4);
		ListNode3 ln3=new ListNode3(3,ln4);
		ListNode3 ln2=new ListNode3(2,ln3);
		ListNode3 ln1=new ListNode3(1,ln2);
		
		ListNode3 l2n7=new ListNode3(7);
		ListNode3 l2n6=new ListNode3(6,l2n7);
		ListNode3 l2n5=new ListNode3(5,l2n6);
		ListNode3 l2n1=new ListNode3(1,l2n5);
		
//		System.out.println("BEFORE:");
//		ListNode3 curr=ln1;
//		while(curr!=null)
//		{
//			System.out.println(curr.val);
//			curr=curr.next;
//		}
//		
//		System.out.println("AFTER:");
//		ListNode3 reverse = reverseList(ln1);
//		ListNode3 curr2=reverse;
//		while(curr2!=null)
//		{
//			System.out.println(curr2.val);
//			curr2=curr2.next;
//		}
		
		System.out.println("AFTER:");
		ListNode3 merged = mergeTwoLists(ln1, l2n1);
		ListNode3 curr2=merged;
		while(curr2!=null)
		{
			System.out.println(curr2.val);
			curr2=curr2.next;
		}
	}
}
