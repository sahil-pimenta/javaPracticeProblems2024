package practisesessionnov2024.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node1{
	char data;
	public Node1(char data)
	{
		this.data=data;
	}
}

class Graph1{
	int[][]matrix;
	List<Node1> nodesList;
	
	public Graph1(int noOfNodes)
	{
		matrix = new int[noOfNodes][noOfNodes];
		nodesList=new ArrayList<Node1>();
	}
	
	public void addNode(Node1 node)
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
		for(Node1 node:nodesList)
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
	
	public void breadthFirstSearch(int src)
	{
		boolean[] visited = new boolean[matrix.length];
		Queue<Integer> nxtNodeQueue = new LinkedList<Integer>();
		
		nxtNodeQueue.offer(src);
		visited[src]=true;
		
		while(nxtNodeQueue.size()!=0)
		{
			src=nxtNodeQueue.poll();
			System.out.println(nodesList.get(src).data+" = visited");
			
			for(int i=0;i<matrix[src].length;i++)
			{
				if(matrix[src][i]==1 && !visited[i])
				{
					nxtNodeQueue.offer(i);
					visited[i]=true;
				}
			}
			
		}
	}
	
}

public class Algo3BreadthFirstSearch {
	
	public static void main(String args[])
	{
		Graph1 graph = new Graph1(5);
		graph.addNode(new Node1('A'));
		graph.addNode(new Node1('B'));
		graph.addNode(new Node1('C'));
		graph.addNode(new Node1('D'));
		graph.addNode(new Node1('E'));
		
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(1, 4);
		graph.addEdge(2, 3);
		graph.addEdge(2, 4);
		graph.addEdge(4, 0);
		
		graph.print();
		
		System.out.println(graph.checkEdge(2, 3));
		
		graph.breadthFirstSearch(0);
		
	}	
}
