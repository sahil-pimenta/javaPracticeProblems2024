package practisesessionnov2024.leetcode;

import java.util.ArrayList;
import java.util.List;

class TreeNode11{
	int val;
	TreeNode11 left;
	TreeNode11 right;
	
	public TreeNode11() {}
	
	public TreeNode11(int val) 
	{
		this.val=val;
	}
	
	public TreeNode11(int val, TreeNode11 left, TreeNode11 right) 
	{
		this.val=val;
		this.left=left;
		this.right=right;
	}
}

public class LeetCode49KthSmallestIntegerInBST 
{

    public static int kthSmallest(TreeNode11 root, int k) 
    {
    	if(root==null)
    	{
    		return -1;
    	}
    	
    	List<Integer> res = new ArrayList<>();
    	inOrderTrversal(root, res);
        return res.get(k-1);
    }
    
    private static void inOrderTrversal(TreeNode11 node, List<Integer> res)
    {
    	if(node==null)
    	{
    		return;
    	}
    	
    	inOrderTrversal(node.left, res);
    	res.add(node.val);
    	inOrderTrversal(node.right, res);
    }
	
	public static void main(String args[])
	{
		TreeNode11 n1 = new TreeNode11(1);
		TreeNode11 n2 = new TreeNode11(2);
		TreeNode11 n3 = new TreeNode11(3);
		TreeNode11 n4 = new TreeNode11(4);
		TreeNode11 n5 = new TreeNode11(5);
		TreeNode11 n6 = new TreeNode11(6);
		
		
		n5.left=n3;
		n5.right=n6;
		
		n3.left=n2;
		n3.right=n4;
		
		n2.left=n1;
		
		int k=3;
		
		System.out.println(kthSmallest(n5, k));
	}
	
}
