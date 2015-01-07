package iManage;

import java.awt.*;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.omg.CORBA.PUBLIC_MEMBER;

/*
 * 资金查询界面：
 * 四个text field：现金金额初始200000，在每次卖出一个商品后将所得的利润加到其中；
 * 总销售额：即该销售员所有售出的商品的售价总和；注意：这里的资金查询是基于每一个销售员的信息查询，销售员之间的信息不相互重叠。
 * 总利润：同上
 * 利润率：通过简单的计算动态更新起数值；
 * 需要完成的功能：数据的呈现和动态更新
 */
public class MoneyCheck extends JFrame {
	JLabel outLine, cash, total, profit, Rate;
	//JTextField cashShow, totalShow, profitShow, RateShow;
	JLabel cashShow, totalShow, profitShow, RateShow;
	Box box1, box2, box3, box4;
	JPanel panel;

	/*
	 * //实例化其他类，然后使用其中的成员变量 Order updateOrder=new Order();
	 * 
	 * //to get the data we want from the Order class. String
	 * totalUnit=updateOrder.UnitPrice.getText(); //总售价 String
	 * totalNum=updateOrder.Num.getText(); //总数量 String
	 * type=updateOrder.typeBox.toString(); //类型
	 * 
	 * int UnitInt=Integer.parseInt(totalUnit); int
	 * NumInt=Integer.parseInt(totalNum); int TypeInt=Integer.parseInt(type);
	 * 
	 * int[] cost={3100,2500,2900,3500,4300}; int currentCost; int totalProfit;
	 * double profitRate; //create the function to get the relating cost. public
	 * int getCost() { switch (type) { case "ipad air——3100 RMB": currentCost =
	 * cost[0];break; case "ipad mini2——2500 RMB": currentCost = cost[1];break;
	 * case "iphone5c——2900 RMB": currentCost = cost[2];break; case
	 * "iphone5——3500 RMB": currentCost = cost[3];break; case
	 * "iphone5s——4300 RMB": currentCost = cost[4];break; default: break; }
	 * return currentCost; }
	 */

	public MoneyCheck() {
		this.setTitle("MoneyCheck");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(300, 300, 350, 175);// the size is strictly set
		this.setResizable(false);//not allowed to change the size of the frame.
		/*
		 * currentCost=getCost(); totalProfit=UnitInt-currentCost;
		 * profitRate=totalProfit/currentCost;
		 */

		// define the labels
		outLine = new JLabel("亲爱的" + "，如下是你的工作情况，望继续努力！");
		cash = new JLabel("现金金额：");
		total = new JLabel("总销售额：");
		profit = new JLabel("总利润：");
		Rate = new JLabel("利润率：");
		// define the textFields ,the four of which should be initialized.
		cashShow = new JLabel();
		totalShow = new JLabel();
		profitShow = new JLabel();
		RateShow = new JLabel();

		// set the cash to the box
		box1 = Box.createHorizontalBox();
		box1.add(cash);
		box1.add(Box.createHorizontalStrut(5));
		box1.add(cashShow);
		// set the total money to the box
		box2 = Box.createHorizontalBox();
		box2.add(total);
		box2.add(Box.createHorizontalStrut(5));
		box2.add(totalShow);
		// set the profit to the box
		box3 = Box.createHorizontalBox();
		box3.add(profit);
		box3.add(Box.createHorizontalStrut(18));
		box3.add(profitShow);
		// set the rate to the box
		box4 = Box.createHorizontalBox();
		box4.add(Rate);
		box4.add(Box.createHorizontalStrut(18));
		box4.add(RateShow);

		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(outLine, BorderLayout.NORTH);
		panel.add(box1);
		panel.add(box2);
		panel.add(box3);
		panel.add(box4);
		setContentPane(panel);
		setVisible(true);
		// listen later
	}

	public static void main(String[] args) {
		new MoneyCheck().setVisible(true);
	}
}
