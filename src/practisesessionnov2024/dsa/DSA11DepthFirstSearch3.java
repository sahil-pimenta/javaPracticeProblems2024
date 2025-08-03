package practisesessionnov2024.dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

class Node3
{
	int val;
	boolean visited;
	List<Node3> nei;
	
	public Node3() {
		nei=new ArrayList<Node3>();
	}
	
	public Node3(int val)
	{
		this.val=val;
		nei=new ArrayList<Node3>();
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public List<Node3> getNei() {
		return nei;
	}

	public void setNei(List<Node3> nei) {
		this.nei = nei;
	}
	
}

public class DSA11DepthFirstSearch3 {

	public static void dfsRecursive(Node3 node)
	{
		node.setVisited(true);
		System.out.println("Visited node:"+node.getVal());
		
		for(Node3 n:node.getNei())
		{
			if(!n.isVisited())
			{
				dfsRecursive(n);
			}
		}
	}
	
	public static void dfsIterative(Node3 root)
	{
		Stack<Node3> stack=new Stack<>();
		stack.push(root);
		
		while(!stack.isEmpty())
		{
			Node3 node=stack.pop();
			
			if(!node.isVisited())
			{
				node.setVisited(true);
				System.out.println("Visited node:"+node.getVal());
				for(Node3 nei:node.getNei())
				{
						stack.push(nei);
				}
			}
		}
	}
	
	public static void bfsIterative(Node3 root)
	{
		Queue<Node3> q = new LinkedList<Node3>();
		q.offer(root);
		
		while(!q.isEmpty())
		{
			Node3 node=q.poll();
			
			if(!node.isVisited())
			{
				node.setVisited(true);
				System.out.println("Visited node:"+node.getVal());
				
				for(Node3 n:node.getNei())
				{
					q.offer(n);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Node3 n0 = new Node3(0);
		Node3 n1 = new Node3(1);
		Node3 n2 = new Node3(2);
		Node3 n3 = new Node3(3);
		Node3 n4 = new Node3(4);
		Node3 n5 = new Node3(5);
		Node3 n6 = new Node3(6);
		
		n0.nei.addAll(Arrays.asList(n1,n5,n6));
		n1.nei.addAll(Arrays.asList(n0,n3,n4,n5));
		n2.nei.addAll(Arrays.asList(n4));
		n3.nei.addAll(Arrays.asList(n1));
		n4.nei.addAll(Arrays.asList(n1,n2,n6));
		n5.nei.addAll(Arrays.asList(n0,n1));
		n6.nei.addAll(Arrays.asList(n0,n4));
		
		//dfsRecursive(n0);
		
		bfsIterative(n0);
	}
}
