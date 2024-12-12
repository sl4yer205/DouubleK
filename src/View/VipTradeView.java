package View;

import java.awt.EventQueue;
import Controller.VipController;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class VipTradeView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private VipController vipCtrl = new VipController();
	
	public VipController getVipCtrl()
	{
		return this.vipCtrl;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VipTradeView frame = new VipTradeView();
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
	public VipTradeView()
	{
		this.init();
		this.setVisible(true);
	}
	public void init()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 747, 519);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.getVipCtrl();
		String[] colName = this.getVipCtrl().getColumns();
		String[][] db = this.getVipCtrl().getData();
		
		JTable Vtable = new JTable(db, colName);
		Vtable.setEnabled(false);
		JScrollPane scrollVPane = new JScrollPane(Vtable);
		scrollVPane.setBounds(10, 10, 713, 462);
		contentPane.add(scrollVPane);
	}
}
