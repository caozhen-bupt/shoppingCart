package homework7;

import java.util.*;

public class _14211182_曹桢_7_PricingStrategyFactory {
	private static _14211182_曹桢_7_PricingStrategyFactory instance = null;
	private static _14211182_曹桢_7_StrategyCatalog catalog;
	
	private _14211182_曹桢_7_PricingStrategyFactory(){}
	
	public static synchronized _14211182_曹桢_7_PricingStrategyFactory getInstance(){
		if(instance == null){
			instance = new _14211182_曹桢_7_PricingStrategyFactory();
		}
		return instance;
	}
	
	public static _14211182_曹桢_7_IPricingStrategy getPricingStrategy(int bookType, _14211182_曹桢_7_StrategyCatalog  StrategyCatalog){
//		图书的类型包括：1.非教材类计算机图书、2.教材类图书、3.连环画类图书、4.养生类图书、5.其他
		catalog = StrategyCatalog;
		HashMap<String, _14211182_曹桢_7_IPricingStrategy> strategyCatalog = catalog.getStrategyList();
		Collection<_14211182_曹桢_7_IPricingStrategy> coll = strategyCatalog.values();
		Iterator<_14211182_曹桢_7_IPricingStrategy> it = coll.iterator();
		_14211182_曹桢_7_IPricingStrategy stra;
		while(it.hasNext()){
			stra = it.next();
			if(stra.getBookType() == bookType){
				if(stra.getStrategyType() == 1){
					return (_14211182_曹桢_7_PercentageStrategy)stra;
//					return new _14211182_曹桢_7_PercentageStrategy((_14211182_曹桢_7_PercentageStrategy)stra);
				}
				else if(stra.getStrategyType() == 2){
					return (_14211182_曹桢_7_FlatRateStrategy)stra;
				}
				else{//stra.getStrategyType() == 10
					return (_14211182_曹桢_7_CompositeStrategy)stra;
				}
			}
		}
		return new _14211182_曹桢_7_NoDiscountStrategy();
	}
	
	public static void setCatalog(_14211182_曹桢_7_StrategyCatalog sc){
		
	}
}
