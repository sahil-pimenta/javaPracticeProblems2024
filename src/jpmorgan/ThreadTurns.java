package jpmorgan;

//Suppose you have 2 threads. One of them prints (1,2,3…) and the other one prints (A,B,C,..). How will you ensure that they run in a sequence, so that it prints (1,A,2,B…)?
public class ThreadTurns {
	public boolean numTurn=true;
	
	public synchronized void printNos()
	{
		for(int i=1;i<=26;i++)
		{
			while(!numTurn)
			{
				try
				{
					this.wait();
				}
				catch(Exception e){}
			}
			System.out.print(i+",");
			numTurn=false;
			this.notifyAll();
		}
	}
	
	public synchronized void printAlpha()
	{
		for(char c='A';c<='Z';c++)
		{
			while(numTurn)
			{
				try
				{
					this.wait();
				}
				catch(Exception e){}
			}
			System.out.print(c+",");
			numTurn=true;
			this.notifyAll();
		}
	}
	
	public static void main(String[] args) {
		ThreadTurns turn=new ThreadTurns();
		Thread t1=new Thread(()->{
			turn.printNos();
		});
		
		Thread t2=new Thread(()->{
			turn.printAlpha();
		});
		
		t1.start();
		t2.start();
	}
}
