package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.time.LocalDate;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import View.InputGoldTradeView;

public class InputGoldController implements ActionListener{
	private InputGoldTradeView inpGold;
	
	
	public InputGoldTradeView getInpGold()
	{
		return inpGold;
	}
	
	public InputGoldController(InputGoldTradeView inpGold)
	{
		this.inpGold = inpGold;
	}


	@Override
	public void actionPerformed(ActionEvent e)
	{
		JButton choose = (JButton) e.getSource();
		String chosen = choose.getText();
		if (chosen.equals("Enter"))
		{
			inputGold();
		}
		if (chosen.equals("Default"))
		{
			LocalDate time = LocalDate.now();
			
			int day = time.getDayOfMonth();
			this.getInpGold().getDayField().setText(String.valueOf(day));
			
			int month = time.getMonthValue();
			this.getInpGold().getMonthField().setText(String.valueOf(month));
			
			int year = time.getYear();
			this.getInpGold().getYearField().setText(String.valueOf(year));
		}
			
	}
	
	public void inputGold()
	{
		try
		{
			int day = Integer.parseInt(this.getInpGold().getDayField().getText());
			int month = Integer.parseInt(this.getInpGold().getMonthField().getText());
			int year = Integer.parseInt(this.getInpGold().getYearField().getText());
			
		}
		catch (NumberFormatException e)
		{
			JOptionPane.showMessageDialog(inpGold, "Date/Amount must be an Integer Number!");
			this.getInpGold().getDayField().setText("");
			this.getInpGold().getMonthField().setText("");
			this.getInpGold().getYearField().setText("");
			
		}
		
		try
		{
			float price = Float.parseFloat(this.getInpGold().getUnitField().getText());
		}
		catch (NumberFormatException e)
		{
			JOptionPane.showMessageDialog(inpGold, "Unit Price must be a Float!");
			this.getInpGold().getUnitField().setText("");
		}
		try
		{
			int amount = Integer.parseInt(this.getInpGold().getAmountField().getText());
		}
		catch(NumberFormatException e)
		{
			JOptionPane.showMessageDialog(inpGold, "Amount must be an Integer Number");
			this.getInpGold().getAmountField().setText("");
		}
		try 
		{
			String id = this.getInpGold().getIdField().getText();
			if (id.trim().isEmpty())
			{
				JOptionPane.showMessageDialog(inpGold, "You must input the ID");
			}
		}
		catch (IllegalArgumentException e)
		{
			e.printStackTrace();
		}
		try 
		{
			String day = this.getInpGold().getDayField().getText();
			if (day.trim().isEmpty())
			{
				JOptionPane.showMessageDialog(inpGold, "You must input Day");
			}
		}
		catch (IllegalArgumentException e)
		{
			e.printStackTrace();
		}
		
		try 
		{
			String month = this.getInpGold().getMonthField().getText();
			if (month.trim().isEmpty())
			{
				JOptionPane.showMessageDialog(inpGold, "You must input Month");
			}
		}
		catch (IllegalArgumentException e)
		{
			e.printStackTrace();
		}
		
		try 
		{
			String year = this.getInpGold().getYearField().getText();
			if (year.trim().isEmpty())
			{
				JOptionPane.showMessageDialog(inpGold, "You must input Year");
			}
		}
		catch (IllegalArgumentException e)
		{
			e.printStackTrace();
		}
		
		try 
		{
			String unit = this.getInpGold().getUnitField().getText();
			if (unit.trim().isEmpty())
			{
				JOptionPane.showMessageDialog(inpGold, "You must input Unit Price");
			}
		}
		catch (IllegalArgumentException e)
		{
			e.printStackTrace();
		}
		try 
		{
			String amount = this.getInpGold().getAmountField().getText();
			if (amount.trim().isEmpty())
			{
				JOptionPane.showMessageDialog(inpGold, "You must input Amount");
			}
		}
		catch (IllegalArgumentException e)
		{
			e.printStackTrace();
		}
		try 
		{
			String type = this.getInpGold().getTypeField().getText();
			if (type.trim().isEmpty())
			{
				JOptionPane.showMessageDialog(inpGold, "You must input Type");
			}
		}
		catch (IllegalArgumentException e)
		{
			e.printStackTrace();
		}

		
		this.getInpGold().getGoldTrade().setIdTrade(this.getInpGold().getIdField().getText());
		this.getInpGold().getGoldTrade().setDate(Integer.parseInt(this.getInpGold().getDayField().getText()));
		this.getInpGold().getGoldTrade().setMonth(Integer.parseInt(this.getInpGold().getMonthField().getText()));
		this.getInpGold().getGoldTrade().setYear(Integer.parseInt(this.getInpGold().getYearField().getText()));
		this.getInpGold().getGoldTrade().setUnitPrice(Float.parseFloat(this.getInpGold().getUnitField().getText()));
		this.getInpGold().getGoldTrade().setAmount(Integer.parseInt(this.getInpGold().getAmountField().getText()));
		this.getInpGold().getGoldTrade().setType(this.getInpGold().getTypeField().getText());

		this.getInpGold().dispose();
		
		String url = "jdbc:mysql://127.0.0.1:3306/doublekdb";
		String user = "root";
		String password = "Dtk.281005";
		try 
		{
			Connection conn = DriverManager.getConnection(url, user, password);
			Statement stm = conn.createStatement();
			
			String id = this.getInpGold().getIdField().getText();
			String date = this.getInpGold().getYearField().getText()+"-"+this.getInpGold().getMonthField().getText()+"-"+this.getInpGold().getDayField().getText();
			float unit = Float.parseFloat(this.getInpGold().getUnitField().getText());
			int amount = Integer.parseInt(this.getInpGold().getAmountField().getText());
			String type = this.getInpGold().getTypeField().getText();
			float money = this.getInpGold().getGoldTrade().IntoMoney();
			
			String sql = String.format("INSERT INTO golddb (idGoldTrade, dateGold, unitGold, amountGold, typeGold, intoGMoney) " + "VALUES('%s', '%s', %.2f, %d, '%s', %.2f)", id, date, unit, amount, type, money);
			
			int rowsAffected = stm.executeUpdate(sql);

			stm.close();
			conn.close();
			System.out.println("New item has been added successly!");
		}
		catch (SQLException e)
		{
			System.out.println("Error when connect to input!");
			e.printStackTrace();
		}
		
	}
	
}
