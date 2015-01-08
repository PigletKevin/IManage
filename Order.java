package iManage;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
/*
 * 订单界面：
 * 需要完成的功能：在下单成功后需要更细“库存”界面中table的数据显示内容，
 * 工号的确认以便于更新“销售查询”中的相关数据
 */
public class Order extends JFrame 
{
	//similar to the Calculate.java
	JLabel type,num,unitPrice,workNumber,clientName,clientAdd,clientPhone,importPrice;
	JTextField Num,UnitPrice,work,name,address,phone,Import;
	JButton order,cancel;
	Box box1,box2,box3,box4,box5,box6,box7,box8,box9;
	JComboBox<String> typeBox;
	
	public static void main(String[] args)
	{
		new Order().setVisible(true);
	}
	public Order()
	{
		setTitle("To order");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100,100,300,300);
		setResizable(false);//not allowed to change the size of the frame.
		
		//define the labels we need
		type=new JLabel("类型:");
		num=new JLabel("数量:");
		unitPrice=new JLabel("售价:");
		importPrice=new JLabel("进价:");
		workNumber=new JLabel("工号:");
		clientName=new JLabel("客户姓名:");
		clientAdd=new JLabel("客户地址:");
		clientPhone=new JLabel("客户电话:");
		
		typeBox = new JComboBox<>();
		//add the types.
		typeBox.addItem("Ipad MINI2          ");
		typeBox.addItem("Ipad Air          ");
		typeBox.addItem("Iphone 5C          ");
		typeBox.addItem("Iphone 5          ");
		typeBox.addItem("Iphone 5S          ");
		typeBox.setEditable(false);
		typeBox.setMaximumSize(typeBox.getPreferredSize());//?
		
		//there is different from calculate.java
		//define the textFields we need
		Num=new JTextField();
		UnitPrice=new JTextField();
		work=new JTextField();
		Import=new JTextField();
		name=new JTextField();
		address=new JTextField();
		phone=new JTextField();
		//define the buttons
		order=new JButton("下单");
		cancel=new JButton("取消");
		
		//put them into different boxes to layout
		box1 = Box.createHorizontalBox();
		box1.add(type);
		box1.add(Box.createHorizontalStrut(30));
		box1.add(typeBox);
		
		box2 = Box.createHorizontalBox();
		box2.add(num);
		box2.add(Box.createHorizontalStrut(30));
		box2.add(Num);
		
		box3 = Box.createHorizontalBox();
		box3.add(unitPrice);
		box3.add(Box.createHorizontalStrut(30));
		box3.add(UnitPrice);
		
		box4 = Box.createHorizontalBox();
		box4.add(workNumber);
		box4.add(Box.createHorizontalStrut(30));
		box4.add(work);
		
		//add the column of the import price.
		box9 = Box.createHorizontalBox();
		box9.add(importPrice);
		box9.add(Box.createHorizontalStrut(30));
		box9.add(Import);
		
		box5 = Box.createHorizontalBox();
		box5.add(clientName);
		box5.add(Box.createHorizontalStrut(5));
		box5.add(name);
		
		box6 = Box.createHorizontalBox();
		box6.add(clientAdd);
		box6.add(Box.createHorizontalStrut(5));
		box6.add(address);
		
		box7 = Box.createHorizontalBox();
		box7.add(clientPhone);
		box7.add(Box.createHorizontalStrut(10));
		box7.add(phone);

		box7 = Box.createHorizontalBox();
		box7.add(Box.createHorizontalGlue());
		box7.add(order);
		box7.add(Box.createHorizontalGlue());
		box7.add(cancel);
		box7.add(Box.createHorizontalGlue());
		
		//arrange boxes and put them into a panel
		JPanel panel=new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(box1);
		panel.add(box2);
		panel.add(box3);
		panel.add(box4);
		panel.add(box9);
		panel.add(box5);
		panel.add(box6);
		panel.add(box7);
		setContentPane(panel);
		setVisible(true);
	   /*
		 listener:order button:
		如果庫存不足，利潤過低，等情況就彈出警告窗口。所以這裏監聽器需要判斷是哪一種情況造成了警告。
		 
		 用如下方法實行：
		 JOptionPane.showMessageDialog(null, "Wrong Identity! ","错误", JOptionPane.ERROR_MESSAGE);
		如果下單成功，彈出打印
		 * */
		
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);				
			}
		});
		 
	}
}

