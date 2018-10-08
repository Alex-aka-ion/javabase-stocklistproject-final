package ru.lanit.client;

import ru.lanit.exceptions.*;
import ru.lanit.stocklist.FoodItem;
import ru.lanit.stocklist.GenericItem;
import ru.lanit.stocklist.ItemCatalog;


import java.time.LocalDateTime;

public class CatalogStubLoader implements CatalogLoader {
    public void load(ItemCatalog cat) throws CatalogLoadException {
            GenericItem item1 = new GenericItem("Sony TV", 23000);
            FoodItem item2 = new FoodItem("Bread", 12, null, LocalDateTime.now(), (short) 10);
            try {
                cat.addItem(item1);
                cat.addItem(item2);
            } catch (ItemAlreadyExistsException e) {
                e.printStackTrace();
                throw new CatalogLoadException(e);
            }
    }
}
