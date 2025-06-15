package practisesessionnov2024.leetcode;

class TreeNode5{
	int val;
	TreeNode5 left;
	TreeNode5 right;
	
	public TreeNode5() {}
	
	public TreeNode5(int val) 
	{
		this.val=val;
	}
	
	public TreeNode5(int val, TreeNode5 left, TreeNode5 right) 
	{
		this.val=val;
		this.left=left;
		this.right=right;
	}
}

public class LeetCode43SubtreeOfAnotherTree {

    public static boolean isSubtree(TreeNode5 root, TreeNode5 subRoot) 
    {
        if(subRoot==null)
        {
        	return true;
        }
        
        if(root==null)
        {
        	return false;
        }
        
        if(isSameTree(root, subRoot))
        {
        	return true;
        }
        
        return isSubtree(root.left,subRoot) || isSubtree(root.right, subRoot);
        
    }
	
    private static boolean isSameTree(TreeNode5 node1, TreeNode5 node2)
    {
    	if(node1==null && node2==null)
    	{
    		return true;
    	}
    	
    	if(node1!=null && node2!=null && node1.val==node2.val)
    	{
    		return isSameTree(node1.left,node2.left) && isSameTree(node1.right,node2.right);
    	}
    	
    	return false;
    }
    
	public static void main(String args[])
	{
		TreeNode5 n1=new TreeNode5(1);
		TreeNode5 n2=new TreeNode5(2);
		TreeNode5 n3=new TreeNode5(3);
		TreeNode5 n4=new TreeNode5(4);
		TreeNode5 n5=new TreeNode5(5);
		
		TreeNode5 n2_4=new TreeNode5(4);
		TreeNode5 n2_1=new TreeNode5(1);
		TreeNode5 n2_2=new TreeNode5(2);
		
		n3.left=n4;
		n3.right=n5;
		
		n4.left=n1;
		n4.right=n2;
		
		
		n2_4.left=n2_1;
		n2_4.right=n2_2;
		
		System.out.println(isSubtree(n3, n2_4));
	}
}
