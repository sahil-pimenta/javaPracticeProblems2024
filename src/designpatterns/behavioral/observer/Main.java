package designpatterns.behavioral.observer;

public class Main {
	public static void main(String[] args) {
		IObserver obs1 = new Observer("Sahil");
		IObserver obs2 = new Observer("James");
		IObserver obs3 = new Observer("Esmond");
		
		ISubject sub = new Subject();
		sub.register(obs1);
		sub.register(obs2);
		sub.register(obs3);
		
		sub.unregister(obs2);
		
		sub.upload();
		
	}
}
