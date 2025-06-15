package practisesessionnov2024.dsa;

import java.util.Arrays;

public class Revision {

	public static void main(String args[])
	{
		int[] array = {50,201,400,3,10,5,1000,54};
		
//		int target = 512;
//		
//		int position = interpolationSearch(array, target);
//		System.out.println("Element at pos:" +position);
		
		//int [] sortedArray = insertionSort(array);
		
		//mergeSort(array);
		
		quickSort(array, 0, array.length-1);
		
		System.out.println("Sorted Array: "+Arrays.toString(array));
	}
	
	private static void quickSort(int[] array, int start, int end)
	{
		if(end<=start) return;
		
		int pivot = partition(array, start, end);
		quickSort(array, start, pivot-1);
		quickSort(array, pivot+1, end);
	}


	private static int partition(int[] array, int start, int end) {
		int pivotVal = array[end];
		
		int i = start-1;
		
		for(int j=start;j<=end-1;j++)
		{
			if(array[j]<pivotVal)
			{
				i++;
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
		
		i++;
		int temp=array[end];
		array[end]=array[i];
		array[i]=temp;
		
		return i;
	}

	private static void mergeSort(int[] array)
	{
		if(array.length<=1) return;
		
		int length = array.length;
		int middle = length/2;
		
		int[] leftArray = new int[middle];
		int[] rightArray = new int[length-middle];
		
		int i=0;//for leftArray
		int j=0; //for rightArray
		
		for(;i<array.length;i++)
		{
			if(i<middle)
			{
				leftArray[i] = array[i];
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
		int i=0,l=0,r=0;
		
		while(l<leftArray.length && r<rightArray.length)
		{
			if(leftArray[l] < rightArray[r])
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
		
		while(l<leftArray.length)
		{
			array[i]=leftArray[l];
			i++;
			l++;
		}
		
		while(r<rightArray.length)
		{
			array[i]=rightArray[r];
			i++;
			r++;
		}
		
	}
	
	
	private static int[] insertionSort(int[] array)
	{
		for(int i=1;i<array.length;i++)
		{
			int temp = array[i];
			int j=i-1;
			while(j>=0 && array[j]>temp)
			{
				array[j+1]=array[j];
				j--;
			}
			array[j+1]=temp;
		}
		
		return array;
	}
	
	private static int[] selectionSort(int[] array)
	{
		for(int i=0; i<array.length-1;i++)
		{
			int min=i;
			for(int j=i+1; j<array.length; j++)
			{
				if(array[j]<array[min])
				{
					min=j;
				}
			}
			int temp = array[i];
			array[i] = array[min];
			array[min] = temp;
		}
		
		return array;
	}
	
	private static int[] bubbleSort(int[] array)
	{
		for(int i=0;i<array.length-1;i++)
		{
			for(int j=0;j<array.length-i-1;j++)
			{
				if(array[j]>array[j+1])
				{
					int temp = array[j+1];
					array[j+1] = array[j];
					array[j]=temp;
				}
			}
		}
		
		return array;
	}
	
	private static int interpolationSearch(int[] array, int target)
	{
		int low=0;
		int high=array.length-1;
		
		while(low<=high && target>=array[low] && target<=array[high])
		{
			int probe = low+(high-low) * (target-array[low])/(array[high]-array[low]);
			
			System.out.println("probe:"+probe);
			
			if(array[probe] < target)
			{
				low = probe+1;
			}
			else if(array[probe] > target)
			{
				high = probe-1;
			}
			else
			{
				return probe;
			}
		}
		
		return -1;
	}
	
	private static int binarySearch(int[] array, int target)
	{
		int low=0;
		int high=array.length-1;
		
		while(low<=high)
		{
			int middle= low + (high-low)/2;
			
			System.out.println("middle:"+middle);
			
			if(array[middle] < target)
			{
				low = middle+1;
			}
			else if(array[middle] > target)
			{
				high = middle-1;
			}
			else
			{
				return middle;
			}
		}
		
		return -1;
	}
	
}
