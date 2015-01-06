package iManage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
import javax.swing.event.*;

/*
 * 登陆界面：
 * 默认：管理员工号为1000，销售员为1001到1005，并且默认工号和密码相同
 * 只有输入正确才能登陆，并且要选择正确的相应按钮告知程序是管理员登陆还是销售员登陆。
 * 缺陷：监听器设置出错，导致无法正确登陆，这个需要接下来的进一步改进。
 * 需要继续完成的功能：按钮的监听器；
 */
public class Login extends JFrame {

	private JTextField textField1;// account
	private JPasswordField passwordField;
	private Box hbox1, hbox2, hbox3, hbox4;// to hold components
	private ButtonGroup group;// to choose whether you are manager or worker
	JPanel jPanel;// to set boxes
	JLabel label1, label2;
	JButton loginButton, cancelButton;

	JRadioButton manageButton, workButton;

	public static final int DEFAULT_WIDTH = 300;
	public static final int DEFAULT_HEIGHT = 300;

	public static void main(String[] args) {
		JFrame login = new Login();
		login.setTitle("IManage LogIn");
		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		login.setBounds(100, 100, 300, 300);
		// login.setSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
		login.setVisible(true);
	}

	// create a function to merge the operations (deleted)
	/*
	 * private void putBox(Box box,JLabel label,JTextField text) { box =
	 * Box.createHorizontalBox(); box.add(label); // separate with a 10-pixel
	 * strut box.add(Box.createHorizontalStrut(10)); box.add(text); }
	 */

	public Login() {
		// construct the top horizontal box
		label1 = new JLabel("账号:");
		textField1 = new JTextField(10);
		textField1.setMaximumSize(textField1.getPreferredSize());// ?

		hbox1 = Box.createHorizontalBox();
		hbox1.add(label1);
		// separate with a 10-pixel strut
		hbox1.add(Box.createHorizontalStrut(10));
		hbox1.add(textField1);

		// construct the key horizontal box
		label2 = new JLabel("密码:");
		passwordField = new JPasswordField(10);
		passwordField.setMaximumSize(passwordField.getPreferredSize());// ?

		hbox2 = Box.createHorizontalBox();
		hbox2.add(label2);
		// separate with a 10-pixel strut
		hbox2.add(Box.createHorizontalStrut(10));
		hbox2.add(passwordField);
		// putBox(hbox2, label2, passwordField);

		// create buttons
		loginButton = new JButton("Log In");
		cancelButton = new JButton("Cancel");

		hbox3 = Box.createHorizontalBox();
		hbox3.add(Box.createGlue());// use "glue" to push the two buttons apart
		hbox3.add(loginButton);
		hbox3.add(Box.createGlue());
		hbox3.add(cancelButton);
		// hbox3.add(Box.createGlue());

		group = new ButtonGroup();
		manageButton = new JRadioButton("管理员", false);
		group.add(manageButton);
		workButton = new JRadioButton("销售员", false);
		group.add(workButton);

		hbox4 = Box.createHorizontalBox();
		hbox4.add(Box.createGlue());// use "glue" to push the two buttons apart
		hbox4.add(manageButton);
		hbox4.add(Box.createGlue());
		hbox4.add(workButton);
		hbox4.add(Box.createGlue());

		// create a panel to put buttons and group buttons on
		jPanel = new JPanel();
		jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));
		jPanel.add(hbox1, BorderLayout.NORTH);
		jPanel.add(hbox2, BorderLayout.CENTER);
		jPanel.add(hbox4, BorderLayout.CENTER);
		hbox3.add(Box.createGlue());
		jPanel.add(hbox3, BorderLayout.SOUTH);
		// put the panel to the frame
		setContentPane(jPanel);

		this.setVisible(true);

		// create the listeners
		// ActionListener loginLis=new LoginListener();
		// ActionListener cancelLis=new Terminator();

		// connect listeners to buttons
		// log in to open the other frame for later use by managers or workers
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				// account is initialized to be equal to the password
				// and the passport of the manager is initialized to be 1000
				String pass = String.valueOf(passwordField.getPassword());

				// manager's Frame is opening.
				if (textField1.getText().equals(pass)
						&& textField1.getText().equals("1000")) {
					// log in successfully
					if (manageButton.isSelected()) {
						new MainFrameManager().setVisible(true);
					} else // if(group.toString()=="销售员")
					{
						JOptionPane.showMessageDialog(null, "Wrong Identity! ",
								"错误", JOptionPane.ERROR_MESSAGE);
					}
					/*
					 * else { JOptionPane.showMessageDialog(null, "请选择你的身份！",
					 * "错误", JOptionPane.ERROR_MESSAGE); }
					 */
				}
				// worker's Frame is opening.
				if (textField1.getText().equals(pass)
						&& (textField1.getText().equals("1001")
								|| textField1.getText().equals("1002")
								|| textField1.getText().equals("1003")
								|| textField1.getText().equals("1004") || textField1
								.getText().equals("1005"))) {
					// log in successfully
					if (workButton.isSelected()) {
						new MainFrame().setVisible(true);
					} else // if(group.toString()=="销售员")
					{
						JOptionPane.showMessageDialog(null, "Wrong Identity! ",
								"错误", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}

}
