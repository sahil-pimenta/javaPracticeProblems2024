package practisesessionnov2024.leetcode;

public class LeetCode22SearchInRotatedSortedArray {
	
    public static int search(int[] nums, int target) {
        int l=0,r=nums.length-1;
        
        while(l<r)
        {
        	int m=(l+r)/2;
        	
        	if(nums[m]> nums[r])
        	{
        		l=m+1;
        	}
        	else
        	{
        		r=m;
        	}
        }
        
        int minIdx=l;
        
        if(nums[minIdx]==target)
        {
        	return minIdx;
        }
    	
        l=0;
        r=nums.length-1;
        
        if(target>=nums[minIdx] && target<=nums[r])
        {
        	l=minIdx;
        }
        else
        {
        	r=minIdx-1;
        }
        
        while(l<=r)
        {
        	int m=(l+r)/2;
        	
        	if(target>nums[m])
        	{
        		l=m+1;
        	}
        	else if(target<nums[m])
        	{
        		r=m-1;
        	}
        	else
        	{
        		return m;
        	}
        }
        
        return -1;
    }
    
	public static void main(String args[])
	{
		int[] nums = {3,4,5,6,1,2};
		int target = 1;
		System.out.println(search(nums, target));
	}
}
