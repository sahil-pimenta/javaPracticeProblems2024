package revision;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node3{
	char data;
	
	public Node3(char data)
	{
		this.data=data;
	}
}

class Graph3{
	int[][] matrix;
	List<Node3> nodesList;
	
	public Graph3(int noOfNodes)
	{
		matrix=new int[noOfNodes][noOfNodes];
		nodesList=new ArrayList<Node3>();
	}
	
	
	public void addNode(Node3 node)
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
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[matrix.length];
		
		queue.offer(src);
		visited[src]=true;
		
		while(queue.size()!=0)
		{
			src=queue.poll();
			System.out.println(nodesList.get(src).data+" = visited");
			
			for(int i=0;i<matrix[src].length;i++)
			{
				if(matrix[src][i]==1 && !visited[i])
				{
					queue.offer(i);
					visited[i]=true;
				}
			}
		}
		
	}
	
	public void print()
	{
		System.out.print("  ");
		for(Node3 node: nodesList)
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

public class BreadthFirstSearch {
	public static void main(String args[])
	{
		Graph3 graph = new Graph3(5);
		graph.addNode(new Node3('A'));
		graph.addNode(new Node3('B'));
		graph.addNode(new Node3('C'));
		graph.addNode(new Node3('D'));
		graph.addNode(new Node3('E'));
		
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
