package src.model;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import src.model.exception.FewNotebookException;
import src.model.exception.MainException;
import src.model.exception.MuchNotebookException;
import src.model.exception.NoNotebookException;
import src.model.exception.WriterException;
import src.model.exception.WrongFIOException;
import src.model.exception.WrongGenderException;
import src.model.exception.WrongNotebookException;
import src.model.exception.WrongNumberException;
import src.model.write.Writable;

public class Formatter implements Service {
    private List<String> allValues;
    private Service service;
    private Writable writable;

    public Formatter() {
        this.allValues = new ArrayList<>();
    }

    @Override
    public void setNotebook(String fromUser) {
        this.allValues = new ArrayList<>(List.of(fromUser.split(" ")));
    }

    //Одно из значений не содержит данных!"
    @Override
    public Notebook parse() throws MainException{
        Gender gender = getGender();
        String birthdate = getBirthdate();
        String number = getNumber();
        String surname = getSurname(getFio());
        String name = getName(getFio());
        String patronymic = getPatronymic(getFio());
        if (gender == null || birthdate == null || number == null || surname == null || name == null || patronymic == null) {
            throw new NoNotebookException();
        }
        return new Notebook(surname, name, patronymic, birthdate, gender, number);
    }

    // Вы ввели недостаточно данных!  Вы ввели слишком много данных!
    @Override
    public int getNotebookLength() throws FewNotebookException, MuchNotebookException {
        int err = 0;
        if (allValues.size() < 6) {
            err = -1;
        } else if (allValues.size() > 6) {
            err = -2;
        }
        checkNotebook(err);
        return err;
    }

    // Вы ввели недостаточно данных!  Вы ввели слишком много данных!
    @Override
    public boolean checkNotebook(int err) throws FewNotebookException, MuchNotebookException {
        boolean d = false;
        if (err == -1) {
            throw new FewNotebookException();
        } else if (err == -2) {
            throw new MuchNotebookException();
        } else d = true;
        return d;
    }

   //Пол указан неверно!"
    @Override
    public Gender getGender() throws WrongGenderException {
        Gender gender = null;
        for (String value : allValues) {
            if (value.equals("f") || value.equals("m")) {
                gender = Gender.valueOf(value);
            }
        }
        if (gender == null) {
            throw new WrongGenderException();
        }
        return gender;
    }

    //Неверный формат даты!
    @Override
    public String getBirthdate() throws MainException{
        String birthdate = null;
        for (String value : allValues) {
            if (dateIsValid(value) != null) {
                birthdate = value;
            }
        }
        if (birthdate == null) {
            throw new WrongNotebookException();
        }
        return birthdate;
    }


    private Date dateIsValid(String value) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            dateFormat.setLenient(false);
            return dateFormat.parse(value.trim());
        } catch (ParseException pe) {
            return null;
        }
    }

    //Неверный формат номера телефона!
    @Override
    public String getNumber() throws WrongNumberException {
        String number = null;
        for (String value : allValues) {
            if (numberIsValid(value) != null) {
                number = value;
                return number;
            }
        }
        if (number == null) {
            throw new WrongNumberException();
        }
        return number;
    }

    private String numberIsValid(String value) throws WrongNumberException {
        try {
            if (value.matches("[0-9]+")) {
                return value;
            }
        } catch (NumberFormatException e) {
            throw new WrongNumberException();
        }
        return null;
    }

    //Неверный формат ФИО!
    @Override
    public List<String> getFio() throws MainException{
        List<String> fio = new ArrayList<>();
        for (String value : allValues) {
            if (!value.equals("f") && !value.equals("m") && dateIsValid(value) == null && numberIsValid(value) == null) {
                fio.add(value);
            }
        }
        if (fio.size() < 3) {
            throw new WrongFIOException();
        }
        return fio;
    }

    @Override
    public String getSurname(List<String> fio) {
        return fio.get(0);
    }

    @Override
    public void setWritable(Writable writable) {
        this.writable = writable;
    }

    //Запись данных в файл невозможна!
    @Override
    public String writeNotebook(String fromUser) throws MainException, IOException{
        service = this;
        Notebook result = new Notebook();
        if (service.getNotebookLength() == 0) {
            result = service.parse();
            if (result == null) {
                throw new WriterException();
            }
            writable.write(result);
        }
        return result.toString();
    }

    private String getName(List<String> fio) {
        return fio.get(1);
    }

    private String getPatronymic(List<String> fio) {
        return fio.get(2);
    }
}

