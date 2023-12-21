package src.view;

import java.io.IOException;

import src.model.exception.MainException;

public interface View {
    void start() throws IOException, MainException;
    void print(String text);
    void finish();
    String scan();
}
