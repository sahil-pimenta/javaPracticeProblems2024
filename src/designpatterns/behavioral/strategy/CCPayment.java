package designpatterns.behavioral.strategy;

public class CCPayment implements PaymentMode{
	
	private CreditCard cc;
	
	public void fetchingDetails()
	{
		cc = new CreditCard(123456, 666, 9000, "7/29");
	}
	public boolean validateDetails()
	{
		//Validating
		return true;
	}
	public void processPayment(int price)
	{
		int totalPrice = price+10;
		cc.setTotalAmt(cc.totalAmt-totalPrice);
		System.out.println("Balance Amt:"+cc.totalAmt);
	}
}
