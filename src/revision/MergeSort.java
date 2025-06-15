package revision;

import java.util.Arrays;

public class MergeSort {

	private static void mergeSort(int[] array)
	{
		if(array.length<=1) return;
		
		int length=array.length;
		int middle = length/2;
		
		int[] leftArray = new int[middle];
		int[] rightArray = new int[length-middle];
		
		int i=0;
		int j=0;
		
		for(; i<array.length;i++)
		{
			if(i<middle)
			{
				leftArray[i]=array[i];
			}
			else
			{
				rightArray[j]=array[i];
				j++;
			}
		}
		
		mergeSort(leftArray);
		mergeSort(rightArray);
		merge(leftArray, rightArray, array);
	}
	
	private static void merge(int[] leftArray, int[] rightArray, int[] array)
	{
		int i=0, l=0, r=0;
		
		while((l<leftArray.length) && (r<rightArray.length))
		{
			if(leftArray[l]<rightArray[r])
			{
				array[i]=leftArray[l];
				i++;
				l++;
			}
			else
			{
				array[i]=rightArray[r];
				i++;
				r++;
			}
		}
		
		while(r<rightArray.length)
		{
			array[i]=rightArray[r];
			i++;
			r++;
		}
		
		while(l<leftArray.length)
		{
			array[i]=leftArray[l];
			i++;
			l++;
		}
		
	}
	
	public static void main(String args[])
	{
		int[] array = {500,45,90,67,694,300,102};
		
		mergeSort(array);
		
		System.out.println("Sorted Array: "+Arrays.toString(array));
	}
}
