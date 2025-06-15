package practisesessionnov2024.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Node8 {
    public int val;
    public List<Node8> neighbors;
    public Node8() {
        val = 0;
        neighbors = new ArrayList<Node8>();
    }
    public Node8(int _val) {
        val = _val;
        neighbors = new ArrayList<Node8>();
    }
    public Node8(int _val, ArrayList<Node8> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class LeetCode61CloneGraph {
	
    public static Node8 cloneGraphDFS(Node8 node) {
        Map<Node8, Node8> copyMap = new HashMap<>();
        return cloneDFS(node, copyMap);
    }

    private static Node8 cloneDFS(Node8 node, Map<Node8,Node8> copyMap)
    {
        if(node==null)return null;

        if(copyMap.containsKey(node))return copyMap.get(node);

        Node8 copy = new Node8(node.val);
        copyMap.put(node, copy);

        for(Node8 neighbor: node.neighbors)
        {
            copy.neighbors.add(cloneDFS(neighbor, copyMap));
        }

        return copy;
    }
	
    public static Node8 cloneGraphBFS(Node8 node) {
        if(node==null)return null;
        Queue<Node8> q = new LinkedList<>();
        Map<Node8,Node8> copyMap = new HashMap<>();
        q.offer(node);
        copyMap.put(node, new Node8(node.val));

        while(!q.isEmpty())
        {
            Node8 nodeP=q.poll();

            for(Node8 neighbor : nodeP.neighbors)
            {
                if(!copyMap.containsKey(neighbor))
                {
                    copyMap.put(neighbor, new Node8(neighbor.val));
                    q.offer(neighbor);
                }

                copyMap.get(nodeP).neighbors.add(copyMap.get(neighbor));
            }
        }

        return copyMap.get(node);
    }
    
	
	public static void main(String args[])
	{
		Node8 n1 = new Node8(1);
		Node8 n2 = new Node8(2);
		Node8 n3 = new Node8(3);
		
		n1.neighbors=new ArrayList<Node8>(Arrays.asList(n2));
		n2.neighbors=new ArrayList<Node8>(Arrays.asList(n1,n3));
		n3.neighbors=new ArrayList<Node8>(Arrays.asList(n2));
		
		System.out.println("BEFORE");
		traverse(n1);
		
		System.out.println("AFTER");
		Node8 copy = cloneGraphBFS(n1);
		traverse(copy);
	}
	
	private static void traverse(Node8 Node8)
	{
		List<Node8> visited = new ArrayList<>();
		
		dfsTraverse(Node8, visited);
	}
	
	private static void dfsTraverse(Node8 Node8, List<Node8> visited)
	{
		System.out.println(Node8.val);
		visited.add(Node8);
		
		for(Node8 nei : Node8.neighbors)
		{
			if(!visited.contains(nei))
			{
				dfsTraverse(nei, visited);
			}
		}
	}
}
