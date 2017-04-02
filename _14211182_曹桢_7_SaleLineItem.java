package homework7;
public class _14211182_曹桢_7_SaleLineItem {
	private int copies;
	private _14211182_曹桢_7_BookSpecification prodSpec;
	private _14211182_曹桢_7_IPricingStrategy strategy;
	
	public _14211182_曹桢_7_SaleLineItem(int copies, _14211182_曹桢_7_BookSpecification prodSpec, _14211182_曹桢_7_StrategyCatalog strategyCatalog){
		this.copies = copies;
		this.prodSpec = prodSpec;
		this.strategy = _14211182_曹桢_7_PricingStrategyFactory.getPricingStrategy(prodSpec.getType(), strategyCatalog);
	}
	public int getCopies(){
		return this.copies;
	}
	public _14211182_曹桢_7_BookSpecification getProdSpec(){
		return this.prodSpec;
	}
	public double getSubTotal(){
		return this.strategy.getSubTotal(this);
	}
	
	public String toString(){
		return this.prodSpec.getTitle() + "          " + this.copies;
	}
}
