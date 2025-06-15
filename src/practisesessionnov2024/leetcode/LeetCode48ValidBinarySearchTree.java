package practisesessionnov2024.leetcode;

class TreeNode10{
	int val;
	TreeNode10 left;
	TreeNode10 right;
	
	public TreeNode10() {}
	
	public TreeNode10(int val) 
	{
		this.val=val;
	}
	
	public TreeNode10(int val, TreeNode10 left, TreeNode10 right) 
	{
		this.val=val;
		this.left=left;
		this.right=right;
	}
}

public class LeetCode48ValidBinarySearchTree {

    public static boolean isValidBST(TreeNode10 root) 
    {
    	return isValidBSThelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private static boolean isValidBSThelper(TreeNode10 node, long left, long right)
    {
    	if(node==null)
    	{
    		return true;
    	}
    	
    	if(!(node.val>left && node.val<right))
    	{
    		return false;
    	}
    	
    	return isValidBSThelper(node.left, left, node.val) 
    			&& isValidBSThelper(node.right, node.val, right);
    }
    
	
	public static void main(String args[])
	{
		TreeNode10 n1 = new TreeNode10(1);
		TreeNode10 n2 = new TreeNode10(2);
		TreeNode10 n3 = new TreeNode10(3);
		
		
		n2.left=n1;
		n2.right=n3;

		System.out.println(isValidBST(n2));
	}
}
