package homework7;

public class _14211182_曹桢_7_BookSpecification {
	private String isbn;
	private double price;
	private String title;
	private int type;	//图书的类型包括：1.非教材类计算机图书、2.教材类图书、3.连环画类图书、4.养生类图书、5.其他
	
	public _14211182_曹桢_7_BookSpecification(String isbn, double price, String title, int type){
		this.isbn = isbn;
		this.price = price;
		this.title = title;
		this.type = type;
	}
	public String getISBN(){
		return this.isbn;
	}
	public String getTitle(){
		return this.title;
	}
	public double getPrice(){
		return this.price;
	}
	public int getType(){
		return this.type;
	}
	public String toString(){
		return isbn + "         " + title + "         " + price + "         " + type;
	}
	
}
