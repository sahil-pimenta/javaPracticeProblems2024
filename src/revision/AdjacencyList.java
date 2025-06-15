package revision;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Node1{
	char data;
	
	public Node1(char data)
	{
		this.data=data;
	}
}

class Graph1{
	List<LinkedList<Node1>> nodesList;
	
	public Graph1()
	{
		nodesList=new ArrayList<LinkedList<Node1>>();
	}
	
	public void addNode(Node1 node)
	{
		LinkedList<Node1> newNode = new LinkedList<Node1>();
		newNode.add(node);
		nodesList.add(newNode);
	}
	
	public void addEdge(int src, int dst)
	{
		Node1 dstNode = nodesList.get(dst).get(0);
		LinkedList<Node1> srcNodeList = nodesList.get(src);
		srcNodeList.add(dstNode);
	}
	
	public boolean checkEdge(int src, int dst)
	{
		Node1 dstNode = nodesList.get(dst).get(0);
		LinkedList<Node1> srcNodeList = nodesList.get(src);
		for(Node1 srcNode: srcNodeList)
		{
			if(srcNode==dstNode)
			{
				return true;
			}
		}
		
		return false;
	}
	
	public void print()
	{
		for(LinkedList<Node1> nodeLList: nodesList)
		{
			for(Node1 node: nodeLList)
			{
				System.out.print(node.data+"->");
			}
			System.out.println();
		}
	}
	
}

public class AdjacencyList {
	public static void main(String args[])
	{
		Graph1 graph = new Graph1();
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
		
		System.out.println(graph.checkEdge(2, 4));
	}
}
