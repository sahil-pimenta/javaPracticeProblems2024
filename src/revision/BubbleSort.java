package revision;

import java.util.Arrays;

public class BubbleSort {
	
	private static int[] bubbleSort(int[] array)
	{
		for(int i=0;i<array.length-1;i++)
		{
			for(int j=0;j<array.length-i-1;j++)
			{
				if(array[j]>array[j+1])
				{
					int temp = array[j];
					array[j]=array[j+1];
					array[j+1]=temp;
				}
			}
		}
		
		return array;
	}
	
	public static void main(String args[])
	{
		int[] array = {500,45,90,67,694,300,102};
		
		int[] sortedArray = bubbleSort(array);
		
		System.out.println("Sorted Array: "+Arrays.toString(sortedArray));
	}
}
