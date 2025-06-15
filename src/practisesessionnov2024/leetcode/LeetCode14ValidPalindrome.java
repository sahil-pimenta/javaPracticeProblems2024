package practisesessionnov2024.leetcode;

public class LeetCode14ValidPalindrome {

    public static boolean isPalindromeMySol(String s) {
    	
    	StringBuilder sb = new StringBuilder();
    	
    	s = s.toLowerCase();
    	for(char c:s.toCharArray())
    	{
    		if((c>='a' && c<='z')
    				|| (c>='0' && c<='9'))
    		{
    			sb.append(c);
    		}
    	}
    	
    	s = sb.toString();
    	
    	int i=0;
    	int j=s.length()-1;
    	
    	while(i<=j)
    	{
    		char c = s.charAt(i);
    		char d = s.charAt(j);
    		
    		if(c!=d)
    		{
    			return false;
    		}
    		
    		i++;
    		j--;
    	}
    	
    	return true;
    }
    
   public static boolean isPalindrome(String s) 
   {
    	s = s.toLowerCase();    	
    	int i=0;
    	int j=s.length()-1;
    	
    	while(i<j)
    	{    		
    		while(i<j && !isAlphaNumeric(s.charAt(i)))
    		{
    			i++;
    		}
    		
    		while(i<j && !isAlphaNumeric(s.charAt(j)))
    		{
    			j--;
    		}
    		
    		if(s.charAt(i)!=s.charAt(j))
    		{
    			return false;
    		}
    		
    		i++;
    		j--;
    	}
    	
    	return true;
    }
    
    public static boolean isAlphaNumeric(char c)
    {
    	return ((c>='a' && c<='z') || (c>='0' && c<='9'));
    }
    
	public static void main(String args[])
	{
		//String s = "Was it a car or a cat I saw?";
		String s = "A man, a plan, a canal: Panama";
		System.out.println(isPalindrome(s));
	}
}
