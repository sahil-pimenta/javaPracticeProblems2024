package designpatterns.behavioral.observer;

public class Observer implements IObserver{

	String name;
	
	public Observer(String name)
	{
		this.name=name;
	}
	
	public void update()
	{
		System.out.println(this.name+" notification received!");
	}
}
