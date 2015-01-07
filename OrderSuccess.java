package iManage;

import java.awt.*;

import javax.swing.*;

public class OrderSuccess extends JFrame{
	public void main(String[] arg)
	{
		JFrame orderInfo=new OrderSuccess();
		orderInfo.setTitle("Order Information");
		orderInfo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		orderInfo.setBounds(100, 100, 200, 300);
		orderInfo.setResizable(false); //not allowed to change the size of the frame.
		orderInfo.setVisible(true);
	}
	
	JLabel greet,type,sum,unitPrice,workNum,clientName,clientAdd,clientPhone;
	//8 labels are based on the information listed in the order class.
	String Type,Sum,UnitPrice,WorkNum,ClientName,ClientAdd,ClientPhone;//to contain the information in the order class.
	JPanel panel;
	JButton confirmButton;
	public OrderSuccess()
	{
	  Order getData=new Order();
	  
	  //Type=getData.typeBox.;
	  Sum=getData.Num.getText();
	  UnitPrice=getData.UnitPrice.getText();
	  WorkNum=getData.work.getText();
	  ClientName=getData.name.getText();
	  ClientAdd=getData.address.getText();
	  ClientPhone=getData.phone.getText();
		
	  greet=new JLabel("下單成功，以下是訂單信息");
	  type=new JLabel();
	  sum=new JLabel(Sum);
	  unitPrice=new JLabel(UnitPrice);
	  workNum=new JLabel(WorkNum);
	  clientName=new JLabel(ClientName);
	  clientAdd=new JLabel(ClientAdd);
	  clientPhone=new JLabel(ClientPhone);
	  
	  confirmButton=new JButton("確認");
	  
	  panel=new JPanel(new BorderLayout());
	  panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	  panel.add(greet);
	  panel.add(type);
	  panel.add(sum);
	  panel.add(unitPrice);
	  panel.add(workNum);
	  panel.add(clientName);
	  panel.add(clientAdd);
	  panel.add(clientPhone);
	  panel.add(confirmButton);
	  
	  setContentPane(panel);
	  setVisible(true);
	}

}
