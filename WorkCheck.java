package iManage;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableColumn;

/*
 * 销售查询界面：
 * 该表格比库存查询中的表格复杂，但是需要动态更新的只有“数量”和“售价”一栏，其他栏只需要搬移数据就可以
 * 还需要进一步的功能：主要是数据的动态改动以及对其他类的数据的影响。
 * 
 * ******************************************
 * 功能发生变化，只需要显示销售额和利润，简化的界面。
 */
public class WorkCheck extends JFrame {
/*
	JButton totalOut, totalProfit, cancel;
	Box box1, box2, box3;
	JTextField out, profit;
	JPanel panel1, panel2;
	
	// create a function to add an item in the table to update.
	public void updataFun(JTextField type, int num, int cost, int unitPrice,
			int profit) {

	}*/

	public WorkCheck() {
		
		this.setTitle("WorkCheck!");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 300, 300);
		this.setLocationByPlatform(true);
		this.setResizable(false);//not allowed to change the size of the frame.
		
		JLabel info1,info2,sellPrice,profitJLabel;
		String getInfo;
		JPanel panel;
		Font font=new Font("Dialog", 0, 16);
		/*
		 * info1 : get the work number in the log-in class.
		 * info2 : brief introduction
		 * sellPrice: total sold price of the certain worker.
		 * ProfitJLabel: get the average profit .
		 * getInfo:get the String type of the text Filed in the login class.
		*/
		Login getDataLogin=new Login();//this is something wrong to show.
		//getDataLogin.setVisible(false);//there is something  wrong with the frame.
		getInfo=getDataLogin.textField1.getText();
		info1=new JLabel("                  亲爱的 "+getInfo+"号工作员， ",JLabel.CENTER);
		info2=new JLabel("        这是你的工作业绩，望继续努力！",JLabel.CENTER);
		//next is to initialize the sell price and the profit which is in the order class.
		sellPrice=new JLabel("                 (快点给我加东西！)",JLabel.CENTER);
		profitJLabel=new JLabel("                (快点给我更新啊！)",JLabel.CENTER);
		
		info1.setFont(font);
		info2.setFont(font);
		sellPrice.setFont(font);
		profitJLabel.setFont(font);
		
		
		/*info1.setHorizontalAlignment(SwingConstants.CENTER);
		info2.setHorizontalAlignment(SwingConstants.CENTER);
		sellPrice.setHorizontalAlignment(SwingConstants.CENTER);
		profitJLabel.setHorizontalAlignment(SwingConstants.CENTER);
		*/
		panel =new JPanel(new BorderLayout());
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(info1);
		panel.add(info2);
		panel.add(sellPrice);
		panel.add(profitJLabel);
		setContentPane(panel);
		setVisible(true);
		
		
		/*setTitle("Check Your Work!");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 300, 400, 200);

		// create a class and to get the unit price.
		Order getDataOrder = new Order();
		int unitPrice = 0;
		unitPrice = Integer.parseInt(getDataOrder.UnitPrice.getText());

		String[] type = { "ipad air ", "ipad mini2 ", "iphone5c ", "iphone5 ",
				"iphone5s " };
		int[] cost = { 3100, 2500, 2900, 3500, 4300 };
		int[] numTable = { 0, 0, 0, 0, 0 };
		String[] Names = { "类型", "数量", "单价", "售价", "利润" };

		// this place should be modified
		Object[][] basicInfo = {};

		JTable table = new JTable(basicInfo, Names);
		// table.setPreferredScrollableViewportSize(new Dimension(550,30));
		// table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
		// table.setPreferredSize(table.getPreferredSize());

		TableColumn column = null;
		column = table.getColumnModel().getColumn(0);
		column.setPreferredWidth(100);

		JScrollPane scrollPane;
		scrollPane = new JScrollPane(table);
		// ************
		totalOut = new JButton("总售价");
		totalProfit = new JButton("总进价");

		box1 = Box.createHorizontalBox();
		box1.add(table);
		box1.add(scrollPane, BorderLayout.CENTER);
		box1.add(Box.createHorizontalGlue());

		out = new JTextField(6);
		box2 = Box.createHorizontalBox();
		box2.add(totalOut);
		box2.add(Box.createHorizontalStrut(10));
		box2.add(out);

		profit = new JTextField(6);
		box3 = Box.createHorizontalBox();
		box3.add(totalProfit);
		box3.add(Box.createHorizontalStrut(10));
		box3.add(profit);

		panel1 = new JPanel();
		panel1.add(box2);
		panel1.add(box3);

		panel2 = new JPanel(new BorderLayout());
		panel2.add(box1, BorderLayout.CENTER);
		panel2.add(panel1, BorderLayout.SOUTH);

		this.setContentPane(panel2);
		this.setVisible(true);
       */
		// listen later
		/*cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});*/
	}

	public static void main(String[] args) {
		new WorkCheck().setVisible(true);
	}
}
