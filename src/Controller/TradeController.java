package Controller;

import View.InputGoldTradeView;
import View.TotalMonAmountView;
import View.TotalGoldAmountView;
import View.InputMoneyView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import View.ShowGoldView;
import View.TradeManagementView;
import javax.swing.*;
import View.ShowMoneyView;
import View.AvgIntoMoney;
import View.VipTradeView;

public class TradeController implements ActionListener{
	private TradeManagementView tradeView;
	private InputGoldTradeView inpGoldView;

	public InputGoldTradeView getInpGoldView()
	{
		return this.inpGoldView;
	}
	public TradeManagementView getTradeView()
	{
		return tradeView;
	}
	
	public TradeController(TradeManagementView a)
	{
		this.tradeView = a;
	}
	
	public TradeController(InputGoldTradeView a)
	{
		this.inpGoldView = a;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		JMenuItem choose = (JMenuItem) e.getSource();
		String menuText = choose.getText();
		
		switch (menuText)
		{
		case "New Gold Trading":
			System.out.println(1.1);
			InputGoldTradeView inpGold = new InputGoldTradeView();
			inpGold.setVisible(true);
			
			break;
		case "Show Gold Trading":
			System.out.println(1.2);
			ShowGoldView showGold = new ShowGoldView();
			showGold.setVisible(true);
			break;
		case "Total":
			System.out.println(1.3);
			TotalGoldAmountView totalGoldAmount = new TotalGoldAmountView();
			totalGoldAmount.setVisible(true);
			break;
		case "New Money Trading":
			System.out.println(2.1);
			InputMoneyView inpM = new InputMoneyView();
			inpM.setVisible(true);
			break;
		case "Show Money Trading":
			System.out.println(2.2);
			ShowMoneyView showMon = new ShowMoneyView();
			showMon.setVisible(true);
			break;
		case "Total Money":
			TotalMonAmountView totalMonView = new TotalMonAmountView();
			totalMonView.setVisible(true);
			System.out.println(2.3);
			break;
		case "Average Money":
			System.out.println(2.4);
			AvgIntoMoney avgMon = new AvgIntoMoney();
			avgMon.setVisible(true);
			break;
		case "Vip Trading":
			VipTradeView vip = new VipTradeView();
			vip.setVisible(true);
			System.out.println(3);
			break;
		default:
			System.out.println("No thing here");
				break;
		}
	}
}
