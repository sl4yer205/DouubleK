package View;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Controller.ShowMoneyController;

public class ShowMoneyView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable Mtable;
	private ShowMoneyController monCtrl = new ShowMoneyController();
	

	public ShowMoneyController getMonCtrl() {
		return monCtrl;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowMoneyView frame = new ShowMoneyView();
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
	public ShowMoneyView() {
		this.init();
		this.setVisible(true);
	}
	public void init()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 616, 454);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.getMonCtrl();
		String[] colName = this.getMonCtrl().getColumns();
		String[][] db = this.getMonCtrl().getData();
		
		Mtable = new JTable(db, colName);
		Mtable.setEnabled(false);
		JScrollPane scrollMPane = new JScrollPane(Mtable);
		scrollMPane.setBounds(10, 10, 582, 397);
		contentPane.add(scrollMPane);
	}

}
