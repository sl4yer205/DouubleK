package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class VipController {
	
	private String[] columns;
	private String[][] data;
	public String[] getColumns()
	{
		return columns;
	}
	public void setColumns(String[] columns)
	{
		this.columns = columns;
	}
	public String[][] getData()
	{
		return data;
	}
	public void setData(String[][] data)
	{
		this.data = data;
	}
	
	public VipController()
	{
		loadData();
	}
	
	public void loadData()
	{
		String url = "jdbc:mysql://127.0.0.1:3306/doublekdb";
		String user = "root";
		String password = "Dtk.281005";
		
		int i = 0;
		int count = 0;
		try
		{
			Connection conn = DriverManager.getConnection(url, user, password);
			Statement stm = conn.createStatement();
			String sql = "SELECT * FROM moneydb";
			ResultSet rs = stm.executeQuery(sql);
			
			
			while (rs.next())
			{
				float unit = rs.getFloat("unitMoney");
				float compensation = 1000;
				if (unit>1000000000f+compensation)
				{
					count++;
				}
			}
			rs.close();
			stm.close();
			conn.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		try
		{
			Connection conn = DriverManager.getConnection(url, user, password);
			Statement stm = conn.createStatement();
			String sql = "SELECT * FROM golddb";
			ResultSet rs = stm.executeQuery(sql);
			
			
			while (rs.next())
			{
				float unit = rs.getFloat("unitGold");
				float compensation = 1000;
				if (unit>1000000000f+compensation)
				{
					count++;
				}
			}
			rs.close();
			stm.close();
			conn.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		System.out.println(">1B: "+count);
		if (count==0)
		{
			JOptionPane.showMessageDialog(null, "Don't have any trading has unit more than 1B");
		}
		else
		{
			String[] col = {"Order","ID Trade", "Date", "Unit Price", "Amount", "Type", "Rate", "Pay"};
			this.setColumns(col);
			String[][] dataTemp =  new String[count][8];
			this.setData(dataTemp);
			
			try
			{
				Connection conn = DriverManager.getConnection(url, user, password);
				Statement stm = conn.createStatement();
				String sql = "SELECT * FROM moneydb";
				ResultSet rs = stm.executeQuery(sql);

				while (rs.next())
				{
					float unit = rs.getFloat("unitMoney");
					float compensation = 1000;


					if (unit>1000000000f+compensation)
					{
						int order = rs.getInt("orderMoney");
						String id = rs.getString("idMoney");
						String date = rs.getString("dateMoney");
						
						int amount = rs.getInt("amountMoney");
						String type = rs.getString("typeMoney");
						float rate = rs.getFloat("rateMoney");
						float money = rs.getFloat("intoMMoney");

						data[i][0] = String.valueOf(order);
						data[i][1] = id;
						data[i][2] = date;
						data[i][3] = String.valueOf(unit);
						data[i][4] = String.valueOf(amount);
						data[i][5] = type;
						data[i][6] = String.valueOf(rate);
						data[i][7] = String.valueOf(money);

						i++;
						System.out.println(order+ " "+id+" "+date+" "+unit+" "+amount+" "+type + " "+rate);
					}
					
				}
				rs.close();
				stm.close();
				conn.close();
				System.out.println("Success Connection!");
			}
			catch (SQLException e)
			{
				System.out.println("Error connection!");
				e.printStackTrace();
			}
			
			try
			{
				Connection conn = DriverManager.getConnection(url, user, password);
				Statement stm = conn.createStatement();
				String sql = "SELECT * FROM golddb";
				ResultSet rs = stm.executeQuery(sql);

				while (rs.next())
				{
					float unit = rs.getFloat("unitGold");
					float compensation = 1000;
					if (unit>1000000000f+compensation)
					{
						int order = rs.getInt("orderGoldTrade");
						String id = rs.getString("idGoldTrade");
						String date = rs.getString("dateGold");
						
						int amount = rs.getInt("amountGold");
						String type = rs.getString("typeGold");
						float money = rs.getFloat("intoGMoney");

						data[i][0] = String.valueOf(order);
						data[i][1] = id;
						data[i][2] = date;
						data[i][3] = String.valueOf(unit);
						data[i][4] = String.valueOf(amount);
						data[i][5] = type;
						data[i][7] = String.valueOf(money);

						i++;
						System.out.println(order+ " "+id+" "+date+" "+unit+" "+amount+" "+type + " ");
					}
					
				}
				rs.close();
				stm.close();
				conn.close();
				System.out.println("Success Connection!");
			}
			catch (SQLException e)
			{
				System.out.println("Error connection!");
				e.printStackTrace();
			}
		}

	}
}
