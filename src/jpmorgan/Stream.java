package jpmorgan;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Stream {

	//Given an Array, remove all odd numbers, multiply each number by a constant and then return sum. All operations were to be done using Java streams.
    public static int sum(int[] nums, int a)
    {
    	int sum=Arrays.stream(nums).filter(x->x%2==0).map(x->x*a).sum();
    	return sum;
    }
    
    public static List<Integer> getList(int[] nums, int a)
    {
    	return Arrays.stream(nums).filter(x->x%2==0).map(x->x*a).boxed().collect(Collectors.toList());
    	//boxed() converts int to Integer
    }

    
	public static void main(String[] args) {
		int[] nums= {1,2,3,4,5,6};
		System.out.println(sum(nums, 2));
		System.out.println(getList(nums, 2));
	}
}
