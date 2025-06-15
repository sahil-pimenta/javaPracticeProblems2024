package practisesessionnov2024.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Revision14 {

    public static List<List<Integer>> subsets(int[] nums) 
    {
    	List<List<Integer>> res = new ArrayList<>();
    	subsetsHelper(nums, 0, new ArrayList<>(), res);
    	return res;
    }
    
    private static void subsetsHelper(int[] nums, int i, List<Integer> subset, List<List<Integer>> res)
    {
    	if(i==nums.length)
    	{
    		res.add(new ArrayList<>(subset));
    		return;
    	}
    	
    	subset.add(nums[i]);
    	subsetsHelper(nums, i+1, subset, res);
    	subset.remove(subset.size()-1);
    	subsetsHelper(nums, i+1, subset, res);
    }
    
    public static List<List<Integer>> combinationSum(int[] nums, int target) 
    {
    	List<List<Integer>> res = new ArrayList<>();
    	csHelper(nums, 0, 0, target, new ArrayList<>(), res);
    	return res;
    }
    
    private static void csHelper(int[] nums, int i, int sum, int target, List<Integer> comb, List<List<Integer>> res)
    {
    	if(sum==target)
    	{
    		res.add(new ArrayList<>(comb));
    		return;
    	}
    	
    	if(i>=nums.length || sum>target)return;
    	
    	comb.add(nums[i]);
    	csHelper(nums, i, sum+nums[i], target, comb, res);
    	comb.remove(comb.size()-1);
    	csHelper(nums, i+1, sum, target, comb, res);
    }
    
    public static List<List<Integer>> combinationSum2(int[] nums, int target) 
    {
    	List<List<Integer>> res = new ArrayList<>();
    	Arrays.sort(nums);
    	cs2Helper(nums, 0, 0, target, new ArrayList<>(), res);
    	return res;
    }
	
    private static void cs2Helper(int[] nums, int i, int sum, int target, List<Integer> comb, List<List<Integer>> res)
    {
    	if(sum==target)
    	{
    		res.add(new ArrayList<>(comb));
    		return;
    	}
    	
    	if(i>=nums.length || sum>target)return;
    	
    	comb.add(nums[i]);
    	cs2Helper(nums, i+1, sum+nums[i], target, comb, res);
    	
    	comb.remove(comb.size()-1);
    	
    	while(i+1<nums.length && nums[i]==nums[i+1])
    	{
    		i++;
    	}
    	cs2Helper(nums, i+1, sum, target, comb, res);
    }
    
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permuteHelper(nums, new boolean[nums.length], new ArrayList<>(), res);
        return res;
    }
    
    private static void permuteHelper(int[] nums, boolean[] picked, List<Integer> perm, List<List<Integer>> res)
    {
    	if(perm.size()==nums.length)
    	{
    		res.add(new ArrayList<>(perm));
    		return;
    	}
    	
    	for(int i=0;i<nums.length;i++)
    	{
    		if(!picked[i])
    		{
    			perm.add(nums[i]);
    			picked[i]=true;
    			permuteHelper(nums, picked, perm, res);
    			perm.remove(perm.size()-1);
    			picked[i]=false;
    		}
    	}
    }
    
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
    	List<List<Integer>> res = new ArrayList<>();
    	Arrays.sort(nums);
    	sdHelper(nums, 0, new ArrayList<>(),res);
    	return res;
    }
    
    private static void sdHelper(int[] nums, int i, List<Integer> comb, List<List<Integer>> res)
    {
    	if(i==nums.length)
    	{
    		res.add(new ArrayList<>(comb));
    		return;
    	}
    	
    	comb.add(nums[i]);
    	sdHelper(nums, i+1, comb, res);
    	comb.remove(comb.size()-1);
    	
    	while(i+1<nums.length && nums[i]==nums[i+1])
    	{
    		i++;
    	}
    	sdHelper(nums, i+1, comb, res);
    }
    
    public static boolean exist(char[][] board, String word) 
    {
        int ROW = board.length;
        int COL = board[0].length;
        boolean[][] visited = new boolean[ROW][COL];
        
        for(int r=0;r<ROW;r++)
        {
        	for(int c=0;c<COL;c++)
        	{
        		if(existHelper(board, 0, r, c, word, visited))
        		{
        			return true;
        		}
        	}
        }
        
        return false;
    }
    
    private static boolean existHelper(char[][] board, int i, int r, int c, String word, boolean[][] visited)
    {
    	if(i==word.length())
    	{
    		return true;
    	}
    	
    	if(r<0||r>=board.length || c<0||c>=board[0].length 
    			|| visited[r][c] || board[r][c]!=word.charAt(i))return false;
    	
    	visited[r][c]=true;
    	
    	boolean res = existHelper(board, i+1, r+1, c, word, visited) ||
    			existHelper(board, i+1, r-1, c, word, visited) ||
    			existHelper(board, i+1, r, c+1, word, visited) ||
    			existHelper(board, i+1, r, c-1, word, visited);
    	
    	visited[r][c]=false;
    	return res;
    }
    
    public static List<List<String>> partition(String s) {
    	List<List<String>> res = new ArrayList<>();
    	partHelper(s, 0, new ArrayList<>(), res);
    	return res;
    }
    
    private static void partHelper(String s, int i, List<String> part, List<List<String>> res)
    {
    	if(i==s.length())
    	{
    		res.add(new ArrayList<>(part));
    		return;
    	}
    	
    	for(int j=i;j<s.length();j++)
    	{
    		if(isPalindrome(s, i, j))
    		{
    			part.add(s.substring(i, j+1));
    			partHelper(s, j+1, part, res);
    			part.remove(part.size()-1);
    		}
    	}
    }
    
    private static boolean isPalindrome(String s, int l, int r)
    {
    	while(l<r)
    	{
    		if(s.charAt(l)!=s.charAt(r))return false;
    		l++;
    		r--;
    	}
    	return true;
    }
    
    public static List<String> letterCombinations(String digits) {
    	List<String> res = new ArrayList<>();
    	String[] map= {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    	lcHelper(digits, 0, map, "", res);
    	return res;
    }
    
    private static void lcHelper(String digits, int i, String[] map, String comb, List<String> res)
    {
    	if(comb.length()==digits.length())
    	{
    		res.add(comb);
    		return;
    	}
    	
    	String digitChars = map[digits.charAt(i)-'0'];
    	for(char c:digitChars.toCharArray())
    	{
    		lcHelper(digits, i+1, map, comb+c, res);
    	}
    }
    
    public static int numIslands(char[][] grid) 
    {
        int ROW=grid.length;
        int COL=grid[0].length;
        
        int islands=0;
        
        for(int r=0;r<ROW;r++)
        {
        	for(int c=0;c<COL;c++)
        	{
        		if(grid[r][c]=='1')
        		{
        			numIslandsHelper(grid, r, c);
        			islands++;
        		}
        	}
        }
        
        return islands;
    }
    
    private static void numIslandsHelper(char[][] grid, int row, int col)
    {
    	if(grid[row][col]!='1')
    	{
    		return;
    	}
    	
    	grid[row][col]='0';
    	
    	int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    	
    	for(int[] dir:dirs)
    	{
    		int r=row+dir[0];
    		int c=col+dir[1];
    		
    		if(r<0||r>=grid.length || c<0||c>=grid[0].length || grid[r][c]!='1')continue;
    		numIslandsHelper(grid, r, c);
    	}
    }
    
    public static int maxAreaOfIsland(int[][] grid) {
        int ROW=grid.length;
        int COL=grid[0].length;
        
        int maxArea=0;
        
        for(int r=0;r<ROW;r++)
        {
        	for(int c=0;c<COL;c++)
        	{
        		if(grid[r][c]==1)
        		{
        			int area = maxAreaHelper(grid, r, c, 0);
        			maxArea=Math.max(area, maxArea);
        		}
        	}
        }
        return maxArea;
    }
    
    private static int maxAreaHelper(int[][] grid, int row, int col, int area)
    {
    	if(grid[row][col]!=1)return 0;
    	
    	area++;
    	grid[row][col]=0;
    	int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    	
    	for(int[] dir:dirs)
    	{
    		int r=row+dir[0];
    		int c=col+dir[1];
    		
    		if(r<0||r>=grid.length || c<0||c>=grid[0].length || grid[r][c]!=1)continue;
    		
    		area=maxAreaHelper(grid, r, c, area);
    	}
    	return area;
    }
    
	public static void main(String args[])
	{
//		int[] nums = {1,2,3};
//		System.out.println(subsets(nums).toString());
		
//		int[] nums = {2,3,6,7};
//		int target = 7;
//		System.out.println(combinationSum(nums, target).toString());
		
//		int[] nums = {10,1,2,7,6,1,5};
//		int target = 8;
//		System.out.println(combinationSum2(nums, target).toString());
		
//		int[] nums = {1,2,3};
//		System.out.println(permute(nums).toString());
		
//		int[] nums = {1,2,2};
//		System.out.println(subsetsWithDup(nums).toString());
		
//		char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//		String word = "ABCCEE";
//		System.out.println(exist(board, word));
		
//		String s = "aab";
//		System.out.println(partition(s).toString());
		
//		String digits = "23";
//		System.out.println(letterCombinations(digits).toString());
		
//		char[][] grid = { 
//				{ '1', '1', '1', '1', '0' },
//				{ '1', '1', '0', '1', '0' }, 
//				{ '1', '1', '0', '0', '0' },
//				{ '0', '0', '0', '0', '0' } };
//		System.out.println(numIslands(grid));
		
		int[][] grid = {
				{0,0,1,0,0,0,0,1,0,0,0,0,0},
				{0,0,0,0,0,0,0,1,1,1,0,0,0},
				{0,1,1,0,1,0,0,0,0,0,0,0,0},
				{0,1,0,0,1,1,0,0,1,0,1,0,0},
				{0,1,0,0,1,1,0,0,1,1,1,0,0},
				{0,0,0,0,0,0,0,0,0,0,1,0,0},
				{0,0,0,0,0,0,0,1,1,1,0,0,0},
				{0,0,0,0,0,0,0,1,1,0,0,0,0}};
		System.out.println(maxAreaOfIsland(grid));
	}
}
