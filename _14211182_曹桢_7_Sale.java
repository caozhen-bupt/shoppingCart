package homework7;

import java.util.ArrayList;

public class _14211182_曹桢_7_Sale implements _14211182_曹桢_7_Subject{
	private ArrayList<_14211182_曹桢_7_SaleLineItem> items;
	private ArrayList<_14211182_曹桢_7_Observer> observers;
	
	public _14211182_曹桢_7_Sale(){
		items = new ArrayList<_14211182_曹桢_7_SaleLineItem>();
		observers = new ArrayList<_14211182_曹桢_7_Observer>();
	}
	
	public void addItem(_14211182_曹桢_7_SaleLineItem aSaleItem){
		this.items.add(aSaleItem);
	}
	
	public void removeObserver(_14211182_曹桢_7_Observer obs){
		this.observers.remove(obs);
	}
	
	public void registerObserver(_14211182_曹桢_7_Observer obs){
		this.observers.add(obs);
	}
	
	public void notifyObserver(){
		for(int i = 0; i < this.observers.size(); i++){
			this.observers.get(i).update(this);
		}
	}
	
	public ArrayList<String> getItems(){
		ArrayList<String> ItemsString = new ArrayList<String>();
		for(int i = 0; i < this.items.size(); i++){
			ItemsString.add(this.items.get(i).toString());
		}
		return ItemsString;
	}
	
	public double getTotal(){
		double total = 0;
		for(int i = 0; i < this.items.size(); i++){
			total += this.items.get(i).getSubTotal();
		}
		return total;
	}
}
