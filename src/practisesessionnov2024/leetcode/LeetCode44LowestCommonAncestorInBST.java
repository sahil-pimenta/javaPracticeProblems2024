package practisesessionnov2024.leetcode;

class TreeNode6{
	int val;
	TreeNode6 left;
	TreeNode6 right;
	
	public TreeNode6() {}
	
	public TreeNode6(int val) 
	{
		this.val=val;
	}
	
	public TreeNode6(int val, TreeNode6 left, TreeNode6 right) 
	{
		this.val=val;
		this.left=left;
		this.right=right;
	}
}

public class LeetCode44LowestCommonAncestorInBST 
{
    public static TreeNode6 lowestCommonAncestor(TreeNode6 root, TreeNode6 p, TreeNode6 q) 
    {
        if(root==null || p==null || q==null)
        {
        	return null;
        }
        
        TreeNode6 cur = root;
        
        while(cur!=null)
        {
        	if(p.val < cur.val && q.val < cur.val)
        	{
        		cur=cur.left;
        	}
        	else if(p.val > cur.val && q.val > cur.val)
        	{
        		cur=cur.right;
        	}
        	else
        	{
        		return cur;
        	}
        }
        
        return null;
    }
	
	
	public static void main(String args[])
	{
		TreeNode6 n0 = new TreeNode6(0);
		TreeNode6 n2 = new TreeNode6(2);
		TreeNode6 n3 = new TreeNode6(3);
		TreeNode6 n4 = new TreeNode6(4);
		TreeNode6 n5 = new TreeNode6(5);
		TreeNode6 n6 = new TreeNode6(6);
		TreeNode6 n7 = new TreeNode6(7);
		TreeNode6 n8 = new TreeNode6(8);
		TreeNode6 n9 = new TreeNode6(9);
		
		
		n6.left=n2;
		n6.right=n8;
		
		n2.left=n0;
		n2.right=n4;
		
		n4.left=n3;
		n4.right=n5;
		
		n8.left=n7;
		n8.right=n9;
		
		System.out.println(lowestCommonAncestor(n6, n2, n8).val);
	}
}
