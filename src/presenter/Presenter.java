package src.presenter;

import java.io.IOException;

import src.model.Service;
import src.model.exception.MainException;
import src.model.write.Writable;
import src.view.View;

public class Presenter {
    private View view;
    private Service service;


    public Presenter(View view) {
        this.view = view;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public void setData(String fromUser) {
        service.setNotebook(fromUser);
    }
    public void writeData(String fromUser) throws MainException, IOException{
        String result = service.writeNotebook(fromUser);
        String answer = result.toString();
        view.print(answer);
    }

    public void setWritable(Writable writable) {
        service.setWritable(writable);
    }
}
