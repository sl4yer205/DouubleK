package View;

import Controller.LoginController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Login_GUI extends JFrame {

	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JButton btnLogin;

    public Login_GUI() {
		initUI();
		attachController();
		setVisible(true);
	}

	// Initialize the user interface
	private void initUI() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 190, 450, 300);
		setResizable(false);

		// Container Panel
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(102, 153, 255));
		setContentPane(panel);

		// Username Label
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setBounds(50, 50, 100, 30);
		panel.add(lblUsername);

		// Username Input Field
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtUsername.setBounds(180, 50, 200, 30);
		panel.add(txtUsername);

		// Password Label
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBounds(50, 100, 100, 30);
		panel.add(lblPassword);

		// Password Input Field
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtPassword.setBounds(180, 100, 200, 30);
		panel.add(txtPassword);

		// Login Button
		btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLogin.setBackground(new Color(106, 90, 205));
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setBounds(150, 180, 100, 30);
		panel.add(btnLogin);

		// Add KeyListeners for Enter key login
		txtUsername.addKeyListener(new LoginKeyListener());
		txtPassword.addKeyListener(new LoginKeyListener());
	}

	// Attach the controller to the button
	private void attachController() {
        LoginController controller = new LoginController(this);
		btnLogin.addActionListener(controller);
	}

	// Getters for input fields (used by the controller)
	public String getUsername() {
		return txtUsername.getText();
	}

	public String getPassword() {
		return new String(txtPassword.getPassword());
	}

	public JButton getLoginButton() {
		return btnLogin;
	}

	// Key Listener for detecting Enter key press
	private class LoginKeyListener extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				btnLogin.doClick(); // Gia_lap enter = mouse click
			}
		}
	}

	// Main method for standalone testing
	public static void main(String[] args) {
		new Login_GUI();
	}
}