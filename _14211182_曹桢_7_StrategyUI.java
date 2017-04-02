package homework7;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class _14211182_曹桢_7_StrategyUI extends JDialog{
	_14211182_曹桢_7_Controller controller;
	_14211182_曹桢_7_MainUI mainwindow;
	private JTextField text_simple_number;
	private JTextField text_simple_title;
	private JTextField text_simple_type;
	private JTextField text_simple_book;
	private JTextField text_simple_discount;
	private JTextField text_composite_number;
	private JTextField text_composite_title;
	private JTextField text_composite_simples;
	private JTextField text_composite_book;
	private JList<String> list;
	private JTextField textField;
	
	public _14211182_曹桢_7_StrategyUI(_14211182_曹桢_7_Controller controller, _14211182_曹桢_7_MainUI mainwindow, String title, boolean model){
		super(mainwindow, title, model);
		this.controller = controller;
		this.mainwindow = mainwindow;
		setBounds(120, 120, 618, 500);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 96, 265, 323);
		getContentPane().add(scrollPane);
		
		ArrayList<String> StrategyList = controller.StrategyCatalogArray();
		String strings[]=new String[StrategyList.size()];
		for(int i=0 ;i < StrategyList.size();i++){
			strings[i] = StrategyList.get(i);
		}
		
		list = new JList();
		this.changeList();
		

		
		scrollPane.setViewportView(list);
		
		JPanel panel_simple1 = new JPanel();
		panel_simple1.setBounds(317, 13, 269, 33);
		getContentPane().add(panel_simple1);
		
		JLabel label_simple_number = new JLabel("策略编号：");
		panel_simple1.add(label_simple_number);
		
		text_simple_number = new JTextField();
		panel_simple1.add(text_simple_number);
		text_simple_number.setColumns(15);
		
		JPanel panel_simple2 = new JPanel();
		panel_simple2.setBounds(317, 53, 269, 33);
		getContentPane().add(panel_simple2);
		
		JLabel label_simple_title = new JLabel("策略名称：");
		panel_simple2.add(label_simple_title);
		
		text_simple_title = new JTextField();
		text_simple_title.setColumns(15);
		panel_simple2.add(text_simple_title);
		
		JPanel panel_simple3 = new JPanel();
		panel_simple3.setBounds(317, 93, 269, 33);
		getContentPane().add(panel_simple3);
		
		JLabel label_simple_type = new JLabel("策略类型：");
		panel_simple3.add(label_simple_type);
		
		text_simple_type = new JTextField();
		text_simple_type.setColumns(15);
		panel_simple3.add(text_simple_type);
		
		JPanel panel_simple4 = new JPanel();
		panel_simple4.setBounds(317, 133, 269, 33);
		getContentPane().add(panel_simple4);
		
		JLabel label_simple_book = new JLabel("图书类型：");
		panel_simple4.add(label_simple_book);
		
		text_simple_book = new JTextField();
		text_simple_book.setColumns(15);
		panel_simple4.add(text_simple_book);
		
		JPanel panel_simple5 = new JPanel();
		panel_simple5.setBounds(317, 173, 269, 33);
		getContentPane().add(panel_simple5);
		
		JLabel label_simple_discount = new JLabel("折扣额度：");
		panel_simple5.add(label_simple_discount);
		
		text_simple_discount = new JTextField();
		text_simple_discount.setColumns(15);
		panel_simple5.add(text_simple_discount);
		
		JPanel panel_composite1 = new JPanel();
		panel_composite1.setBounds(317, 234, 269, 33);
		getContentPane().add(panel_composite1);
		
		JLabel label_composite_number = new JLabel("策略编号：");
		panel_composite1.add(label_composite_number);
		
		text_composite_number = new JTextField();
		text_composite_number.setColumns(15);
		panel_composite1.add(text_composite_number);
		
		JPanel panel_composite2 = new JPanel();
		panel_composite2.setBounds(317, 270, 269, 33);
		getContentPane().add(panel_composite2);
		
		JLabel label_composite_title = new JLabel("策略名称：");
		panel_composite2.add(label_composite_title);
		
		text_composite_title = new JTextField();
		text_composite_title.setColumns(15);
		panel_composite2.add(text_composite_title);
		
		JPanel panel_composite3 = new JPanel();
		panel_composite3.setBounds(317, 342, 269, 33);
		getContentPane().add(panel_composite3);
		
		JLabel label_composite_simples = new JLabel("简单策略号：");
		panel_composite3.add(label_composite_simples);
		
		text_composite_simples = new JTextField();
		text_composite_simples.setColumns(15);
		panel_composite3.add(text_composite_simples);
		
		JButton button_simple = new JButton("添加简单策略");
		button_simple.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String simple_number = text_simple_number.getText();
				String simple_title = text_simple_title.getText();
				String simple_type = text_simple_type.getText();
				String simple_book = text_simple_book.getText();
				String simple_discount = text_simple_discount.getText();
				//1：百分比折扣简单策略，2：绝对值优惠简单策略
				if(simple_number.equals("") || simple_title.equals("") || simple_type.equals("") || simple_book.equals("") || simple_discount.equals("")){
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
							_14211182_曹桢_7_IPricingStrategy percentStra = new _14211182_曹桢_7_PercentageStrategy(simple_number, simple_title, book, discount);
							if(_14211182_曹桢_7_StrategyUI.this.controller.addSimpleStrategy(simple_number, percentStra)==null){
								JOptionPane.showMessageDialog(null, "对不起，已有该策略号！");
								return;
							}
							
						}
						else if(type == 2){
							double discount;
							discount = Double.parseDouble(simple_discount);
							_14211182_曹桢_7_IPricingStrategy flatStra = new _14211182_曹桢_7_FlatRateStrategy(simple_number, simple_title, book, discount);
							if(_14211182_曹桢_7_StrategyUI.this.controller.addSimpleStrategy(simple_number, flatStra)==null){
								JOptionPane.showMessageDialog(null, "对不起，已有该策略号！");
								return;
							}
						}
						else{
							JOptionPane.showMessageDialog(null, "对不起，请输入策略类型有误！1：百分比折扣简单策略，2：绝对值优惠简单策略");
							return;
						}
						
						
						text_simple_number.setText("");
						text_simple_title.setText("");
						text_simple_type.setText("");
						text_simple_book.setText("");
						text_simple_discount.setText("");
						JOptionPane.showMessageDialog(null, "成功添加简单策略！");
						_14211182_曹桢_7_StrategyUI.this.changeList();
						
					}
					catch(NumberFormatException e1){
						JOptionPane.showMessageDialog(null, "输入错误：注意应输入数字的地方!1：百分比折扣简单策略，2：绝对值优惠简单策略");
					}
					catch(Exception e1){
						JOptionPane.showMessageDialog(null, "未知错误！");
					}
				}
			}
		});
		button_simple.setBounds(462, 208, 126, 25);
		getContentPane().add(button_simple);
		
		JButton button_composite = new JButton("添加组合策略");
		button_composite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String composite_number = text_composite_number.getText();
				String composite_title = text_composite_title.getText();
				String composite_simples = text_composite_simples.getText();
				String composite_book = text_composite_book.getText();
				if(composite_number.equals("") || composite_title.equals("") || composite_simples.equals("") || composite_book.equals("")){
					JOptionPane.showMessageDialog(null, "对不起，请输入完整信息");
				}
				else{
					try{
						int book = Integer.parseInt(composite_book);
						
						_14211182_曹桢_7_CompositeStrategy compositeStra = new _14211182_曹桢_7_CompositeStrategy(composite_number, composite_title, composite_simples, book);
						if(_14211182_曹桢_7_StrategyUI.this.controller.addCompositeStrategy(composite_number, compositeStra) == false){
							JOptionPane.showMessageDialog(null, "错误！");
						}
						else{
							text_composite_number.setText("");
							text_composite_title.setText("");
							text_composite_simples.setText("");
							text_composite_book.setText("");
							JOptionPane.showMessageDialog(null, "成功添加组合策略！");
							_14211182_曹桢_7_StrategyUI.this.changeList();
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
		button_composite.setBounds(460, 394, 126, 25);
		getContentPane().add(button_composite);
		
		JPanel panel_composite_book = new JPanel();
		panel_composite_book.setBounds(317, 306, 269, 33);
		getContentPane().add(panel_composite_book);
		
		JLabel label_composite_book = new JLabel("图书类型：");
		panel_composite_book.add(label_composite_book);
		
		text_composite_book = new JTextField();
		text_composite_book.setColumns(15);
		panel_composite_book.add(text_composite_book);
		
		JPanel panel = new JPanel();
		panel.setBounds(23, 13, 269, 70);
		getContentPane().add(panel);
		
		JLabel label = new JLabel("策略编号：");
		panel.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		panel.add(textField);
		
		JButton button_search = new JButton("查找");
		button_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number = textField.getText();
				if(number.equals("")){
					_14211182_曹桢_7_StrategyUI.this.changeList();
				}
				else{
					_14211182_曹桢_7_StrategyUI.this.searchFor(number);
				}
			}
		});
		panel.add(button_search);
		
		JButton button_delete = new JButton("删除");
		button_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number = textField.getText();
				if(number.equals("")){
					JOptionPane.showMessageDialog(null, "对不起，请输入完整信息");
				}
				else{
					_14211182_曹桢_7_StrategyUI.this.delete(number);
					_14211182_曹桢_7_StrategyUI.this.changeList();
				}
			}
		});
		panel.add(button_delete);
		
		JButton button_update = new JButton("更改");
		button_update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number = textField.getText();
				if(number.equals("")){
					JOptionPane.showMessageDialog(null, "对不起，请输入完整信息");
				}
				else{
					_14211182_曹桢_7_StrategyUI.this.update(number);
					_14211182_曹桢_7_StrategyUI.this.changeList();
				}
			}
		});
		panel.add(button_update);
		setResizable(false);
		setVisible(true);
	}
	
	public void changeList(){
		ArrayList<String> StrategyList = this.controller.StrategyCatalogArray();
		String strings[]=new String[StrategyList.size() + 1];
		strings[0] = "策略编号   策略名   图书种类   折扣";
		for(int i = 0 ;i < StrategyList.size();i++){
			strings[i + 1] = StrategyList.get(i);
		}
		this.list.setListData(strings);
	}
	
	public void searchFor(String number){
		_14211182_曹桢_7_IPricingStrategy stra = this.controller.SearchFor(number);
		if(stra == null){
			JOptionPane.showMessageDialog(null, "对不起，没有这个策略");
		}
		else{
			String strings[]=new String[2];
			strings[0] = "策略编号   策略名   图书种类   折扣";
			strings[1] = stra.toString();
			this.list.setListData(strings);	
		}
		
	}
	
	public void delete(String number){
		_14211182_曹桢_7_IPricingStrategy stra = this.controller.deleteStrategy(number);
		if(stra == null){
			JOptionPane.showMessageDialog(null, "对不起，没有这个策略");
		}
		else{
			this.controller.deleteStrategy(number);
			JOptionPane.showMessageDialog(null, "删除成功");
		}
	}
	
	public void update(String number){
		_14211182_曹桢_7_IPricingStrategy stra = this.controller.deleteStrategy(number);
		if(stra == null){
			JOptionPane.showMessageDialog(null, "对不起，没有这个策略");
		}
		else{
			new _14211182_曹桢_7_upStrategyUI(this.controller, this.mainwindow, number, "更改策略", true);
		}
		
	}
}
