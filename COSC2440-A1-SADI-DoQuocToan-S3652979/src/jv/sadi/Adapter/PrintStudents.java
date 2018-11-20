package jv.sadi.Adapter;

import jv.sadi.Student;

import java.util.ArrayList;
import java.util.Iterator;

public class PrintStudents implements PrintEmrollments {
    @Override
    public void print(ArrayList s) {
        var id = 0;

        Iterator st = s.iterator();
        while (st.hasNext()) {
            Object obj = st.next();
            if (obj instanceof Student) {
                id++;
                Student stprint = (Student) obj;
                System.out.println("ID:" + id + "||" + " Name:" + stprint.getName() +" "+stprint.getId()+" "+stprint.getDob());
            }
        }
    }
}
