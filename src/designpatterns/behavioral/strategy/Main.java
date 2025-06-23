package designpatterns.behavioral.strategy;

public class Main {

	public static void main(String[] args) {
		PaymentMode paymentMode = new GPayPayment();
		PaymentService ps = new PaymentService();
		ps.setPm(paymentMode);
		ps.processOrder(600);
	}
}
