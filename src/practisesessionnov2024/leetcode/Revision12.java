package practisesessionnov2024.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Node9 {
    public int val;
    public List<Node9> neighbors;
    public Node9() {
        val = 0;
        neighbors = new ArrayList<Node9>();
    }
    public Node9(int _val) {
        val = _val;
        neighbors = new ArrayList<Node9>();
    }
    public Node9(int _val, ArrayList<Node9> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class Revision12 {

    public static int numIslands(char[][] grid) 
    {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        boolean[][] visited = new boolean[ROWS][COLS];
        
        int island=0;
        for(int r=0;r<ROWS;r++)
        {
        	for(int c=0;c<COLS;c++)
        	{
        		if((!visited[r][c]) && (grid[r][c]=='1'))
        		{
        			findIsland(r, c, visited, grid);
        			island++;
        		}
        	}
        }
        
        return island;
    }
    
    private static void findIsland(int row, int col, boolean[][] visited, char[][]grid)
    {
    	visited[row][col]=true;
    	
    	int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    	
    	for(int[] dir : dirs)
    	{
    		int r = row+dir[0];
    		int c = col+dir[1];
    		
    		if(r<0||r>=grid.length || c<0||c>=grid[0].length || visited[r][c] || grid[r][c]!='1')continue;
    		
    		findIsland(r, c, visited, grid);
    	}
    }
    
    public static int maxAreaOfIsland(int[][] grid) 
    {
        int ROW=grid.length;
        int COL=grid[0].length;
        boolean[][] visited=new boolean[ROW][COL];
        
        int maxArea=0;
        for(int r=0;r<ROW;r++)
        {
        	for(int c=0;c<COL;c++)
        	{
        		if((!visited[r][c]) && (grid[r][c]==1))
        		{
        			int area = getArea(r,c,visited,grid);
        			maxArea=Math.max(maxArea, area);
        		}
        	}
        }
        
        return maxArea;
    }
    
    private static int getArea(int row, int col, boolean[][] visited, int[][] grid)
    {
    	visited[row][col]=true;
    	int area=1;
    	
    	int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    	
    	for(int[] dir : dirs)
    	{
    		int r = row+dir[0];
    		int c= col+dir[1];
    		
    		if(r<0||r>=grid.length || c<0||c>=grid[0].length || visited[r][c] || grid[r][c]!=1)continue;    		
    		area+=getArea(r, c, visited, grid);
    	}
    	
    	return area;
    }
    
    public static Node9 cloneGraphDFS(Node9 node) 
    {
        Map<Node9, Node9> copyMap = new HashMap<Node9, Node9>();
        return dfs(node, copyMap);
    }
    
    private static Node9 dfs(Node9 node, Map<Node9, Node9> copyMap)
    {
    	if(node==null)return null;
    	
    	if(copyMap.containsKey(node)) return copyMap.get(node);
    	
    	Node9 copy = new Node9(node.val);
    	copyMap.put(node, copy);
    	
    	for(Node9 nextNode : node.neighbors)
    	{
    		copy.neighbors.add(dfs(nextNode, copyMap));
    	}
    	
    	return copy;
    }
    
    
    public static Node9 cloneGraphBFS(Node9 node) 
    {
    	if(node==null)return null;
    	
    	Map<Node9, Node9> copyMap = new HashMap<>();
    	Queue<Node9> q = new LinkedList<Node9>();
    	q.offer(node);
    	copyMap.put(node, new Node9(node.val));
    	
    	while(!q.isEmpty())
    	{
    		Node9 qNode = q.poll();
    		
    		for(Node9 nextNode:qNode.neighbors)
    		{
    			if(!copyMap.containsKey(nextNode))
    			{
    				copyMap.put(nextNode, new Node9(nextNode.val));
    				q.offer(nextNode);
    			}
    			
    			copyMap.get(qNode).neighbors.add(copyMap.get(nextNode));
    			
    		}
    	}
    	
    	return copyMap.get(node);
    }
    
	private static void traverse(Node9 Node9)
	{
		List<Node9> visited = new ArrayList<>();
		
		dfsTraverse(Node9, visited);
	}
	
	private static void dfsTraverse(Node9 Node9, List<Node9> visited)
	{
		System.out.println(Node9.val);
		visited.add(Node9);
		
		for(Node9 nei : Node9.neighbors)
		{
			if(!visited.contains(nei))
			{
				dfsTraverse(nei, visited);
			}
		}
	}
	
    public static void islandsAndTreasure(int[][] grid) 
    {
        int ROW=grid.length;
        int COL=grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        
        for(int r=0;r<ROW;r++)
        {
        	for(int c=0;c<COL;c++)
        	{
        		if(grid[r][c]==0)
        		{
        			q.offer(new int[] {r,c});
        		}
        	}
        }
        
        while(!q.isEmpty())
        {
        	int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        	
        	int qSize=q.size();
        	
        	for(int i=0;i<qSize;i++)
        	{
        		int[] chestPos = q.poll();
        		int row=chestPos[0];
        		int col=chestPos[1];
        		
        		for(int[] dir : dirs)
        		{
        			int r=row+dir[0];
        			int c=col+dir[1];
        			
        			if(r<0||r>=ROW || c<0||c>=COL || grid[r][c]!=Integer.MAX_VALUE)continue;
        			
        			grid[r][c]=grid[row][col]+1;
        			q.offer(new int[] {r,c});
        		}
        	}
        }
    }
	
    
    public static int orangesRotting(int[][] grid) 
    {
        int ROW=grid.length;
        int COL=grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        
        int fresh=0;
        int time=0;
        
        for(int r=0;r<ROW;r++)
        {
        	for(int c=0;c<COL;c++)
        	{
        		if(grid[r][c]==1)
        		{
        			fresh++;
        		}
        		
        		if(grid[r][c]==2)
        		{
        			q.offer(new int[] {r,c});
        		}
        	}
        }
        
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        
        while((!q.isEmpty()) && (fresh>0))
        {
        	int qSize = q.size();
        	
        	for(int i=0;i<qSize;i++)
        	{
        		int[] rotPos = q.poll();
        		int row = rotPos[0];
        		int col = rotPos[1];
        		
        		for(int[] dir : dirs)
        		{
        			int r = row+dir[0];
        			int c = col+dir[1];
        			
        			if(r<0||r>=ROW || c<0||c>=COL || grid[r][c]!=1)continue;
        			
        			grid[r][c]=2;
        			fresh--;
        			q.offer(new int[] {r,c});
        		}
        	}
        	time++;
        }
        
        return fresh>0?-1:time;
    }
    
    public static List<List<Integer>> pacificAtlantic(int[][] heights) 
    {
        int ROW=heights.length;
        int COL=heights[0].length;
        
        boolean[][] pacific=new boolean[ROW][COL];
        boolean[][] atlantic=new boolean[ROW][COL];
        
        for(int r=0;r<ROW;r++)
        {
        	findCells(r, 0, pacific, heights);
        	
        	findCells(r, COL-1, atlantic, heights);
        }
        
        for(int c=0;c<COL;c++)
        {
        	findCells(0, c, pacific, heights);
        	
        	findCells(ROW-1, c, atlantic, heights);
        }
        
        List<List<Integer>> res = new ArrayList<>();
        
        for(int r=0;r<ROW;r++)
        {
        	for(int c=0;c<COL;c++)
        	{
        		if(pacific[r][c] && atlantic[r][c])
        		{
        			res.add(Arrays.asList(r,c));
        		}
        	}
        }
        
        return res;
    }
    
    private static void findCells(int row, int col, boolean[][] ocean, int[][] heights)
    {
    	ocean[row][col]=true;
    	int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    	
    	for(int[] dir : dirs)
    	{
    		int r=row+dir[0];
    		int c=col+dir[1];
    		
    		if(r<0||r>=heights.length || c<0||c>=heights[0].length || ocean[r][c] || heights[r][c]<heights[row][col])continue;
    		
    		findCells(r, c, ocean, heights);
    	}
    }
    
    public static void solve(char[][] board) 
    {
        int ROW=board.length;
        int COL=board[0].length;
        
        for(int r=0;r<ROW;r++)
        {
        	if(board[r][0]=='O')
        	{
            	markEdgeRegion(r, 0, board);
        	}

        	if(board[r][COL-1]=='O')
        	{
            	markEdgeRegion(r, COL-1, board);
        	}
        }
        
        for(int c=0;c<COL;c++)
        {
        	if(board[0][c]=='O')
        	{
        		markEdgeRegion(0, c, board);
        	}
        	
        	if(board[ROW-1][c]=='O')
        	{
            	markEdgeRegion(ROW-1, c, board);
        	}
        }
        
        for(int r=0;r<ROW;r++)
        {
        	for(int c=0;c<COL;c++)
        	{
        		if(board[r][c]=='O')
        		{
        			board[r][c]='X';
        		}
        		else if(board[r][c]=='T')
        		{
        			board[r][c]='O';
        		}
        	}
        }
        
    }
    
    private static void markEdgeRegion(int row, int col, char[][] board)
    {
    	board[row][col]='T';
    	
    	int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    	
    	for(int[] dir : dirs)
    	{
    		int r=row+dir[0];
    		int c=col+dir[1];
    		
    		if(r<0||r>=board.length || c<0||c>=board[0].length || board[r][c]!='O')continue;
    		
    		markEdgeRegion(r,c,board);
    	}
    }
    
    
    public static boolean canFinish(int numCourses, int[][] prerequisites) 
    {
        Map<Integer, List<Integer>> preMap = new HashMap<>();
        Set<Integer> takingCourse = new HashSet<>();
        Set<Integer> finishedCourse = new HashSet<>();
        
        for(int i=0;i<numCourses;i++)
        {
        	preMap.put(i, new ArrayList<>());
        }
        
        for(int[] pre : prerequisites)
        {
        	preMap.get(pre[0]).add(pre[1]);
        }
        
        for(int i=0;i<numCourses;i++)
        {
        	if(!takeCourse(i, takingCourse, finishedCourse, preMap))
    		{
        		return false;
    		}
        }
        
        return true;
    }
    
    private static boolean takeCourse(int course, Set<Integer> takingCourse, Set<Integer> finishedCourse, Map<Integer, List<Integer>> preMap)
    {
    	if(takingCourse.contains(course))return false;
    	
    	if(finishedCourse.contains(course))return true;
    	
    	takingCourse.add(course);
    	
    	for(int preCourse:preMap.get(course))
    	{
    		if(!takeCourse(preCourse, takingCourse, finishedCourse, preMap))
    		{
    			return false;
    		}
    	}
    	
    	finishedCourse.add(course);
    	takingCourse.remove(course);
    	return true;
    }
    
    public static int[] findOrder(int numCourses, int[][] prerequisites) 
    {
        Map<Integer,List<Integer>> preMap = new HashMap<>();
        Set<Integer> taking = new HashSet<>();
        Set<Integer> finished = new HashSet<>();
        List<Integer> order = new ArrayList<>();
        
        for(int i=0;i<numCourses;i++)
        {
        	preMap.put(i, new ArrayList<>());
        }
        
        for(int[] pre:prerequisites)
        {
        	preMap.get(pre[0]).add(pre[1]);
        }
        
        int[] res = new int[numCourses];
        
        for(int i=0;i<numCourses;i++)
        {
        	if(!takingCourse(i, preMap, taking, finished, order))
        	{
        		return new int[] {};
        	}
        	
        	res[i] = order.get(i);
        }
        
        return res;
    }
    
    private static boolean takingCourse(int course, Map<Integer,List<Integer>> preMap, Set<Integer> taking, Set<Integer> finished, List<Integer> order)
    {
    	if(taking.contains(course))return false;
    	
    	if(finished.contains(course))return true;
    	
    	taking.add(course);
    	
    	for(int preCourse:preMap.get(course))
    	{
    		if(!takingCourse(preCourse, preMap, taking, finished, order))
    		{
    			return false;
    		}
    	}
    	
    	taking.remove(course);
    	finished.add(course);
    	order.add(course);
    	return true;
    }
    
    public static boolean validTree(int n, int[][] edges) 
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
    	
    	if(!traverse(0,-1,visited,adj))
    	{
    		return false;
    	}

    	return visited.size()==n;
    }
    
    private static boolean traverse(int node, int prevNode, Set<Integer> visited, List<List<Integer>> adj)
    {
    	if(visited.contains(node))return false;
    	
    	visited.add(node);
    	
    	for(int nextNode: adj.get(node))
    	{
    		if(nextNode==prevNode)continue;
    		
    		if(!traverse(nextNode, node, visited, adj))
    		{
    			return false;
    		}
    	}
    	return true;
    }
    
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
    			countComp(i,visited,adj);
    			res++;
    		}
    	}
    	
    	return res;
    }
    
    private static void countComp(int node, Set<Integer> visited, List<List<Integer>> adj)
    {
    	if(visited.contains(node))return;
    	
    	visited.add(node);
    	
    	for(int nextNode:adj.get(node))
    	{    		
    		countComp(nextNode,visited,adj);
    	}
    }
    
    
    public static int[] findRedundantConnection(int[][] edges) 
    {
    	int n=edges.length;
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
        	
        	visited.clear();
        	if(findCon(edge[0], -1, visited, adj))
        	{
        		return edge;
        	}
        }
        return new int[] {};
    }
    
    private static boolean findCon(int node, int prevNode, Set<Integer> visited, List<List<Integer>> adj) 
    {
    	if(visited.contains(node))return true;
    	
    	visited.add(node);
    	
    	for(int nextNode:adj.get(node))
    	{
    		if(nextNode==prevNode)continue;
    		
    		if(findCon(nextNode, node, visited, adj))
    		{
    			return true;
    		}
    	}
    	return false;
    }
    
	public static void main(String args[])
	{
//		char[][] grid = {
//		                 {'1','1','0','0','0'},
//		                 {'1','1','0','0','0'},
//		                 {'0','0','1','0','0'},
//		                 {'0','0','0','1','1'}
//						};
//		
//		System.out.println(numIslands(grid));
		
//		int[][] grid = {{0,1,1,0,1},
//		                {1,0,1,0,1},
//		                {0,1,1,0,1},
//		                {0,1,0,0,1}};
//		
//		System.out.println(maxAreaOfIsland(grid));
		
//		Node9 n1 = new Node9(1);
//		Node9 n2 = new Node9(2);
//		Node9 n3 = new Node9(3);
//		
//		n1.neighbors=new ArrayList<Node9>(Arrays.asList(n2));
//		n2.neighbors=new ArrayList<Node9>(Arrays.asList(n1,n3));
//		n3.neighbors=new ArrayList<Node9>(Arrays.asList(n2));
//		
//		System.out.println('BEFORE');
//		traverse(n1);
//		
//		System.out.println('AFTER');
//		Node9 copy = cloneGraphBFS(n1);
//		traverse(copy);
		
//		int[][] grid = {{2147483647,-1,0,2147483647},
//		                {2147483647,2147483647,2147483647,-1},
//		                {2147483647,-1,2147483647,-1},
//		                {0,-1,2147483647,2147483647}};
//		
//		islandsAndTreasure(grid);
//		
//		for(int r=0;r<grid.length;r++)
//		{
//			for(int c=0;c<grid[0].length;c++)
//			{
//				System.out.print(grid[r][c]+' ');
//			}
//			System.out.println();
//		}
		
//		int[][] grid = {{2,1,1},{0,1,1},{1,0,1}};
//		System.out.println(orangesRotting(grid));
		
//		int[][] heights = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
//		System.out.println(pacificAtlantic(heights).toString());
		
		
//		char[][] board = {
//							{'X','X','X','X'},
//							{'X','O','O','X'},
//							{'X','X','O','X'},
//							{'X','O','X','X'}
//							};
//		solve(board);
//		
//		for(int r=0;r<board.length;r++)
//		{
//			for(int c=0;c<board[0].length;c++)
//			{
//				System.out.print(board[r][c]);
//			}
//			System.out.println();
//		}
		
		
//		int numCourses=2;
//		int[][] prerequisites = {{1,0}};
//		System.out.println(canFinish(numCourses, prerequisites));
		
//		int numCourses=4;
//		int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
//		System.out.println(Arrays.toString(findOrder(numCourses, prerequisites)));
		
//		int n = 5;
//		int[][] edges = {{0,1},{0,2},{0,3},{1,4}};
//		System.out.println(validTree(n, edges));
		
//		int n = 6;
//		int[][] edges = {{0,1},{1,2},{2,3},{4,5}};
//		System.out.println(countComponents(n, edges));
		
		int[][] edges = {{1,2},{2,3},{3,4},{1,4},{1,5}};
		System.out.println(Arrays.toString(findRedundantConnection(edges)));
	}
	
}
