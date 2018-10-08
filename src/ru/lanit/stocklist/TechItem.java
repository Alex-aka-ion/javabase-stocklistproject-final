package ru.lanit.stocklist;

public class TechItem extends GenericItem {
    private short warrantyTime;

    void printAll() {
        System.out.println("ID="+ getID());
        System.out.println("name="+ getName());
        System.out.println("price="+ getPrice());
        System.out.println("warrantyTime="+ getWarrantyTime());
        System.out.println("------");
    }

    public boolean equals(Object o) {
        if (o instanceof TechItem) {
            TechItem item = (TechItem) o;
            if (item.getName().equals(this.getName())
                    && item.getPrice() == this.getPrice()
                    && item.getWarrantyTime() == this.getWarrantyTime()) {
                return true;
            }
        }
        return false;
    }

    public Object clone() {
        TechItem item = new TechItem();
        item.setName(this.getName());
        item.setPrice(this.getPrice());
        item.setWarrantyTime(this.getWarrantyTime());

        return item;
    }

    public short getWarrantyTime() {
        return warrantyTime;
    }

    public void setWarrantyTime(short warrantyTime) {
        this.warrantyTime = warrantyTime;
    }
}
