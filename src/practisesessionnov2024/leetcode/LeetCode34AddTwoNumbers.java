package practisesessionnov2024.leetcode;

class ListNode7 {
	int val;
	ListNode7 next;

	ListNode7() {
	}

	ListNode7(int val) {
		this.val = val;
	}

	ListNode7(int val, ListNode7 next) {
		this.val = val;
		this.next = next;
	}
}

public class LeetCode34AddTwoNumbers {
	
    public static ListNode7 addTwoNumbers(ListNode7 l1, ListNode7 l2) 
    {
    	ListNode7 dummy = new ListNode7(0);
    	ListNode7 curr=dummy;
    	
    	int carry=0;
    	while(l1!=null || l2!=null || carry!=0)
    	{
    		int val1=(l1!=null)?l1.val:0;
    		int val2=(l2!=null)?l2.val:0;
    		
    		int val=val1+val2+carry;
    		carry=val/10;
    		val=val%10;
    		curr.next=new ListNode7(val);
    		
    		curr=curr.next;
    		l1=(l1!=null)?l1.next:null;
    		l2=(l2!=null)?l2.next:null;
    	}
    	
    	return dummy.next;
    }
    
	public static void main(String args[])
	{
		ListNode7 list1n3 = new ListNode7(3);
		ListNode7 list1n2 = new ListNode7(4,list1n3);
		ListNode7 list1n1 = new ListNode7(2,list1n2);
		
		ListNode7 list2n3 = new ListNode7(4);
		ListNode7 list2n2 = new ListNode7(6,list2n3);
		ListNode7 list2n1 = new ListNode7(5,list2n2);
		
		ListNode7 node=addTwoNumbers(list1n1, list2n1);
		while(node!=null)
		{
			System.out.println(node.val);
			node=node.next;
		}
	}
}
