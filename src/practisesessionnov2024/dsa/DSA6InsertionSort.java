package practisesessionnov2024.dsa;

import java.util.Arrays;

public class DSA6InsertionSort {
	
	public static void main(String args[])
	{
		int[] array = {5,4,2,3,1};
		
		int [] sortedArray = insertionSort(array);
		
		System.out.println("Sorted Array: "+Arrays.toString(sortedArray));
		
	}
	
	private static int[] insertionSort(int[] array)
	{
		for(int i=1; i< array.length; i++)
		{
			int temp = array[i];
			int j= i-1;
			
			while(j>=0 && (temp < array[j]))
			{
				array[j+1] = array[j];
				j--;
			}
			
			array[j+1] = temp;
		}
		
		return array;
	}
}
