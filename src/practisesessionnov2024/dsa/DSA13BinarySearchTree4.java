package practisesessionnov2024.dsa;

class Node8
{
	int val;
	Node8 left;
	Node8 right;
	
	public Node8() {
		
	}
	public Node8(int val) {
		this.val = val;
	}
}

public class DSA13BinarySearchTree4 {
	
	public static boolean isEmpty(Node8 root)
	{
		return root==null;
	}
	
	public static int getMin(Node8 root)
	{
		while(root.left!=null)
		{
			root=root.left;
		}
		return root.val;
	}
	
	public static int getMax(Node8 root)
	{
		while(root.right!=null)
		{
			root=root.right;
		}
		return root.val;
	}
	
	public static void traverse(String traversal, Node8 root)
	{
		if(root!=null)
		{
			if(traversal.equals("INORDER"))
			{
				traverse("INORDER", root.left);
				System.out.println("Visited node:"+root.val);
				traverse("INORDER", root.right);
			}
			else if(traversal.equals("PREORDER"))
			{
				System.out.println("Visited node:"+root.val);
				traverse("INORDER", root.left);
				traverse("INORDER", root.right);
			}
			else
			{
				traverse("INORDER", root.left);
				traverse("INORDER", root.right);
				System.out.println("Visited node:"+root.val);
			}
		}
	}
	
	public static void insert(Node8 root, int val)
	{
		root=insertH(root,val);
	}
	
	private static Node8 insertH(Node8 node, int val)
	{
		if(node==null)
		{
			return new Node8(val);
		}
		
		if(val>node.val)
		{
			node.right=insertH(node.right, val);
		}
		else if(val<node.val)
		{
			node.left=insertH(node.left,val);
		}
		return node;
	}
	
	public static void delete(Node8 root, int val)
	{
		root=deleteH(root,val);
	}
	
	private static Node8 deleteH(Node8 node, int val)
	{
		if(node==null)return null;
		
		if(val>node.val)
		{
			node.right=deleteH(node.right,val);
		}
		else if(val<node.val)
		{
			node.left=deleteH(node.left,val);
		}
		else
		{
			if(node.left==null)
			{
				return node.right;
			}
			else if(node.right==null)
			{
				return node.left;
			}
			
			node.val=getMax(node.left);//predecessor
			node.left=deleteH(node.left,node.val);
		}
		return node;
	}

	public static void main(String[] args) {
		Node8 n10=new Node8(10);
		Node8 n6=new Node8(6);
		Node8 n15=new Node8(15);
		Node8 n4=new Node8(4);
		Node8 n9=new Node8(9);
		Node8 n12=new Node8(12);
		Node8 n20=new Node8(20);
		
		n10.left=n6;
		n10.right=n15;
		
		n6.left=n4;
		n6.right=n9;
		
		n15.left=n12;
		n15.right=n20;
		
		//insert(n10, 16);
		delete(n10, 15);
		traverse("PREORDER",n10);
	}
}
