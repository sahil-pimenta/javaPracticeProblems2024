package practisesessionnov2024.dsa;

import java.util.ArrayList;
import java.util.List;

class Node4{
	public char data;
	
	public Node4(char data)
	{
		this.data=data;
	}
}

class Graph4{
	public int[][] matrix;
	public List<Node4> nodes;
	
	public Graph4(int noOfNodes)
	{
		matrix = new int[noOfNodes][noOfNodes];
		nodes = new ArrayList<Node4>();
	}
	
	public void addNode(Node4 node){
		nodes.add(node);
	}
	
	public void addAdjacency(int src, int dst)
	{
		matrix[src][dst]=1;
	}
	
	public boolean checkAdjacency(int src, int dst)
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
		for(Node4 n:nodes)
		{
			System.out.print(n.data + " ");
		}
		
		System.out.println();
		
		for(int i=0; i<matrix.length; i++)
		{
			System.out.print(nodes.get(i).data + " ");
			
			for(int j=0; j<matrix[i].length; j++)
			{
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	
	public void depthFirstSearch(int src)
	{
		boolean[] visited = new boolean[matrix.length];
		dFSHelper(src, visited);
	}

	public void dFSHelper(int src, boolean[] visited) {
		if(visited[src])
		{
			return;
		}
		else
		{
			visited[src] = true;
			System.out.println(nodes.get(src).data+" = visited");
		}
		
		for(int i=0;i<matrix[src].length;i++)
		{
			if(matrix[src][i]==1)
			{
				dFSHelper(i, visited);
			}
		}
		
		return;
		
	}
	
}


public class DSA11DepthFirstSearch {
	public static void main(String args[])
	{
		Graph4 graph = new Graph4(5);
		
		graph.addNode(new Node4('A'));
		graph.addNode(new Node4('B'));
		graph.addNode(new Node4('C'));
		graph.addNode(new Node4('D'));
		graph.addNode(new Node4('E'));
		
		graph.addAdjacency(0, 1);
		graph.addAdjacency(1, 2);
		graph.addAdjacency(1, 4);
		graph.addAdjacency(2, 3);
		graph.addAdjacency(2, 4);
		graph.addAdjacency(4, 0);
		graph.addAdjacency(4, 2);
		
		graph.print();
		System.out.println(graph.checkAdjacency(0, 1));
		
		graph.depthFirstSearch(0);
	}
}
