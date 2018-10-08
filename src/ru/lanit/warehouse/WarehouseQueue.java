package ru.lanit.warehouse;

import sun.awt.windows.ThemeReader;

public class WarehouseQueue implements WhQueue{
    private int ID;
    private int quantity;
    private boolean newInQ = false;

    public synchronized void writeQ(int id, int qnt){
        String threadName = "Theard: "+Thread.currentThread().getName()+" ";
        System.out.println(threadName + "customer asked for id to queue " + id + " quantity " + qnt);
        if (newInQ) {
            try {
                System.out.println(threadName + "customer waiting");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(threadName + "customer added to queue " + id + " quantity " + qnt);
        ID		 = id;
        quantity = qnt;
        newInQ   = true;
        System.out.println(threadName + "customer asked notify");
        notify();
    }

    public synchronized int[] readQ() {
        String threadName = "Theard: "+Thread.currentThread().getName()+" ";
        System.out.println(threadName +"worker read queue");
        if (!newInQ) {
            try {
                System.out.println(threadName + "worker waiting");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        newInQ = false;
        System.out.println(threadName + "worker return item");
        System.out.println(threadName + "worker ask notify");
        notify();
        return new int[]{ID, quantity};
    }


}
