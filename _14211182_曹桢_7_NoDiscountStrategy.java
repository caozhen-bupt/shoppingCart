package homework7;

public class _14211182_曹桢_7_NoDiscountStrategy implements _14211182_曹桢_7_IPricingStrategy{
	private int bookType;
	private int strategyType;
	public _14211182_曹桢_7_NoDiscountStrategy(){
		this.bookType = 5;
		this.strategyType = 100;
	}
	public double getSubTotal(_14211182_曹桢_7_SaleLineItem saleLineItem){
//		System.out.println("CompositeBestForCustomer" + saleLineItem.getCopies() * saleLineItem.getProdSpec().getPrice());
		return saleLineItem.getCopies() * saleLineItem.getProdSpec().getPrice();
	}
	
	public int getBookType(){
		return this.bookType;
	}
	public int getStrategyType(){
		return this.strategyType;
	}
}