package ru.lanit.stocklist;

import java.time.LocalDateTime;

public class FoodItem extends GenericItem {
    private LocalDateTime dateOfIncome; // дата производства
    private short expires; // срок годности

    public FoodItem(String name, float price, FoodItem analog, LocalDateTime dateOfIncome, short expires) {
        super(name,price,analog);
        this.setDateOfIncome(dateOfIncome);
        this.setExpires(expires);
    }
    public FoodItem(String name, float price) {
        super(name,price);
        this.setDateOfIncome(LocalDateTime.now());
        this.setExpires((short)30);
    }
    public FoodItem(String name) {
        super(name,0);
        this.setDateOfIncome(LocalDateTime.now());
        this.setExpires((short)30);
    }


    public void printAll() {
        System.out.println("ID="+ getID());
        System.out.println("name="+ getName());
        System.out.println("price="+ getPrice());
        System.out.println("dateOfIncome="+ getDateOfIncome());
        System.out.println("expires="+ getExpires());
        System.out.println("------");
    }

    public boolean equals(Object o) {
        if (o instanceof FoodItem) {
            FoodItem item = (FoodItem) o;
            if (item.getName().equals(this.getName())
                    && item.getPrice() == this.getPrice()
                    && item.getDateOfIncome().equals(this.getDateOfIncome())
                    && item.getExpires() == this.getExpires()) {
                return true;
            }
        }
        return false;
    }

    //TODO:: Узнать почему здесь this.analog - это GenericItem
    public Object clone() {
        FoodItem item = new FoodItem(this.getName(), this.getPrice(), (FoodItem) this.getAnalog(), this.getDateOfIncome(), this.getExpires());

        return item;
    }

    public LocalDateTime getDateOfIncome() {
        return dateOfIncome;
    }

    public void setDateOfIncome(LocalDateTime dateOfIncome) {
        this.dateOfIncome = dateOfIncome;
    }

    public short getExpires() {
        return expires;
    }

    public void setExpires(short expires) {
        this.expires = expires;
    }
}
