package iManage;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.TableColumn;
import javax.swing.text.StyledEditorKit.ForegroundAction;

/*
 * 库存界面：
 * 数据：放在table中进行存储，其中需要动态更改数量，进价和类型都是默认固定的
 * 需要继续完成的功能：“库存数量”和“平均进价”需要完成动态更新功能，在下单完成后需要更新其中显示的值并更新库存数量；
 */

public class WarehouseCheck extends JFrame 
{
	JScrollPane scrollPane;	
	JLabel number,aveImport; //  the number of the wares in the warehouse && average money to import
	Box hbox1,hbox2,hbox3;//to set the labels
	JTextField num,ave;
	JPanel panel1,panel2;
	JButton cancel;
	//set the table to save the data
	//Names are the head
	//type includes the Bid.
	//cost is the bid for each item.
	//number is the current sum of each type	
	String[] Names={"类型","数量","平均进价"};
	String[] type={
			"ipad air ",
			"ipad mini2 ",
			"iphone5c ",
			"iphone5 ",
			"iphone5s "};
	int[] cost={3100,2500,2900,3500,4300};
	int[] numTable={20,20,20,20,20};
    //to get the total number and fill the text field.
	int totalNum=0;
	int average=0;
	int totalMoney=0;

	//constructor
	public WarehouseCheck()
	{	
		//basic setting of the frame
		setTitle("WareHouse");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationByPlatform(true);
		setBounds(300,300,300,250);
		setResizable(false);//not allowed to change the size of the frame.
		//initialize the table data
		Object[][] basicInfo=new Object[5][3];
		for(int i=0;i<type.length;i++)
		{
			for(int j=0;j<5;j++){
				basicInfo[j][1]=numTable[j];
				basicInfo[j][2]=cost[j];
			}
			basicInfo[i][0]=type[i];
		}
				
		
		JTable table=new JTable(basicInfo,Names);
		table.setPreferredScrollableViewportSize(new Dimension(400,150)); 
		/*table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS); //?
		table.setCellSelectionEnabled(false);
		table.setPreferredSize(table.getPreferredSize());
		*/
		//change the size of each column.
		TableColumn column1=null,column2=null,column3=null;
		column1=table.getColumnModel().getColumn(0);
		column2=table.getColumnModel().getColumn(1);
		column3=table.getColumnModel().getColumn(2);
		column1.setPreferredWidth(200);
		column2.setPreferredWidth(50);
		column3.setPreferredWidth(100);
		//put the table into the scrollPane.
		scrollPane = new JScrollPane(table);
		//scrollPane.getViewport().add(table, null);//?
		//scrollPane.add(table, BorderLayout.CENTER);
		
		//hbox3 contains the table and the scrollPane
		hbox3 = Box.createHorizontalBox();
		hbox3.add(scrollPane,BorderLayout.CENTER);
		
		//initialize the label and to show the info
		number=new JLabel("库存数量：");
	    num= new JTextField(6);
	    num.setMaximumSize(num.getPreferredSize());
	    
	    aveImport= new JLabel("平均进价：");
	    ave= new JTextField(6);
	    ave.setMaximumSize(ave.getPreferredSize());
	    
	    //below is to set the text field.
	    for(int i=0;i<5;i++){
	    	totalNum += numTable[i];
	    }
	    num.setText(String.valueOf(totalNum)); //"库存数量"中显示总共的数量
	    
	    for(int j=0;j<5;j++){
	    	totalMoney += numTable[j]*cost[j];//计算总金钱数
	    }
	    average=totalMoney/totalNum;
	    ave.setText(String.valueOf(average));//"平均进价"中显示了结果
	    
	    
	    //hbox1 contains the total number of the warehouse 
	    hbox1 = Box.createHorizontalBox();
	    hbox1.add(Box.createGlue());
	    hbox1.add(number);
	    hbox1.add(num);
	    hbox1.add(Box.createGlue());
	    
	    //hbox2 contains the average cost of the warehouse
	    hbox2 = Box.createHorizontalBox();
	    hbox2.add(Box.createGlue());
	    hbox2.add(aveImport);
	    hbox2.add(ave);
	    hbox2.add(Box.createGlue());

	    cancel=new JButton("取消");
	    
	    panel1=new JPanel();
	    panel1.add(hbox1);
	    panel1.add(hbox2);
	    panel1.add(cancel);
	    	    
        panel2 = new JPanel();
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));//set components vertically
        panel2.add(hbox3);
        panel2.add(panel1);

	    
	    setContentPane(panel2);
	    setVisible(true);
	    pack();//vital!
	    
	    //to listen     *********use later!
	    //warehousing.addActionListener(this);//?
	    cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

	}

    public static void main(String[] args)
   {
    	new WarehouseCheck().setVisible(true);
   }
    	
}

