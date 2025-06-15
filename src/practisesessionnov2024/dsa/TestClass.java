package practisesessionnov2024.dsa;

public class TestClass {
	
	public static void main(String args[])
	{
		DSA1DynamicArray da = new DSA1DynamicArray();
		
		da.add(500);
		da.add(600);

		System.out.println("Values:"+da);
		
		da.remove(600);
		
		
		System.out.println("Capacity:"+da.capacity);
		System.out.println("Size:"+da.size);
		System.out.println("Is Empty:"+da.isEmpty());
		System.out.println("Values:"+da);
	}

}
