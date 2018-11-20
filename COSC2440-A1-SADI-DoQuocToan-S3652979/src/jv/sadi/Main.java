package jv.sadi;

import jv.sadi.Decorator.Decorator;
import jv.sadi.Decorator.Message;
import jv.sadi.Decorator.NewMessage;
import jv.sadi.Observer.Notifier;
import jv.sadi.Proxy.Banner;
import jv.sadi.Proxy.ProxyBanner;
import jv.sadi.Singleton.MyTask;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void creatingSample(ArrayList s, ArrayList c){
        Student<Integer> st1 = new Student<Integer>(3652979,"Do Quoc Toan", "6/12/1994");   //Generics Feature
        Student<String> st2 = new Student<String>("s123456","Nguyen Hoang Phuc", "7/8/1994");
        Student<Integer> st3 = new Student<Integer>(456789,"Nguyen Van Cuong", "5/1/1994");
        s.add(st1);
        s.add(st2);
        s.add(st3);
        Course c1 = new Course(Courses.COSC2440,"Programming 1", 12);           //Enum Feature
        Course c2 = new Course(Courses.COSC2441,"Web Programming", 12);
        Course c3 = new Course(Courses.COSC2442,"Intro to Programming", 12);
        c.add(c1);
        c.add(c2);
        c.add(c3);
    }
    public static void printMenu(String...a){
        int i = 1;
        for (String s:a){
            System.out.println(i+"."+s);
            i++;
        }
    }
    public static void main(String[] args) {
        Banner banner = new ProxyBanner();
        banner.show();
        ArrayList<Student> students = new ArrayList();
        ArrayList<Course> courses = new ArrayList();
        ArrayList<StudentEnrollMent> studentEnrollMents = new ArrayList();
        creatingSample(students, courses);

        System.out.print("What is your name? ");
        Scanner readname = new Scanner(System.in);
        var name = readname.nextLine();
        System.out.println("Hello "+name);
        MyTask task = MyTask.getInstance();     //Singleton
        Thread t = new Thread(task);
        t.start();
        while (true){
            StudentEnrollMent ste = new StudentEnrollMent();
            Notifier notifier1 = new Notifier("Toan","s3652979@rmit.edu.vn");
            notifier1.follow(ste);
            Notifier notifier2 = new Notifier("Linh","s123456@rmit.edu.vn");
            notifier2.follow(ste);

//            String[] general_array = {"1-Enroll Courses", "2-Drop Course", "3-Update Course", "4-View Enrollments", "5-Exit"};
//            for (String ageneral_array : general_array){
//                System.out.println(ageneral_array);
//            }
            printMenu("Enroll Course","Drop Course","Update Course","View Enrollments", "Exit");    //Varargs Feature

            System.out.print("Choose your option:");
            Scanner scanner = new Scanner(System.in);
            var choice = scanner.nextInt();

            switch (choice) {
                case 1: {
                    studentEnrollMents = ste.enroll(studentEnrollMents, students, courses);
                    ste.view(studentEnrollMents);
                    break;
                }
                case 2: {
                    ste.view(studentEnrollMents);
                    studentEnrollMents = ste.withdraw(studentEnrollMents);
                    ste.view(studentEnrollMents);
                    break;
                }
                case 3: {
                    ste.view(studentEnrollMents);
                    studentEnrollMents = ste.edit(studentEnrollMents, students, courses);
                    ste.view(studentEnrollMents);
                    break;
                }
                case 4: {
                    ste.view(studentEnrollMents);
                    break;
                }
                case 5: {
                    Decorator newmessage = new NewMessage(new Message()); //Singleton
                    newmessage.himessage(name);
                    return;
                }

            }


        }


    }
}

