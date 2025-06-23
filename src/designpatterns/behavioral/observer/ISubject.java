package designpatterns.behavioral.observer;

public interface ISubject {
	
	public void register(IObserver obs);
	public void unregister(IObserver obs);
	public void notifyObserver();
	public void upload();
}
