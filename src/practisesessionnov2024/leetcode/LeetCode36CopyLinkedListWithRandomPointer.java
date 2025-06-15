package practisesessionnov2024.leetcode;

import java.util.HashMap;
import java.util.Map;

class Node2 {
    int val;
    Node2 next;
    Node2 random;

    public Node2(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class LeetCode36CopyLinkedListWithRandomPointer {

    public static Node2 copyRandomList(Node2 head) 
    {
        Map<Node2, Node2> copyMap = new HashMap<Node2, Node2>();
        copyMap.put(null, null);
        
        Node2 curr=head;
        while(curr!=null)
        {
        	Node2 copy = new Node2(curr.val);
        	copyMap.put(curr, copy);
        	curr=curr.next;
        }
        
        curr=head;
        while(curr!=null)
        {
        	Node2 copy=copyMap.get(curr);
        	copy.next=copyMap.get(curr.next);
        	copy.random=copyMap.get(curr.random);
        	curr=curr.next;
        }
        
        return copyMap.get(head);
    }
    
	public static void main(String args[])
	{
		Node2 n1=new Node2(7);
		Node2 n2=new Node2(13);
		Node2 n3=new Node2(11);
		Node2 n4=new Node2(10);
		Node2 n5=new Node2(1);
		
		n1.next=n2;
		n1.random=null;
		n2.next=n3;
		n2.random=n1;
		n3.next=n4;
		n3.random=n5;
		n4.next=n5;
		n4.random=n3;
		n5.next=null;
		n5.random=n1;
		
		//BEFORE
		System.out.println("BEFORE:");
		Node2 node=n1;
		int nodeNo=0;
		while(node!=null)
		{
			nodeNo++;
			String val = Integer.toString(node.val);
			String next = (node.next!=null)?Integer.toString(node.next.val):null;
			String random = (node.random!=null)?Integer.toString(node.random.val):null;
			System.out.println("N"+nodeNo+": val="+val+", next="+next+", random="+random);
			node=node.next;
		}
		
		//AFTER
		System.out.println("AFTER:");
		Node2 op=copyRandomList(n1);
		nodeNo=0;
		while(op!=null)
		{
			nodeNo++;
			String val = Integer.toString(op.val);
			String next = (op.next!=null)?Integer.toString(op.next.val):null;
			String random = (op.random!=null)?Integer.toString(op.random.val):null;
			System.out.println("N"+nodeNo+": val="+val+", next="+next+", random="+random);
			op=op.next;
		}
	}
}
