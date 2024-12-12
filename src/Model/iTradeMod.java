package Model;

interface iTradeMod {
	String idTrade="";
	int date = 0;
	int month = 0;
	int year=0;
	float unitPrice=0;
	int amount=0;
	String type="";
	
	void setIdTrade(String idTrade);
	void setDate(int day);
	void setMonth(int month);
	void setYear(int year);
	void setUnitPrice(float unit);
	void setAmount(int amount);
	void setType(String type);
	
	String getIdTrade();
	int getDate();
	int getMonth();
	int getYear();
	float getUnitPrice();
	int getAmount();
	String getType();
	
	float IntoMoney();
}
