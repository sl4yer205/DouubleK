package View;

import java.awt.EventQueue;
import Controller.AvgIntoMonController;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;

public class AvgIntoMoney extends JFrame {
	private AvgIntoMonController avgMon = new AvgIntoMonController();
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField avgIntoMoney;
	
	public AvgIntoMonController getAvgMon() {
		return avgMon;
	}

	public void setAvgMon(AvgIntoMonController avgMon) {
		this.avgMon = avgMon;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AvgIntoMoney frame = new AvgIntoMoney();
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
	public AvgIntoMoney() {
		this.init();
		this.setVisible(true);
	}
	public void init()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 734, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		avgIntoMoney = new JTextField();
		avgIntoMoney.setFont(new Font("Tahoma", Font.PLAIN, 15));
		avgIntoMoney.setEditable(false);
		avgIntoMoney.setText("Average of Into Money:");
		avgIntoMoney.setBounds(87, 425, 260, 29);
		contentPane.add(avgIntoMoney);
		avgIntoMoney.setColumns(10);
		
		this.getAvgMon();
		String[] colName = this.getAvgMon().getColumns();
		String[][] db = this.getAvgMon().getData();
		float avg = this.getAvgMon().getAvg();
		
		JTable Atable = new JTable(db, colName);
		Atable.setEnabled(false);
		JScrollPane APane = new JScrollPane(Atable);
		APane.setBounds(10, 10, 700, 387);
		contentPane.add(APane);
		
		JLabel lblAvg = new JLabel(String.format("%.2f", avg));

		lblAvg.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAvg.setBounds(357, 425, 350, 29);
		contentPane.add(lblAvg);
	}
}
