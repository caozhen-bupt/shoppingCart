package homework7;

import java.util.ArrayList;
import java.util.HashMap;

public class _14211182_曹桢_7_Controller {
	private _14211182_曹桢_7_BookCatalog bookCatalog;
	private _14211182_曹桢_7_StrategyCatalog strategyCatalog;
	private _14211182_曹桢_7_Sale aSale;
	
	public _14211182_曹桢_7_Controller(){
		bookCatalog = new _14211182_曹桢_7_BookCatalog();
		strategyCatalog = new _14211182_曹桢_7_StrategyCatalog();
		aSale = new _14211182_曹桢_7_Sale();
	}
	public _14211182_曹桢_7_BookCatalog getBookCatalog(){
		return bookCatalog;
	}
	
	public void addBook(String isbn, String title, double price, int type){
		_14211182_曹桢_7_BookSpecification abook = new _14211182_曹桢_7_BookSpecification(isbn, price, title, type);
		bookCatalog.addBookList(abook);
	}
	
	public boolean addCompositeStrategy(String stra_num, _14211182_曹桢_7_CompositeStrategy compositeStra){
		String [] simples = compositeStra.getSimpleNumbers().split("\\|");
		_14211182_曹桢_7_IPricingStrategy stra;
//		boolean flag = true;
		for(int i = 0; i < simples.length; i++){
			stra = strategyCatalog.getStrategySpecification(simples[i]);
			if(stra == null){
				return false;
			}
		}
	
		for(int i = 0; i < simples.length; i++){
			stra = strategyCatalog.getStrategySpecification(simples[i]);
			compositeStra.add(stra);
		}
		 if(strategyCatalog.addStrategyList(stra_num, compositeStra) == null){
			 return false;
		}
		return true;
	}
	
	public _14211182_曹桢_7_IPricingStrategy addSimpleStrategy(String stra_num, _14211182_曹桢_7_IPricingStrategy simpleStra){
		return this.strategyCatalog.addStrategyList(stra_num, simpleStra);
	}
	
	public _14211182_曹桢_7_IPricingStrategy deleteStrategy(String stra_num){
		return this.strategyCatalog.delStrategyList(stra_num);
	}
	
	public _14211182_曹桢_7_IPricingStrategy updateStrategy(String stra_num, _14211182_曹桢_7_IPricingStrategy stra){
		return this.strategyCatalog.upStrategyList(stra_num, stra);
	}
	
	public ArrayList<String> StrategyCatalogArray(){
		return strategyCatalog.StringArray();
	}
	
	public ArrayList<String> BookCatalogArray(){
		return bookCatalog.BookCatalogString();
	}
	
	public boolean buyBook(String isbn, int copies){
		boolean flag = false;
		ArrayList<_14211182_曹桢_7_BookSpecification> books = bookCatalog.getBookList();
		for(int i = 0; i < books.size(); i++){
			if(isbn.equals(books.get(i).getISBN())){
				_14211182_曹桢_7_SaleLineItem aSaleItem = new _14211182_曹桢_7_SaleLineItem(copies, books.get(i), this.strategyCatalog);
				this.aSale.addItem(aSaleItem);
				flag = true;
				break;
			}
		}
		this.aSale.notifyObserver();
		return flag;
	}
	
	public _14211182_曹桢_7_Sale getSale(){
		return this.aSale;
	}
	
	public _14211182_曹桢_7_IPricingStrategy SearchFor(String str){
		return this.strategyCatalog.getStrategySpecification(str);
	}
	
}
