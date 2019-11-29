package app;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

public class GradesMenu implements Serializable {
    public JPanel panel1;
    private JTabbedPane tabbedPane1;
    private JComboBox subject;
    private JComboBox student;
    private JComboBox grade;
    private JButton addGrade;
    public JComboBox subjectName;
    public JComboBox studentName;
    private JList<Double> grades;
    private JButton deleteGrade;
    private JButton showGrades;
    private JComboBox newGrade;
    private JButton changeGrade;
    private JList gradesToChange;
    private JComboBox subName;
    private JComboBox studName;
    private JButton showGradesToChange;
    private JButton generate;
    private JComboBox sN;
    private JLabel averageGrade;
    private JButton generateAvg;
    private JTextArea classAverageGrade;

    public GradesMenu() {
        String[] subjects = new String[Subject.subjects.size()];
        for (int i=0; i<Subject.subjects.size(); i++) {
            subjects[i] = Subject.subjects.get(i).subjectName;
        }
        DefaultComboBoxModel model = new DefaultComboBoxModel(subjects);
        subject.setModel(model);
        subjectName.setModel(model);
        subName.setModel(model);

        String[] students = new String[Student.students.size()];
        for (int i=0; i<Student.students.size(); i++) {
            students[i] = Student.students.get(i).name;
        }
        DefaultComboBoxModel studentModel = new DefaultComboBoxModel(students);
        studentName.setModel(studentModel);
        student.setModel(studentModel);
        studName.setModel(studentModel);
        sN.setModel(studentModel);

        addGrade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Subject.subjects.get(subject.getSelectedIndex()).grades.get(student.getSelectedIndex()).grades.addElement(Double.parseDouble((String) grade.getSelectedItem()));
                Data.saveData();
                JOptionPane.showMessageDialog(null,"Pomyślnie dodano ocenę.");
            }
        });


        showGrades.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                grades.setModel(Subject.subjects.get(subjectName.getSelectedIndex()).grades.get(studentName.getSelectedIndex()).grades);
            }
        });

        deleteGrade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Subject.subjects.get(subjectName.getSelectedIndex()).grades.get(studentName.getSelectedIndex()).grades.remove(grades.getSelectedIndex());
                Data.saveData();
                JOptionPane.showMessageDialog(null,"Usunięto wybraną ocenę.");
            }
        });
        showGradesToChange.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gradesToChange.setModel(Subject.subjects.get(subName.getSelectedIndex()).grades.get(studName.getSelectedIndex()).grades);
            }
        });
        changeGrade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Subject.subjects.get(subName.getSelectedIndex()).grades.get(studName.getSelectedIndex()).grades.set(gradesToChange.getSelectedIndex(),Double.parseDouble((String)newGrade.getSelectedItem()));
                Data.saveData();
                JOptionPane.showMessageDialog(null,"Poprawiono wybraną ocenę.");
            }
        });

        generate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                averageGrade.setText(Double.toString(Subject.averageStudentGrade(sN.getSelectedIndex())));
            }
        });

        generateAvg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                classAverageGrade.append(Subject.averageClassGrade());
            }
        });
    }

    public void createUIComponents() {
        subject = new JComboBox();
        student = new JComboBox();
        subjectName = new JComboBox();
        studentName = new JComboBox();
        subName = new JComboBox();
        studName = new JComboBox();
        sN = new JComboBox();
        grades = new JList<>();
        gradesToChange = new JList<>();
        averageGrade = new JLabel();
        classAverageGrade = new JTextArea();
    }
}
