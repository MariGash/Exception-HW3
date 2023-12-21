package src.model.exception;

public class NoNotebookException extends MainException {
    public NoNotebookException() {
        super("Одно из значений не содержит данных!");
    }
}
