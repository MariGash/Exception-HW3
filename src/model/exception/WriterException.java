package src.model.exception;

public class WriterException extends MainException {
    public WriterException() {
        super("Запись данных в файл невозможна!");
    }
}
