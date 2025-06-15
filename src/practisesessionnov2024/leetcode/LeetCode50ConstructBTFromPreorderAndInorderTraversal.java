package practisesessionnov2024.leetcode;

import java.util.HashMap;
import java.util.Map;

class TreeNode12{
	int val;
	TreeNode12 left;
	TreeNode12 right;
	
	public TreeNode12() {}
	
	public TreeNode12(int val) 
	{
		this.val=val;
	}
	
	public TreeNode12(int val, TreeNode12 left, TreeNode12 right) 
	{
		this.val=val;
		this.left=left;
		this.right=right;
	}
}

public class LeetCode50ConstructBTFromPreorderAndInorderTraversal 
{
	static int preorder_idx=0;
	static Map<Integer, Integer> inorderMap = new HashMap<>();
	
    public static TreeNode12 buildTree(int[] preorder, int[] inorder) 
    {
        for(int i=0;i<inorder.length;i++)
        {
        	inorderMap.put(inorder[i], i);
        }
        
        return buildTreeHelper(preorder, 0, inorder.length-1);
    }
    
    private static TreeNode12 buildTreeHelper(int[] preorder, int l, int r)
    {
    	if(l>r)return null;
    	
    	int root_val = preorder[preorder_idx];
    	TreeNode12 root = new TreeNode12(root_val);
    	preorder_idx++;
    	int mid=inorderMap.get(root_val);
    	root.left = buildTreeHelper(preorder, l, mid-1);
    	root.right = buildTreeHelper(preorder, mid+1, r);
    	return root;
    }
    
    public static void traversal(TreeNode12 node, String traversalType)
    {
    	if(node!=null)
    	{
    		if(traversalType.equals("PREORDER"))
    		{
    			System.out.println(node.val);
    			traversal(node.left, traversalType);
    			traversal(node.right, traversalType);
    		}
    		else if(traversalType.equals("INORDER"))
    		{
    			traversal(node.left, traversalType);
    			System.out.println(node.val);
    			traversal(node.right, traversalType);
    		}
    	}
    }
    
    public static void main(String args[])
    {
    	int[] preorder = {3,9,20,15,7};
    	int[] inorder = {9,3,15,20,7};
    	
    	TreeNode12 root = buildTree(preorder, inorder);
    	
    	System.out.println("PREORDER");
    	traversal(root, "PREORDER");
    	System.out.println("INORDER");
    	traversal(root, "INORDER");
    }
}
