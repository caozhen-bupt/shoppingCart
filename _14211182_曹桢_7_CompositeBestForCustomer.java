package homework7;

import java.util.ArrayList;

public class _14211182_曹桢_7_CompositeBestForCustomer extends _14211182_曹桢_7_CompositeStrategy{
	public _14211182_曹桢_7_CompositeBestForCustomer(ArrayList<_14211182_曹桢_7_IPricingStrategy> strategies, String strategyNumber, String strategyTitle, String simpleNumbers, int bookType){
		super(strategyNumber, strategyTitle, simpleNumbers, bookType);
		this.strategies = strategies;
	}
	
	public double getSubTotal(_14211182_曹桢_7_SaleLineItem saleLineItem){
		if(this.strategies.size() == 0){
			return -1;
		}
		double best = this.strategies.get(0).getSubTotal(saleLineItem);
		for(int i = 1; i < this.strategies.size(); i++){
			double temp = this.strategies.get(i).getSubTotal(saleLineItem);
			if(temp < best){
				best = temp;
			}
		}
//		System.out.println("CompositeBestForCustomer" + best);
		return best;
	}
}
