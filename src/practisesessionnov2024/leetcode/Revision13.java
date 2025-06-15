package practisesessionnov2024.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

class TimeMap4 {

	Map<String, TreeMap<Integer, String>> map;
	
    public TimeMap4() {
    	map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(map.containsKey(key))
        {
        	map.get(key).put(timestamp, value);
        }
        else
        {
        	TreeMap<Integer, String> newEntry = new TreeMap<>();
        	newEntry.put(timestamp, value);
        	map.put(key, newEntry);
        }
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key))return "";
        
        TreeMap<Integer, String> mapVal = map.get(key);
        
        Entry<Integer, String> entry = mapVal.floorEntry(timestamp);
        
        return entry!=null?entry.getValue():"";
    }
}

public class Revision13 {

    public static int binarySearch(int[] nums, int target) {
        int l=0, r=nums.length-1;
        
        while(l<=r)
        {
        	int m = (l+r)/2;
        	
        	if(target > nums[m])
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
    
    public static boolean searchMatrix(int[][] matrix, int target) 
    {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;
        
        int l=0, r=ROWS-1;
        
        while(l<=r)
        {
        	int m = (l+r)/2;
        	
        	if(target > matrix[m][COLS-1])
        	{
        		l=m+1;
        	}
        	else if(target < matrix[m][0])
        	{
        		r=m-1;
        	}
        	else
        	{
        		break;
        	}
        }
        
        int rowFound = (l+r)/2;
        
        l=0;
        r=COLS-1;
        
        while(l<=r)
        {
        	int m=(l+r)/2;
        	
        	if(target > matrix[rowFound][m])
        	{
        		l=m+1;
        	}
        	else if(target < matrix[rowFound][m])
        	{
        		r=m-1;
        	}
        	else
        	{
        		return true;
        	}
        }
        
        return false;
    }
    
    public static int minEatingSpeed(int[] piles, int h) {
        int l=0;
        int r=Integer.MIN_VALUE;
        
        for(int n:piles)
        {
        	if(n>r)
        	{
        		r=n;
        	}
        }
        
        int res = Integer.MAX_VALUE;
        
        while(l<=r)
        {
        	int k=(l+r)/2;
        	
        	long totalTime=0;
        	for(int n:piles)
        	{
        		totalTime+=Math.ceil((double)n/k);
        	}
        	
        	if(totalTime<=h)
        	{
        		res=k;
        		r=k-1;
        	}
        	else
        	{
        		l=k+1;
        	}
        }
        
        return res;
    }
    
    public static int findMin(int[] nums) {
        int l=0, r=nums.length-1;
        
        while(l<r)
        {
        	int m = (l+r)/2;
        	
        	if(nums[m]>nums[r])
        	{
        		l=m+1;
        	}
        	else
        	{
        		r=m;
        	}
        }
        
        return nums[l];
    }
    
    public static int search(int[] nums, int target) {
        int l=0, r=nums.length-1;
        
        while(l<r)
        {
        	int m = (l+r)/2;
        	
        	if(nums[m]>nums[r])
        	{
        		l=m+1;
        	}
        	else
        	{
        		r=m;
        	}
        }
        
        int minIdx = l;
        
        l=0;
        r=nums.length-1;
        
        if(target==nums[minIdx])return minIdx;
        
        if(target>nums[minIdx] && target<=nums[r])
        {
        	l=minIdx+1;
        }
        else if(target<nums[minIdx] && target>=nums[l])
        {
        	r=minIdx-1;
        }
        
        while(l<=r)
        {
        	int m = (l+r)/2;
        	
        	if(target > nums[m])
        	{
        		l=m+1;
        	}
        	else if(target< nums[m])
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
//		int[] nums = {-1,0,3,5,9,12};
//		int target=12;
//		System.out.println(binarySearch(nums, target));
		
//		int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
//		int target=35;
//		System.out.println(searchMatrix(matrix, target));
		
//		int[] piles = {30,11,23,4,20};
//		int h=6;
//		System.out.println(minEatingSpeed(piles, h));
		
//		int[] nums = {3,4,5,1,2};
//		System.out.println(findMin(nums));
		
//		int[] nums = {1};
//		int target = 3;
//		System.out.println(search(nums, target));
		
//		TimeMap4 timeMap = new TimeMap4();
//		timeMap.set("foo", "bar", 1);  // store the key "foo" and value "bar" along with timestamp = 1.
//		System.out.println(timeMap.get("foo", 1));         // return "bar"
//		System.out.println(timeMap.get("foo", 3));        // return "bar", since
//		timeMap.set("foo", "bar2", 4); // store the key "foo" and value "bar2" along with timestamp = 4.
//		System.out.println(timeMap.get("foo", 4));         // return "bar2"
//		System.out.println(timeMap.get("foo", 5));         // return "bar2"
		
//		int[] nums={3,8,2,5,7,6,12};
//		int w=4;
//		System.out.println(maxSumSubarrayFL(nums, w));
		
//		int[] prices={7,6,4,3,1};
//		System.out.println(maxProfit(prices));
		
//		int[] nums= {1,4,4};
//		int target=4;
//		System.out.println(minSubArrayLen(target, nums));
		
//		String s = "bbbbb";
//		System.out.println(lengthOfLongestSubstring(s));
		
//		String s = "AABABBA";
//		int k = 1;
//		System.out.println(characterReplacement(s, k));
		
//		String s1 = "ab", s2 = "eidboaoo";
//		System.out.println(checkInclusion(s1, s2));
	}
}
