package practisesessionnov2024.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode7EncodeAndDecodeStrings {

//    public static String encode(List<String> strs) 
//    {
//    	String encodeStr="";
//    	
//    	for(String str:strs)
//    	{
//    		encodeStr+=str+",";
//    	}
//    	
//    	return encodeStr;
//    }
//
//    public static List<String> decode(String str) {
//    	return Arrays.asList(str.split(","));
//    }
    
//	   public static String encode(List<String> strs) 
//	   {
//		   if(strs.size()<=0)
//		   {
//			   return "";
//		   }
//		   
//		   StringBuilder res = new StringBuilder();
//		   List<Integer> sizes = new ArrayList<Integer>();
//		   
//		   for(String str: strs)
//		   {
//			   sizes.add(str.length());
//		   }
//		   
//		   for(int size:sizes)
//		   {
//			   res.append(size).append(",");
//		   }
//		   
//		   res.append("#");
//		   
//		   for(String str:strs)
//		   {
//			   res.append(str);
//		   }
//		   
//		   return res.toString();
//	   }
//
//	    public static List<String> decode(String str) 
//	    {
//	    	if(str.length()<=0)
//	    	{
//	    		return new ArrayList();
//	    	}
//	    	
//	    	List<String> res = new ArrayList<String>();
//	    	List<Integer> sizes = new ArrayList<Integer>();
//	    	
//	    	int i=0;
//	    	
//	    	while(str.charAt(i)!='#')
//	    	{
//	    		StringBuilder strSize = new StringBuilder();
//	    		
//	    		while(str.charAt(i)!=',')
//	    		{
//	    			strSize.append(str.charAt(i));
//	    			i++;
//	    		}
//	    		
//	    		sizes.add(Integer.parseInt(strSize.toString()));
//	    		i++;
//	    	}
//	    	i++;
//	    	
//	    	for(Integer size:sizes)
//	    	{
//	    		res.add(str.substring(i, i+size));
//	    		i=i+size;
//	    	}
//	    	
//	    	return res;
//	    }
	    
	
    public static String encode(List<String> strs) {
    	
    	StringBuilder res = new StringBuilder();
    	for(String s:strs)
    	{
    		res.append(s.length()).append("#").append(s);
    	}
    	return res.toString();
    }

    public static List<String> decode(String str) {
    	List<String> res = new ArrayList<String>();
    	
    	int i=0;
    	
    	while(i<str.length())
    	{
    		int j=i;
    		
    		while(str.charAt(j)!='#')
    		{
    			j++;
    		}
    		
    		int length = Integer.parseInt(str.substring(i,j));
    		
    		i=j+1;
    		j=i+length;
    		res.add(str.substring(i,j));
    		i=j;
    	}
    	
    	return res;
    }
    
	public static void main(String args[])
	{
		List<String> inputList = Arrays.asList("neet","code","love","you");
		
		String encodeStr = encode(inputList);
		
		System.out.println("encodeStr>>"+encodeStr);
		
		List<String> decodedList = decode(encodeStr);
		
		System.out.println("decodedList>>"+decodedList.toString());
		
	}
}
