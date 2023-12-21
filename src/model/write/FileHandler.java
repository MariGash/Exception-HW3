package src.model.write;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import src.model.Notebook;

public class FileHandler implements Writable{

    @Override
    public void write(Notebook notebook) throws IOException {
        String fileName = "files\\" + notebook.getSurname().toLowerCase() + ".txt";
        File file = new File(fileName);
        try (FileWriter fileWriter = new FileWriter(file, true)){
            if (file.length() > 0){
                fileWriter.write('\n');
            }
            fileWriter.write(notebook.toString());
        }
    }
}