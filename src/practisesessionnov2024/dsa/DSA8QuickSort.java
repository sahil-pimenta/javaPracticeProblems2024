package practisesessionnov2024.dsa;

import java.util.Arrays;

public class DSA8QuickSort {
	public static void main(String args[])
	{
		int[] array = {8,2,5,3,9,4,7,6,1};
		
		quickSort(array, 0, array.length-1);

		System.out.println("Sorted Array: "+Arrays.toString(array));
	}

	private static void quickSort(int[] array, int start, int end) {
		
		if(end<=start) return;
		
		int pivot = patrition(array, start, end);
		
		quickSort(array, start, pivot-1);
		quickSort(array, pivot+1, end);
	}

	private static int patrition(int[] array, int start, int end) {
		
		int pivotVal = array[end];
		int i = start-1;
		
		for(int j=start; j<=end-1; j++)
		{
			if(array[j] < pivotVal)
			{
				i++;
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
		i++;
		int temp = array[i];
		array[i] = array[end];
		array[end] = temp;
		
		return i;
	}
}
