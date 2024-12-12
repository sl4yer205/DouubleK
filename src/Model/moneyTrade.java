package Model;

public class moneyTrade extends TradeModel{
	private float rate;
	
	//constructor
	public moneyTrade() {}
	public moneyTrade(String id, int d, int m, int y, float unit, int amount, String type, float r)
	{
		super(id, d, m, y, unit, amount, type);
		this.rate = r;
	}
	
	//setter
	public void setRate(float r)
	{
		this.rate = r;
	}
	//getter
	public float getRate()
	{
		return this.rate;
	}
	
	
	public float IntoMoney()
	{
		if (this.getType().equals("USD") || this.getType().equals("€"))
		{
			return this.getUnitPrice()*this.getAmount()*this.getRate();
		}
		else
		{
			return this.getUnitPrice()*this.getAmount();
		}
	}
}
