package src.model.exception;

public class WrongNumberException extends MainException {
    public WrongNumberException() {
        super("Неверный формат номера телефона!");
    }
}
