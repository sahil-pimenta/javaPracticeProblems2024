package practise;

public class ThreadDeadlock {
	
	public static void main(String[] args) {
		
		String lock1 = "lock1";
		String lock2 = "lock2";
				
		new Thread(()->{
			synchronized(lock1)
			{
				try {Thread.sleep(100);}catch(Exception e) {}
				
				synchronized(lock2)
				{
					System.out.println("Execution done t1");
				}
				
			}
		}, "t1").start();
		
		new Thread(()->{
			synchronized(lock2)
			{
				try {Thread.sleep(100);}catch(Exception e) {}
				
				synchronized(lock1)
				{
					System.out.println("Execution done t2");
				}
				
			}
		}, "t2").start();
		
	}
	
}
