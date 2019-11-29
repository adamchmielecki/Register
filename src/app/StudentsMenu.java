package app;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

public class StudentsMenu implements Serializable {
    public JPanel studentsPanel;
    private JTabbedPane tabbedPane1;
    private JTextField textField1;
    private JTextField textField2;
    private JButton click;
    private JComboBox studentsBox;
    private JButton deleteStudent;

    public StudentsMenu() {
        String[] students = new String[Student.students.size()];
        for (int i=0; i<Student.students.size(); i++) {
            students[i] = Student.students.get(i).name;
        }
        DefaultComboBoxModel studentsModel = new DefaultComboBoxModel(students);
        studentsBox.setModel(studentsModel);

        click.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Student student = new Student(textField1.getText(), textField2.getText());
                Student.students.add(student);
                for (int i=0; i<Subject.subjects.size(); i++){
                    Grade grade = new Grade();
                    Subject.subjects.get(i).grades.add(grade);
                }
                Data.saveData();
                JOptionPane.showMessageDialog(null,"Pomyślnie dodano nowego ucznia: "+student.name);
                textField1.setText("");
                textField2.setText("");
                String[] actualizeStudents = new String[Student.students.size()];
                for (int i=0; i<Student.students.size(); i++) {
                    actualizeStudents[i] = Student.students.get(i).name;
                }
                DefaultComboBoxModel studentsModel = new DefaultComboBoxModel(actualizeStudents);
                studentsBox.setModel(studentsModel);
            }
        });

        deleteStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Student.students.remove(studentsBox.getSelectedIndex());
                for (int i=0; i<Subject.subjects.size(); i++){
                    Subject.subjects.get(i).grades.remove(studentsBox.getSelectedIndex());
                }
                Data.saveData();
                JOptionPane.showMessageDialog(null,"Usunięto ucznia "+studentsBox.getSelectedItem());
                String[] actualizeStudents = new String[Student.students.size()];
                for (int i=0; i<Student.students.size(); i++) {
                    actualizeStudents[i] = Student.students.get(i).name;
                }
                DefaultComboBoxModel studentsModel = new DefaultComboBoxModel(actualizeStudents);
                studentsBox.setModel(studentsModel);
            }
        });
    }

    private void createUIComponents() {
        studentsBox = new JComboBox();
    }
}
