package practisesessionnov2024.leetcode;

public class LeetCode17ContainerWithMostWater {

    public static int maxAreaBruteForce(int[] heights) 
    {
    	int maxArea=0;
    	
    	for(int i=0;i<heights.length;i++)
    	{
    		for(int j=i+1;j<heights.length;j++)
    		{
    			maxArea = Math.max((Math.min(heights[i], heights[j]))*(j-i), maxArea);
    		}
    	}
    	return maxArea;
    }
    
    public static int maxArea(int[] heights) {
    	int maxArea=0;
    	int l=0;
    	int r=heights.length-1;
    	
    	while(l<r)
    	{
    		int area = (Math.min(heights[l], heights[r])) * (r-l);
    		maxArea=Math.max(maxArea, area);
    		
    		if(heights[l]<=heights[r])
    		{
    			l++;
    		}
    		else
    		{
    			r--;
    		}
    	}
    	
    	return maxArea;
    }
    
	public static void main(String args[])
	{
		int [] height = {1,8,6,2,5,4,8,3,7};
		System.out.println(maxArea(height));
	}
}
