package revision;

class Node4{
	int data;
	Node4 left;
	Node4 right;
	
	public Node4(int data)
	{
		this.data=data;
	}
}

class BinarySearchTree1{
	Node4 root;
	
	public void insert(Node4 node)
	{
		root=insertHelper(root, node);
	}
	
	private Node4 insertHelper(Node4 root, Node4 node)
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
	
	private void displayHelper(Node4 root)
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
	
	private boolean searchHelper(Node4 root, int data)
	{
		if(root==null)
		{
			return false;
		}
		else if(root.data == data)
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
			System.out.println(data+" not found in tree");
		}
	}
	
	private Node4 removeHelper(Node4 root, int data)
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
			if(root.right==null && root.left==null)
			{
				root=null;
				return root;
			}
			else if(root.right!=null)
			{
				root.data = successor(root);
				root.right = removeHelper(root.right, root.data);
			}
			else
			{
				root.data = predecessor(root);
				root.left = removeHelper(root.left, root.data);
			}
		}
		return root;
	}
	
	private int successor(Node4 root)
	{
		root=root.right;
		while(root.left!=null)
		{
			root = root.left;
		}
		return root.data;
	}
	
	private int predecessor(Node4 root)
	{
		root=root.left;
		while(root.right!=null)
		{
			root = root.right;
		}
		return root.data;
	}
	
}

public class BinarySearchTree {
	public static void main(String args[])
	{
		BinarySearchTree1 bst = new BinarySearchTree1();
		
		bst.insert(new Node4(5));
		bst.insert(new Node4(3));
		bst.insert(new Node4(9));
		bst.insert(new Node4(1));
		bst.insert(new Node4(7));
		bst.insert(new Node4(2));
		bst.insert(new Node4(8));
		bst.insert(new Node4(4));
		bst.insert(new Node4(6));
		
//		bst.display();
//		
//		bst.remove(7);
//		
		bst.remove(9);
//		
//		System.out.println(bst.search(7));
//		
		bst.display();
	}
}
