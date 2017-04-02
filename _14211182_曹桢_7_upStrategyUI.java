package homework7;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class _14211182_曹桢_7_upStrategyUI extends JDialog{
	_14211182_曹桢_7_Controller controller;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	String key;
	
	public _14211182_曹桢_7_upStrategyUI(_14211182_曹桢_7_Controller controller, 
			_14211182_曹桢_7_MainUI mainwindow, String key, String title, boolean model){
		super(mainwindow, title, model);
		this.controller = controller;
		this.key = key;
		setBounds(120, 120, 323, 442);
		getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(17, 19, 269, 33);
		getContentPane().add(panel_1);
		
		JLabel label_1 = new JLabel("策略名称：");
		panel_1.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(15);
		panel_1.add(textField_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(17, 59, 269, 33);
		getContentPane().add(panel_2);
		
		JLabel label_2 = new JLabel("策略类型：");
		panel_2.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(15);
		panel_2.add(textField_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(17, 99, 269, 33);
		getContentPane().add(panel_3);
		
		JLabel label_3 = new JLabel("图书类型：");
		panel_3.add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(15);
		panel_3.add(textField_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(17, 139, 269, 33);
		getContentPane().add(panel_4);
		
		JLabel label_4 = new JLabel("折扣额度：");
		panel_4.add(label_4);
		
		textField_4 = new JTextField();
		textField_4.setColumns(15);
		panel_4.add(textField_4);
		
		JButton button_simple = new JButton("更改为简单策略");
		button_simple.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String simple_title = textField_1.getText();
				String simple_type = textField_2.getText();
				String simple_book = textField_3.getText();
				String simple_discount = textField_4.getText();
				//1：百分比折扣简单策略，2：绝对值优惠简单策略
				if(simple_title.equals("") || simple_type.equals("") || simple_book.equals("") || simple_discount.equals("")){
					JOptionPane.showMessageDialog(null, "对不起，请输入完整信息");
				}
				else{
					int type;
					int book;
					
					try{
						type = Integer.parseInt(simple_type);
						book = Integer.parseInt(simple_book);
						if(type == 1){
							int discount;
							discount = Integer.parseInt(simple_discount);
							_14211182_曹桢_7_IPricingStrategy percentStra = new _14211182_曹桢_7_PercentageStrategy(_14211182_曹桢_7_upStrategyUI.this.key, simple_title, book, discount);
							_14211182_曹桢_7_upStrategyUI.this.controller.updateStrategy(_14211182_曹桢_7_upStrategyUI.this.key, percentStra);
							
						}
						else if(type == 2){
							double discount;
							discount = Double.parseDouble(simple_discount);
							_14211182_曹桢_7_IPricingStrategy flatStra = new _14211182_曹桢_7_FlatRateStrategy(_14211182_曹桢_7_upStrategyUI.this.key, simple_title, book, discount);
							_14211182_曹桢_7_upStrategyUI.this.controller.updateStrategy(_14211182_曹桢_7_upStrategyUI.this.key, flatStra);
								
						}
						else{
							JOptionPane.showMessageDialog(null, "对不起，请输入策略类型有误！1：百分比折扣简单策略，2：绝对值优惠简单策略");
							return;
						}
						textField_1.setText("");
						textField_2.setText("");
						textField_3.setText("");
						textField_4.setText("");
						JOptionPane.showMessageDialog(null, "成功更新简单策略！");
						_14211182_曹桢_7_upStrategyUI.this.dispose();
					}
					catch(NumberFormatException e1){
						JOptionPane.showMessageDialog(null, "输入错误：注意应输入数字的地方！");
					}
					catch(Exception e1){
						JOptionPane.showMessageDialog(null, "未知错误！");
					}
				}
				
			}
		});
		button_simple.setBounds(159, 185, 126, 25);
		getContentPane().add(button_simple);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(17, 235, 269, 33);
		getContentPane().add(panel_5);
		
		JLabel label_5 = new JLabel("策略名称：");
		panel_5.add(label_5);
		
		textField_5 = new JTextField();
		textField_5.setColumns(15);
		panel_5.add(textField_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(17, 271, 269, 33);
		getContentPane().add(panel_6);
		
		JLabel label_6 = new JLabel("图书类型：");
		panel_6.add(label_6);
		
		textField_6 = new JTextField();
		textField_6.setColumns(15);
		panel_6.add(textField_6);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(17, 307, 269, 33);
		getContentPane().add(panel_7);
		
		JLabel label_7 = new JLabel("简单策略号：");
		panel_7.add(label_7);
		
		textField_7 = new JTextField();
		textField_7.setColumns(15);
		panel_7.add(textField_7);
		
		JButton button_composite = new JButton("更改为组合策略");
		button_composite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String composite_title = textField_5.getText();
				String composite_simples = textField_6.getText();
				String composite_book = textField_7.getText();
				if(composite_title.equals("") || composite_simples.equals("") || composite_book.equals("")){
					JOptionPane.showMessageDialog(null, "对不起，请输入完整信息");
				}
				else{
					try{
						int book = Integer.parseInt(composite_book);
						
						_14211182_曹桢_7_CompositeStrategy compositeStra = new _14211182_曹桢_7_CompositeStrategy(_14211182_曹桢_7_upStrategyUI.this.key, composite_title, composite_simples, book);
						if(_14211182_曹桢_7_upStrategyUI.this.controller.updateStrategy(_14211182_曹桢_7_upStrategyUI.this.key, compositeStra) == null){
							JOptionPane.showMessageDialog(null, "错误！");
						}
						else{
							textField_5.setText("");
							textField_6.setText("");
							textField_7.setText("");
							JOptionPane.showMessageDialog(null, "成功添加组合策略！");
						}
						
					}
					catch(NumberFormatException e1){
						JOptionPane.showMessageDialog(null, "输入错误：注意应输入数字的地方！");
					}
					catch(Exception e1){
						JOptionPane.showMessageDialog(null, "未知错误！");
					}
				}
			}
		});
		button_composite.setBounds(159, 351, 126, 25);
		getContentPane().add(button_composite);
		
		setResizable(false);
		setVisible(true);
	}
}
