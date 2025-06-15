package revision;


public class BinarySearch {

	private static int binarySearch(int[] array, int target)
	{
		int low=0;
		int high=array.length-1;
		
		while(low<=high)
		{
			int middle = low+(high-low)/2;
			
			if(array[middle]>target)
			{
				high=middle-1;
			}
			else if(array[middle]<target)
			{
				low=middle+1;
			}
			else
			{
				return middle;
			}
		}
		
		return -1;
	}
	
	
	public static void main(String args[])
	{
		int[] array = {45,67,90,102,300,500,694};
		
		int target = 694;
		
		
		int position = binarySearch(array, target);
		
		System.out.println("Element found at index: "+position);
	}
	
}
