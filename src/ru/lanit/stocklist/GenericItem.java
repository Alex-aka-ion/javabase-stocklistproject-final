package ru.lanit.stocklist;

public class GenericItem {
    static int currentID;

    private int ID;   		// ID товара
    private String name;   		// Наименование товара
    private float price;    		//Цена товара
    private GenericItem analog = null;

    public GenericItem(String name, float price) {
        this.setID(++GenericItem.currentID);
        this.setName(name);
        this.setPrice(price);
    }
    public GenericItem(String name, float price, GenericItem analog) {
        this(name,price);
        this.setAnalog(analog);
    }
    public GenericItem() {
    }

    void printAll() {
        System.out.println("ID="+ getID());
        System.out.println("name="+ getName());
        System.out.println("price="+ getPrice());

        if (this.getAnalog() != null) {
            System.out.println("Analog:");
            this.getAnalog().printAll();
        }
        System.out.println("------");
    }

    public boolean equals(Object o) {
        if (o instanceof GenericItem) {
            GenericItem item = (GenericItem)o;
            if (item.getName().equals(this.getName()) && item.getPrice() == this.getPrice()) {
                return true;
            }
        }
        return false;
    }

    public Object clone() {
        GenericItem item = new GenericItem(this.getName(), this.getPrice(), this.getAnalog());

        return item;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public GenericItem getAnalog() {
        return analog;
    }

    public void setAnalog(GenericItem analog) {
        this.analog = analog;
    }
}
