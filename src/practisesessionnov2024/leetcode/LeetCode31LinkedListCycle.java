package practisesessionnov2024.leetcode;

import java.util.HashSet;
import java.util.Set;

class ListNode4 {
	int val;
	ListNode4 next;

	ListNode4() {
	}

	ListNode4(int val) {
		this.val = val;
	}

	ListNode4(int val, ListNode4 next) {
		this.val = val;
		this.next = next;
	}
}

public class LeetCode31LinkedListCycle {

	public static boolean hasCycleSet(ListNode4 head)
	{
		Set<ListNode4> set = new HashSet<>();
		
		ListNode4 curr=head;
		
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
	
	public static boolean hasCycle(ListNode4 head)
	{
		ListNode4 fast = head;
		ListNode4 slow = head;
		
		while(fast!=null && fast.next!=null)
		{
			fast=fast.next.next;
			slow=slow.next;
			if(fast==slow)return true;
		}
		
		return false;
	}
	
	public static void main(String args[])
	{
		ListNode4 ln4 = new ListNode4(4);
		ListNode4 ln3 = new ListNode4(3,ln4);
		ListNode4 ln2 = new ListNode4(2,ln3);
		ListNode4 ln1 = new ListNode4(1,ln2);
		//ln4.next=ln2;
		
		ListNode4 curr=ln1;
		int count=0;
		while(curr!=null)
		{
			System.out.println(curr.val);
			count++;
			curr=curr.next;
			if(count==20)
			{
				curr=null;
			}
		}
		
		System.out.println(hasCycle(ln1));
		
	}
}
