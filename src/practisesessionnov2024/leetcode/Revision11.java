package practisesessionnov2024.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Revision11 {

    public static List<List<Integer>> subsets(int[] nums) 
    {
        List<List<Integer>> res = new ArrayList<>();
        subsetsHelper(nums, 0, new ArrayList<Integer>(), res);
        return res;
    }
    
    private static void subsetsHelper(int[] nums, int i, List<Integer> subset, List<List<Integer>> res)
    {
    	if(i>=nums.length)
    	{
    		res.add(new ArrayList<>(subset));
    		return;
    	}
    	
    	subset.add(nums[i]);
    	subsetsHelper(nums, i+1, subset, res);
    	
    	subset.remove(subset.size()-1);
    	subsetsHelper(nums, i+1, subset, res);
    }
    
    
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        csHelper(candidates, 0, 0, target, new ArrayList<Integer>(), res);
        return res;
    }
    
    private static void csHelper(int[] candidates, int i, int sum, int target, List<Integer> comb, List<List<Integer>> res)
    {
    	if(sum==target)
    	{
    		res.add(new ArrayList<>(comb));
    		return;
    	}
    	
    	if(i>=candidates.length || sum>target)return;
    	
    	comb.add(candidates[i]);
    	csHelper(candidates, i, sum+candidates[i], target, comb, res);
    	
    	comb.remove(comb.size()-1);
    	csHelper(candidates, i+1, sum, target, comb, res);
    }
    
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        
        cs2Helper(candidates, 0, 0, target, new ArrayList<Integer>(), res);
        return res;
    }
    
    private static void cs2Helper(int[] candidates, int i, int sum, int target, List<Integer> comb, List<List<Integer>> res)
    {
    	if(sum==target)
    	{
    		res.add(new ArrayList<>(comb));
    		return;
    	}
    	
    	if(sum>target || i>=candidates.length)return;
    	
    	comb.add(candidates[i]);
    	cs2Helper(candidates, i+1, sum+candidates[i], target, comb, res);
    	
    	comb.remove(comb.size()-1);
    	
    	while(i+1 < candidates.length && candidates[i]==candidates[i+1])
    	{
    		i++;
    	}
    	
    	cs2Helper(candidates, i+1, sum, target, comb, res);
    }
    
    
    public static List<List<Integer>> permute(int[] nums) 
    {
        List<List<Integer>> res = new ArrayList<>();
        permuteHelper(nums, new boolean[nums.length], new ArrayList<Integer>(), res);
        return res;
    }
    
    private static void permuteHelper(int[] nums, boolean[] pick, List<Integer> perm, List<List<Integer>> res)
    {
    	if(perm.size()==nums.length)
    	{
    		res.add(new ArrayList<>(perm));
    		return;
    	}
    	
    	for(int i=0;i<nums.length;i++)
    	{
    		if(!pick[i])
    		{
    			perm.add(nums[i]);
    			pick[i]=true;
    			permuteHelper(nums, pick, perm, res);
    			
    			perm.remove(perm.size()-1);
    			pick[i]=false;
    		}
    	}
    }
    
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        sub2Helper(nums, 0, new ArrayList<Integer>(), res);
        return res;
    }
    
    private static void sub2Helper(int[] nums, int i, List<Integer> sub, List<List<Integer>> res)
    {
    	if(i>=nums.length)
    	{
    		res.add(new ArrayList<>(sub));
    		return;
    	}
    	
    	sub.add(nums[i]);
    	sub2Helper(nums, i+1, sub, res);
    	
    	sub.remove(sub.size()-1);
    	
    	while(i+1 < nums.length && nums[i]==nums[i+1])
    	{
    		i++;
    	}
    	sub2Helper(nums, i+1, sub, res);
    }
    
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
        		if(search(board, word, 0, r, c))
        		{
        			return true;
        		}
        	}
        }
        return false;
    }
    
    private boolean search(char[][] board, String word, int i, int r, int c)
    {
    	if(i>=word.length())return true;
    	
    	if(r<0||r>=ROWS || c<0||c>=COLS || board[r][c]!=word.charAt(i) || visited[r][c])
    	{
    		return false;
    	}
    	
    	visited[r][c]=true;
    	boolean res = search(board, word, i+1, r-1, c) ||
    			search(board, word, i+1, r+1, c) ||
    			search(board, word, i+1, r, c-1) ||
    			search(board, word, i+1, r, c+1);
    	visited[r][c]=false;
    	
    	return res;
    }
    
    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        partHelper(s,0,new ArrayList<String>(), res);
        return res;
    }
    
    private static void partHelper(String s, int i, List<String> part, List<List<String>> res)
    {
    	if(i>=s.length())
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
    
    String [] digitsToChars = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    public List<String> letterCombinations(String digits) 
    {
    	if(digits.isEmpty())return new ArrayList<>();
    	
        List<String> res = new ArrayList<>();
        letterComb(digits, 0, "", res);
        return res;
    }
    
    private void letterComb(String digits, int i, String comb, List<String> res)
    {
    	if(comb.length()==digits.length())
    	{
    		res.add(comb);
    		return;
    	}
    	
    	String digitChars = digitsToChars[digits.charAt(i)-'0'];
    	for(char c: digitChars.toCharArray())
    	{
    		letterComb(digits, i+1, comb+c, res);
    	}
    }
    
	public static void main(String args[])
	{
//		int[] nums= {1,2,3};
//		System.out.println(subsets(nums).toString());
		
//		int[] candidates= {10,1,2,7,6,1,5};
//		int target=8;
//		System.out.println(combinationSum2(candidates,target).toString());
		
//		int[] nums= {1,2,2};
//		System.out.println(subsetsWithDup(nums).toString());
		
//		char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//		String word="DECCBAA";
//		System.out.println(new Revision11().exist(board, word));
		
//		String s = "aab";
//		System.out.println(partition(s).toString());
		
		String digits = "23";
		System.out.println(new Revision11().letterCombinations(digits).toString());
	}
}
