package practisesessionnov2024.dsa;

import java.util.Arrays;

public class DSA5SelectionSort {
	
	public static void main(String args[])
	{
		int[] array = {5,4,2,3,1};
		
		int [] sortedArray = selectionSort(array);
		
		System.out.println("Sorted Array: "+Arrays.toString(sortedArray));
		
	}
	
	private static int[] selectionSort(int[] array)
	{
		for(int i=0; i< array.length-1; i++)
		{
			int minIndex = i;
			for(int j=i+1; j< array.length; j++)
			{
				if(array[j] < array[minIndex])
				{
					minIndex = j;
				}
			}
						
			int temp = array[i];
			array[i] = array[minIndex];
			array[minIndex] = temp;
		}
		
		return array;
	}
}
