package practisesessionnov2024.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

class TreeNode1
{
	int val;
	TreeNode1 left;
	TreeNode1 right;
	
	public TreeNode1() {}
	
	public TreeNode1(int val) 
	{
		this.val=val;
	}
	
	public TreeNode1(int val, TreeNode1 left, TreeNode1 right) 
	{
		this.val=val;
		this.left=left;
		this.right=right;
	}
}

public class LeetCode39MaxDepthOfBinaryTree 
{
    public static int maxDepthDFSRecursive(TreeNode1 root) 
    {
        if(root==null)
        {
        	return 0;
        }
        
        return 1+Math.max(maxDepthDFSRecursive(root.left), maxDepthDFSRecursive(root.right));
    }
    
//    public static int maxDepthDFSIterative(TreeNode1 root) 
//    {
//    	
//    }
    
    public static int maxDepthBFS(TreeNode1 root) 
    {
        if(root==null)
        {
        	return 0;
        }
        
        int len=0;
        
        Queue<TreeNode1> queue = new LinkedList<TreeNode1>();
        queue.offer(root);
        
        while(!queue.isEmpty())
        {
        	int qSize = queue.size();
        	
        	for(int i=0;i<qSize;i++)
        	{
            	TreeNode1 node = queue.poll();
            	
            	if(node.left!=null)
            	{
            		queue.offer(node.left);
            	}
            	
            	if(node.right!=null)
            	{
            		queue.offer(node.right);
            	}
        	}
        	len++;
        }
        
        return len;
    }
	
	public static void main(String args[])
	{
		TreeNode1 n1=new TreeNode1(1);
		TreeNode1 n2=new TreeNode1(2);
		TreeNode1 n3=new TreeNode1(3);
		TreeNode1 n4=new TreeNode1(4);
		TreeNode1 n5=new TreeNode1(5);
		TreeNode1 n6=new TreeNode1(6);
		TreeNode1 n7=new TreeNode1(7);
		
		n1.left=n2;
		n1.right=n3;
		
		n2.left=n4;
		n2.right=n5;
		
		n3.left=n6;
		n3.right=n7;
		
		System.out.println(maxDepthBFS(n1));
	}
}
