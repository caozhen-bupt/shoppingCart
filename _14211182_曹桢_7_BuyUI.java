package homework7;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
public class _14211182_曹桢_7_BuyUI extends JDialog{
	private JTextField text_isbn;
	private JTextField text_copies;
	private _14211182_曹桢_7_Controller controller;
	private JList list;
//	private _14211182_曹桢_7_ShoppingCarUI shoppingCarDialog;
	public _14211182_曹桢_7_BuyUI(_14211182_曹桢_7_Controller controller, _14211182_曹桢_7_MainUI mainwindow, String title, boolean model){
		super(mainwindow, title, model);
		this.controller = controller;
		setBounds(120, 120, 400, 500);
		getContentPane().setLayout(null);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 13, 358, 276);
		getContentPane().add(scrollPane);
		
		list = new JList();
		list.setFont(new Font("黑体", Font.PLAIN, 15));
		changeList();
		scrollPane.setViewportView(list);
		
		JPanel panel_isbn = new JPanel();
		panel_isbn.setBounds(12, 317, 358, 30);
		getContentPane().add(panel_isbn);
		
		JLabel label_isbn = new JLabel("Isbn  ");
		label_isbn.setFont(new Font("幼圆", Font.PLAIN, 15));
		panel_isbn.add(label_isbn);
		
		text_isbn = new JTextField();
		text_isbn.setFont(new Font("幼圆", Font.PLAIN, 15));
		panel_isbn.add(text_isbn);
		text_isbn.setColumns(25);
		
		JPanel panel_copies = new JPanel();
		panel_copies.setBounds(12, 365, 358, 30);
		getContentPane().add(panel_copies);
		
		JLabel label_copies = new JLabel("数量  ");
		label_copies.setFont(new Font("黑体", Font.PLAIN, 15));
		panel_copies.add(label_copies);
		
		text_copies = new JTextField();
		text_copies.setFont(new Font("幼圆", Font.PLAIN, 15));
		text_copies.setColumns(25);
		panel_copies.add(text_copies);
		
		JButton btnNewButton = new JButton("加入购物车");
		btnNewButton.setFont(new Font("黑体", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String isbn = _14211182_曹桢_7_BuyUI.this.text_isbn.getText();
				String copiesStr = _14211182_曹桢_7_BuyUI.this.text_copies.getText();
				boolean flag;
				if(isbn.equals("") || copiesStr.equals("")){
					JOptionPane.showMessageDialog(null, "对不起，请输入完整信息");
				}
				else{
					try{
						int copies = Integer.parseInt(copiesStr);
						flag = _14211182_曹桢_7_BuyUI.this.controller.buyBook(isbn, copies);
						if(flag == false){
							JOptionPane.showMessageDialog(null, "输入错误：没有isbn为所输入isbn的图书！");
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
		btnNewButton.setBounds(245, 415, 125, 25);
		getContentPane().add(btnNewButton);
		
		setResizable(false);
		setVisible(true);
		
	}
	
	public void changeList(){
		ArrayList<String> BookList = this.controller.BookCatalogArray();
		String strings[]=new String[BookList.size() + 1];
		strings[0] = "isbn   书名      价格     种类";
		for(int i = 0 ;i < BookList.size();i++){
			strings[i + 1] = BookList.get(i);
			System.out.println(strings[i+1]);
		}
		this.list.setListData(strings);
	}
}
