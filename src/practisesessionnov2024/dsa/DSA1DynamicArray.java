package practisesessionnov2024.dsa;

public class DSA1DynamicArray {
	
	int capacity;
	int size;
	int array[];
	
	public DSA1DynamicArray()
	{
		this.capacity=10;
		this.array = new int[capacity];
	}
	
	public DSA1DynamicArray(int capacity)
	{
		this.capacity=capacity;
		array = new int[capacity];
	}
	
	public void add(int element)
	{
		if(size>=capacity)
		{
			grow();
		}
		array[size] = element;
		size++;
	}
	
	public void insert(int index, int element)
	{
		if(size>=capacity)
		{
			grow();
		}
		
		for(int i=size; i> index; i--)
		{
			array[i] = array[i-1];
		}
		array[index] = element;
		size++;
	}
	
	public void remove(int element)
	{
		for(int i=0;i<size;i++)
		{
			if(array[i] == element)
			{
				for(int j=0; j< (size-i-1); j++)
				{
					array[i+j] = array[i+j+1];
				}
				array[size-1] = 0;
				size--;
				break;
			}
		}
		
		if(size <= (capacity/3))
		{
			shrink();
		}
	}
	
	public void grow()
	{
		this.capacity = (int)this.capacity * 2;
		int[] newArray = new int[this.capacity];
		for(int i=0;i<size;i++)
		{
			newArray[i] = array[i];
		}
		array = newArray;
	}
	
	public void shrink()
	{
		this.capacity = (int)this.capacity / 2;
		int[] newArray = new int[this.capacity];
		for(int i=0;i<size;i++)
		{
			newArray[i] = array[i];
		}
		array = newArray;
	}
	
	public int search(int element)
	{
		for(int i=0;i<size;i++)
		{
			if(array[i] == element)
			{
				return i;
			}
		}
		
		return -1;
	}
	
	public boolean isEmpty()
	{
		return size==0;
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(int i=0;i<size;i++)
		{
			sb.append(array[i]);
			if(i<size-1)
			{
				sb.append(" ,");
			}			
		}
		sb.append("]");
		return sb.toString();
	}

}
