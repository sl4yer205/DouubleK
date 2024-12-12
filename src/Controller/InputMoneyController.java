package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import View.InputMoneyView;

public class InputMoneyController implements ActionListener{
	private InputMoneyView inpMoneyView;
	
	
	public InputMoneyView getInpMoneyView() {
		return inpMoneyView;
	}

	public InputMoneyController(InputMoneyView inpMView)
	{
		this.inpMoneyView = inpMView;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		JButton choose = (JButton) e.getSource();
		String chosen = choose.getText();
		if (chosen.equals("Enter"))
		{
			input();
		}
		else
		{
			LocalDate time = LocalDate.now();
			
			int day = time.getDayOfMonth();
			this.getInpMoneyView().getDateMField().setText(Integer.toString(day));
			
			int month = time.getMonthValue();
			this.getInpMoneyView().getMonthMField().setText(String.valueOf(month));
			
			int year = time.getYear();
			this.getInpMoneyView().getYearMField().setText(String.valueOf(year));
			
		}
	}
	
	public void input()
	{
		try
		{
			int day = Integer.parseInt(this.getInpMoneyView().getDateMField().getText());
			int month = Integer.parseInt(this.getInpMoneyView().getMonthMField().getText());
			int year = Integer.parseInt(this.getInpMoneyView().getYearMField().getText());
			
		}
		catch (NumberFormatException e)
		{
			JOptionPane.showMessageDialog(inpMoneyView, "Date must be an Integer Number!");
			this.getInpMoneyView().getDateMField().setText("");
			this.getInpMoneyView().getMonthMField().setText("");
			this.getInpMoneyView().getYearMField().setText("");
		}
		
		try
		{
			float price = Float.parseFloat(this.getInpMoneyView().getUnitMField().getText());
		}
		catch (NumberFormatException e)
		{
			JOptionPane.showMessageDialog(inpMoneyView, "Unit Price must be a Float!");
			this.getInpMoneyView().getUnitMField().setText("");
		}
		try
		{
			int amount = Integer.parseInt(this.getInpMoneyView().getAmountMField().getText());
		}
		catch (NumberFormatException e)
		{
			JOptionPane.showMessageDialog(inpMoneyView, "Amount must be an Integer Number!");
			this.getInpMoneyView().getAmountMField().setText("");
		}
		try 
		{
			String id = this.getInpMoneyView().getIdMField().getText();
			if (id.trim().isEmpty())
			{
				JOptionPane.showMessageDialog(inpMoneyView, "You must input Day");
			}
		}
		catch (IllegalArgumentException e)
		{
			e.printStackTrace();
		}
		try 
		{
			String day = this.getInpMoneyView().getDateMField().getText();
			if (day.trim().isEmpty())
			{
				JOptionPane.showMessageDialog(inpMoneyView, "You must input Day");
			}
		}
		catch (IllegalArgumentException e)
		{
			e.printStackTrace();
		}
		
		try 
		{
			String month = this.getInpMoneyView().getMonthMField().getText();
			if (month.trim().isEmpty())
			{
				JOptionPane.showMessageDialog(inpMoneyView, "You must input Month");
			}
		}
		catch (IllegalArgumentException e)
		{
			e.printStackTrace();
		}
		
		try 
		{
			String year = this.getInpMoneyView().getYearMField().getText();
			if (year.trim().isEmpty())
			{
				JOptionPane.showMessageDialog(inpMoneyView, "You must input Year");
			}
		}
		catch (IllegalArgumentException e)
		{
			e.printStackTrace();
		}
		
		try 
		{
			String unit = this.getInpMoneyView().getUnitMField().getText();
			if (unit.trim().isEmpty())
			{
				JOptionPane.showMessageDialog(inpMoneyView, "You must input Unit Price");
			}
		}
		catch (IllegalArgumentException e)
		{
			e.printStackTrace();
		}
		try 
		{
			String amount = this.getInpMoneyView().getAmountMField().getText();
			if (amount.trim().isEmpty())
			{
				JOptionPane.showMessageDialog(inpMoneyView, "You must input Amount");
			}
		}
		catch (IllegalArgumentException e)
		{
			e.printStackTrace();
		}
		try 
		{
			String type = (String) this.getInpMoneyView().getComboBox().getSelectedItem();
			if (type.trim().isEmpty())
			{
				JOptionPane.showMessageDialog(inpMoneyView, "You must input Type");
			}
		}
		
		catch (IllegalArgumentException e)
		{
			e.printStackTrace();
		}
		try 
		{
			String rate = this.getInpMoneyView().getRateMField().getText();
			if (rate.trim().isEmpty())
			{
				JOptionPane.showMessageDialog(inpMoneyView, "You must input Rate");
			}
		}
		catch (IllegalArgumentException e)
		{
			e.printStackTrace();
		}
		
		
		this.getInpMoneyView().getMonTrade().setIdTrade(this.getInpMoneyView().getIdMField().getText());
		this.getInpMoneyView().getMonTrade().setDate(Integer.parseInt(this.getInpMoneyView().getDateMField().getText()) );
		this.getInpMoneyView().getMonTrade().setMonth(Integer.parseInt(this.getInpMoneyView().getMonthMField().getText()));
		this.getInpMoneyView().getMonTrade().setYear(Integer.parseInt(this.getInpMoneyView().getYearMField().getText()));
		this.getInpMoneyView().getMonTrade().setUnitPrice(Float.parseFloat(this.getInpMoneyView().getUnitMField().getText()));
		this.getInpMoneyView().getMonTrade().setAmount(Integer.parseInt(this.getInpMoneyView().getAmountMField().getText()));
		this.getInpMoneyView().getMonTrade().setType((String) this.getInpMoneyView().getComboBox().getSelectedItem());
		this.getInpMoneyView().getMonTrade().setRate(Float.parseFloat(this.getInpMoneyView().getRateMField().getText()));
		
		System.out.println(this.getInpMoneyView().getIdMField().getText());
		System.out.println(this.getInpMoneyView().getDateMField().getText());
		System.out.println(Integer.parseInt(this.getInpMoneyView().getMonthMField().getText()));
		System.out.println(Integer.parseInt(this.getInpMoneyView().getYearMField().getText()));
		System.out.println(Float.parseFloat(this.getInpMoneyView().getUnitMField().getText()));
		System.out.println(Integer.parseInt(this.getInpMoneyView().getAmountMField().getText()));
		System.out.println((String) this.getInpMoneyView().getComboBox().getSelectedItem());
		
		this.getInpMoneyView().dispose();
		
		String url = "jdbc:mysql://127.0.0.1:3306/doublekdb";
		String user = "root";
		String password = "Dtk.281005";
		try 
		{
			Connection conn = DriverManager.getConnection(url, user, password);
			Statement stm = conn.createStatement();
			
			String id = this.getInpMoneyView().getIdMField().getText();
			String date = this.getInpMoneyView().getYearMField().getText()+"-"+this.getInpMoneyView().getMonthMField().getText()+"-"+this.getInpMoneyView().getDateMField().getText();
			float unit = Float.parseFloat(this.getInpMoneyView().getUnitMField().getText());
			int amount = Integer.parseInt(this.getInpMoneyView().getAmountMField().getText());
			String type = String.valueOf(this.getInpMoneyView().getComboBox().getSelectedItem());
			float rate = Float.parseFloat(this.getInpMoneyView().getRateMField().getText());
			float money = this.getInpMoneyView().getMonTrade().IntoMoney();
			
			String sql = String.format("INSERT INTO moneydb (idMoney, dateMoney, unitMoney, amountMoney, typeMoney, rateMoney, intoMMoney) " + "VALUES('%s', '%s', %.2f, %d, '%s', %.2f, %.2f)", id, date, unit, amount, type, rate, money);
			
			int rowsAffected = stm.executeUpdate(sql);

			stm.close();
			conn.close();
			System.out.println("New item has been added successly!");
		}
		catch (SQLException er)
		{
			System.out.println("Error when connect to input!");
			er.printStackTrace();
		}
	}
}
