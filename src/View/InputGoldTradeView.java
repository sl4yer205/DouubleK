package View;

import Model.goldenTrade;
import Controller.InputGoldController;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;


public class InputGoldTradeView extends JFrame {
	private goldenTrade goldTrade;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField idField;
	private JTextField dayField;
	private JTextField monthField;
	private JTextField yearField;
	private JTextField unitField;
	private JTextField amountField;
	private JTextField typeField;
	private JButton enterBtn;
	private JButton defaultBtn;
	
	private InputGoldController inpGold;
	
	public InputGoldController getInpGold() {
		return inpGold;
	}
	public JButton getEnterBtn()
	{
		return this.enterBtn;
	}
	public goldenTrade getGoldTrade() {
		return this.goldTrade;
	}
	
	public void setGoldTrade(goldenTrade goldTrade) {
		this.goldTrade = goldTrade;
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public void setCustomContentPane(JPanel contentPane) {
		this.contentPane = contentPane;
		super.setContentPane(contentPane);
	}

	public JTextField getIdField() {
		return idField;
	}

	public void setIdField(JTextField idField) {
		this.idField = idField;
	}

	public JTextField getDayField() {
		return dayField;
	}

	public void setDayField(JTextField dayField) {
		this.dayField = dayField;
	}

	public JTextField getMonthField() {
		return monthField;
	}

	public void setMonthField(JTextField monthField) {
		this.monthField = monthField;
	}

	public JTextField getYearField() {
		return yearField;
	}

	public void setYearField(JTextField yearField) {
		this.yearField = yearField;
	}

	public JTextField getUnitField() {
		return unitField;
	}

	public void setUnitField(JTextField unitField) {
		this.unitField = unitField;
	}

	public JTextField getAmountField() {
		return amountField;
	}

	public void setAmountField(JTextField amountField) {
		this.amountField = amountField;
	}

	public JTextField getTypeField() {
		return typeField;
	}

	public void setTypeField(JTextField typeField) {
		this.typeField = typeField;
	}

	/**
	 * Create the frame.
	 */
	public InputGoldTradeView()
	{
		this.goldTrade = new goldenTrade();
		this.init();
		this.setVisible(true);
	}
	
	public void init() {
	    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    setTitle("New Gold Trading");
	    setBounds(100, 100, 455, 310);

	    contentPane = new JPanel();
	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	    setCustomContentPane(contentPane);
	    contentPane.setLayout(null);

	    JLabel idGoldeLbl = new JLabel("ID Gold ");
	    idGoldeLbl.setBounds(10, 35, 88, 16);
	    contentPane.add(idGoldeLbl);

	    idField = new JTextField();
	    idField.setBounds(108, 32, 157, 19);
	    contentPane.add(idField);
	    idField.setColumns(10);

	    JLabel dayLbl = new JLabel("Day");
	    dayLbl.setBounds(10, 76, 45, 13);
	    contentPane.add(dayLbl);

	    dayField = new JTextField();
	    dayField.setBounds(47, 73, 36, 19);
	    contentPane.add(dayField);
	    dayField.setColumns(10);

	    JLabel monthLbl = new JLabel("Month");
	    monthLbl.setBounds(108, 76, 45, 13);
	    contentPane.add(monthLbl);

	    monthField = new JTextField();
	    monthField.setBounds(151, 73, 36, 19);
	    contentPane.add(monthField);
	    monthField.setColumns(10);

	    JLabel lblNewLabel = new JLabel("Year");
	    lblNewLabel.setBounds(218, 76, 45, 13);
	    contentPane.add(lblNewLabel);

	    yearField = new JTextField();
	    yearField.setBounds(257, 73, 63, 19);
	    contentPane.add(yearField);
	    yearField.setColumns(10);

	    JLabel unitLbl = new JLabel("Unit Price");
	    unitLbl.setBounds(10, 123, 76, 13);
	    contentPane.add(unitLbl);

	    unitField = new JTextField();
	    unitField.setBounds(108, 120, 96, 19);
	    contentPane.add(unitField);
	    unitField.setColumns(10);

	    JLabel amountLbl = new JLabel("Amount");
	    amountLbl.setBounds(10, 163, 45, 13);
	    contentPane.add(amountLbl);

	    amountField = new JTextField();
	    amountField.setBounds(108, 160, 96, 19);
	    contentPane.add(amountField);
	    amountField.setColumns(10);

	    JLabel typeLbl = new JLabel("Type");
	    typeLbl.setBounds(10, 209, 45, 13);
	    contentPane.add(typeLbl);

	    typeField = new JTextField();
	    typeField.setBounds(108, 206, 96, 19);
	    contentPane.add(typeField);
	    typeField.setColumns(10);

	    enterBtn = new JButton("Enter");
	    ActionListener inpGoldListen = new InputGoldController(this);
	    enterBtn.setBounds(173, 242, 85, 21);
	    enterBtn.addActionListener(inpGoldListen);

	    contentPane.add(enterBtn);
	    
	    defaultBtn = new JButton("Default");
	    defaultBtn.setBounds(346, 72, 85, 21);
	    ActionListener dfLis = new InputGoldController(this);
	    defaultBtn.addActionListener(dfLis);
	    contentPane.add(defaultBtn);
	}
}
