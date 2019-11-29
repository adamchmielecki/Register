package app;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Subject implements Serializable {

    String subjectName;
    public List<Grade> grades = new LinkedList<Grade>();

    public static List<Subject> subjects = new LinkedList<Subject>();

    public Subject (String subjectName, List<Student> students) {
        this.subjectName = subjectName;
        for (int i=0; i<students.size(); i++) {
            Grade grade = new Grade();
            grades.add(grade);
        }
    }

    public static double averageStudentGrade(int student){
        double avg = 0;
        for (int i=0; i<subjects.size(); i++){
            avg += Grade.generateAverageGrade(subjects.get(i).grades.get(student).grades);
        }
        avg = avg/subjects.size();
        return avg;
    }

    public static String averageClassGrade(){
        double avg;
        double totalAvg = 0;
        String averageGrade = "";
        for (int s=0; s<subjects.size(); s++) {
            avg = 0;
            for (int i = 0; i < Student.students.size(); i++) {
                avg += Grade.generateAverageGrade(subjects.get(s).grades.get(i).grades);
            }
            avg = avg / Student.students.size();
            averageGrade = averageGrade + subjects.get(s).subjectName + ": " + avg + "\n";
            totalAvg += avg;
        }
        totalAvg = totalAvg / subjects.size();
        averageGrade = averageGrade + "\nŚrednia klasy: " + totalAvg;
        return averageGrade;
    }

}
