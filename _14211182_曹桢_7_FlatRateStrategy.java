package homework7;
public class _14211182_曹桢_7_FlatRateStrategy implements _14211182_曹桢_7_IPricingStrategy{
	private String strategyNumber;
	private String strategyTitle;
	private int strategyType;
	private int bookType;
	private double discountPerBook;
	
	public _14211182_曹桢_7_FlatRateStrategy(String strategyNumber, String strategyTitle, int bookType, double discountPerBook){
		this.strategyNumber = strategyNumber;
		this.strategyTitle = strategyTitle;
		this.strategyType = 2;
		this.bookType = bookType;
		this.discountPerBook = discountPerBook;
	}
	
	public double getSubTotal(_14211182_曹桢_7_SaleLineItem saleLineItem){
		_14211182_曹桢_7_BookSpecification prod = saleLineItem.getProdSpec();
		double price = prod.getPrice();
		if(price >= discountPerBook){
//			System.out.println("FlatRateStrategy" + saleLineItem.getCopies() * (price - discountPerBook));
			return saleLineItem.getCopies() * (price - discountPerBook);
		}
		else{
//			System.out.println("FlatRateStrategy" + 0 );
			return 0;
		}
	}
	
	public int getBookType(){
		return this.bookType;
	}
	
	public int getStrategyType(){
		return this.strategyType;
	}
	
	public String toString(){
		return strategyNumber + "         " + strategyTitle + "         " + bookType + "         " + discountPerBook;
		
	}
}
