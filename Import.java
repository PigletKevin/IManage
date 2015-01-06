package iManage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/*
 * 入库界面：
 * 需要继续完成的功能：两个按钮的监听器的设置，通过设置“增加”监听器使得在成功下单后按照选定的类型和数量更新库存中的内容，
 */
public class Import extends JFrame // implements ActionListener
{
	JLabel imTypeAndPrice, sum;
	JButton increment, cancel;
	JComboBox<String> typeBox;
	Box hbox1, hbox2, hbox3;
	JTextField numTextField = new JTextField(10);

	public static void main(String[] args) {
		new Import().setVisible(true);
	}

	public Import()// constructor
	{

		this.setTitle("import");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 300, 200);
		this.setLocationByPlatform(true);

		typeBox = new JComboBox<>();
		// add the types.
		typeBox.addItem("ipad air——3100 RMB");
		typeBox.addItem("ipad mini2——2500 RMB");
		typeBox.addItem("iphone5c——2900 RMB");
		typeBox.addItem("iphone5——3500 RMB");
		typeBox.addItem("iphone5s——4300 RMB");
		typeBox.setEditable(false);
		typeBox.setMaximumSize(typeBox.getPreferredSize());// ?

		imTypeAndPrice = new JLabel("增加数量:");
		sum = new JLabel("数量:");

		// set the type to the box
		hbox1 = Box.createHorizontalBox();
		hbox1.add(imTypeAndPrice);
		hbox1.add(Box.createHorizontalStrut(10));
		hbox1.add(typeBox);

		// set the sum to the box
		numTextField.setMaximumSize(numTextField.getPreferredSize());
		hbox2 = Box.createHorizontalBox();
		hbox2.add(sum);
		hbox2.add(Box.createHorizontalStrut(10));
		hbox2.add(numTextField);

		// set the buttons to the box
		increment = new JButton("增加");
		cancel = new JButton("取消");
		hbox3 = Box.createHorizontalBox();
		hbox3.add(Box.createHorizontalGlue());
		hbox3.add(increment);
		hbox3.add(Box.createHorizontalGlue());
		hbox3.add(cancel);
		hbox3.add(Box.createHorizontalGlue());

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(hbox1);
		panel.add(hbox2);
		panel.add(hbox3);

		this.setContentPane(panel);
		this.setVisible(true);

		// create listeners
		increment.addActionListener(new ActionListener() {

			WarehouseCheck updateCheck = new WarehouseCheck();// 实例化类，然后使用其中的数据变量
			int info = Integer.parseInt(numTextField.getText());// 将字符转换为整型进行储存。

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (typeBox.getName() == "ipad air——3100 RMB") {
					updateCheck.numTable[0] += info;
				} else if (typeBox.getName() == "ipad mini2——2500 RMB") {
					updateCheck.numTable[1] += info;
				} else if (typeBox.getName() == "iphone5c——2900 RMB") {
					updateCheck.numTable[2] += info;
				} else if (typeBox.getName() == "iphone5——3500 RMB") {
					updateCheck.numTable[3] += info;
				} else if (typeBox.getName() == "iphone5s——4300 RMB") {
					updateCheck.numTable[4] += info;
				}
				// new successImport().setVisible(true);
				JOptionPane.showMessageDialog(null, "Import Correctly! ", "正确",
						JOptionPane.YES_OPTION);
			}
		});
		/*
		 * //add the listener of the comboBox typeBox.addActionListener(new
		 * ActionListener() {
		 * 
		 * public void actionPerformed(ActionEvent e) { //to add the operation }
		 * });
		 */
		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
	}
}
