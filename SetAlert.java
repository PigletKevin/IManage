package iManage;

import java.awt.EventQueue;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/*
 * 设置警戒线界面：
 * 警戒线表示利润率，当利润率低于警戒线的时候，需要向销售员确认，是否下单；
 * 警戒线的作用在于保证每次的下单的利润达到预计的要求
 * 需要完成的功能：按钮监听器的设置；同时这个页面的警戒线需要与“订单”界面中的数据进行比较以此判断出是否需要弹出警告。
 */
public class SetAlert extends JFrame
{
	JLabel oldOne,newOne;
	JButton confirm,cancel;
	JTextField Old,New;
	Box box1,box2,box3;
	
	public static void main(String[] args)
	{
		new SetAlert().setVisible(true);
	}
	public SetAlert()
	{
		setTitle("MoneyCheck");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100,100,250,200);
		
		oldOne=new JLabel("旧警戒线：");
		newOne=new JLabel("新警戒线：");
		Old =new JTextField(10);
		Old.setMaximumSize(Old.getPreferredSize());
		New =new JTextField(10);
		New.setMaximumSize(New.getPreferredSize());
		confirm=new JButton("确认");
		cancel=new JButton("取消");
		
		box1 = Box.createHorizontalBox();
		box1.add(oldOne);
		box1.add(Box.createHorizontalStrut(10));
		box1.add(Old);
		
		box2 = Box.createHorizontalBox();
		box2.add(newOne);
		box2.add(Box.createHorizontalStrut(10));
		box2.add(New);
		
		box3 = Box.createHorizontalBox();
		box3.add(Box.createHorizontalGlue());
		box3.add(confirm);
		box3.add(Box.createHorizontalStrut(10));
		box3.add(cancel);
		box3.add(Box.createHorizontalGlue());
		
		JPanel panel=new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(box1);
		panel.add(box2);
		panel.add(box3);
		setContentPane(panel);
		setVisible(true);
	}
}










