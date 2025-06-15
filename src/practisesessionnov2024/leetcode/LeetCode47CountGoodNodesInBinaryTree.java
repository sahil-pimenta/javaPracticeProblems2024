package practisesessionnov2024.leetcode;

class TreeNode9{
	int val;
	TreeNode9 left;
	TreeNode9 right;
	
	public TreeNode9() {}
	
	public TreeNode9(int val) 
	{
		this.val=val;
	}
	
	public TreeNode9(int val, TreeNode9 left, TreeNode9 right) 
	{
		this.val=val;
		this.left=left;
		this.right=right;
	}
}

public class LeetCode47CountGoodNodesInBinaryTree {

    public static int goodNodes(TreeNode9 root) 
    {
    	return goodNodesHelper(root, root.val);
    }
    
    private static int goodNodesHelper(TreeNode9 node, int maxVal)
    {
    	if(node==null)
    	{
    		return 0;
    	}
    	
    	int res = node.val>=maxVal?1:0;
    	maxVal = Math.max(maxVal, node.val);
    	res+= goodNodesHelper(node.left, maxVal);
    	res+= goodNodesHelper(node.right, maxVal);
    	return res;
    }
    
	
	public static void main(String args[])
	{
		TreeNode9 n1 = new TreeNode9(1);
		TreeNode9 n1_2 = new TreeNode9(1);
		TreeNode9 n3 = new TreeNode9(3);
		TreeNode9 n3_2 = new TreeNode9(3);
		TreeNode9 n4 = new TreeNode9(4);
		TreeNode9 n5 = new TreeNode9(5);
		
		
		n3.left=n1;
		n3.right=n4;
		
		n1.left=n3_2;
		
		n4.left=n1_2;
		n4.right=n5;
		
		System.out.println(goodNodes(n3));
	}
}
