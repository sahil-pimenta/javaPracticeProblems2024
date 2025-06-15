package revision;

import java.util.ArrayList;
import java.util.List;

class Node2{
	char data;
	
	public Node2(char data)
	{
		this.data=data;
	}
}

class Graph2{
	int[][] matrix;
	List<Node2> nodesList;
	
	public Graph2(int noOfNodes)
	{
		matrix=new int[noOfNodes][noOfNodes];
		nodesList=new ArrayList<Node2>();
	}
	
	
	public void addNode(Node2 node)
	{
		nodesList.add(node);
	}
	
	public void addEdge(int src, int dst)
	{
		matrix[src][dst]=1;
	}
	
	public boolean checkEdge(int src,int dst)
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
	
	public void depthFirstSearch(int src)
	{
		boolean[] visited = new boolean[matrix.length];
		
		dFSHelper(src, visited);
	}
	
	private void dFSHelper(int src, boolean[] visited)
	{
		if(visited[src])
		{
			return;
		}
		
		visited[src]=true;
		
		System.out.println(nodesList.get(src).data+" = visited");
		
		for(int i=0;i<matrix[src].length;i++)
		{
			if(matrix[src][i]==1)
			{
				dFSHelper(i, visited);
			}
		}
		return;
	}
	
	public void print()
	{
		System.out.print("  ");
		for(Node2 node: nodesList)
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
	
}

public class DepthFirstSearch {
	public static void main(String args[])
	{
		Graph2 graph = new Graph2(5);
		graph.addNode(new Node2('A'));
		graph.addNode(new Node2('B'));
		graph.addNode(new Node2('C'));
		graph.addNode(new Node2('D'));
		graph.addNode(new Node2('E'));
		
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(1, 4);
		graph.addEdge(2, 3);
		graph.addEdge(2, 4);
		graph.addEdge(4, 0);
		
		graph.print();
		
		System.out.println(graph.checkEdge(2, 4));
		
		graph.depthFirstSearch(0);
	}
}
