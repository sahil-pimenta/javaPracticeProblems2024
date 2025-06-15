package practisesessionnov2024.leetcode;

public class LeetCode24BestTimeToBuyAndSellStock {

    public static int maxProfitBruteForce(int[] prices) {
    	
    	int maxProfit=0;
    	
    	for(int i=0;i<prices.length;i++)
    	{
    		int profit=0;
    		for(int j=i+1;j<prices.length;j++)
    		{
    			if(prices[i]<prices[j])
    			{
    				profit=prices[j]-prices[i];
    				
    	    		if(profit>maxProfit)
    	    		{
    	    			maxProfit=profit;
    	    		}
    			}
    		}
    	}
    	
    	return maxProfit;
    }
    
    public static int maxProfit(int[] prices) {
    	int buy=prices[0];
    	int maxProfit=0;
    	
    	for(int i=1;i<prices.length;i++)
    	{
    		if(prices[i]<buy)
    		{
    			buy=prices[i];
    		}
    		
    		int profit = prices[i]-buy;
    		
    		maxProfit = Integer.max(maxProfit, profit);
    	}
    	
    	return maxProfit;
    }
    
    public static int maxProfitUsingSlidingWindow(int[] prices) {
        int maxProfit=0;
        int l=0;
        
        for(int r=0;r<prices.length;r++)
        {
        	if(prices[r]<prices[l])
        	{
        		l=r;
        	}
        	
        	int profit=prices[r]-prices[l];
        	if(profit>maxProfit)
        	{
        		maxProfit=profit;
        	}
        }
        return maxProfit;
    }


    
	public static void main(String args[])
	{
		int[] prices = {7,1,5,3,6,4};
		System.out.println(maxProfitUsingSlidingWindow(prices));
	}
}
