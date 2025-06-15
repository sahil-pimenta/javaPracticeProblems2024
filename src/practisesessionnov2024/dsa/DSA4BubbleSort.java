package practisesessionnov2024.dsa;

import java.util.Arrays;

public class DSA4BubbleSort {
	
	public static void main(String args[])
	{
		int[] array = {5,4,2,3,1};
		
		int [] sortedArray = bubbleSort(array);
		
		System.out.println("Sorted Array: "+Arrays.toString(sortedArray));
		
	}
	
	private static int[] bubbleSort(int[] array)
	{
		for(int i=0; i< array.length-1; i++)
		{
			for(int j=0; j< array.length-i-1; j++)
			{
				if(array[j] > array[j+1])
				{
					System.out.println("Swapped: "+array[j+1]+" with :"+array[j]);
					int temp = array[j+1];
					array[j+1] = array[j];
					array[j] = temp;
				}
			}
		}
		
		return array;
	}
}
