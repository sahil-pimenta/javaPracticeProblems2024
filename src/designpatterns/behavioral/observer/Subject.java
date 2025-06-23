package designpatterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject implements ISubject{

	List<IObserver> observer = new ArrayList<>();

	public void register(IObserver obs)
	{
		observer.add(obs);
	}
	
	public void unregister(IObserver obs)
	{
		observer.remove(obs);
	}
	
	public void notifyObserver()
	{
		for(IObserver obs : observer)
		{
			obs.update();
		}
	}
	
	public void upload()
	{
		System.out.println("Video Uploaded");
		notifyObserver();
	}
	
}
