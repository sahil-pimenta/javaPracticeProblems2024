package practisesessionnov2024.dsa;

import java.util.ArrayList;
import java.util.List;

class Graph{
	public int[][] matrix;
	public List<Node> nodes;
	
	public Graph(int noOfNodes)
	{
		matrix = new int[noOfNodes][noOfNodes];
		nodes = new ArrayList<Node>();
	}
	
	public void addNode(Node node){
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
		for(Node n:nodes)
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
	
}

class Node{
	public char data;
	
	public Node(char data)
	{
		this.data=data;
	}
}

public class DSA9AdjacencyMatrix {

	public static void main(String args[])
	{
		Graph graph = new Graph(5);
		
		graph.addNode(new Node('A'));
		graph.addNode(new Node('B'));
		graph.addNode(new Node('C'));
		graph.addNode(new Node('D'));
		graph.addNode(new Node('E'));
		
		graph.addAdjacency(0, 1);
		graph.addAdjacency(1, 2);
		graph.addAdjacency(2, 3);
		graph.addAdjacency(2, 4);
		graph.addAdjacency(4, 0);
		graph.addAdjacency(4, 2);
		
		graph.print();
		System.out.println(graph.checkAdjacency(0, 1));
	}
}
