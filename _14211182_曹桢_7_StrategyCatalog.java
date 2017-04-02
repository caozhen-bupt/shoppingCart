package homework7;
import java.util.*;

public class _14211182_曹桢_7_StrategyCatalog {
	private HashMap<String, _14211182_曹桢_7_IPricingStrategy> strategies;
	
	public _14211182_曹桢_7_StrategyCatalog(){
		strategies = new HashMap<String, _14211182_曹桢_7_IPricingStrategy>();
	}
	public _14211182_曹桢_7_IPricingStrategy addStrategyList(String stra_num, _14211182_曹桢_7_IPricingStrategy stra){
		if(strategies.containsKey(stra_num)){
			return null;
		}
		this.strategies.put(stra_num, stra);
		return stra;
	}
	
	public _14211182_曹桢_7_IPricingStrategy delStrategyList(String stra_num){
		return this.strategies.remove(stra_num);
	}
	
	public _14211182_曹桢_7_IPricingStrategy upStrategyList(String stra_num, _14211182_曹桢_7_IPricingStrategy stra){
		_14211182_曹桢_7_IPricingStrategy strategy = this.strategies.remove(stra_num);
		this.strategies.put(stra_num, stra);
		return strategy;
	}
	
	public _14211182_曹桢_7_IPricingStrategy getStrategySpecification(String str){
		return this.strategies.get(str);
	}
	
	public HashMap<String, _14211182_曹桢_7_IPricingStrategy> getStrategyList(){
		return this.strategies;
	}
	
	
	public ArrayList<String> StringArray(){
		Collection<_14211182_曹桢_7_IPricingStrategy> coll = strategies.values();
		Iterator<_14211182_曹桢_7_IPricingStrategy> it = coll.iterator();
		ArrayList<String> StrategyArray = new ArrayList<String>();
		int i = 0;
		while(it.hasNext()){
			StrategyArray.add(it.next().toString());
//			System.out.println("toStringArray  str[i]:" + StrategyArray.get(i));
		}
		return StrategyArray;
	}
}
