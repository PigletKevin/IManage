package iManage;

import java.awt.*;

import javax.swing.*;

public class LoginWarning extends JFrame {

	public static void main(String[] args) {
		JFrame LoginWarning = new Login();
		LoginWarning.setTitle("Warning!");
		LoginWarning.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		LoginWarning.setBounds(300, 300, 400, 200);
		// login.setSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
		LoginWarning.setVisible(true);
	}

	public LoginWarning() {
		JPanel warningPanel = new JPanel();
		JLabel warning = new JLabel(
				" Wrongly corresponding \n account and password !\n "
						+ " Please retry!");
		warningPanel.setLayout(new BorderLayout());
		warningPanel.add(warning, BorderLayout.CENTER);
		setContentPane(warningPanel);
		setVisible(true);
	}
}
