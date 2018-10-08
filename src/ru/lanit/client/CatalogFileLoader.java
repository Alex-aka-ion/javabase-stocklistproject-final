package ru.lanit.client;

import ru.lanit.exceptions.CatalogLoadException;
import ru.lanit.exceptions.ItemAlreadyExistsException;
import ru.lanit.stocklist.FoodItem;
import ru.lanit.stocklist.ItemCatalog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class CatalogFileLoader implements CatalogLoader {
    private String fileName;
    public CatalogFileLoader(String fileName) {
        this.fileName = fileName;
    }

    public void load(ItemCatalog cat) throws CatalogLoadException {
        File f = new File(fileName);
        FileInputStream fis;

        String line;

        try {
            fis = new FileInputStream(f);
            Scanner s = new Scanner(fis);

            while (s.hasNextLine()) {
                line = s.nextLine();
                if (line.length() == 0) break;
                String[] itemFields = line.split(";");
                String name = itemFields[0];
                float price = Float.parseFloat(itemFields[1]);
                short expires = Short.parseShort(itemFields[2]);
                FoodItem item = new FoodItem(name, price, null, LocalDateTime.now(), expires);
                cat.addItem(item);
            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new CatalogLoadException(e);
        } catch (ItemAlreadyExistsException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new CatalogLoadException(e);
        }
    }

}
