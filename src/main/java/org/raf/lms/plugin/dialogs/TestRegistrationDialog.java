package org.raf.lms.plugin.dialogs;

import com.intellij.openapi.project.ProjectManager;
import com.intellij.openapi.ui.ComboBox;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowManager;
import com.intellij.ui.content.Content;
import org.jetbrains.annotations.Nullable;
import org.raf.lms.plugin.backendcalls.GitServerCalls;
import org.raf.lms.plugin.datamodel.CurrentTestSingleton;
import org.raf.lms.plugin.datamodel.StudentTestInfo;
import org.raf.lms.plugin.inteillijcalls.LMSProjectManagement;
import org.raf.lms.plugin.toolwindows.StudentInfoPanel;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class TestRegistrationDialog extends DialogWrapper {

    private JTextField imeStudentaTf = new JTextField();
    private JTextField prezimeStudentaTf = new JTextField();
    private JTextField brojIndeksTf = new JTextField();
    private JTextField studProgramIndeksTf = new JTextField();
    private JTextField godinaUpisaIndeksTf = new JTextField();
    private ComboBox<String> studijskaGrupaCb = new ComboBox<>();
    private ComboBox<String> grupaZadatakaCb = new ComboBox<>();

    private class StartTestAction extends DialogWrapperAction {
        protected StartTestAction() {
            super("Započni");
            putValue(Action.NAME, "StartTest");
        }

        @Override
        protected void doAction(ActionEvent e) {
            doStartTestAction();
        }

    }

    boolean isOkEnabled() {
        // return true if dialog can be closed
        return true;
    }


    public TestRegistrationDialog(){
        super(true);
        setTitle("Test registration");
        init();

    }
    @Override
    protected @Nullable JComponent createCenterPanel() {
        JPanel dialogPanel = new JPanel(new BorderLayout());
        JLabel label = new JLabel("Podaci o studentu");
        label.setPreferredSize(new Dimension(300, 300));
        GridLayout gl = new GridLayout(5,2);
        JPanel inputPanel = new JPanel(gl);
        studijskaGrupaCb.setModel(getComboBoxModelForStudijskaGrupa());
        inputPanel.add(new JLabel("Ime"));
        inputPanel.add(imeStudentaTf);
        inputPanel.add(new JLabel("Prezime"));
        inputPanel.add(prezimeStudentaTf);

        JPanel indeksPanel = new JPanel();
        indeksPanel.setLayout(new BoxLayout(indeksPanel,BoxLayout.LINE_AXIS));
        indeksPanel.add(studProgramIndeksTf);
        indeksPanel.add(brojIndeksTf);
        indeksPanel.add(godinaUpisaIndeksTf);
        inputPanel.add(new JLabel("Indeks"));
        inputPanel.add(indeksPanel);

        inputPanel.add(new JLabel("Studijska grupa"));
        inputPanel.add(studijskaGrupaCb);

        inputPanel.add(new JLabel("Grupa zadatka"));
        inputPanel.add(grupaZadatakaCb);

        dialogPanel.add(label, BorderLayout.NORTH);
        dialogPanel.add(inputPanel, BorderLayout.CENTER);
        return dialogPanel;
    }

    private void doStartTestAction(){
        String path = LMSProjectManagement.clearAndGetCurrentProjectPath();
        GitServerCalls.cloneLocalRepository(path);
        ProjectManager.getInstance().reloadProject(LMSProjectManagement.getProject());
        CurrentTestSingleton.getInstance().setStudentTestInfo(imeStudentaTf.getText(),
                prezimeStudentaTf.getText(),"26", studProgramIndeksTf.getText(),
                "2022","101","grupa1");
        ToolWindow toolWindow = ToolWindowManager.getInstance(LMSProjectManagement.getProject()).getToolWindow("ActiveTestWindow");
        Content[] contents =  toolWindow.getContentManager().getContents();
        for(Content c:contents){
            if(c.getComponent() instanceof StudentInfoPanel){
                ((StudentInfoPanel)c.getComponent()).refreshStudentInfo();
            }
        }

        this.close(0);
    }

    private ComboBoxModel<String> getComboBoxModelForStudijskaGrupa(){
        List<String> studijskeGrupe = new ArrayList<String>();
        studijskeGrupe.addAll(List.of("101","102","103"));  // TODO ovaj deo se preuzima preko API-ja

        ComboBoxModel<String> retVal = new ComboBoxModel<String>() {
            @Override
            public void setSelectedItem(Object anItem) {
            }

            @Override
            public Object getSelectedItem() {
                return null;
            }

            @Override
            public int getSize() {
                return studijskeGrupe.size();
            }

            @Override
            public String getElementAt(int index) {
                return studijskeGrupe.get(index);
            }

            @Override
            public void addListDataListener(ListDataListener l) {

            }

            @Override
            public void removeListDataListener(ListDataListener l) {
            }
        };
        return retVal;
    }


    @Override
    protected Action[] createActions() {
        super.createDefaultActions();
        return new Action[] {new StartTestAction(),getCancelAction() };
    }



}
