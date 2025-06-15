package revision;

public class InterpolationSearch {
	
	private static int interpolationSearch(int[] array, int target)
	{
		int low=0;
		int high=array.length-1;
		
		while(low<=high && target>=array[low] && target<=array[high])
		{
			int probe = low + (high-low) * (target-array[low])/(array[high]-array[low]);
			
			if(array[probe]>target)
			{
				high=probe-1;
			}
			else if(array[probe]<target)
			{
				low=probe+1;
			}
			else
			{
				return probe;
			}
		}
		
		return -1;
		
	}
	
	public static void main(String args[])
	{
		int[] array = {45,67,90,102,300,500,694};
		
		int target = 500;
		
		
		int position = interpolationSearch(array, target);
		
		System.out.println("Element found at index: "+position);
	}
}
