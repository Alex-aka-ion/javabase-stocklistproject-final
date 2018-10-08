package ru.lanit.stocklist;

import ru.lanit.exceptions.ItemAlreadyExistsException;
import ru.lanit.stocklist.GenericItem;

import java.util.ArrayList;
import java.util.HashMap;

public class ItemCatalog {
    private HashMap<Integer, GenericItem> catalog = new HashMap<>();
    private ArrayList<GenericItem> ALCatalog = new ArrayList< >();

    public void addItem(GenericItem item) throws ItemAlreadyExistsException {
        if (catalog.putIfAbsent(item.getID(),item) == null) {
            ALCatalog.add(item);
        } else {
            throw new ItemAlreadyExistsException("item.id="+item.getID());
        }
    }

    public void printItems() {
        /*for (GenericItem item: ALCatalog) {
            item.printAll();
        }*/
        /*ALCatalog.forEach(item -> System.out.println(item)); // - лямбда, вызывается метод toSting() класса GenericItem
        ALCatalog.forEach(System.out::println); // - ссылка на метод, вызывается метод toString() класса GenericItem
        ALCatalog.forEach(item -> item.printAll()); // - лямбда, вызывается метод printAll() класса GenericItem*/
        ALCatalog.forEach(GenericItem::printAll); // - ссылка на метод, вызывается метод printAll() класса GenericItem
    }

    public GenericItem findItemByID(int id) {
        return catalog.get(id);
    }

    public GenericItem findItemByIDAL(int id) {
        GenericItem itemSearched = null;
        for (GenericItem item: ALCatalog) {
            if (item.getID() == id) {
                itemSearched = item;
            }
        }
        return itemSearched;
    }


}
