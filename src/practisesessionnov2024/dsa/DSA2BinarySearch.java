package practisesessionnov2024.dsa;

public class DSA2BinarySearch {
	
	public static void main(String args[])
	{
		
		int array[]= new int[500];
		int target = 103;
		
		for(int i=0;i<500;i++)
		{
			array[i]=i;
		}
		
		int index = getBinarySearch(array, target);
		
		System.out.println("Element found at index: "+index);
		
	}
	
	public static int getBinarySearch(int[] array, int target)
	{
		int head = 0;
		int tail = array.length - 1;
		
		while(head<=tail)
		{
			int middle = head + (tail - head)/2;
			
			System.out.println("middle is at: "+middle);
			
			int value = array[middle];
			
			if(value < target)
			{
				head = middle + 1;
			}
			else if(value > target)
			{
				tail = middle - 1;
			}
			else
			{
				return middle;
			}
		}
		
		return -1;
	}

}
