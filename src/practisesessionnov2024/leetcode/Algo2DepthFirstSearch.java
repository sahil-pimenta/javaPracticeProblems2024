package practisesessionnov2024.leetcode;

import java.util.ArrayList;
import java.util.List;

class Node{
	char data;
	public Node(char data)
	{
		this.data=data;
	}
}

class Graph{
	int[][]matrix;
	List<Node> nodesList;
	
	public Graph(int noOfNodes)
	{
		matrix = new int[noOfNodes][noOfNodes];
		nodesList=new ArrayList<Node>();
	}
	
	public void addNode(Node node)
	{
		nodesList.add(node);
	}
	
	public void addEdge(int src, int dst)
	{
		matrix[src][dst]=1;
	}
	
	public boolean checkEdge(int src, int dst)
	{
		if(matrix[src][dst]==1)
		{
			return true;
		}
		else
		{
			
			return false;
		}
	}
	
	public void print()
	{
		System.out.print("  ");
		for(Node node:nodesList)
		{
			System.out.print(node.data+" ");
		}
		
		System.out.println();
		
		for(int i=0;i<matrix.length;i++)
		{
			System.out.print(nodesList.get(i).data+" ");
			for(int j=0;j<matrix[i].length;j++)
			{
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public void depthFirstSearch(int src)
	{
		boolean[] visited = new boolean[matrix.length];
		
		dfsHelper(src, visited);
	}
	
	private void dfsHelper(int src, boolean[] visited)
	{
		if(visited[src])return;
		
		visited[src]=true;
		System.out.println(nodesList.get(src).data+" = visited");
		
		for(int i=0;i<matrix[src].length;i++)
		{
			if(matrix[src][i]==1)
			{
				dfsHelper(i, visited);
			}
		}
		
	}
}



public class Algo2DepthFirstSearch {

	public static void main(String args[])
	{
		Graph graph = new Graph(5);
		graph.addNode(new Node('A'));
		graph.addNode(new Node('B'));
		graph.addNode(new Node('C'));
		graph.addNode(new Node('D'));
		graph.addNode(new Node('E'));
		
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(1, 4);
		graph.addEdge(2, 3);
		graph.addEdge(2, 4);
		graph.addEdge(4, 0);
		
		graph.print();
		
		System.out.println(graph.checkEdge(2, 3));
		
		graph.depthFirstSearch(0);
		
	}	
}
