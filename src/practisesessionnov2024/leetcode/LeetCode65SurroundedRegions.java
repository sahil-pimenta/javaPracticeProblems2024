package practisesessionnov2024.leetcode;

public class LeetCode65SurroundedRegions 
{
    public static void solve(char[][] board) 
    {
        int ROWS=board.length;
        int COLS=board[0].length;
        
        //Check every cell on borders for 'O'
        //and mark are regions connected to border as 'T',
        //then mark the remaining 'O's as 'X' (capturing them)
        //and replace 'T' back to 'O' 
        
        
        //1st and last Rows
        for(int c=0;c<COLS;c++)
        {
        	if(board[0][c]=='O')
        	{
        		markUnwantedRegions(board, 0, c);
        	}
        	
        	if(board[ROWS-1][c]=='O')
        	{
        		markUnwantedRegions(board, ROWS-1, c);
        	}
        }
        
        
        //1st and last Cols
        for(int r=0;r<ROWS;r++)
        {
        	if(board[r][0]=='O')
        	{
        		markUnwantedRegions(board, r, 0);
        	}
        	
        	if(board[r][COLS-1]=='O')
        	{
        		markUnwantedRegions(board, r, COLS-1);
        	}
        }
        
        
        //Replace all remaining 'O's (valid regions) with 'X's (capturing them) and replace all 'T's back to 'O's
        
        for(int r=0;r<ROWS;r++)
        {
        	for(int c=0;c<COLS;c++)
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
    
    private static void markUnwantedRegions(char[][] board, int row, int col)
    {
    	board[row][col]='T';
    	
    	int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    	
    	for(int[] dir : dirs)
    	{
    		int r=row+dir[0];
    		int c=col+dir[1];
    		
    		if(r<0||r>=board.length
    				||c<0||c>=board[0].length
    				||board[r][c]!='O')
    		{
    			continue;
    		}
    		
    		markUnwantedRegions(board, r, c);
    	}
    	
    }
	
	public static void main(String args[])
	{
		char[][] board = {
				{'X','X','X','X'},
				{'X','O','O','X'},
				{'X','X','O','X'},
				{'X','O','X','X'}
				};
		
		solve(board);
		
		for(int r=0;r<board.length;r++)
		{
			for(int c=0;c<board[0].length;c++)
			{
				System.out.print(board[r][c]+" ");
			}
			System.out.println();
		}
		
	}
}
