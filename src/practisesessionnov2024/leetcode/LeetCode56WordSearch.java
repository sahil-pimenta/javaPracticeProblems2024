package practisesessionnov2024.leetcode;

public class LeetCode56WordSearch 
{
	int ROWS;
	int COLS;
	boolean[][] visited;
	
    public boolean exist(char[][] board, String word) 
    {
        ROWS=board.length;
        COLS=board[0].length;
        visited=new boolean[ROWS][COLS];
        
        for(int r=0;r<ROWS;r++)
        {
        	for(int c=0;c<COLS;c++)
        	{
        		if(find(board,word,r,c,0))return true;
        	}
        }
        
        return false;
    }
    
    private boolean find(char[][] board, String word, int r, int c, int i)
    {
    	if(i==word.length())return true;
    	
    	if(r<0||r>=ROWS || c<0||c>=COLS || board[r][c]!=word.charAt(i) || visited[r][c])
    	{
    		return false;
    	}
    	
    	visited[r][c]=true;
    	boolean res = find(board,word,r+1,c,i+1) ||
    			find(board,word,r-1,c,i+1) ||
    			find(board,word,r,c+1,i+1) ||
    			find(board,word,r,c-1,i+1);
    	
    	visited[r][c]=false;
    	
    	return res;
    }
	
	public static void main(String args[])
	{
		char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		String word="DECCBA";
		System.out.println(new LeetCode56WordSearch().exist(board, word));
	}
}
