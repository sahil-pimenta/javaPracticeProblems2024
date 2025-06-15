package practisesessionnov2024.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	
	public TreeNode() {}
	
	public TreeNode(int val) 
	{
		this.val=val;
	}
	
	public TreeNode(int val, TreeNode left, TreeNode right) 
	{
		this.val=val;
		this.left=left;
		this.right=right;
	}
}

public class LeetCode38InvertBinaryTree 
{
	public static TreeNode invertTreeBfs(TreeNode root) 
	{
		if(root==null)
		{
			return null;
		}
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		
		while(!queue.isEmpty())
		{
			TreeNode node = queue.poll();
			
			TreeNode tmp = node.left;
			node.left=node.right;
			node.right=tmp;
			
			if(node.left!=null)
			{
				queue.offer(node.left);
			}
			
			if(node.right!=null)
			{
				queue.offer(node.right);
			}
		}
		
		return root;
	}
	
	public static TreeNode invertTreeDfsIterative(TreeNode root) 
	{
		if(root==null)
		{
			return null;
		}
		
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		
		while(!stack.isEmpty())
		{
			TreeNode node = stack.pop();
			
			TreeNode tmp=node.left;
			node.left=node.right;
			node.right=tmp;
			
			if(node.left!=null)
			{
				stack.push(node.left);
			}
			
			if(node.right!=null)
			{
				stack.push(node.right);
			}
		}
		return root;
	}
	
	public static TreeNode invertTreeDfsRecursion(TreeNode root) 
	{
		if(root==null)
		{
			return null;
		}
		
		TreeNode node = new TreeNode(root.val);
		
		node.left=invertTreeDfsRecursion(root.right);
		node.right=invertTreeDfsRecursion(root.left);
		
		return node;
	}
	
	public static void traverse(TreeNode root)
	{
		if(root!=null)
		{
			System.out.println("Visited Node: "+root.val);
			traverse(root.left);
			traverse(root.right);
		}
	}

	public static void main(String args[])
	{
		TreeNode n1=new TreeNode(1);
		TreeNode n2=new TreeNode(2);
		TreeNode n3=new TreeNode(3);
		TreeNode n4=new TreeNode(4);
		TreeNode n5=new TreeNode(5);
		TreeNode n6=new TreeNode(6);
		TreeNode n7=new TreeNode(7);
		
		n1.left=n2;
		n1.right=n3;
		
		n2.left=n4;
		n2.right=n5;
		
		n3.left=n6;
		n3.right=n7;
		
		System.out.println("BEFORE");
		traverse(n1);
		
		System.out.println("AFTER");
		
		//TreeNode root = invertTreeBfs(n1);
		//TreeNode root = invertTreeDfsIterative(n1);
		TreeNode root = invertTreeDfsRecursion(n1);
		traverse(root);
	}
}
