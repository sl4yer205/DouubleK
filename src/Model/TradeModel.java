package Model;

public class TradeModel implements iTradeMod{
	private String idTrade;
	private int date ;
	private int month ;
	private int year;
	private float unitPrice;
	private int amount;
	private String type;
	
	//constructor
	public TradeModel() {}
	public TradeModel(String id, int d, int m, int y, float unit, int amount, String type)
	{
		this.idTrade = id;
		this.date = d;
		this.month = m;
		this.year = y;
		this.unitPrice = unit;
		this.amount = amount;
		this.type = type;
	}

	//setter
	public void setIdTrade(String idTrade)
	{
		this.idTrade = idTrade;
	}
	public void setDate(int day)
	{
		this.date = day;
	}
	public void setMonth(int month)
	{
		this.month = month;
	}
	public void setYear(int year)
	{
		this.year = year;
	}
	public void setUnitPrice(float unit)
	{
		this.unitPrice = unit;
	}
	public void setAmount(int amount)
	{
		this.amount = amount;
	}
	public void setType(String type)
	{
		this.type = type;
	}
	
	//getter
	public String getIdTrade() {return this.idTrade; }
	public int getDate()
	{
		return this.date;
	}
	public int getMonth()
	{
		return this.month;
	}
	public int getYear()
	{
		return this.year;
	}
	public float getUnitPrice()
	{
		return this.unitPrice;
	}
	public int getAmount()
	{
		return this.amount;
	}
	public String getType()
	{
		return this.type;
	}
	
	//function
	public float IntoMoney()
	{
		return this.getUnitPrice()*this.getAmount();
	}
}
