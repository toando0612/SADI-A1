package jv.sadi;

public class Course {
    private Courses id;
    private String name;
    private int credit;

    public Course(Courses id, String name, int credit) {
        this.id = id;
        this.name = name;
        this.credit = credit;
    }

    public Courses getId() {
        return id;
    }

    public void setId(Courses id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }
}