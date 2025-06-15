package practisesessionnov2024.leetcode;

public class LeetCode60MaxAreaOfIsland {

	int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
	
    public int maxAreaOfIsland(int[][] grid) 
    {
        int ROWS=grid.length;
        int COLS=grid[0].length;
        
        int maxArea=0;
        
        for(int r=0;r<ROWS;r++)
        {
        	for(int c=0;c<COLS;c++)
        	{
        		if(grid[r][c]==1)
        		{
        			int area=islandArea(grid, 0, r, c);
        			maxArea=Math.max(maxArea, area);
        		}
        	}
        }
        
        return maxArea;
    }
    
    private int islandArea(int[][] grid, int area, int r, int c)
    {
    	if(r<0||r>=grid.length || c<0||c>=grid[0].length || grid[r][c]==0)return area;
    	
    	area++;
    	grid[r][c]=0;
    	
    	for(int[] move: directions)
    	{
    		area = islandArea(grid, area, r+move[0], c+move[1]);
    	}
    	
    	return area;
    }
	
	public static void main(String args[])
	{
		int[][] grid = {
				{0,0,1,0,0,0,0,1,0,0,0,0,0},
				{0,0,0,0,0,0,0,1,1,1,0,0,0},
				{0,1,1,0,1,0,0,0,0,0,0,0,0},
				{0,1,0,0,1,1,0,0,1,0,1,0,0},
				{0,1,0,0,1,1,0,0,1,1,1,0,0},
				{0,0,0,0,0,0,0,0,0,0,1,0,0},
				{0,0,0,0,0,0,0,1,1,1,0,0,0},
				{0,0,0,0,0,0,0,1,1,0,0,0,0}
				};
		
		System.out.println(new LeetCode60MaxAreaOfIsland().maxAreaOfIsland(grid));
	}
}
