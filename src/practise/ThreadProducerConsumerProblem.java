package practise;

import java.util.LinkedList;
import java.util.Queue;

class BlockingQueue
{
	Queue<Integer> q;
	int cap;
	
	public BlockingQueue(int cap)
	{
		this.cap=cap;
		q=new LinkedList<>();
	}
	
	//Producer
	public synchronized boolean offer(int element)
	{
		while(q.size()>=cap)
		{
			//wait
			System.out.println("offer wait");
			try{this.wait();}catch(InterruptedException e) {}
			
		}
		System.out.println("Adding..");
		q.offer(element);
		System.out.println(q.toString());
		this.notifyAll();
		return true;
	}
	
	//Consumer
	public synchronized int poll()
	{
		while(q.size()==0)
		{
			//wait
			System.out.println("poll wait");
			try{this.wait();}catch(InterruptedException e) {}
		}
		System.out.println("Removing..");
		int poll=q.poll();
		System.out.println(q.toString());
		this.notifyAll();
		return poll;
	}
	
}

public class ThreadProducerConsumerProblem {

	public static void main(String[] args) {
		
		BlockingQueue bq = new BlockingQueue(5);
		
		new Thread(()-> {
			for(int i=0;i<5;i++)
			{
				bq.poll();
			}
		}).start();
		
		new Thread(()-> {
			for(int i=0;i<5;i++)
			{
				bq.offer(100+i);
			}
		}).start();
	}
}
