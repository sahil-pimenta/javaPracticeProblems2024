package practisesessionnov2024.dsa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Graph1{
	
	List<LinkedList<Node1>> nodeList;
	
	public Graph1()
	{
		nodeList = new ArrayList<>();
	}
	
	public void addNode(Node1 node)
	{
		LinkedList<Node1> currentList = new LinkedList<Node1>();
		currentList.add(node);
		nodeList.add(currentList);
	}
	
	public void addAdjacency(int src, int dst)
	{
		LinkedList<Node1> currentList = nodeList.get(src);
		currentList.add(nodeList.get(dst).get(0));
	}
	
	public boolean checkAdjacency(int src, int dst)
	{
		LinkedList<Node1> currentList = nodeList.get(src);
		Node1 dstNode = nodeList.get(dst).get(0);
		for(Node1 srcListDstNode: currentList)
		{
			if(srcListDstNode == dstNode)
			{
				return true;
			}
		}
		return false;
	}
	
	public void print()
	{
		for(LinkedList<Node1> nodeList: nodeList)
		{
			for(Node1 nodes: nodeList)
			{
				System.out.print(nodes.data+"->");
			}
			System.out.println();
		}
	}
	
}

class Node1{
	public char data;
	
	public Node1(char data)
	{
		this.data=data;
	}
}

public class DSA10AdjacencyList {
	public static void main(String args[])
	{
		Graph1 graph = new Graph1();
		
		graph.addNode(new Node1('A'));
		graph.addNode(new Node1('B'));
		graph.addNode(new Node1('C'));
		graph.addNode(new Node1('D'));
		graph.addNode(new Node1('E'));
		
		graph.addAdjacency(0, 1);
		
		graph.print();
		
		System.out.println(graph.checkAdjacency(0, 1));;
	}
}
