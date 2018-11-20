package jv.sadi;

import jv.sadi.Adapter.AdapterPrintCourses;
import jv.sadi.Adapter.AdapterPrintStudents;
import jv.sadi.Adapter.PrintEmrollments;
import jv.sadi.Observer.Notifier;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class StudentEnrollMent {
    private Student student;
    private Course course;
    private String semester;

    private List<Notifier> notifiers = new ArrayList<>();

    public List<Notifier> getNotifiers() {
        return notifiers;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public ArrayList enroll(ArrayList e, ArrayList s, ArrayList c) {
        StudentEnrollMent ste = new StudentEnrollMent();

//        printStudent(s);
        PrintEmrollments printStudents = new AdapterPrintStudents();
        printStudents.print(s);

        System.out.print("Please choose id student that you want to enroll:");
        Scanner scanner = new Scanner(System.in);
        var ids = scanner.nextInt() - 1;
        Student s1;
        s1 = (Student) s.get(ids);
        ste.setStudent(s1);

//        printCourse(c);
        PrintEmrollments printCourses = new AdapterPrintCourses();
        printCourses.print(c);
        System.out.print("Please choose id course that you want to enroll:");
        var idc = scanner.nextInt() - 1;
        Course c1;
        c1 = (Course) c.get(idc);
        ste.setCourse(c1);

        System.out.println("Enter the semester: 1.2018A |2.2018B |3.2018C");
        Scanner scanner1 =new Scanner(System.in);
        String sem = scanner1.nextLine().toUpperCase();
        ste.setSemester(sem);

        e.add(ste);

        for (Notifier notifier: notifiers){
            sendNotification(notifier.getEmail(), notifier.getName());
        }
        return e;
    }

    public ArrayList withdraw(ArrayList e){
        System.out.print("Please enter the ID of enrollment to drop:");
        Scanner scanner = new Scanner(System.in);
        var idtodrop = scanner.nextInt() - 1;
        e.remove(idtodrop);
        for (Notifier notifier: notifiers){
            sendNotification(notifier.getEmail(), notifier.getName());
        }
        return e;
    }

    public void view(ArrayList e) {
        if (e.size()==0){
            System.out.println("The enrollment is empty");
        }
        var id = 0;
        Iterator ste = e.iterator();
        while (ste.hasNext()) {
            Object obj = ste.next();
            if (obj instanceof StudentEnrollMent) {
                id++;
                StudentEnrollMent steprint = (StudentEnrollMent) obj;
                System.out.println(
                        "ID:" + id + "-->| Name:" + steprint.getStudent().getName() +"|Card Number: "+steprint.getStudent().getId()+" |Dob:" + steprint.getStudent().getDob()
                                + "|"+steprint.getCourse().getId()+" " + steprint.getCourse().getName() + "|Credit:" + steprint.getCourse().getCredit()
                                + "|Semester:" + steprint.getSemester()+"|");
            }
        }
    }

    public ArrayList edit(ArrayList e, ArrayList s, ArrayList c){
        System.out.print("Please enter ID of enrollment that you want to update:");
        Scanner scanner = new Scanner(System.in);
        var ide = scanner.nextInt() - 1;
        StudentEnrollMent ste;
        ste = (StudentEnrollMent) e.get(ide);

        System.out.print("Choose which one to update:"+"\n"
                +"1.Student"+"\n"
                +"2.Course"+"\n"
                +"3.Semester"+"\n"
                +"4.Press other to back"+"\n"
                +"Your choice: ");
        var choice = scanner.nextInt();
        if (choice==1) {
//            printStudent(s);
            PrintEmrollments printStudents = new AdapterPrintStudents();
            printStudents.print(s);
            System.out.print("Choose student to replace:");
            var student = scanner.nextInt() - 1;
            Student student1;
            student1 = (Student) s.get(student);
            ste.setStudent(student1);

        }
        else if (choice==2)
        {
//            printCourse(c);
            PrintEmrollments printCourses = new AdapterPrintCourses();
            printCourses.print(c);
            System.out.print("Choose course to replace:");
            var course = scanner.nextInt() - 1;
            Course course1;
            course1 = (Course) c.get(course);
            ste.setCourse(course1);
        }
        else if (choice == 3){
            System.out.println("Enter the semester: 2018A |2018B |2018C");
            Scanner scanner1 =new Scanner(System.in);
            String sem = scanner1.nextLine().toUpperCase();
            ste.setSemester(sem);
        }
        for (Notifier notifier: notifiers){
            sendNotification(notifier.getEmail(), notifier.getName());
        }
        return e;
    }

    public void sendNotification(String email, String name){
        System.out.println("Notification has been release to  ===>" +name+":"+email);
    }

}
