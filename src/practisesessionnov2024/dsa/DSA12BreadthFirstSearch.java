package practisesessionnov2024.dsa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node5{
	public char data;
	
	public Node5(char data)
	{
		this.data=data;
	}
}

class Graph5{
	public int[][] matrix;
	public List<Node5> nodes;
	
	public Graph5(int noOfNodes)
	{
		matrix = new int[noOfNodes][noOfNodes];
		nodes = new ArrayList<Node5>();
	}
	
	public void addNode(Node5 node){
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
		for(Node5 n:nodes)
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
	
	public void breadthFirstSearch(int src)
	{
		Queue<Integer> nodeQueue = new LinkedList<Integer>();
		boolean[] visited = new boolean[matrix.length];
		
		nodeQueue.offer(src);
		visited[src]=true;
		
		while(nodeQueue.size()!=0)
		{
			src = nodeQueue.poll();
			System.out.println(nodes.get(src).data+" = visited");
			
			for(int i=0;i<matrix[src].length;i++)
			{
				if(matrix[src][i]==1 && !visited[i])
				{
					nodeQueue.offer(i);
					visited[i]=true;
				}
			}
		}
				
	}
}

public class DSA12BreadthFirstSearch {
	public static void main(String args[])
	{
		Graph5 graph = new Graph5(5);
		
		graph.addNode(new Node5('A'));
		graph.addNode(new Node5('B'));
		graph.addNode(new Node5('C'));
		graph.addNode(new Node5('D'));
		graph.addNode(new Node5('E'));
		
		graph.addAdjacency(0, 1);
		graph.addAdjacency(1, 2);
		graph.addAdjacency(1, 4);
		graph.addAdjacency(2, 3);
		graph.addAdjacency(2, 4);
		graph.addAdjacency(4, 0);
		graph.addAdjacency(4, 2);
		
		graph.print();
		System.out.println(graph.checkAdjacency(0, 1));
		
		graph.breadthFirstSearch(0);
	}
}
