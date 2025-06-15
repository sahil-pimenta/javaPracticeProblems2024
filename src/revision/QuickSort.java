package revision;

import java.util.Arrays;

public class QuickSort {

	private static void quickSort(int[] array, int start, int end)
	{
		if(start>=end) return;
		
		int pivot = partition(array, start, end);
		quickSort(array, start, pivot-1);
		quickSort(array, pivot+1, end);
	}
	
	private static int partition(int[] array, int start, int end)
	{
		int pivotVal = array[end];
		
		int i=start-1;
		
		for(int j=start;j<end;j++)
		{
			if(array[j]<pivotVal)
			{
				i++;
				int temp = array[j];
				array[j]=array[i];
				array[i]=temp;
			}
		}
		
		i++;
		int temp= array[end];
		array[end]=array[i];
		array[i]=temp;
		
		return i;
	}
	
	public static void main(String args[])
	{
		int[] array = {500,45,90,67,694,300,102};
		
		quickSort(array, 0, array.length-1);
		
		System.out.println("Sorted Array: "+Arrays.toString(array));
	}
}
