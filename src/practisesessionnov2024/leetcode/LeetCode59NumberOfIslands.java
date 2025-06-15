package practisesessionnov2024.leetcode;

public class LeetCode59NumberOfIslands {

    public static int numIslands(char[][] grid) 
    {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        
        int islands=0;
        
        for(int r=0;r<ROWS;r++)
        {
        	for(int c=0;c<COLS;c++)
        	{
        		if(grid[r][c]=='1')
        		{
        			checkIslands(grid, r, c);
        			islands++;
        		}
        	}
        }
        
        return islands;
    }
    
    private static void checkIslands(char[][] grid, int r, int c)
    {
    	if(r<0||r>=grid.length || c<0||c>=grid[0].length || grid[r][c]=='0')return;
    	
    	grid[r][c]='0';
    	checkIslands(grid, r+1, c);
    	checkIslands(grid, r-1, c);
    	checkIslands(grid, r, c+1);
    	checkIslands(grid, r, c-1);
    }
	
	public static void main(String args[])
	{
		char[][] grid = {
				{'1','1','1','1','0'},
				{'1','1','0','1','0'},
				{'1','1','0','0','0'},
				{'0','0','0','0','0'}
				};
		
		System.out.println(numIslands(grid));
	}
}
