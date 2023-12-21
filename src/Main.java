package src;

import src.model.Formatter;
import src.model.write.FileHandler;
import src.view.ConsoleUI;

public class Main {
    public static void main(String[] args){
        ConsoleUI test = new ConsoleUI();
        test.setService(new Formatter());
        test.setWritable(new FileHandler());
        test.start();
    }
}
