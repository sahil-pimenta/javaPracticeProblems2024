package practisesessionnov2024.dsa;

public class DSA3InterpolationSearch {
	
	public static void main(String args[])
	{
		int[] array = {1,2,4,8,16,32,64,128,256,512,1024};
		int target = 256;
		
		int index = interpolationSearch(array, target);
		
		if(index!=-1)
		{
			System.out.println("Element found at: "+index);
		}
		
	}
	
	private static int interpolationSearch(int[] array, int target) {
		int low = 0;
		int high = array.length-1;
		
		while((low<=high)
				&& (target >= array[low])
				&& (target <= array[high]))
		{
			int probe = low + (high-low) * (target - array[low])/(array[high]-array[low]);
			
			System.out.println("probe at: "+probe);
			
			if(array[probe] < target)
			{
				low = probe+1;
				
			}
			else if(array[probe] > target)
			{
				high = probe-1;
			}
			else
			{
				return probe;
			}
			
		}
		return -1;
	}

	private static int binarySearch(int[] array, int target) {
		int low = 0;
		int high = array.length-1;
		
		while(low<=high)
		{
			int middle = low + (high-low)/2;
			
			System.out.println("middle at: "+middle);
			
			if(array[middle] > target)
			{
				high = middle-1;
			}
			else if(array[middle] < target)
			{
				low = middle+1;
			}
			else
			{
				return middle;
			}
			
		}
		return -1;
	}

}
