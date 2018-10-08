package ru.lanit.client;

import ru.lanit.exceptions.CatalogLoadException;
import ru.lanit.stocklist.ItemCatalog;
import ru.lanit.warehouse.WarehouseQueue;
import ru.lanit.warehouse.Warehouse;
import ru.lanit.warehouse.WarehouseKeeper;

public class Main {

    public static void main(String[] args) {

        // Алгоритм Сбалансированной строки
        /*String sB = "(z)(((123*35)))((68)())";
        char[] arrC = new char[sB.length()];
        int sch = 0;

        for(int i = 0; i < sB.length(); i++) {
            if (sB.charAt(i)=='(') {
                sch++;
            } else if (sB.charAt(i)==')') {
                sch--;
            }
            if (sch < 0) {
                System.out.println("not valid");
            }
        }
        System.out.println("valid");
*/


 /*       String s1 = "Ac";
        String s2 = "BD";
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());*/

        /*System.out.println("s1"+s1);
        System.out.println("s2"+s2);
        s2 = s1;
        System.out.println("s1"+s1);
        System.out.println("s2"+s2);
        s1 = "Good bye";
        System.out.println("s1"+s1);
        System.out.println("s2"+s2);*/

        /*String sss = "Конфеты ’Маска’;45;120";
        String[] itemFields = new String[3];
        itemFields = sss.split(";");*/

       /* System.out.println(itemFields[0]);
        System.out.println(itemFields[1]);
        System.out.println(itemFields[2]);*/

       /*
        FoodItem fff = new FoodItem(itemFields[0],Float.parseFloat(itemFields[1]),null,null,Short.parseShort(itemFields[2]));
        fff.printAll();

        GenericItem item1 = new GenericItem("xz",1000);

        GenericItem item2 = new GenericItem("ne xz", 2000, item1);

        FoodItem food = new FoodItem("food", 3000, null, LocalDateTime.now(), (short)3);
        FoodItem food2 = new FoodItem("food2", 3200);
        food2.setAnalog(food);*/

     /*   StringBuilder sb1 = new StringBuilder("hello");
        StringBuilder sb2 = new StringBuilder("hello");

        System.out.println(sb2.equals(sb1));*/

        //item1.printAll();
        //item2.printAll();

       /* food.printAll();
        System.out.println("-------------------");
        food2.printAll();*/

        /*TechItem tech = new TechItem();
        tech.setID(4);
        tech.setName("tech");
        tech.setPrice(4000);
        tech.setWarrantyTime((short)4);

        TechItem tech2 = new TechItem();
        tech2.setID(10);
        tech2.setName("tech2");
        tech2.setPrice(10000);
        tech2.setWarrantyTime((short)7);

        TechItem tech3 = new TechItem();
        tech3.setID(11);
        tech3.setName("tech3");
        tech3.setPrice(11000);
        tech3.setWarrantyTime((short)9);

        GenericItem[] items = new GenericItem[2];
        items[0] = food;
        items[1] = tech;

        for (GenericItem i: items) {
        //    i.printAll();
        }

        FoodItem foodNew = (FoodItem)food.clone();

        //foodNew.price = 6000;

        //foodNew.printAll();
        System.out.println("-------------------");
        if (food.equals(foodNew)) {
            System.out.println("equals");
        } else {
            System.out.println("not equals");
        }*/

        /*GenericItem item2new = (GenericItem)item2.clone();*/
        //System.out.println("-------------------");
        //item2.printAll();
        //System.out.println("-------------------");
        //item2new.printAll();

        ItemCatalog cat = new ItemCatalog();

/*        cat.addItem(fff);
        cat.addItem(food);
        cat.addItem(food2);
        cat.addItem(foodNew);
        cat.addItem(tech);
        cat.addItem(item1);
        cat.addItem(item2);
        cat.addItem(item2new);
        cat.addItem(tech2);
        cat.addItem(tech3);

        cat.printItems();

        for(int j=0; j<10;j++) {

            long begin = java.time.Instant.now().toEpochMilli();
            for (int i = 0; i < 100_000; i++)
                cat.findItemByID(10);
            long end = java.time.Instant.now().toEpochMilli();
            System.out.println("In HashMap " + (end - begin));


            begin = java.time.Instant.now().toEpochMilli();
            for (int i = 0; i < 100_000; i++)
                cat.findItemByIDAL(10);
            end = java.time.Instant.now().toEpochMilli();
            System.out.println("In ArrayList " + (end - begin));
        }*/

        /*CatalogLoader loader = new CatalogStubLoader();
        try {
            loader.load(cat);
        } catch (CatalogLoadException e) {
            e.printStackTrace();
        }*/

        CatalogLoader loader2 = new CatalogFileLoader("items.lst");
        try {
            loader2.load(cat);
        } catch (CatalogLoadException e) {
            e.printStackTrace();
        }

        //cat.printItems();



        Warehouse wh = new Warehouse();
       // NotSynWarehouseQueue q = new NotSynWarehouseQueue();
        WarehouseQueue q = new WarehouseQueue();
        Customer cust = new Customer(q, 20, 300);
        WarehouseKeeper kep = new WarehouseKeeper(q, wh, cat, 1000);

        cust.start();
        kep.start();


    }
}
