package iManage;

import java.awt.*;

import javax.swing.*;

/*
 * 计算界面：
 * 在下单之前通过计算判断利润率是否达标；
 * 基本界面与订单界面类似
 * 需要完成的功能：监听器的实现，以及其中数据之间的计算，和弹出结果的窗体；
 */
public class Calculate extends JFrame {
	JLabel type, num, unitPrice;
	JTextField Num, UnitPrice;
	JButton order, cancel;
	Box box1, box2, box3, box4;
	JComboBox<String> typeBox;

	public static void main(String[] args) {
		new Calculate().setVisible(true);
	}

	public Calculate() {
		setTitle("To Calculate and to order");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 300, 300, 150);

		typeBox = new JComboBox<>();
		// add the types.
		typeBox.addItem("ipad air——3100 RMB");
		typeBox.addItem("ipad mini2——2500 RMB");
		typeBox.addItem("iphone5c——2900 RMB");
		typeBox.addItem("iphone5——3500 RMB");
		typeBox.addItem("iphone5s——4300 RMB");
		typeBox.setEditable(false);
		typeBox.setMaximumSize(typeBox.getPreferredSize());// ?

		// define the parameters we need
		type = new JLabel("类型:");
		num = new JLabel("数量:");
		unitPrice = new JLabel("售价:");

		Num = new JTextField(10);
		UnitPrice = new JTextField(10);

		order = new JButton("下单");
		cancel = new JButton("取消");
		// put them into different boxes to layout
		box1 = Box.createHorizontalBox();
		box1.add(type);
		box1.add(Box.createHorizontalStrut(10));
		box1.add(typeBox);

		box2 = Box.createHorizontalBox();
		box2.add(num);
		box2.add(Box.createHorizontalStrut(10));
		box2.add(Num);

		box3 = Box.createHorizontalBox();
		box3.add(unitPrice);
		box3.add(Box.createHorizontalStrut(10));
		box3.add(UnitPrice);

		box4 = Box.createHorizontalBox();
		box4.add(Box.createHorizontalGlue());
		box4.add(order);
		box4.add(Box.createHorizontalGlue());
		box4.add(cancel);
		box4.add(Box.createHorizontalGlue());
		// arrange boxes and put them into a panel
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(box1);
		panel.add(box2);
		panel.add(box3);
		panel.add(box4);
		this.setContentPane(panel);
		this.setVisible(true);

	}
}
