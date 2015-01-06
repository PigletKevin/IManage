package iManage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/*
 * 管理员菜单界面：
 * 其中菜单项中是所有人的选择项，而在管理员中只能选择部分菜单项完成功能。
 * 需要继续完成的功能：无；只需要在弹出的窗体中进行后续设置即可。
 */
public class MainFrameManager extends JFrame implements ActionListener {
	public static void main(String[] args) {
		new MainFrameManager().setVisible(true);
	}

	// design a function to merge means to add an MenuItem
	public void addItem(JMenu Menu, String menuName, ActionListener listener) {
		JMenuItem anItem = new JMenuItem(menuName);
		anItem.setActionCommand(menuName); // ?
		anItem.addActionListener(listener);
		anItem.setEnabled(true);
		Menu.add(anItem);
	}

	// a function to exclude menus which are not the corresponding part
	public void addItemButDisabled(JMenu Menu, String menuName,
			ActionListener listener) {
		JMenuItem anItem = new JMenuItem(menuName);
		anItem.setActionCommand(menuName); // ?
		anItem.addActionListener(listener);
		anItem.setEnabled(false);
		Menu.add(anItem);
	}

	public MainFrameManager() {
		this.setTitle("IManagement for Workers");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 300, 300);
		this.setLocationByPlatform(true);

		// place the menu bar to the frame
		// this.setContentPane(new MenuWindow());
		JMenu menu1 = new JMenu("商品管理");
		addItem(menu1, "库存查询", this);
		addItemButDisabled(menu1, "入库", this);

		JMenu menu2 = new JMenu("资金管理");
		addItem(menu2, "资金查询", this);
		// this is for workers not managers
		addItemButDisabled(menu2, "销售查询", this);

		addItem(menu2, "设置警戒线", this);

		JMenu menu3 = new JMenu("订单管理");
		// this is for workers not managers
		addItemButDisabled(menu3, "计算", this);
		addItemButDisabled(menu3, "下单", this);

		JMenuBar menubar = new JMenuBar();

		menubar.add(menu1);
		menubar.add(menu2);
		menubar.add(menu3);
		this.setJMenuBar(menubar);
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
