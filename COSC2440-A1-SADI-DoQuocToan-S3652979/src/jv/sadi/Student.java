package jv.sadi;

public class Student<T> {
    private T id;
    private String name;
    private String dob;

    public Student(T id, String name, String dob) {
        this.id = id;
        this.name = name;
        this.dob = dob;
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
}

