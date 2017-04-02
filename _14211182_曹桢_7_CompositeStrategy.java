package homework7;

import java.util.ArrayList;

public class _14211182_曹桢_7_CompositeStrategy implements _14211182_曹桢_7_IPricingStrategy{
	protected ArrayList<_14211182_曹桢_7_IPricingStrategy> strategies;
	protected String strategyNumber;
	protected String strategyTitle;
	protected String simpleNumbers;
	protected int strategyType;
	protected int bookType;
	public _14211182_曹桢_7_CompositeStrategy(String strategyNumber, String strategyTitle, String simpleNumbers, int bookType){
		this.strategyNumber = strategyNumber;
		this.strategyTitle = strategyTitle;
		this.strategyType = 10;
		this.bookType = bookType;
		this.simpleNumbers = simpleNumbers;
		strategies = new ArrayList<_14211182_曹桢_7_IPricingStrategy>();
	}
	
	public void add(_14211182_曹桢_7_IPricingStrategy stra){
		this.strategies.add(stra);
	}
	
	public double getSubTotal(_14211182_曹桢_7_SaleLineItem saleLineItem){
		_14211182_曹桢_7_CompositeStrategy best = new _14211182_曹桢_7_CompositeBestForCustomer(strategies, strategyNumber, strategyTitle, simpleNumbers, bookType);
		return best.getSubTotal(saleLineItem);
	}
	
	public int getBookType(){
		return this.bookType;
	}
	
	public int getStrategyType(){
		return this.strategyType;
	}
	
	public String getSimpleNumbers(){
		return this.simpleNumbers;
	}
	
	public String toString(){
		return strategyNumber + "         " + strategyTitle + "         " + bookType + "         " + simpleNumbers;
	}
}
