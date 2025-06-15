package practisesessionnov2024.leetcode;

public class Algo1BinarySearch {

	public static void main(String args[]) {
		int[] array = {10,50,89,95,101,203,500};
		
		int target = 101;
		
		int position = binarySearch(array, target);
		
		System.out.println("Element is at:"+position);
		
	}

	private static int binarySearch(int[] array, int target) {
		
		int low=0;
		int high=array.length-1;
		
		while(low<=high)
		{
			int middle=low+(high-low)/2;
			
			if(target > array[middle])
			{
				low=middle+1;
			}
			else if(target < array[middle])
			{
				high= middle-1;
			}
			else
			{
				return middle;
			}
			
		}
		
		return -1;
	}
}
