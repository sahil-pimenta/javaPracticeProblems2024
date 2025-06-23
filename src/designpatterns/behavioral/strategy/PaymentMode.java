package designpatterns.behavioral.strategy;

public interface PaymentMode {
	public void fetchingDetails();
	public boolean validateDetails();
	public void processPayment(int price);
}
