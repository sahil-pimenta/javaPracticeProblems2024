package practisesessionnov2024.dsa;

class Node7{
	int data;
	Node7 left;
	Node7 right;
	
	public Node7(int data)
	{
		this.data=data;
	}
}

class BinarySearchTree2{
	Node7 root;
	
	public void insert(Node7 node)
	{
		root=insertHelper(root, node);
	}
	
	private Node7 insertHelper(Node7 root, Node7 node)
	{
		if(root==null)
		{
			root=node;
			return root;
		}
		else if(node.data < root.data)
		{
			root.left=insertHelper(root.left, node);
		}
		else
		{
			root.right=insertHelper(root.right, node);
		}
		return root;
	}
	
	public void display()
	{
		displayHelper(root);
	}
	
	public void displayHelper(Node7 root)
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
	
	private boolean searchHelper(Node7 root, int data)
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
		if(search(data))
		{
			removeHelper(root, data);
		}
		else
		{
			System.out.println(data+" does not exist in BST");
		}
	}
	
	private Node7 removeHelper(Node7 root, int data)
	{
		if(root==null)
		{
			return root;
		}
		else if(data < root.data)
		{
			root.left = removeHelper(root.left, data);
		}
		else if(data > root.data)
		{
			root.right = removeHelper(root.right, data);
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
				root.data=successor(root);
				root.right = removeHelper(root.right, root.data);
			}
			else
			{
				root.data=predecessor(root);
				root.left=removeHelper(root.left, root.data);
			}
		}
		
		return root;
	}
	
	private int successor(Node7 root)
	{
		root=root.right;
		while(root.left!=null)
		{
			root=root.left;
		}
		return root.data;
	}
	
	private int predecessor(Node7 root)
	{
		root=root.left;
		while(root.right!=null)
		{
			root=root.right;
		}
		return root.data;
	}
	
}

public class DSA13BinarySearchTree2 {
	public static void main(String args[])
	{
		BinarySearchTree2 bst = new BinarySearchTree2();
		
		bst.insert(new Node7(5));
		bst.insert(new Node7(3));
		bst.insert(new Node7(9));
		bst.insert(new Node7(1));
		bst.insert(new Node7(7));
		bst.insert(new Node7(2));
		bst.insert(new Node7(8));
		bst.insert(new Node7(4));
		bst.insert(new Node7(6));
		
		bst.display();
		
		System.out.println(bst.search(4));
		
		bst.remove(7);
		bst.remove(2);
		
		bst.display();
	}
}
