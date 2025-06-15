package practisesessionnov2024.leetcode;

public class LeetCode18BinarySearch {

    public static int search(int[] nums, int target) {
        int low=0;
        int high=nums.length-1;
        
        while(low<=high)
        {
        	int mid=low+(high-low)/2;
        	
        	if(nums[mid]>target)
        	{
        		high=mid-1;
        	}
        	else if(nums[mid]<target)
        	{
        		low=mid+1;
        	}
        	else
        	{
        		return mid;
        	}
        }
        return -1;
    }
    
    public static void main(String args[])
    {
    	int[] nums = {-1,0,2,4,6,8};
    	int target = 4;
    	System.out.println(search(nums, target));
    }
}
