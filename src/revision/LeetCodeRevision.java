package revision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LeetCodeRevision {

	public static boolean containsDuplicate(int[] nums)
	{
		Set<Integer> numsSet = new HashSet<Integer>();
		
		for(int n : nums)
		{
			if(numsSet.contains(n))
			{
				return true;
			}
			
			numsSet.add(n);
		}
		return false;
	}
	
	
	public static int[] twoSum(int[] nums, int target)
	{
		Map<Integer,Integer> numsMap = new HashMap<Integer, Integer>();
		
		for(int i=0;i<nums.length; i++)
		{
			numsMap.put(nums[i], i);
		}
		
		for(int i=0; i<nums.length; i++)
		{
			int complement = target - nums[i];
			if(numsMap.containsKey(complement) && numsMap.get(complement)!=i)
			{
				return new int[] {i, numsMap.get(complement)};
			}
		}
		return new int[] {};
	}
	
	public static boolean isAnagramUsingSorting(String s, String t)
	{
		if(s.length()!=t.length())
		{
			return false;
		}
		
		char[] sArr = s.toCharArray();
		char[] tArr = t.toCharArray();
		
		Arrays.sort(sArr);
		Arrays.sort(tArr);
		
		
		return Arrays.equals(sArr, tArr);
	}
	
	public static boolean isAnagramUsingMap(String s, String t)
	{
		if(s.length()!=t.length())
		{
			return false;
		}
		
		Map<Character, Integer> sMap = new HashMap<Character, Integer>();
		Map<Character, Integer> tMap = new HashMap<Character, Integer>();
		
		for(int i=0;i<s.length();i++)
		{
			sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0)+1);
			tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0)+1);
		}
		
		return sMap.equals(tMap);
	}
	
	public static boolean isAnagramUsingAlphaArray(String s, String t)
	{
		if(s.length()!=t.length())
		{
			return false;
		}
		
		int[] count = new int[26];
		
		for(char c:s.toCharArray())
		{
			count[c-'a']++;
		}
		
		for(char c:t.toCharArray())
		{
			count[c-'a']--;
		}
		
		for(int val:count)
		{
			if(val!=0)
			{
				return false;
			}
		}
		
		return true;		
	}
	
	public static List<List<String>> groupAnagrams(String[] strs)
	{
		Map<String, List<String>> respMap = new HashMap<String, List<String>>();
		
		for(String s:strs)
		{
			int[] count = new int[26];
			
			for(char c: s.toCharArray())
			{
				count[c-'a']++;
			}
			
			String key = Arrays.toString(count);
			
			respMap.putIfAbsent(key, new ArrayList<String>());
			respMap.get(key).add(s);
		}
		
		return new ArrayList<List<String>>(respMap.values());
	}
	
	public static List<List<String>> groupAnagramsWithSorting(String[] strs)
	{
		Map<String,List<String>> respMap = new HashMap<String, List<String>>();
		
		for(String s:strs)
		{
			char[] sArr = s.toCharArray();
			
			Arrays.sort(sArr);
			
			String key = Arrays.toString(sArr);
			
			respMap.putIfAbsent(key, new ArrayList<String>());
			respMap.get(key).add(s);
		}
		return new ArrayList<List<String>>(respMap.values());
	}
	
	public static int[] topKelementsWithListSorting(int[] nums, int k)
	{
		Map<Integer,Integer> numsMap = new HashMap<Integer, Integer>();
		
		for(int n: nums)
		{
			numsMap.put(n, numsMap.getOrDefault(n, 0)+1);
		}
		
		List<int[]> list = new ArrayList<int[]>();
		
		for(Map.Entry<Integer, Integer> entry:numsMap.entrySet())
		{
			list.add(new int[] {entry.getValue(), entry.getKey()});
		}
		
		list.sort((a,b)-> b[0]-a[0]);
		
		int[] op = new int[k];
		for(int i=0 ; i<k; i++)
		{
			op[i]=list.get(i)[1];
		}
		return op;
	}
	
	public static int[] topKelementsWithBucketSort(int[] nums, int k)
	{
		Map<Integer,Integer> numsMap = new HashMap<Integer, Integer>();
		
		for(int n: nums)
		{
			numsMap.put(n, numsMap.getOrDefault(n, 0)+1);
		}
		
		List<Integer>[] freqArr = new List[nums.length+1];
		
		for(int i=0; i<freqArr.length;i++)
		{
			freqArr[i] = new ArrayList<Integer>();
		}
		
		for(Map.Entry<Integer, Integer> entry:numsMap.entrySet())
		{
			freqArr[entry.getValue()].add(entry.getKey());
		}
		
		int[] op = new int[k];
		int j=0;
		
		for(int i=freqArr.length-1; i>=0; i--)
		{
			for(int n: freqArr[i])
			{
				op[j]=n;
				j++;
			}
			if(j==k)
			{
				return op;
			}
		}
		
		return new int[] {};
		
	}
	
    public static int maxProfit(int[] prices) {
    	int maxProfit=0;
    	int buy=prices[0];
    	
    	for(int i=1;i<prices.length;i++)
    	{
    		if(prices[i]<buy)
    		{
    			buy=prices[i];
    		}
    		
    		int profit=prices[i]-buy;
    		maxProfit=Math.max(maxProfit,profit);
    	}
    	return maxProfit;
    }
    
    public static int minSubArrayLen(int target, int[] nums) {
        int minLen=Integer.MAX_VALUE;
        int sum=0;
        int l=0;
        
        for(int r=0;r<nums.length;r++)
        {
        	sum+=nums[r];
        	
        	while(sum>=target)
        	{
        		int len=r-l+1;
        		if(len<minLen)
        		{
        			minLen=len;
        		}
        		sum-=nums[l];
        		l++;
        	}
        }
        
        return minLen==Integer.MAX_VALUE?0:minLen;
    }
    
    public static int characterReplacement(String s, int k) {
        int maxLen=0;
        int[] count=new int[26];
        int maxCount=0;
        int l=0;
        
        for(int r=0;r<s.length();r++)
        {
        	count[s.charAt(r)-'A']++;
        	
        	maxCount = Math.max(maxCount, count[s.charAt(r)-'A']);
        	
        	while((r-l+1)-maxCount > k)
        	{
        		count[s.charAt(l)-'A']--;
        		l++;
        	}
        	
        	int len = r-l+1;
        	maxLen = Math.max(len, maxLen);
        }
        
        return maxLen;
    }
	
	public static void main(String args[]) {
//		int[] nums = {1,2,3,1};
//		System.out.println(containsDuplicate(nums));
		
//		int[] nums = {2,7,11,15};
//		int target=17;
//		
//		int[] op = twoSum(nums, target);
//		
//		System.out.println(Arrays.toString(op));
		
//		String[] strs = {"eat","tea","tan","ate","nat","bat"};
//		
//		System.out.println(groupAnagramsWithSorting(strs).toString());
		
//		int[] nums = {1,1,1,2,2,3};
//		int k=2;
//		
//		System.out.println(Arrays.toString(topKelementsWithBucketSort(nums, k)));
		
//		int[] prices= {7,1,5,3,6,4};
//		System.out.println(maxProfit(prices));
		
//		int[] nums = {1,4,4};
//		int target = 4;
//		System.out.println(minSubArrayLen(target, nums));
		
		String s="ABAB";
		int k=2;
		System.out.println(characterReplacement(s, k));
	}
	
}
