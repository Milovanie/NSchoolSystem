package loginapp;

public enum Option {
    Admin, Student;



    Option() {
    }

    public String value() {
        return name();
    }

    // for combobox
    public static Option fromValue(String value) {
        return valueOf(value);
    }
}
