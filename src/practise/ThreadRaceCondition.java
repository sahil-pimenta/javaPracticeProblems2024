package practise;

class Stack
{
	int[] array;
	int stackTopIdx;
	
	public Stack(int capacity)
	{
		array=new int[capacity];
		stackTopIdx=-1;
	}
	
	public synchronized boolean push(int element)
	{
		if(isFull()) return false;
		
		++stackTopIdx;
		
		try {Thread.sleep(1000);}catch (Exception e) {}
		array[stackTopIdx]=element;
		
		return true;
	}
	
	public synchronized int pop()
	{
		if(isEmpty())return Integer.MIN_VALUE;
		
		int pop = array[stackTopIdx];
		array[stackTopIdx]=Integer.MIN_VALUE;
		
		try {Thread.sleep(1000);}catch (Exception e) {}
		--stackTopIdx;
		return pop;
	}
	
	private boolean isFull()
	{
		return stackTopIdx>=array.length-1;
	}
	
	private boolean isEmpty()
	{
		return stackTopIdx<0;
		
	}
}

public class ThreadRaceCondition {
	public static void main(String[] args) {
		Stack stack = new Stack(5);
		
		new Thread(()->{
			for(int i=0;i<5;i++)
			{
				stack.push(100);
				System.out.println(Thread.currentThread()+" Pushed 100, pos>>"+i);
			}
		}, "pusher").start();
		
		new Thread(()->{
			for(int i=0;i<5;i++)
			{
				stack.pop();
				System.out.println(Thread.currentThread()+" Popped 100, pos>>"+i);
			}
		}, "popper").start();
	}
}
