package View;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import Controller.ShowGoldController;

public class ShowGoldView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable gTable;
	
	private ShowGoldController showCtrl = new ShowGoldController();
	
	public ShowGoldController getShowCtrl()
	{
		return this.showCtrl;
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowGoldView frame = new ShowGoldView();
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
	public ShowGoldView() {
		this.init();
		this.setVisible(true);
	}
	public void init()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 786, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.getShowCtrl();
		String[] columns = this.getShowCtrl().getColumns();
		String[][] data = this.getShowCtrl().getData();
		
		gTable = new JTable(data, columns);
		gTable.setEnabled(false);
		JScrollPane gPane = new JScrollPane(gTable);
		gPane.setBounds(10, 10, 752, 407);
		contentPane.add(gPane);

	}
}
