package practisesessionnov2024.leetcode;

class TreeNode2
{
	int val;
	TreeNode2 left;
	TreeNode2 right;
	
	public TreeNode2() {}
	
	public TreeNode2(int val) 
	{
		this.val=val;
	}
	
	public TreeNode2(int val, TreeNode2 left, TreeNode2 right) 
	{
		this.val=val;
		this.left=left;
		this.right=right;
	}
}

public class LeetCode40DiameterOfBinaryTree 
{
    public static int diameterOfBinaryTree(TreeNode2 root) 
    {
    	int[] res = new int[1];
    	dfs(root, res);
    	return res[0];
    }
    
    private static int dfs(TreeNode2 node, int[] res)
    {
    	if(node==null)
    	{
    		return 0;
    	}
    	int left=dfs(node.left, res);
    	int right=dfs(node.right, res);
    	res[0] = Math.max(res[0], left+right);
    	return 1+Math.max(left, right);
    }
    
    public static void main(String args[])
    {
    	TreeNode2 n1 = new TreeNode2(1);
    	TreeNode2 n2 = new TreeNode2(2);
    	TreeNode2 n3 = new TreeNode2(3);
    	TreeNode2 n4 = new TreeNode2(4);
    	TreeNode2 n5 = new TreeNode2(5);
    	
    	n1.left=n2;
    	n1.right=n3;
    	
    	n2.left=n4;
    	n2.right=n5;
    	
    	System.out.println(diameterOfBinaryTree(n1));
    }
}
