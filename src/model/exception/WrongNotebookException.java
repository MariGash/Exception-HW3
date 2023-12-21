package src.model.exception;

public class WrongNotebookException extends MainException {
    public WrongNotebookException() {
        super("Неверный формат даты!");
    }
}
