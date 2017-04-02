package homework7;
public class _14211182_曹桢_7_PercentageStrategy implements _14211182_曹桢_7_IPricingStrategy {
	private String strategyNumber;
	private String strategyTitle;
	private int strategyType;
	private int bookType;
	private int discountPercentage;
	
	public _14211182_曹桢_7_PercentageStrategy(String strategyNumber, String strategyTitle, int bookType, int discountPercentage){
		this.strategyNumber = strategyNumber;
		this.strategyTitle = strategyTitle;
		this.strategyType = 1;
		this.bookType = bookType;
		this.discountPercentage = discountPercentage;
		
	}
	
	public double getSubTotal(_14211182_曹桢_7_SaleLineItem saleLineItem){
		_14211182_曹桢_7_BookSpecification prod = saleLineItem.getProdSpec();
//		System.out.println("PercentageStrategy" + saleLineItem.getCopies() * (1 - 0.01 * discountPercentage) * prod.getPrice());
		return saleLineItem.getCopies() * (1 - 0.01 * discountPercentage) * prod.getPrice();
	}
	
	public int getBookType(){
		return this.bookType;
	}
	public int getStrategyType(){
		return this.strategyType;
	}
	
	public String toString(){
		return strategyNumber + "         " + strategyTitle + "         " + bookType + "         " + discountPercentage;
		
	}
	
	
}