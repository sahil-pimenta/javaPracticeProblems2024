package practisesessionnov2024.leetcode;

class TreeNode3{
	int val;
	TreeNode3 left;
	TreeNode3 right;
	
	public TreeNode3() {}
	
	public TreeNode3(int val) 
	{
		this.val=val;
	}
	
	public TreeNode3(int val, TreeNode3 left, TreeNode3 right) 
	{
		this.val=val;
		this.left=left;
		this.right=right;
	}
}

public class LeetCode41BalancedBinaryTree {
	
    public static boolean isBalanced(TreeNode3 root) 
    {
    	return isBalancedHelper(root)[0]==1;
    }
    
    private static int[] isBalancedHelper(TreeNode3 node)
    {
    	if(node==null)
    	{
    		return new int[] {1,0};
    	}
    	
    	int[] left = isBalancedHelper(node.left);
    	int[] right = isBalancedHelper(node.right);
    	
    	boolean balanced = (left[0]==1 && right[0]==1) && (Math.abs(left[1]-right[1]) <=1);
    	
    	int height = 1+Math.max(left[1], right[1]);
    	
    	return new int[] {balanced?1:0, height};
    }
	
	public static void main(String args[])
	{
		TreeNode3 n3=new TreeNode3(3);
		TreeNode3 n9=new TreeNode3(9);
		TreeNode3 n20=new TreeNode3(20);
		TreeNode3 n15=new TreeNode3(15);
		TreeNode3 n7=new TreeNode3(7);
		
		n3.left=n9;
		n3.right=n20;
		
		n20.left=n15;
		n20.right=n7;
		
		System.out.println(isBalanced(n3));
	}
}
