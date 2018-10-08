package ru.lanit.exceptions;

import java.io.FileNotFoundException;

public class CatalogLoadException extends Throwable {
    public CatalogLoadException (Exception e) {
        super(e);
    }

    public CatalogLoadException() {
        super("Что-то пошло не так с каталогом!");
    }
}
