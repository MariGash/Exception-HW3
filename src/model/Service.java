package src.model;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import src.model.exception.MainException;
import src.model.exception.WrongGenderException;
import src.model.exception.WrongNumberException;
import src.model.write.Writable;

public interface Service {

    Notebook parse() throws MainException;
    boolean checkNotebook(int err) throws MainException;
    int getNotebookLength() throws IOException, MainException;
    Gender getGender() throws WrongGenderException;
    String getBirthdate() throws MainException, ParseException;
    String getNumber() throws WrongNumberException;
    List<String> getFio() throws MainException, ParseException;
    String getSurname(List<String> fio);
    void setWritable(Writable writable);
    String writeNotebook(String fromUser) throws MainException, IOException;
    void setNotebook(String fromUser);
}
