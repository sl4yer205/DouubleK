package View;

import javax.swing.ImageIcon;
import Model.goldenTrade;
import Model.moneyTrade;
import javax.swing.JFrame;
import javax.swing.JPanel;
import Controller.TradeController;

import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JLabel;

public class TradeManagementView extends JFrame {
	private goldenTrade goldTrade;
	private moneyTrade monTrade;
	
	private static final long serialVersionUID = 1L;
	
	private JScrollPane scrollPane;
	private JMenuBar menuBar;
	private JMenuItem inpGoldItem;
	private JMenuItem outGoldItem;
	private JMenuItem totalGoldItem;

	private JMenu moneyTrade;
	private JMenuItem inpMItem;
	private JMenu goldenTrade;
	private JMenuItem outMItem;
	private JMenuItem totalMItem;
	private JMenuItem avgMItem;

	private JMenu vipTrading;
	private JMenuItem vipTradeItem;
	private JPanel panel;
	private JLabel Image;
	
	
	// getter + setter
	public goldenTrade getGoldTrade() {
		return goldTrade;
	}

	public void setGoldTrade(goldenTrade goldTrade) {
		this.goldTrade = goldTrade;
	}

	public moneyTrade getMonTrade() {
		return monTrade;
	}

	public void setMonTrade(moneyTrade monTrade) {
		this.monTrade = monTrade;
	}

	
	
	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

//	public JMenuBar getMenuBar() {
//		return this.menuBar;
//	}

	public void setMenuBar(JMenuBar menuBar) {
		this.menuBar = menuBar;
	}

	public JMenuItem getInpGoldItem() {
		return inpGoldItem;
	}

	public void setInpGoldItem(JMenuItem inpGoldItem) {
		this.inpGoldItem = inpGoldItem;
	}

	public JMenuItem getOutGoldItem() {
		return outGoldItem;
	}

	public void setOutGoldItem(JMenuItem outGoldItem) {
		this.outGoldItem = outGoldItem;
	}

	public JMenuItem getTotalGoldItem() {
		return totalGoldItem;
	}

	public void setTotalGoldItem(JMenuItem totalGoldItem) {
		this.totalGoldItem = totalGoldItem;
	}

	public JMenu getMoneyTrade() {
		return moneyTrade;
	}

	public void setMoneyTrade(JMenu moneyTrade) {
		this.moneyTrade = moneyTrade;
	}

	public JMenuItem getInputMItem() {
		return inpMItem;
	}

	public void setInputMItem(JMenuItem inputMItem) {
		this.inpMItem = inputMItem;
	}

	public JMenu getGoldenTrade() {
		return goldenTrade;
	}

	public void setGoldenTrade(JMenu goldenTrade) {
		this.goldenTrade = goldenTrade;
	}

	public JMenuItem getOutputMItem() {
		return outMItem;
	}

	public void setOutputMItem(JMenuItem outputMItem) {
		this.outMItem = outputMItem;
	}

	public JMenuItem getTotalMItem() {
		return totalMItem;
	}

	public void setTotalMItem(JMenuItem totalMItem) {
		this.totalMItem = totalMItem;
	}

	public JMenuItem getAvgMItem() {
		return avgMItem;
	}

	public void setAvgMItem(JMenuItem avgMItem) {
		this.avgMItem = avgMItem;
	}

	public JMenu getVipTrading() {
		return vipTrading;
	}

	public void setVipTrading(JMenu vipTrading) {
		this.vipTrading = vipTrading;
	}

	public JMenuItem getVipTradeItem() {
		return vipTradeItem;
	}

	public void setVipTradeItem(JMenuItem vipTradeItem) {
		this.vipTradeItem = vipTradeItem;
	}


	public TradeManagementView()
	{
		setTitle("Gold and Money - Double K");
		setBackground(new Color(0, 204, 204));
		this.goldTrade = new goldenTrade();
		this.monTrade = new moneyTrade();
		
		this.init();
		this.setVisible(true);
	}
	public void init()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 781, 544);
		
		scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		menuBar = new JMenuBar();
		menuBar.setForeground(new Color(240, 255, 255));
		menuBar.setBackground(new Color(240, 255, 255));
		scrollPane.setColumnHeaderView(menuBar);
		
		goldenTrade = new JMenu("Golden Trade");
		goldenTrade.setForeground(new Color(255, 215, 0));
		goldenTrade.setBackground(new Color(240, 255, 255));
		menuBar.add(goldenTrade);
		
		inpGoldItem = new JMenuItem("New Gold Trading");
		inpGoldItem.setBackground(new Color(255, 255, 255));
		inpGoldItem.setForeground(new Color(255, 215, 0));
		goldenTrade.add(inpGoldItem);
		
		outGoldItem = new JMenuItem("Show Gold Trading");
		outGoldItem.setBackground(new Color(255, 255, 255));
		outGoldItem.setForeground(new Color(255, 215, 0));
		goldenTrade.add(outGoldItem);
		
		totalGoldItem = new JMenuItem("Total");
		totalGoldItem.setBackground(new Color(255, 255, 255));
		totalGoldItem.setForeground(new Color(255, 215, 0));
		goldenTrade.add(totalGoldItem);
		
		moneyTrade = new JMenu("Money Trade");
		moneyTrade.setForeground(new Color(102, 204, 0));
		menuBar.add(moneyTrade);
		
		inpMItem = new JMenuItem("New Money Trading");
		inpMItem.setBackground(new Color(255, 255, 255));
		inpMItem.setForeground(new Color(50, 205, 50));
		moneyTrade.add(inpMItem);
		
		outMItem = new JMenuItem("Show Money Trading");
		outMItem.setBackground(new Color(255, 255, 255));
		outMItem.setForeground(new Color(50, 205, 50));
		moneyTrade.add(outMItem);
		
		totalMItem = new JMenuItem("Total Money");
		totalMItem.setBackground(new Color(255, 255, 255));
		totalMItem.setForeground(new Color(50, 205, 50));
		moneyTrade.add(totalMItem);
		
		avgMItem = new JMenuItem("Average Money");
		avgMItem.setBackground(new Color(255, 255, 255));
		avgMItem.setForeground(new Color(50, 205, 50));
		moneyTrade.add(avgMItem);
		
		vipTrading = new JMenu("VIP");
		vipTrading.setForeground(new Color(255, 102, 102));
		menuBar.add(vipTrading);
		
		vipTradeItem = new JMenuItem("Vip Trading");
		vipTradeItem.setBackground(new Color(255, 255, 255));
		vipTradeItem.setForeground(new Color(255, 0, 0));
		vipTrading.add(vipTradeItem);
		
		panel = new JPanel();
		panel.setBackground(new Color(240, 248, 255));
		scrollPane.setViewportView(panel);
		panel.setLayout(null);
		
		ImageIcon img = new ImageIcon("D:\\DK_My_Code\\Code_Java\\DoubleK\\src\\concac.jpg", "concac");
		Image = new JLabel("Image", img, JLabel.CENTER);
		Image.setBounds(10, 10, 745, 463);
		panel.add(Image);
		
		
		
		
		
		ActionListener menuListen = new TradeController(this);
		
		inpGoldItem.addActionListener(menuListen);
		outGoldItem.addActionListener(menuListen);
		totalGoldItem.addActionListener(menuListen);
		
		inpMItem.addActionListener(menuListen);
		outMItem.addActionListener(menuListen);
		totalMItem.addActionListener(menuListen);
		avgMItem.addActionListener(menuListen);
		
		vipTradeItem.addActionListener(menuListen);
	}
}
