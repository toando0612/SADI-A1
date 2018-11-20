package jv.sadi.Observer;

import jv.sadi.StudentEnrollMent;

public class Notifier {
    private String name;
    private String email;


    public Notifier(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
    public void follow(StudentEnrollMent studentEnrollMent){
        studentEnrollMent.getNotifiers().add(this);
    }
}
