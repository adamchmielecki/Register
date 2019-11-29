package app;

import java.io.*;
import java.util.List;

public class Data implements Serializable {

    public static void loadData() {
        try {
            ObjectInputStream in1 = new ObjectInputStream(new FileInputStream("subjects.dat"));
            Subject.subjects = (List<Subject>) in1.readObject();
            in1.close();
            ObjectInputStream in2 = new ObjectInputStream(new FileInputStream("students.dat"));
            Student.students = (List<Student>) in2.readObject();
            in2.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void saveData() {
        try {
            ObjectOutputStream out1 = new ObjectOutputStream(new FileOutputStream("subjects.dat"));
            out1.writeObject(Subject.subjects);
            out1.close();
            ObjectOutputStream out2 = new ObjectOutputStream(new FileOutputStream("students.dat"));
            out2.writeObject(Student.students);
            out2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
