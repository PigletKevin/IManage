package iManage;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/*
 * this main frame is for workers not for managers.
 * 销售员菜单界面：
 * 其中菜单项中是所有人的选择项，而在销售员中只能选择部分菜单项完成功能。
 * 需要继续完成的功能：无；只需要在弹出的窗体中进行后续设置即可。
 */
public class MainFrame extends JFrame implements ActionListener {
	public static void main(String[] args) {
		new MainFrame().setVisible(true);
		;
	}

	// design a function to merge means to add an MenuItem
	public void addItem(JMenu Menu, String menuName, ActionListener listener) {
		JMenuItem anItem = new JMenuItem(menuName);
		anItem.setActionCommand(menuName); // ?
		anItem.addActionListener(listener);
		// anItem.setEnabled(true);
		Menu.add(anItem);
	}

	// exclude menus which are not the relative part
	public void addItemButDisabled(JMenu Menu, String menuName,
			ActionListener listener) {
		JMenuItem anItem = new JMenuItem(menuName);
		anItem.setActionCommand(menuName); // ?
		anItem.addActionListener(listener);
		anItem.setEnabled(false);
		Menu.add(anItem);
	}

	JLabel label1,label2,label3,label4;//to show the basic information in the blank below the menu.
	String workNum;//to get the work number from the Log-in class.
	JPanel panel=new JPanel();//to contain the menu and the label.
	Font font=new Font("Dialog", 0, 16);
	Font font2=new Font("Dialog", 1, 16);
	
	public MainFrame() {
		this.setTitle("IManagement for Workers");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 300, 200);
		this.setLocationByPlatform(true);
		this.setResizable(false);//not allowed to change the size of the frame.
		
		//new a class and get the account .
		Login login=new Login();//????????
		login.setVisible(false);//not to show it.
		
		workNum=login.textField1.getText();
		label1=new JLabel("Dear "+workNum  +" : ");
		label2=new JLabel("               welcome back to the ");
		label3=new JLabel( "                         IMANAGE  ");
		label4=new JLabel("                    Enjoy managing !");
		
		label1.setFont(font);
		label2.setFont(font);
		label3.setFont(font2);
		label4.setFont(font);
		
		
		// place the menu bar to the frame
		// this.setContentPane(new MenuWindow());
		JMenu menu1 = new JMenu("商品管理");
		addItemButDisabled(menu1, "库存查询", this);
		addItemButDisabled(menu1, "入库", this);

		JMenu menu2 = new JMenu("资金管理");
		addItemButDisabled(menu2, "资金查询", this);
		addItem(menu2, "销售查询", this);
		addItemButDisabled(menu2, "设置警戒线", this);

		JMenu menu3 = new JMenu("订单管理");
		addItem(menu3, "计算", this);
		addItem(menu3, "下单", this);

		JMenuBar menubar = new JMenuBar();

		menubar.add(menu1);
		menubar.add(menu2);
		menubar.add(menu3);
		this.setJMenuBar(menubar);
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(label1,BorderLayout.NORTH);
		panel.add(label2,BorderLayout.CENTER);
		panel.add(label3,BorderLayout.CENTER);
		panel.add(label4,BorderLayout.SOUTH);
		this.setContentPane(panel);
		this.setVisible(true);

	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() instanceof JMenuItem) // 判断事件源是否为菜单项
		{
			String ItemName = event.getActionCommand();
			if (ItemName.equals("库存查询")) {
				new WarehouseCheck().setVisible(true);
			} else if (ItemName.equals("入库")) {
				new Import().setVisible(true);
			} else if (ItemName.equals("资金查询")) {
				new MoneyCheck().setVisible(true);
			} else if (ItemName.equals("销售查询")) {
				new WorkCheck().setVisible(true);
			} else if (ItemName.equals("设置警戒线")) {
				new SetAlert().setVisible(true);
			} else if (ItemName.equals("计算")) {
				new Calculate().setVisible(true);
			} else if (ItemName.equals("下单")) {
				new Order().setVisible(true);
			}

		}
	}
}
