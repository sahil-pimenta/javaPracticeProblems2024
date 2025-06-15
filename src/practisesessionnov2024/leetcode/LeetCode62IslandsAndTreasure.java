package practisesessionnov2024.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode62IslandsAndTreasure 
{
    public static void islandsAndTreasure(int[][] grid) 
    {
        int ROWS=grid.length;
        int COLS=grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        
        for(int r=0;r<ROWS;r++)
        {
        	for(int c=0;c<COLS;c++)
        	{
        		if(grid[r][c]==0)
        		{
        			q.add(new int[] {r, c});
        		}
        	}
        }
        
        if(q.size()==0)return;
        
        int[][] dirs= {{1,0},{-1,0},{0,1},{0,-1}};
        
        while(!q.isEmpty())
        {
        	int[] node=q.poll();
        	int row=node[0];
        	int col=node[1];
        	
        	for(int[] dir : dirs)
        	{
        		int r = row+dir[0];
        		int c = col+dir[1];
        		
        		if(r<0||r>=grid.length || c<0||c>=grid[0].length || grid[r][c]!=2147483647)continue;
        		
        		q.add(new int[] {r, c});
        		grid[r][c] = grid[row][col]+1;
        	}
        }
    }
	
	public static void main(String args[])
	{
		int[][] grid = {
		                {2147483647,-1,0,2147483647},
		                {2147483647,2147483647,2147483647,-1},
		                {2147483647,-1,2147483647,-1},
		                {0,-1,2147483647,2147483647}
		              };
		
		islandsAndTreasure(grid);
		
		for(int r=0;r<grid.length;r++)
		{
			for(int c=0;c<grid[0].length;c++)
			{
				System.out.print(grid[r][c]+" ");
			}
			System.out.println();
		}
		
	}
}
