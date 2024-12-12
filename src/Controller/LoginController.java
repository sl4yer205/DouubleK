package Controller;

import View.Login_GUI;
import View.TradeManagementView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController implements ActionListener {

	private Login_GUI loginGUI;

	public LoginController(Login_GUI loginGUI) {
		this.loginGUI = loginGUI;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Get the entered credentials from the GUI
		String username = loginGUI.getUsername();
		String password = loginGUI.getPassword();

		// Perform basic login validation (this can later be replaced with business logic)
		if ("admin".equals(username) && "123".equals(password)) {
			JOptionPane.showMessageDialog(loginGUI, "Login Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);

			// Close (dispose of) the current Login GUI
			loginGUI.dispose();

			// Navigate to TradeManagementView
			TradeManagementView tradeManagementView = new TradeManagementView();
			tradeManagementView.setVisible(true); // Open the new window
		} else {
			JOptionPane.showMessageDialog(loginGUI, "Username or Password incorrect!", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}