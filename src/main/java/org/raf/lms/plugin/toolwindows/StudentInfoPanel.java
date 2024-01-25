package org.raf.lms.plugin.toolwindows;

import org.raf.lms.plugin.datamodel.CurrentTestSingleton;
import org.raf.lms.plugin.datamodel.StudentTestInfo;

import javax.swing.*;
import java.awt.*;

public class StudentInfoPanel extends JPanel {

    private JLabel imeLabel = new JLabel();
    private JLabel prezimeLabel = new JLabel();
    private JLabel indeksLabel = new JLabel();
    private JLabel studijskaGrupaLabel = new JLabel();
    private JLabel grupaZadatakaLabel = new JLabel();
    private JButton predajBtn = new JButton();


    public StudentInfoPanel() {
        super();
        refreshStudentInfo();
        GridLayout layout = new GridLayout(6,2);
        this.setLayout(layout);
        layout.setHgap(0);
        layout.setVgap(0);


        this.add(new JLabel("<html><b>Ime</b></html>: "));
        this.add(imeLabel);
        this.add(new JLabel("<html><b>Prezime</b></html>:"));
        this.add(prezimeLabel);
        this.add(new JLabel("<html><b>Indeks</b></html>:"));
        this.add(indeksLabel);
        this.add(new JLabel("<html><b>Studijska grupa</b></html>:"));
        this.add(studijskaGrupaLabel);
        this.add(new JLabel("<html><b>Grupa zadataka</b></html>:"));
        this.add(grupaZadatakaLabel);
        predajBtn.setText("Pošalji rad");
        this.add(predajBtn);




    }

    public void refreshStudentInfo(){
        StudentTestInfo studentInfo = CurrentTestSingleton.getInstance().getStudentTestInfo();
        if(studentInfo!=null) {
            if (studentInfo.getIme() != null) {
                imeLabel.setText(studentInfo.getIme());
            }
            if(studentInfo.getPrezime()!=null)
                prezimeLabel.setText(studentInfo.getPrezime());
            indeksLabel.setText(studentInfo.getIndeks());
            studijskaGrupaLabel.setText(studentInfo.getStudijskaGrupa());
            grupaZadatakaLabel.setText(studentInfo.getGrupaZadataka());
        }
        super.repaint();


    }
}
