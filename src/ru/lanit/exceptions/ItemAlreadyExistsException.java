package ru.lanit.exceptions;

public class ItemAlreadyExistsException extends Exception {
    public ItemAlreadyExistsException (String message) {
        super(message);
    }

    public ItemAlreadyExistsException() {
        super("Что-то пошло не так с айтемом!");
    }
}
