package designpatterns.behavioral.strategy;

public class GPayPayment implements PaymentMode {
	public void fetchingDetails()
	{
		String upiId="XXXXXXXXXXXXXXXXXXXXX";
	}
	public boolean validateDetails()
	{
		//Validating
		return true;
	}
	public void processPayment(int price)
	{
		int total = price+10;
		System.out.println("Debiting Amt:"+total);
	}
}
