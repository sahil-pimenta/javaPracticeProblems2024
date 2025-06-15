package practisesessionnov2024.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class TreeNode4{
	int val;
	TreeNode4 left;
	TreeNode4 right;
	
	public TreeNode4() {}
	
	public TreeNode4(int val) 
	{
		this.val=val;
	}
	
	public TreeNode4(int val, TreeNode4 left, TreeNode4 right) 
	{
		this.val=val;
		this.left=left;
		this.right=right;
	}
}

public class LeetCode42SameBinaryTree {
	
    public static boolean isSameTreeDFSRecursive(TreeNode4 p, TreeNode4 q) 
    {
    	if(q==null && p==null)
    	{
    		return true;
    	}
    	
    	if(q!=null && p!=null && p.val==q.val)
    	{
    		return isSameTreeDFSRecursive(p.left, q.left) && isSameTreeDFSRecursive(p.right, q.right);
    	}
    	else
    	{
    		return false;
    	}
    	
    }
    
    public static boolean isSameTreeBFS(TreeNode4 p, TreeNode4 q) 
    {
    	if(q==null && p==null)
    	{
    		return true;
    	}
    	
    	Queue<TreeNode4> queue1 = new LinkedList<TreeNode4>();
    	Queue<TreeNode4> queue2 = new LinkedList<TreeNode4>();
    	queue1.offer(p);
    	queue2.offer(q);
    	
    	while(!queue1.isEmpty() && !queue2.isEmpty())
    	{
    		for(int i=0;i<queue1.size();i++)
    		{
        		TreeNode4 nodep = queue1.poll();
        		TreeNode4 nodeq = queue2.poll();
        		
        		if(nodep==null && nodeq==null) continue;
        		if(nodep==null || nodeq==null || nodep.val!=nodeq.val)
        		{
        			return false;
        		}
        		
        		queue1.offer(nodep.left);
        		queue1.offer(nodep.right);
        		
        		queue2.offer(nodeq.left);
        		queue2.offer(nodeq.right);
    		}
    	}
    	return true;
    }
    

	public static void main(String args[])
	{
		TreeNode4 n1=new TreeNode4(1);
		TreeNode4 n2=new TreeNode4(2);
		TreeNode4 n3=new TreeNode4(3);
		
		TreeNode4 n2_1=new TreeNode4(1);
		TreeNode4 n2_2=new TreeNode4(2);
		TreeNode4 n2_3=new TreeNode4(3);
		
		n1.left=n2;
		n1.right=n3;
		
		n2_1.left=n2_2;
		n2_1.right=n2_3;
		
		System.out.println(isSameTreeBFS(n1, n2_1));
	}
}
