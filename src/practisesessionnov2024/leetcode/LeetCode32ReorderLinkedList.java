package practisesessionnov2024.leetcode;

import java.util.ArrayList;
import java.util.List;

class ListNode5 {
	int val;
	ListNode5 next;

	ListNode5() {
	}

	ListNode5(int val) {
		this.val = val;
	}

	ListNode5(int val, ListNode5 next) {
		this.val = val;
		this.next = next;
	}
}

public class LeetCode32ReorderLinkedList {

    public static void reorderListBruteForce(ListNode5 head) 
    {
        List<ListNode5> list = new ArrayList<>();
        
        ListNode5 node=head;
        while(node!=null)
        {
        	list.add(node);
        	node=node.next;
        }
        
        int i=0,j=list.size()-1;
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
    
    public static void reorderList(ListNode5 head) 
    {
    	//Use slow and faster pointer to find middle of a list
    	ListNode5 slow=head;
    	ListNode5 fast=head.next;
    	
    	while(fast!=null && fast.next!=null)
    	{
    		slow=slow.next;
    		fast=fast.next.next;
    	}
    	
    	//Reverse the 2nd half of the list
    	ListNode5 second=slow.next;
    	slow.next=null;
    	ListNode5 prev=null;
    	
    	while(second!=null)
    	{
    		ListNode5 temp=second.next;
    		second.next=prev;
    		prev=second;
    		second=temp;
    	}
    	
    	//Merge 1st half & 2nd half(reversed) list to get output
    	ListNode5 first=head;
    	second=prev;
    	
    	while(second!=null)
    	{
    		ListNode5 temp1=first.next;
    		ListNode5 temp2=second.next;
    		first.next=second;
    		second.next=temp1;
    		first=temp1;
    		second=temp2;
    	}
    }
	
	public static void main(String args[])
	{
		ListNode5 ln5= new ListNode5(5,null);
		ListNode5 ln4 = new ListNode5(4,ln5);
		ListNode5 ln3 = new ListNode5(3,ln4);
		ListNode5 ln2 = new ListNode5(2,ln3);
		ListNode5 ln1 = new ListNode5(1,ln2);
		
		System.out.println("BEFORE:");
		
		ListNode5 curr=ln1;
		while(curr!=null)
		{
			System.out.println(curr.val);
			curr=curr.next;
		}
		
		reorderList(ln1);
		
		System.out.println("AFTER:");
		
		ListNode5 curr1=ln1;
		while(curr1!=null)
		{
			System.out.println(curr1.val);
			curr1=curr1.next;
		}
	}
}
