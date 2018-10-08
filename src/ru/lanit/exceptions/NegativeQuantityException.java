package ru.lanit.exceptions;

public class NegativeQuantityException extends Exception {
    public NegativeQuantityException (Exception e) {
        super(e);
    }

    public NegativeQuantityException() {
        super("Что-то пошло не так с количеством!");
    }
}
