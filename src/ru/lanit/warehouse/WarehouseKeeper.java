package ru.lanit.warehouse;

import ru.lanit.stocklist.FoodItem;
import ru.lanit.stocklist.GenericItem;
import ru.lanit.stocklist.ItemCatalog;

public class WarehouseKeeper extends Thread {
	
	WhQueue q;
	Warehouse w;
	ItemCatalog cat;
	private int timeout;
	
	public WarehouseKeeper(WhQueue q, Warehouse w, ItemCatalog cat, int timeout){
		this.q	 =q;
		this.w   =w;
		this.cat = cat;
		this.timeout = timeout;
	}

	public void run() {
		int[] qnt;
		while (true) {
			qnt = q.readQ();
			if (qnt[0] == -1) break; //тут остановка
			GenericItem item = cat.findItemByID(qnt[0]);
			if (item != null) w.addQuantity(item, qnt[1]);
			String threadName = "Theard: "+Thread.currentThread().getName()+" ";
			System.out.println(threadName + "Get from worker: ID " + qnt[0] + ", Quantity " + qnt[1]);
			try {
				Thread.sleep(this.timeout);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
