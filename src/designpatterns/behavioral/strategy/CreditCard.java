package designpatterns.behavioral.strategy;

public class CreditCard {
	
	long cardNo;
	int cvv;
	int totalAmt;
	String exp;
	
	public CreditCard(long cardNo, int cvv, int totalAmt, String exp)
	{
		this.cardNo=cardNo;
		this.cvv=cvv;
		this.totalAmt=totalAmt;
		this.exp=exp;
	}
	
	public void setTotalAmt(int amt)
	{
		this.totalAmt=amt;
	}
}
