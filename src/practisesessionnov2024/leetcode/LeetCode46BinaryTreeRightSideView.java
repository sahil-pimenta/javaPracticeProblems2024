package practisesessionnov2024.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode8{
	int val;
	TreeNode8 left;
	TreeNode8 right;
	
	public TreeNode8() {}
	
	public TreeNode8(int val) 
	{
		this.val=val;
	}
	
	public TreeNode8(int val, TreeNode8 left, TreeNode8 right) 
	{
		this.val=val;
		this.left=left;
		this.right=right;
	}
}

public class LeetCode46BinaryTreeRightSideView 
{

    public static List<Integer> rightSideView(TreeNode8 root) 
    {
        List<Integer> res = new ArrayList<Integer>();
        Queue<TreeNode8> queue = new LinkedList<TreeNode8>();
        queue.offer(root);
        
        while(!queue.isEmpty())
        {
        	TreeNode8 rightMost=null;
        	int size=queue.size();
        	for(int i=0;i<size;i++)
        	{
        		TreeNode8 node = queue.poll();
        		
        		if(node!=null)
        		{
            		rightMost = node;
        			queue.offer(node.left);
        			queue.offer(node.right);
        		}
        	}
        	
        	if(rightMost!=null)
        	{
            	res.add(rightMost.val);
        	}
        }
        return res;
    }
	
	public static void main(String args[])
	{
		TreeNode8 n1 = new TreeNode8(1);
		TreeNode8 n2 = new TreeNode8(2);
		TreeNode8 n3 = new TreeNode8(3);
		TreeNode8 n4 = new TreeNode8(4);
		TreeNode8 n5 = new TreeNode8(5);
		
		
		n1.left=n2;
		n1.right=n3;
		
		n2.left=n4;
		
		n4.left=n5;
		
		System.out.println(rightSideView(n1).toString());
	}
}
