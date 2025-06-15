package revision;

import java.util.Arrays;

public class InsertionSort {
	
	private static int[] insertionSort(int[] array)
	{
		for(int i=1;i<array.length;i++)
		{
			int temp = array[i];
			int j=i-1;
			
			while(j>=0 && (array[j]>temp))
			{
					array[j+1]=array[j];
					j--;
			}
			
			array[j+1]=temp;
		}
		
		return array;
	}
	
	public static void main(String args[])
	{
		int[] array = {500,45,90,67,694,300,102};
		
		int[] sortedArray = insertionSort(array);
		
		System.out.println("Sorted Array: "+Arrays.toString(sortedArray));
	}
}
