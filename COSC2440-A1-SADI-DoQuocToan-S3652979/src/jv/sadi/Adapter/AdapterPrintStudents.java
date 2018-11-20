package jv.sadi.Adapter;

import java.util.ArrayList;

public class AdapterPrintStudents implements PrintEmrollments {
    private PrintStudents printStudents = new PrintStudents();

    @Override
    public void print(ArrayList s) {
        printStudents.print(s);
    }
}
