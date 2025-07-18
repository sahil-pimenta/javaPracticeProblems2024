package revision;

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
	int[][] matrix;
	List<Node> nodesList;
	
	public Graph(int noOfNodes)
	{
		matrix=new int[noOfNodes][noOfNodes];
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
	
	public void print()
	{
		System.out.print("  ");
		for(Node node: nodesList)
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

public class AdjacencyMatrix {

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
		
		System.out.println(graph.checkEdge(2, 4));
	}
}
