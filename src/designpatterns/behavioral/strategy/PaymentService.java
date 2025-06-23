package designpatterns.behavioral.strategy;

public class PaymentService {
	
	PaymentMode pm;;
	
	public void processOrder(int price)
	{	
		pm.fetchingDetails();
		if(pm.validateDetails())
		{
			pm.processPayment(price);
		}
	}
	
	public void setPm(PaymentMode pm)
	{
		this.pm=pm;
	}
}
