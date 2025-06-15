package practisesessionnov2024.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode69NoOfComponentsInGraph {
	
    public static int countComponents(int n, int[][] edges) 
    {
    	List<List<Integer>> adj = new ArrayList<>();
    	Set<Integer> visited = new HashSet<>();
    	
    	for(int i=0;i<n;i++)
    	{
    		adj.add(new ArrayList<>());
    	}
    	
    	for(int[] edge : edges)
    	{
    		adj.get(edge[0]).add(edge[1]);
    		adj.get(edge[1]).add(edge[0]);
    	}
    	
    	int res=0;
    	for(int i=0;i<n;i++)
    	{
    		if(!visited.contains(i))
    		{
    			traverse(i,visited,adj);
    			res++;
    		}
    	}
    	
    	return res;
    }
    
    
    private static void traverse(int node, Set<Integer> visited, List<List<Integer>> adj)
    {    	
    	visited.add(node);
    	
    	for(int nextNode : adj.get(node))
    	{
    		if(!visited.contains(nextNode))
    		{
    			traverse(nextNode, visited, adj);
    		}
    	}
    }
	
	public static void main(String args[])
	{
		int n=6;
		int[][] edges = {{0,1}, {1,2}, {2,3}, {4,5}};
		System.out.println(countComponents(n, edges));
	}
}
