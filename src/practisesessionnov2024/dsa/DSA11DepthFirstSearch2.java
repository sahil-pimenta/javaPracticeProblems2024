package practisesessionnov2024.dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class Vertex<T>
{
	T data;
	boolean visited;
	List<Vertex<T>> neighbors;
	
	public Vertex(T data)
	{
		this.data=data;
		this.neighbors=new ArrayList<>();
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<Vertex<T>> getNeighbors() {
		return neighbors;
	}

	public void setNeighbors(List<Vertex<T>> neighbors) {
		this.neighbors = neighbors;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}
}

public class DSA11DepthFirstSearch2 
{
	public static void dfsIterative(Vertex<Integer> srcVertex)
	{
		Stack<Vertex<Integer>> stack = new Stack<>();
		stack.push(srcVertex);
		
		while(!stack.isEmpty())
		{
			Vertex<Integer> curVertex = stack.pop();
			
			if(!curVertex.isVisited())
			{
				curVertex.setVisited(true);
				
				System.out.println("Visited Vertex: "+curVertex.getData());
				
				for(Vertex<Integer> neighbor:curVertex.getNeighbors())
				{
					stack.push(neighbor);
				}
			}
		}
	}
	
	public static void dfsRecursive(Vertex<Integer> vertex)
	{
		vertex.setVisited(true);
		System.out.println("Visited Vertex: "+vertex.getData());
		
		for(Vertex<Integer> neighbor:vertex.getNeighbors())
		{
			if(!neighbor.isVisited())
			{
				dfsRecursive(neighbor);
			}
		}
	}
	
	
	public static void main(String args[])
	{
		Vertex<Integer> n0 = new Vertex<>(0);
		Vertex<Integer> n1 = new Vertex<>(1);
		Vertex<Integer> n2 = new Vertex<>(2);
		Vertex<Integer> n3 = new Vertex<>(3);
		Vertex<Integer> n4 = new Vertex<>(4);
		Vertex<Integer> n5 = new Vertex<>(5);
		Vertex<Integer> n6 = new Vertex<>(6);
		
		n0.setNeighbors(Arrays.asList(n1,n5,n6));
		n1.setNeighbors(Arrays.asList(n3,n4,n5));
		n4.setNeighbors(Arrays.asList(n2,n6));
		n6.setNeighbors(Arrays.asList(n0));
		
		//System.out.println("ITERATIVE");
		//dfsIterative(n0);
		System.out.println();
		System.out.println("RECURSIVE");
		dfsRecursive(n0);
	}
}
