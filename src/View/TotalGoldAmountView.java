package View;

import java.awt.EventQueue;
import Controller.TotalGoldAmountController;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;

public class TotalGoldAmountView extends JFrame {
	private TotalGoldAmountController totalGold = new TotalGoldAmountController();
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTotalGoldAmount;
	
	public TotalGoldAmountController getTotalGold() {
		return totalGold;
	}
	
	//Create a function in TotalMonAmountController to display on the frame
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TotalGoldAmountView frame = new TotalGoldAmountView();
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
	public TotalGoldAmountView()
	{
		this.init();
		this.setVisible(true);
	}
	public void init()
	{
		setTitle("Total Gold Amount");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 713, 468);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtTotalGoldAmount = new JTextField();
		txtTotalGoldAmount.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTotalGoldAmount.setText("Total Gold Amount");
		txtTotalGoldAmount.setEditable(false);
		txtTotalGoldAmount.setBounds(439, 388, 170, 33);
		contentPane.add(txtTotalGoldAmount);
		txtTotalGoldAmount.setColumns(10);
		
		this.getTotalGold();
		String[] col = this.getTotalGold().getColumns();
		String[][] data = this.getTotalGold().getData();
		int totalGAmount = this.getTotalGold().getTotalAmount();
		
		txtTotalGoldAmount.setText("Total Gold Amount:     ");
		
		JTable gTotalTable = new JTable(data, col);
		gTotalTable.setEnabled(false);
		JScrollPane gTotalPane = new JScrollPane(gTotalTable);
		gTotalPane.setBounds(10, 10, 679, 368);
		contentPane.add(gTotalPane);
		
		JLabel valueGTotal = new JLabel();
		valueGTotal.setText(String.valueOf(totalGAmount));
		valueGTotal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		valueGTotal.setBounds(624, 392, 65, 25);
		contentPane.add(valueGTotal);
	}
}
