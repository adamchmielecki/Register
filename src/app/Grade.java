package app;

import javax.swing.*;
import java.io.Serializable;

public class Grade implements Serializable {

    DefaultListModel<Double> grades;

    public Grade (){
        grades = new DefaultListModel<>();
    }

    public static double generateAverageGrade(DefaultListModel<Double> grades){
        double avg=0;
        for (int i=0; i<grades.size(); i++){
            avg += grades.get(i);
        }
        avg = avg/grades.size();
        return avg;
    }
}
