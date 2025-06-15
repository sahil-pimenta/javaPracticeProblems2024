package practisesessionnov2024.dsa;

class Node6{
	int data;
	Node6 left;
	Node6 right;
	
	public Node6(int data)
	{
		this.data=data;
	}
}

class BinarySearchTree{
	
	Node6 root;
	
	public void insert(Node6 node)
	{
		root = insertHelper(root, node);
	}
	
	private Node6 insertHelper(Node6 root, Node6 node)
	{
		if(root==null)
		{
			root=node;
			return root;
		}
		else if(node.data < root.data)
		{
			root.left = insertHelper(root.left, node);
		}
		else
		{
			root.right = insertHelper(root.right, node);
		}
		
		return root;
	}
	
	public void display()
	{
		displayHelper(root);
	}
	
	private void displayHelper(Node6 root)
	{
		if(root!=null)
		{
			displayHelper(root.left);
			System.out.println(root.data);
			displayHelper(root.right);
		}
	}
	
	public boolean search(int data)
	{
		return searchHelper(root, data);
	}
	
	private boolean searchHelper(Node6 root, int data)
	{
		if(root==null)
		{
			return false;
		}
		else if(root.data==data)
		{
			return true;
		}
		else if(data < root.data)
		{
			return searchHelper(root.left, data);
		}
		else
		{
			return searchHelper(root.right, data);
		}
	}
	
	public void remove(int data)
	{
		removeHelper(root, data);
	}
	
	private Node6 removeHelper(Node6 root, int data)
	{
		if(root==null)
		{
			return root;
		}
		else if(data<root.data)
		{
			root.left=removeHelper(root.left, data);
		}
		else if(data>root.data)
		{
			root.right=removeHelper(root.right, data);
		}
		else
		{
			if(root.left==null && root.right==null)
			{
				root=null;
				return root;
			}
			else if(root.right!=null)
			{
				root.data = successor(root);
				root.right=removeHelper(root.right, root.data);
			}
			else
			{
				root.data=predecessor(root);
				root.left=removeHelper(root.left, root.data);
			}
		}
		
		return root;
	}
	
	private int successor(Node6 root)
	{
		root = root.right;
		while(root.left!=null)
		{
			root=root.left;
		}
		return root.data;
	}

	private int predecessor(Node6 root)
	{
		root = root.left;
		while(root.right!=null)
		{
			root=root.right;
		}
		return root.data;
	}
}

public class DSA13BinarySearchTree {

	public static void main(String args[])
	{
		BinarySearchTree bst = new BinarySearchTree();
		
		bst.insert(new Node6(5));
		bst.insert(new Node6(3));
		bst.insert(new Node6(9));
		bst.insert(new Node6(1));
		bst.insert(new Node6(7));
		bst.insert(new Node6(2));
		bst.insert(new Node6(8));
		bst.insert(new Node6(4));
		bst.insert(new Node6(6));
		
		bst.remove(7);
		bst.remove(3);
		
		bst.display();
		
		System.out.println(bst.search(3));
	}
}
