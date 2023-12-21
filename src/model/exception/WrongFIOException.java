package src.model.exception;

public class WrongFIOException extends MainException{
    public WrongFIOException() {
        super("Неверный формат ФИО!");
    }
}
