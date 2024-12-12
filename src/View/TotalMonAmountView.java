package View;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import Controller.TotalMonAmountController;

public class TotalMonAmountView extends JFrame {
	private TotalMonAmountController totalMon = new TotalMonAmountController();
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField totalMonField;

	public TotalMonAmountController getTotalMon() {
		return totalMon;
	}
	
	//Create a function in TotalMonAmountController to display on the frame

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TotalMonAmountView frame = new TotalMonAmountView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TotalMonAmountView()
	{
		this.init();
		this.setVisible(true);
	}
	public void init()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 792, 512);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		totalMonField = new JTextField();
		totalMonField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		totalMonField.setEditable(false);
		totalMonField.setText("Total Money Amount:");
		totalMonField.setBounds(513, 441, 160, 34);
		contentPane.add(totalMonField);
		totalMonField.setColumns(10);
		
		this.getTotalMon();
		String[] col = this.getTotalMon().getColumns();
		String[][] data = this.getTotalMon().getData();
		int totalMAmount = this.getTotalMon().getTotalAmount();
		
		totalMonField.setText("Total Money Amount:     ");
		
		JTable mTotalTable = new JTable(data, col);
		mTotalTable.setEnabled(false);
		JScrollPane mTotalPane = new JScrollPane(mTotalTable);
		mTotalPane.setBounds(10, 10, 754, 417);
		contentPane.add(mTotalPane);
		
		JLabel valueMTotal = new JLabel();
		valueMTotal.setText(String.valueOf(totalMAmount));
		valueMTotal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		valueMTotal.setBounds(683, 445, 65, 25);
		contentPane.add(valueMTotal);
	}
}
