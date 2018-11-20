package jv.sadi.Adapter;

import java.util.ArrayList;

public class AdapterPrintCourses implements PrintEmrollments {
    private PrintCourses printCourses = new PrintCourses();
    @Override
    public void print(ArrayList a) {
        printCourses.print(a);
    }
}
