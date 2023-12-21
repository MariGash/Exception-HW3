package src.model;

public class Notebook {
    private String surname;
    private String name;
    private String patronymic;
    private String birthdate;
    private Gender gender;
    private String number;

    public Notebook (String surname, String name, String patronymic, String birthdate, Gender gender, String number) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.birthdate = birthdate;
        this.gender = gender;
        this.number = number;
    }

    public Notebook() {
        this.surname = null;
        this.name = null;
        this.patronymic = null;
        this.birthdate = null;
        this.gender = null;
        this.number = null;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public Gender getGender() {
        return gender;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "<" + surname + "><" + name + "><" + patronymic + "><" + birthdate + "><" + number + "><" + gender + ">";

    }
}