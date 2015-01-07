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

	//the part to show the outcome 
	JLabel toShow,showSell,sell,showProfit,profit,showAlert,Alert;
	Box box5,box6,box7,box8;

	public static void main(String[] args) {
		new Calculate().setVisible(true);
	}

	public Calculate() {
		setTitle("To Calculate and to order");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 300, 230, 230);
		setResizable(false);//not allowed to change the size of the frame.
		
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

		Num = new JTextField();
		UnitPrice = new JTextField();

		order = new JButton("计算");
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
		
		toShow=new JLabel("計算結果如下：");
		showSell=new JLabel("總售價：");
		showProfit=new JLabel("利潤：");
		showAlert=new JLabel("是否超過警戒綫：");
		//下面三個需要動態設置
		sell=new JLabel();
		profit=new JLabel();
		Alert=new JLabel();
		
		box5 = Box.createHorizontalBox();
		box5.add(Box.createHorizontalGlue());
		box5.add(showSell);
		box5.add(Box.createHorizontalGlue());
		box5.add(sell);
		box5.add(Box.createHorizontalGlue());
		
		box6 = Box.createHorizontalBox();
		box6.add(Box.createHorizontalGlue());
		box6.add(showProfit);
		box6.add(Box.createHorizontalGlue());
		box6.add(profit);
		box6.add(Box.createHorizontalGlue());
		
		box7 = Box.createHorizontalBox();
		box7.add(Box.createHorizontalGlue());
		box7.add(showAlert);
		box7.add(Box.createHorizontalGlue());
		box7.add(Alert);
		box7.add(Box.createHorizontalGlue());
		
		box8 = Box.createHorizontalBox();
		box8.add(toShow);
		box8.add(Box.createHorizontalGlue());
		// arrange boxes and put them into a panel
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(box1);
		panel.add(box2);
		panel.add(box3);
		panel.add(box4);
		panel.add(box8);
		panel.add(box5);
		panel.add(box6);
		panel.add(box7);
		this.setContentPane(panel);
		this.setVisible(true);

	}
}
