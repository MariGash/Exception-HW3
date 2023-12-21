package src.view;

import java.io.IOException;
import java.util.Scanner;

import src.model.Service;
import src.model.exception.MainException;
import src.model.write.Writable;
import src.presenter.Presenter;

public class ConsoleUI implements View {
    private Presenter presenter;
    private Scanner scanner;
    private boolean work;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
    }

    @Override
    public void start(){
        while (work) {
            try {
                hello();
                String data = scan();
                presenter.setData(data);
                if (data == null) {
                    throw new IOException("Вы не ввели данные");
                }
                else if (data.equals("0")) {
                    finish();
                } else {
                    try {
                        presenter.writeData(data);
                    } catch (MainException e) {
                        System.out.println(e.getMessage());
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void hello() {
        System.out.println("Введите фамилию, имя, отчество, дату рождения (в формате dd.mm.yyyy), номер телефона (число без разделителей) и пол (символ латиницей f или m), разделенные пробелом");
        System.out.println("Для выхода нажмите 0");
    }

    @Override
    public String scan() {
        return scanner.nextLine();
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void finish() {
        System.out.println("Работа приложения завершена.");
        scanner.close();
        work = false;
    }

    public void setService(Service service) {
        presenter.setService(service);
    }

    public void setWritable(Writable writable) {
        presenter.setWritable(writable);
    }
}
