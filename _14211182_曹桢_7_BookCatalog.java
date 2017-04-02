package homework7;

import java.util.ArrayList;

public class _14211182_曹桢_7_BookCatalog {
	private ArrayList<_14211182_曹桢_7_BookSpecification> books;
	
	public _14211182_曹桢_7_BookCatalog(){
		books = new ArrayList<_14211182_曹桢_7_BookSpecification>();
	}
	public void addBookList(_14211182_曹桢_7_BookSpecification abook){
		books.add(abook);
	}
	
	public _14211182_曹桢_7_BookSpecification getBookSpecification(String str){
		for(int i = 0; i < books.size(); i++){
			if(books.get(i).getISBN().equals(str)){
				return books.get(i);
			}
		}
		return null;
	}
	
	public ArrayList<String> BookCatalogString(){
		ArrayList<String> BookString = new ArrayList<String>();
		for(int i = 0; i < books.size(); i++){
			BookString.add(books.get(i).toString());
		}
		return BookString;
	}
	
	public ArrayList<_14211182_曹桢_7_BookSpecification> getBookList(){
		return books;
	}
}
