package practisesessionnov2024.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode68GraphValidTree 
{
    public static boolean validTree(int n, int[][] edges) 
    {
    	//no. of edges are always less the no. of nodes
    	if(edges.length>=n)return false;
    	
    	Set<Integer> visited = new HashSet<>();
    	List<List<Integer>> adj = new ArrayList<>();
    	
    	for(int i=0;i<n;i++)
    	{
    		adj.add(new ArrayList<>());
    	}
    	
    	for(int[] edge : edges)
    	{
    		adj.get(edge[0]).add(edge[1]);
    		adj.get(edge[1]).add(edge[0]);
    	}
    	
    	if(!visitNode(0, -1, visited, adj))
    	{
    		return false;
    	}
    	
    	
    	return visited.size()==n;
    }
    
    private static boolean visitNode(int node, int prevNode, Set<Integer> visited, List<List<Integer>> adj)
    {
    	if(visited.contains(node))return false;
    	    	
    	visited.add(node);
    	
    	for(int nei : adj.get(node))
    	{
    		if(nei==prevNode)continue;
    		
    		if(!visitNode(nei, node, visited, adj))
    		{
    			return false;
    		}
    	}
    	
    	return true;
    }
	
	public static void main(String args[])
	{
		int n = 5;
		int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
		System.out.println(validTree(n, edges));
	}
}
