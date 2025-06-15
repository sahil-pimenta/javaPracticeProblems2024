package practisesessionnov2024.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode7{
	int val;
	TreeNode7 left;
	TreeNode7 right;
	
	public TreeNode7() {}
	
	public TreeNode7(int val) 
	{
		this.val=val;
	}
	
	public TreeNode7(int val, TreeNode7 left, TreeNode7 right) 
	{
		this.val=val;
		this.left=left;
		this.right=right;
	}
}

public class LeetCode45BinaryTreeLevelOrderTraversal {

    public static List<List<Integer>> levelOrder(TreeNode7 root) 
    {
        if(root==null)
        {
        	return new ArrayList<List<Integer>>();
        }
        
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode7> queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty())
        {
        	int size = queue.size();
        	List<Integer> list = new ArrayList<>();
        	
        	for(int i=0;i<size;i++)
        	{
        		TreeNode7 node = queue.poll();
        		list.add(node.val);
        		
        		if(node.left!=null)
        		{
        			queue.offer(node.left);
        		}
        		
        		if(node.right!=null)
        		{
        			queue.offer(node.right);
        		}
        	}
        	res.add(list);
        }
        
        return res;
    }
	
	public static void main(String args[])
	{
		TreeNode7 n1 = new TreeNode7(1);
		TreeNode7 n2 = new TreeNode7(2);
		TreeNode7 n3 = new TreeNode7(3);
		TreeNode7 n4 = new TreeNode7(4);
		TreeNode7 n5 = new TreeNode7(5);
		TreeNode7 n6 = new TreeNode7(6);
		TreeNode7 n7 = new TreeNode7(7);
		
		
		n1.left=n2;
		n1.right=n3;
		
		n2.left=n4;
		n2.right=n5;
		
		n3.left=n6;
		n3.right=n7;
		
		System.out.println(levelOrder(n1).toString());
	}
}
