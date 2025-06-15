package practisesessionnov2024.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode64PacificAtlanticWaterFlow {

    public static List<List<Integer>> pacificAtlantic(int[][] heights) 
    {
        int ROWS=heights.length;
        int COLS=heights[0].length;
        boolean[][] pacific=new boolean[ROWS][COLS];
        boolean[][] atlantic=new boolean[ROWS][COLS];
        
        //Going through each cell in 1st Row since its adjacent to pacific
        for(int c=0;c<COLS;c++)
        {
        	pathToOcean(heights, 0, c, pacific);
        }
        
        //Going through each cell in last Row since its adjacent to atlantic
        for(int c=0;c<COLS;c++)
        {
        	pathToOcean(heights, ROWS-1, c, atlantic);
        }
        
        //Going through each cell in 1st Column since its adjacent to pacific
        for(int r=0;r<ROWS;r++)
        {
        	pathToOcean(heights, r, 0, pacific);
        }
        
        //Going through each cell in last Column since its adjacent to atlantic
        for(int r=0;r<ROWS;r++)
        {
        	pathToOcean(heights, r, COLS-1, atlantic);
        }
        
        
        //Solution is the common cells between pacific and atlantic
        List<List<Integer>> res = new ArrayList<>();
        for(int r=0;r<ROWS;r++)
        {
        	for(int c=0;c<COLS;c++)
        	{
        		if(pacific[r][c] && atlantic[r][c])
        		{
        			res.add(Arrays.asList(r,c));
        		}
        	}
        }
        
        return res;
    }
    
    private static void pathToOcean(int[][] heights, int row, int col, boolean[][] visited)
    {
    	visited[row][col]=true;
    	
    	int[][]dirs={{1,0},{-1,0},{0,1},{0,-1}};
    	
    	for(int[] dir : dirs)
    	{
    		int r=row+dir[0];
    		int c=col+dir[1];
    		
    		// row and col should not be out of bounds and new cell's height should be >= prev cell
    		if(r<0||r>=heights.length 
    			|| c<0||c>=heights[0].length 
    			|| visited[r][c] 
    			|| heights[r][c]<heights[row][col])
    			continue;
    		
    		pathToOcean(heights, r, c, visited);
    	}
    }
	
	public static void main(String args[])
	{
		int[][] heights = {
				{1,2,2,3,5},
				{3,2,3,4,4},
				{2,4,5,3,1},
				{6,7,1,4,5},
				{5,1,1,2,4}
				};
		
		System.out.println(pacificAtlantic(heights).toString());
	}
}
