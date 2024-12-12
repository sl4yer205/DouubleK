package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ShowGoldController {
	private String[] columns;
	private String[][] data;
	public String[] getColumns() {
		return columns;
	}
	public void setColumns(String[] columns) {
		this.columns = columns;
	}
	public String[][] getData() {
		return data;
	}
	public void setData(String[][] data) {
		this.data = data;
	}
	
	public ShowGoldController()
	{
		loadData();
	}
	public void loadData()
	{
		String url = "jdbc:mysql://127.0.0.1:3306/doublekdb";
		String user = "root";
		String password = "Dtk.281005";
		int countRows = 0;
		try
		{
			Connection conn = DriverManager.getConnection(url, user, password);
			Statement stm = conn.createStatement();
			String sql = "SELECT COUNT(*) AS totalRows FROM golddb";
			ResultSet rs = stm.executeQuery(sql);
			
			if (rs.next())
			{
				countRows = rs.getInt("totalRows");
				System.out.println(countRows);
			}
			
			
			rs.close();
			stm.close();
			conn.close();
			System.out.println("success");
		}
		catch(SQLException e)
		{
			System.out.println("Error");
		}
		String[] col = {"Order","ID Trade", "Date", "Unit Price", "Amount", "Type", "Pay"};
		this.setColumns(col);
		String[][] dataTemp =  new String[countRows][7];
		this.setData(dataTemp);
		try
		{
			Connection conn = DriverManager.getConnection(url, user, password);
			Statement stm = conn.createStatement();
			String sql = "SELECT * FROM golddb";
			ResultSet rs = stm.executeQuery(sql);
			
			int i = 0;
			while (rs.next())
			{
				int order = rs.getInt("orderGoldTrade");
				String id = rs.getString("idGoldTrade");
				String date = rs.getString("dateGold");
				float unit = rs.getFloat("unitGold");
				int amount = rs.getInt("amountGold");
				String type = rs.getString("typeGold");
				float money = rs.getFloat("intoGMoney");
				
				data[i][0] = String.valueOf(order);
				data[i][1] = id;
				data[i][2] = date;
				data[i][3] = String.valueOf(unit);
				data[i][4] = String.valueOf(amount);
				data[i][5] = type;
				data[i][6] = String.valueOf(money);

				i++;
				System.out.println(order+ " "+id+" "+date+" "+unit+" "+amount+" "+type );
			}
			rs.close();
			stm.close();
			conn.close();
			System.out.println("Success Connection!");
		}
		catch (SQLException e)
		{
			System.out.println("Error connection!");
		}
	}
}
