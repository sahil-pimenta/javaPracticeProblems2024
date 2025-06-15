package practisesessionnov2024.leetcode;

class ListNode2 {
	int val;
	ListNode2 next;

	ListNode2() {
	}

	ListNode2(int val) {
		this.val = val;
	}

	ListNode2(int val, ListNode2 next) {
		this.val = val;
		this.next = next;
	}
}

public class LeetCode30MergeTwoSortedLinkedLists {

    public static ListNode2 mergeTwoLists(ListNode2 list1, ListNode2 list2) {
    	ListNode2 dummy = new ListNode2(0);
    	ListNode2 head = dummy;
    	
    	while(list1!=null && list2!=null)
    	{
    		if(list1.val < list2.val)
    		{
    			head.next = list1;
    			list1=list1.next;
    		}
    		else
    		{
    			head.next = list2;
    			list2=list2.next;
    		}
    		head=head.next;
    	}
    	
    	if(list1!=null)
    	{
    		head.next=list1;
    	}
    	else
    	{
    		head.next=list2;
    	}
    	
    	return dummy.next;
    }
    
    public static void main(String args[])
    {
    	ListNode2 ln1_4 = new ListNode2(4);
    	ListNode2 ln1_2 = new ListNode2(2, ln1_4);
    	ListNode2 ln1_1 = new ListNode2(1, ln1_2);
    	
    	ListNode2 ln2_5 = new ListNode2(5);
    	ListNode2 ln2_3 = new ListNode2(3, ln2_5);
    	ListNode2 ln2_1 = new ListNode2(1, ln2_3);
    	
    	ListNode2 sorted_head = mergeTwoLists(ln1_1, ln2_1);
    	
    	ListNode2 head = sorted_head;
    	while(head!=null)
    	{
    		System.out.println(head.val);
    		head = head.next;
    	}
    }
}
