package ru.lanit.warehouse;

import java.util.Queue;

public class NotSynWarehouseQueue implements WhQueue{
	private int ID;
	private int quantity;
	
	public void writeQ(int id, int qnt){
				
		ID		 = id;
		quantity = qnt;
				
	}
	
	public int[] readQ(){
		
		return new int[]{ID,quantity};
		
	}
	
	
}
