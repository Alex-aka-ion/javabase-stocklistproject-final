package ru.lanit.warehouse;

import java.util.HashMap;

import ru.lanit.exceptions.NegativeQuantityException;
import ru.lanit.stocklist.FoodItem;
import ru.lanit.stocklist.GenericItem;

public class Warehouse {
	private HashMap<Integer,Integer> wh;
	
	public Warehouse(){
		wh = new HashMap<Integer,Integer>();
	}

	public void addQuantity(GenericItem i, int quantity) {
		int id = i.getID();
		if (wh.containsKey(id)) {
			int curr_q = wh.get(id);
			wh.put(id, curr_q + quantity);
		} else {
			wh.put(id, quantity);
		}

	}
	
	public void remQuantity(GenericItem i, int quantity) throws NegativeQuantityException{
		int id = i.getID();
		if(wh.containsKey(id)){
			int curr_q = wh.get(id);
			if(curr_q-quantity>=0){
				wh.put(id, curr_q-quantity);
			}else{
				throw new NegativeQuantityException();
			}			
		}else{
			throw new NegativeQuantityException();
		}
			
	}
	
	public int getQuantity(GenericItem i){
		if(wh.containsKey(i.getID())){
			return wh.get(i.getID());
		}else{
			return 0;
		}
	}
	
	
}
