package org.raf.lms.plugin.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;
import org.raf.lms.plugin.dialogs.TestRegistrationDialog;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class StartTestAction  extends AnAction {

    private boolean enabled = true;

    public void update (AnActionEvent e) {
        e.getPresentation().setEnabled(enabled);
        /* postaviti sliku sa disabled dugme
        if(!enabled) {
            e.getPresentation().setIcon(new ImageIcon(getClass().getResource("/resources/icons/raflmsstart-disabled.png")));
        }
        */

    }


    @Override
    public void actionPerformed(@NotNull AnActionEvent anActionEvent) {
        TestRegistrationDialog dialog = new TestRegistrationDialog();
        enabled = false;
        dialog.show();

    }

    // TODO disejblovati ovo dugme da ne moze ponovo da se pokrene
}
