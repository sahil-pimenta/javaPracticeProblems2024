package revision;

import java.util.Arrays;

public class SelectionSort {

	private static int[] selectionSort(int[] array)
	{
		for(int i=0;i<array.length-1;i++)
		{
			int minIndex = i;
			for(int j=i+1; j<array.length; j++)
			{
				if(array[j]<array[minIndex])
				{
					minIndex=j;
				}
			}
			
			int temp=array[i];
			array[i]=array[minIndex];
			array[minIndex]=temp;
		}
		
		return array;
	}
	
	public static void main(String args[])
	{
		int[] array = {500,45,90,67,694,300,102};
		
		int[] sortedArray = selectionSort(array);
		
		System.out.println("Sorted Array: "+Arrays.toString(sortedArray));
	}
}
