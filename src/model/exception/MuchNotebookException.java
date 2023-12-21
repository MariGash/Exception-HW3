package src.model.exception;

public class MuchNotebookException extends MainException {
    public MuchNotebookException() {
        super("Вы ввели слишком много данных!");
    }
}
