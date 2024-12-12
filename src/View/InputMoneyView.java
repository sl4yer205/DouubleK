package View;

import Controller.InputMoneyController;
import Model.moneyTrade;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;

public class InputMoneyView extends JFrame {
	private moneyTrade monTrade;
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField idMField;
	private JTextField dateMField;
	private JTextField monthMField;
	private JTextField yearMField;
	private JTextField unitMField;
	private JTextField amountMField;
	private JTextField rateMField;
	
	private JComboBox<String> comboBox;
	
	public JComboBox<String> getComboBox()
	{
		return this.comboBox;
	}
	
	
	public moneyTrade getMonTrade() {
		return monTrade;
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public JTextField getIdMField() {
		return idMField;
	}

	public JTextField getDateMField() {
		return dateMField;
	}

	public JTextField getMonthMField() {
		return monthMField;
	}

	public JTextField getYearMField() {
		return yearMField;
	}

	public JTextField getUnitMField() {
		return unitMField;
	}

	public JTextField getAmountMField() {
		return amountMField;
	}

	public JTextField getRateMField() {
		return rateMField;
	}

	/**
	 * Create the frame.
	 */
	public InputMoneyView()
	{
		setTitle("New Money Trading");
		this.monTrade = new moneyTrade();
		this.init();
		this.setVisible(true);
	}
	
	public void init()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel idMLbl = new JLabel("ID");
		idMLbl.setBounds(23, 23, 45, 13);
		contentPane.add(idMLbl);
		
		idMField = new JTextField();
		idMField.setBounds(90, 20, 140, 19);
		contentPane.add(idMField);
		idMField.setColumns(10);
		
		JLabel dateMLbl = new JLabel("Date");
		dateMLbl.setBounds(23, 64, 45, 13);
		contentPane.add(dateMLbl);
		
		dateMField = new JTextField();
		dateMField.setBounds(65, 61, 31, 19);
		contentPane.add(dateMField);
		dateMField.setColumns(10);
		
		JLabel monthMLbl = new JLabel("Month");
		monthMLbl.setBounds(106, 64, 45, 13);
		contentPane.add(monthMLbl);
		
		monthMField = new JTextField();
		monthMField.setBounds(161, 61, 31, 19);
		contentPane.add(monthMField);
		monthMField.setColumns(10);
		
		JLabel yearMLbl = new JLabel("Year");
		yearMLbl.setBounds(230, 64, 45, 13);
		contentPane.add(yearMLbl);
		
		yearMField = new JTextField();
		yearMField.setBounds(285, 61, 56, 19);
		contentPane.add(yearMField);
		yearMField.setColumns(10);
		
		JLabel unitMLbl = new JLabel("Unit Price");
		unitMLbl.setBounds(23, 108, 56, 13);
		contentPane.add(unitMLbl);
		
		unitMField = new JTextField();
		unitMField.setBounds(90, 105, 96, 19);
		contentPane.add(unitMField);
		unitMField.setColumns(10);
		
		amountMField = new JTextField();
		amountMField.setBounds(90, 161, 96, 19);
		contentPane.add(amountMField);
		amountMField.setColumns(10);
		
		JLabel amountMLbl = new JLabel("Amount");
		amountMLbl.setBounds(23, 164, 45, 13);
		contentPane.add(amountMLbl);
		
		JLabel typeMLbl = new JLabel("Type");
		typeMLbl.setBounds(23, 210, 45, 13);
		contentPane.add(typeMLbl);
		
		String[] types = {"VND", "USD", "€"};
		
		
		comboBox = new JComboBox<>(types);
		comboBox.setBounds(90, 206, 78, 21);
		comboBox.setSelectedIndex(-1);
		contentPane.add(comboBox);
		
		JLabel rateMLbl = new JLabel("Rate");
		rateMLbl.setBounds(311, 146, 45, 13);
		contentPane.add(rateMLbl);
		
		rateMField = new JTextField();
		rateMField.setBounds(359, 143, 50, 19);
		contentPane.add(rateMField);
		rateMField.setColumns(10);
		
		ActionListener enterLis = new InputMoneyController(this);
		ActionListener setDFLis = new InputMoneyController(this);
		
		JButton enterMBtn = new JButton("Enter");
		enterMBtn.setBounds(204, 232, 85, 21);
		enterMBtn.addActionListener(enterLis);
		contentPane.add(enterMBtn);
		
		JButton setDFBtn = new JButton("Set as default");
		setDFBtn.setBounds(308, 87, 127, 21);
		setDFBtn.addActionListener(setDFLis);
		contentPane.add(setDFBtn);
	}
}
