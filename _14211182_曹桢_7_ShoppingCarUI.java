package homework7;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
public class _14211182_曹桢_7_ShoppingCarUI extends JDialog implements _14211182_曹桢_7_Observer {
	private _14211182_曹桢_7_Controller controller;
	private JLabel lblNewLabel;
	private JList list;
	public _14211182_曹桢_7_ShoppingCarUI(_14211182_曹桢_7_Controller controller, _14211182_曹桢_7_MainUI mainwindow, String title, boolean model){
		super(mainwindow, title, model);
		this.controller = controller;
//		this.controller.getSale().registerObserver(this);
		setBounds(600, 120, 400, 500);
		getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("黑体", Font.PLAIN, 18));
		lblNewLabel.setBounds(28, 396, 190, 30);
		getContentPane().add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 26, 327, 342);
		getContentPane().add(scrollPane);
		
		list = new JList();
		list.setFont(new Font("黑体", Font.PLAIN, 15));
		scrollPane.setViewportView(list);
		this.update(this.controller.getSale());
		
		setResizable(false);
		setVisible(true);
	}
	
	public void update(_14211182_曹桢_7_Sale sl){
		ArrayList<String> itemList = sl.getItems();
		String strings[]=new String[itemList.size() + 1];
		strings[0] = "书名          数量/本";
		for(int i = 0 ;i < itemList.size();i++){
			strings[i + 1] = itemList.get(i);
		}
		this.list.setListData(strings);
		
		DecimalFormat    df   = new DecimalFormat("##########0.00");
		this.lblNewLabel.setText("总价：" + df.format(sl.getTotal()) + "元");
	}
}
