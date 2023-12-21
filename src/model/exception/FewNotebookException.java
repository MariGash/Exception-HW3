package src.model.exception;

public class FewNotebookException extends MainException {
    public FewNotebookException() {
        super("Вы ввели недостаточно данных!");
    }
}
