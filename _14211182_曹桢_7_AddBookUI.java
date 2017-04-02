package homework7;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
public class _14211182_曹桢_7_AddBookUI extends JDialog{
	private JTextField textisbn;
	private JTextField texttitle;
	private JTextField textprice;
	private JTextField texttype;
	private JScrollPane scrollPane;
	private JButton confirm;
	private JPanel panel_isbn;
	private JPanel panel_price;
	private JPanel panel_type;
	private JPanel panel_title;
	private _14211182_曹桢_7_Controller controller;
	private JList list;
	public _14211182_曹桢_7_AddBookUI(_14211182_曹桢_7_Controller controller, _14211182_曹桢_7_MainUI mainwindow, String title, boolean model){
		super(mainwindow, title, model);
		this.controller = controller;
		setBounds(120, 120, 600, 400);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 47, 304, 269);
		getContentPane().add(scrollPane);
		
		list = new JList();
		changeList();
		scrollPane.setViewportView(list);
		
		confirm = new JButton("确认");
		confirm.setFont(new Font("黑体", Font.PLAIN, 15));
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String isbn = textisbn.getText();
				String title = texttitle.getText();
				String pricestr = textprice.getText();
				String typestr = texttype.getText();
				
				if(isbn.equals("") || title.equals("") || pricestr.equals("") || typestr.equals("")){
					JOptionPane.showMessageDialog(null, "对不起，请输入完整信息");
				}
				else{
					try{
						double price = Double.parseDouble(pricestr);
						int type = Integer.parseInt(typestr);
						_14211182_曹桢_7_AddBookUI.this.controller.addBook(isbn, title, price, type);
						textisbn.setText("");
						texttitle.setText("");
						textprice.setText("");
						texttype.setText("");
						JOptionPane.showMessageDialog(null, "成功添加信息！");
						changeList();
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
		confirm.setBounds(485, 291, 67, 25);
		getContentPane().add(confirm);
		
		panel_isbn = new JPanel();
		panel_isbn.setBounds(346, 47, 206, 31);
		getContentPane().add(panel_isbn);
		
		JLabel labelIsbn = new JLabel("isbn  ");
		labelIsbn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_isbn.add(labelIsbn);
		
		textisbn = new JTextField();
		textisbn.setFont(new Font("黑体", Font.PLAIN, 15));
		panel_isbn.add(textisbn);
		textisbn.setColumns(15);
		
		panel_title = new JPanel();
		panel_title.setBounds(345, 98, 205, 31);
		getContentPane().add(panel_title);
		
		JLabel labelTitle = new JLabel("title  ");
		labelTitle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_title.add(labelTitle);
		
		texttitle = new JTextField();
		texttitle.setFont(new Font("黑体", Font.PLAIN, 15));
		texttitle.setColumns(15);
		panel_title.add(texttitle);
		
		panel_price = new JPanel();
		panel_price.setBounds(347, 155, 205, 31);
		getContentPane().add(panel_price);
		
		JLabel labelPrice = new JLabel("price  ");
		labelPrice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_price.add(labelPrice);
		
		textprice = new JTextField();
		textprice.setFont(new Font("黑体", Font.PLAIN, 15));
		textprice.setColumns(15);
		panel_price.add(textprice);
		
		panel_type = new JPanel();
		panel_type.setBounds(347, 215, 205, 31);
		getContentPane().add(panel_type);
		
		JLabel labelType = new JLabel("type  ");
		labelType.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_type.add(labelType);
		
		texttype = new JTextField();
		texttype.setFont(new Font("黑体", Font.PLAIN, 15));
		texttype.setColumns(15);
		panel_type.add(texttype);
		
		setResizable(false);
		setVisible(true);
	}
	
	public void changeList(){
		ArrayList<String> BookList = this.controller.BookCatalogArray();
		String strings[]=new String[BookList.size() + 1];
		strings[0] = "isbn   书名      价格     种类";
		for(int i = 0 ;i < BookList.size();i++){
			strings[i + 1] = BookList.get(i);
		}
		this.list.setListData(strings);
	}
	
}
