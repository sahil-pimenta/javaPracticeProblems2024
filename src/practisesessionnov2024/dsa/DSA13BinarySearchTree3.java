package practisesessionnov2024.dsa;

class Node2<T extends Comparable<T>>
{
	T data;
	Node2<T> left;
	Node2<T> right;
	
	public Node2(T data)
	{
		this.data=data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node2<T> getLeft() {
		return left;
	}

	public void setLeft(Node2<T> left) {
		this.left = left;
	}

	public Node2<T> getRight() {
		return right;
	}

	public void setRight(Node2<T> right) {
		this.right = right;
	}
}

interface Tree<T extends Comparable<T>>
{
	public T getMin();
	public T getMax();
	public void traverse(Node2<T> startNode, String traversalType);
	public boolean isEmpty();
	public void insert(T data);
	public void delete(T data);
}

public class DSA13BinarySearchTree3<T extends Comparable<T>> implements Tree<T>
{
	Node2<T> rootNode;
	
	public DSA13BinarySearchTree3(Node2<T> rootNode)
	{
		this.rootNode=rootNode;
	}
	
	public boolean isEmpty()
	{
		return rootNode==null;
	}
	
	public T getMin()
	{
		if(isEmpty())
		{
			return null;
		}
		
		Node2<T> node=rootNode;
		while(node.getLeft()!=null)
		{
			node=node.getLeft();
		}
		return node.getData();
	}
	
	public T getMax()
	{
		if(isEmpty())
		{
			return null;
		}
		
		Node2<T> node=rootNode;
		while(node.getRight()!=null)
		{
			node=node.getRight();
		}
		return node.getData();
	}
	
	public void traverse(Node2<T> node, String traversalType)
	{
		if(node!=null)
		{
			if(traversalType.equals("IN-ORDER"))
			{
				traverse(node.getLeft(), traversalType);
				System.out.println("Visited Node: "+node.getData());
				traverse(node.getRight(), traversalType);
			}
			else if(traversalType.equals("PRE-ORDER"))
			{
				System.out.println("Visited Node: "+node.getData());
				traverse(node.getLeft(), traversalType);
				traverse(node.getRight(), traversalType);
			}
			else
			{
				traverse(node.getLeft(), traversalType);
				traverse(node.getRight(), traversalType);
				System.out.println("Visited Node: "+node.getData());
			}
		}
	}
	
	public void insert(T data)
	{
		rootNode = insert(data, rootNode);
	}
	
	private Node2<T> insert(T data, Node2<T> node)
	{
		if(node==null)
		{
			return new Node2<T>(data);
		}
		
		if(data.compareTo(node.getData()) < 0)
		{
			node.setLeft(insert(data, node.getLeft()));
		}
		else if(data.compareTo(node.getData()) > 0)
		{
			node.setRight(insert(data, node.getRight()));
		}
		
		return node;
	}
	
	public void delete(T data)
	{
		rootNode = delete(data, rootNode);
	}
	
	private Node2<T> delete(T data, Node2<T> node)
	{
		if(node==null)
		{
			return null;
		}
		
		if(data.compareTo(node.getData()) < 0)
		{
			node.setLeft(delete(data, node.getLeft()));
		}
		else if(data.compareTo(node.getData()) > 0)
		{
			node.setRight(delete(data, node.getRight()));
		}
		else
		{
			//One child or Leaf Node, return that one or null node
			if(node.getLeft()==null)
			{
				return node.getRight();
			}
			else if(node.getRight()==null)
			{
				return node.getLeft();
			}
			
			//Two child nodes, return predecessor (max val from left tree)
			node.setData(getMax(node.getLeft()));
			node.setLeft(delete(node.getData(), node.getLeft()));
		}
		return node;
	}
	
	private T getMax(Node2<T> node)
	{
		if(node==null)
		{
			return null;
		}
		
		while(node.getRight()!=null)
		{
			node=node.getRight();
		}
		
		return node.getData();
	}
	
	public static void main(String args[])
	{
		Node2<Integer> n0=new Node2<>(10);
		Node2<Integer> n1=new Node2<>(6);
		Node2<Integer> n2=new Node2<>(15);
		Node2<Integer> n3=new Node2<>(4);
		Node2<Integer> n4=new Node2<>(9);
		Node2<Integer> n5=new Node2<>(12);
		Node2<Integer> n6=new Node2<>(20);
		
		n0.setLeft(n1);
		n0.setRight(n2);
		
		n1.setLeft(n3);
		n1.setRight(n4);
		
		n2.setLeft(n5);
		n2.setRight(n6);
		
		DSA13BinarySearchTree3<Integer> bst = new DSA13BinarySearchTree3<Integer>(n0);
		
		System.out.println("IS EMPTY? : "+bst.isEmpty());
		System.out.println("MIN: "+bst.getMin());
		System.out.println("MAX: "+bst.getMax());
		
		bst.delete(15);
		
		bst.traverse(n0, "PRE-ORDER");
	}
}
