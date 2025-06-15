package practisesessionnov2024.leetcode;

public class LeetCode35FindDuplicateNo {

    public static int findDuplicate(int[] nums) {
        int slow=0;
        int fast=0;
        
        while(true)
        {
        	slow=nums[slow];
        	fast=nums[nums[fast]];
        	if(slow==fast)break;
        }
        
        int slow2=0;
        while(true)
        {
        	slow=nums[slow];
        	slow2=nums[slow2];
        	if(slow==slow2)
        	{
        		return slow;
        	}
        }
    }
	
	public static void main(String args[])
	{
		int[] nums = {1,2,3,2,2};
		System.out.println(findDuplicate(nums));
	}
}
