package app;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

public class newSubject implements Serializable {
    private JTextField textField1;
    private JButton addSubject;
    public JPanel subjectsPanel;

    public newSubject() {
        addSubject.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Subject subject = new Subject(textField1.getText(), Student.students);
                Subject.subjects.add(subject);
                Data.saveData();
                JOptionPane.showMessageDialog(null,"Dodano przedmiot: "+subject.subjectName);
                textField1.setText("");
            }
        });
    }
}
