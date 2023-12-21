package src.model.exception;

public class WrongGenderException extends MainException {
    public WrongGenderException() {
        super("Пол указан неверно!");
    }
}
