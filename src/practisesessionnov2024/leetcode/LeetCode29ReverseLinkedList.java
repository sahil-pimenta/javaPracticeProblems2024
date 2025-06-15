package practisesessionnov2024.leetcode;

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

public class LeetCode29ReverseLinkedList {

    public static ListNode reverseList(ListNode head) {
    	ListNode prev = null;
    	ListNode curr = head;
    	
    	while(curr!=null)
    	{
    		ListNode temp=curr.next;
    		curr.next=prev;
    		prev=curr;
    		curr=temp;
    	}
    	return prev;
    }
    
    public static ListNode reverseListRecursive(ListNode head) 
    {
        if (head == null) {
            return null;
        }

        ListNode newHead = head;
        if (head.next != null) {
            newHead = reverseListRecursive(head.next);
            head.next.next = head;
        }
        head.next = null;

        return newHead;
    }
    
	public static void main(String args[])
	{
		ListNode ln4 = new ListNode(4);
		ListNode ln3 = new ListNode(3,ln4);
		ListNode ln2 = new ListNode(2,ln3);
		ListNode ln1 = new ListNode(1,ln2);
		
		System.out.println("Before-");
		ListNode temp=ln1;
		while(temp!=null)
		{
			System.out.println("Current:"+temp.val);
			temp=temp.next;
		}
		
		System.out.println("After-");
		ListNode reversedList = reverseListRecursive(ln1);
		
		ListNode temp2=reversedList;
		while(temp2!=null)
		{
			System.out.println("Current:"+temp2.val);
			temp2=temp2.next;
		}
	}
	
}
