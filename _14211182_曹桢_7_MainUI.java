package homework7;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class _14211182_曹桢_7_MainUI extends JFrame{
	private JFrame mainwindow;
	private _14211182_曹桢_7_Controller controller;
	
//	public _14211182_曹桢_7_Controller getController(){
//		return controller;
//	}
	public _14211182_曹桢_7_MainUI(){
		mainwindow = new JFrame("主窗口");
		controller = new _14211182_曹桢_7_Controller();
		Container container = mainwindow.getContentPane();
		container.setLayout(null);
		
		JButton addBookButton = new JButton("添加图书");
		addBookButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new _14211182_曹桢_7_AddBookUI(controller, _14211182_曹桢_7_MainUI.this, "添加图书", true);
			}
		});
		addBookButton.setFont(new Font("黑体", Font.PLAIN, 18));
		addBookButton.setBounds(70, 105, 180, 50);
		container.add(addBookButton);
		
		JButton addStrategyButton = new JButton("优惠策略");
		addStrategyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new _14211182_曹桢_7_StrategyUI(controller, _14211182_曹桢_7_MainUI.this, "优惠策略", true);
//				_14211182_曹桢_7_MainUI.this.controller.addSimpleStrategy();
			}
		});
		addStrategyButton.setFont(new Font("黑体", Font.PLAIN, 18));
		addStrategyButton.setBounds(380, 105, 180, 50);
		container.add(addStrategyButton);
		
		JButton BuyButton = new JButton("购买图书");
		BuyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				_14211182_曹桢_7_MainUI.this.controller.buyBook();
				new _14211182_曹桢_7_BuyUI(controller, _14211182_曹桢_7_MainUI.this, "购买图书", false);
				_14211182_曹桢_7_ShoppingCarUI shoppingCar = new _14211182_曹桢_7_ShoppingCarUI(controller,  _14211182_曹桢_7_MainUI.this, "购物车", false);
				_14211182_曹桢_7_MainUI.this.controller.getSale().registerObserver(shoppingCar);
			}
		});
		BuyButton.setFont(new Font("黑体", Font.PLAIN, 18));
		BuyButton.setBounds(225, 250, 180, 50);
		container.add(BuyButton);
		
		
		mainwindow.setSize(630, 400);
		mainwindow.setResizable(false);
		mainwindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		mainwindow.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new _14211182_曹桢_7_MainUI();

	}
}
