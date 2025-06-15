package practisesessionnov2024.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode70RedundantConnection 
{
    public static int[] findRedundantConnection(int[][] edges) 
    {
        List<List<Integer>> adj = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        int n = edges.length;
        
        for(int i=0;i<=n;i++)
        {
        	adj.add(new ArrayList<>());
        }
        
        for(int[] edge : edges)
        {
        	adj.get(edge[0]).add(edge[1]);
        	adj.get(edge[1]).add(edge[0]);
        	
        	visited.clear();
        	if(checkCycle(edge[0], -1, visited, adj))
        	{
        		return edge;
        	}
        }
        
        return new int[] {};
    }
    
    private static boolean checkCycle(int node, int prevNode, Set<Integer> visited, List<List<Integer>> adj)
    {
    	if(visited.contains(node))return true;
    	
    	visited.add(node);
    	
    	for(int nextNode:adj.get(node))
    	{
    		if(nextNode==prevNode)continue;
    		
    		if(checkCycle(nextNode, node, visited, adj))
    		{
    			return true;
    		}
    	}
    	
    	return false;
    }
    
	public static void main(String args[])
	{
		int[][] edges = {{1,2},{2,3},{3,4},{1,4},{1,5}};
		System.out.println(Arrays.toString(findRedundantConnection(edges)));
	}
}
