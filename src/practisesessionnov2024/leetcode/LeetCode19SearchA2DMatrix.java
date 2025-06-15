package practisesessionnov2024.leetcode;

public class LeetCode19SearchA2DMatrix {

    public static boolean searchMatrixBruteForce(int[][] matrix, int target) {
        
    	for(int m=0;m<matrix.length;m++)
    	{
    		for(int n=0;n<matrix[m].length;n++)
    		{
    			if(matrix[m][n]==target)
    			{
    				return true;
    			}
    		}
    	}
    	return false;
    }
    
    public static boolean searchMatrix(int[][] matrix, int target) {
    	int rows=matrix.length;
    	int columns=matrix[0].length;
    	
    	int top=0,bottom=rows-1;
    	while(top<=bottom)
    	{
    		int mid=(top+bottom)/2;
    		if(target>matrix[mid][columns-1])
    		{
    			top=mid+1;
    		}
    		else if(target<matrix[mid][0])
    		{
    			bottom=mid-1;
    		}
    		else
    		{
    			break;
    		}
    	}
    	
    	if(!(top<=bottom))
    	{
    		return false;
    	}
    	
    	int row=(top+bottom)/2;
    	int l=0,r=columns-1;
    	
    	while(l<=r)
    	{
    		int mid=(l+r)/2;
    		
    		if(target>matrix[row][mid])
    		{
    			l=mid+1;
    		}
    		else if(target<matrix[row][mid])
    		{
    			r=mid-1;
    		}
    		else{
    			return true;
    		}
    	}
    	
    	return false;
    }
	
	public static void main(String args[])
	{
		int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
		int target = 3;
		System.out.println(searchMatrix(matrix, target));
	}
}
