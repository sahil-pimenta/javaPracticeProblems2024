package practisesessionnov2024.dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Vertex2<T>
{
	T data;
	boolean visited;
	List<Vertex2<T>> neighbors;
	
	public Vertex2(T data)
	{
		this.data=data;
		this.neighbors=new ArrayList<Vertex2<T>>();
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public List<Vertex2<T>> getNeighbors() {
		return neighbors;
	}

	public void setNeighbors(List<Vertex2<T>> neighbors) {
		this.neighbors = neighbors;
	}
}

public class DSA12BreadthFirstSearch2 {
	
	public static void breadthFirstSearch(Vertex<Integer> srcVertex)
	{
		Queue<Vertex<Integer>> queue = new LinkedList<>();
		queue.offer(srcVertex);
		
		while(!queue.isEmpty())
		{
			Vertex<Integer> cur=queue.poll();
			
			if(!cur.isVisited())
			{
				cur.setVisited(true);
				System.out.println("Visited Vertex: "+cur.getData());
				
				queue.addAll(cur.getNeighbors());
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
		
		breadthFirstSearch(n0);
	}
}
