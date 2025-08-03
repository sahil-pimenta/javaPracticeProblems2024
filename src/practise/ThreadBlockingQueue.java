package practise;

import java.util.LinkedList;
import java.util.Queue;

class BlockingQueue1 {
	private int capacity;
	private Queue<Integer> q;
	
	public BlockingQueue1(int cap)
	{
		this.capacity=cap;
		this.q=new LinkedList<Integer>();
	}
	
	public synchronized boolean add(int element)
	{
		while(q.size()==capacity)
		{
			try {
				System.out.println("add wait");
				this.wait();
			}catch(Exception e) {}
		}
		
		q.offer(element);
		System.out.println(q.toString());
		this.notifyAll();
		return true;
	}
	
	public synchronized int remove()
	{
		while(q.size()==0)
		{
			try {
				System.out.println("remove wait");
				this.wait();
			}catch(Exception e) {}
		}
		
		int element=q.poll();
		System.out.println(q.toString());
		this.notifyAll();
		return element;
	}
}

public class ThreadBlockingQueue{
	public static void main(String[] args) {
		BlockingQueue1 q=new BlockingQueue1(5);
		
		new Thread(()->{
			q.remove();
		}).start();;
		
		
		new Thread(()->{
			q.add(5);
		}).start();;
	}
}