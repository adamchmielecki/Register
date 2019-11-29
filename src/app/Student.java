package app;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Student implements Serializable {

    String name;

    public static List<Student> students = new LinkedList<Student>();

    public Student(String name, String surname) {
        this.name = name + " " + surname;

    }

}
