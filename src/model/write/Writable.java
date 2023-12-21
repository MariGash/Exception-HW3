package src.model.write;

import java.io.IOException;

import src.model.Notebook;

public interface Writable {
    void write(Notebook notebook) throws IOException;
}
