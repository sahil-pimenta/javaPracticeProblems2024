package practisesessionnov2024.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode63RottingOranges {

    public static int orangesRotting(int[][] grid) 
    {
        int ROWS=grid.length;
        int COLS=grid[0].length;
        int fresh=0;
        int time=0;
        Queue<int[]> q = new LinkedList<>();
        
        for(int r=0;r<ROWS;r++)
        {
        	for(int c=0;c<COLS;c++)
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
        		int[] node = q.poll();
        		int row = node[0];
        		int col = node[1];
        		
        		for(int[] dir : dirs)
        		{
        			int r=row+dir[0];
        			int c=col+dir[1];
        			
        			if(r<0||r>=ROWS||c<0||c>=COLS||grid[r][c]!=1)continue;
        			
        			grid[r][c]=2;
        			q.offer(new int[] {r,c});
        			fresh--;
        		}
        	}
        	time++;
        }
        
        return fresh==0?time:-1;
    }
	
	public static void main(String args[])
	{
		int[][] grid = {{2,1,1},
						{1,1,0},
						{0,1,1}};
		
		System.out.println(orangesRotting(grid));
	}
}
