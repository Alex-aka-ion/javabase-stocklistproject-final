package ru.lanit.client;

import ru.lanit.warehouse.WhQueue;

public class Customer extends Thread {
	
	private WhQueue q;
	private int fin_id;
	private int timeout;
	
	public Customer(WhQueue q, int fin_id, int timeout){
		this.q = q;
		this.fin_id = fin_id;
		this.timeout = timeout;
	}

	public void run() {
		for (int id = 1; id <= fin_id; id++) {
			int qnt = (int) Math.round((Math.random() + 1) * 20);
			q.writeQ(id, qnt);
			String threadName = "Theard: "+Thread.currentThread().getName()+" ";
			System.out.println(threadName + "Put request from customer: ID " + id + ", Quantity " + qnt);
			try {
				Thread.sleep(this.timeout);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		//Это сигнал завершения
		q.writeQ(-1, -1);
	}
	
}
