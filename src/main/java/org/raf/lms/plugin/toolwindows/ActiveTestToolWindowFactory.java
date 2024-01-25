package org.raf.lms.plugin.toolwindows;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import org.jetbrains.annotations.NotNull;
import org.raf.lms.plugin.datamodel.CurrentTestSingleton;
import org.raf.lms.plugin.datamodel.StudentTestInfo;

import javax.swing.*;
import java.awt.*;

public class ActiveTestToolWindowFactory implements ToolWindowFactory {


    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        //ActiveTestToolWindowContent toolWindowContent = new ActiveTestToolWindowContent(toolWindow);
        Content content = ContentFactory.getInstance().createContent(new StudentInfoPanel(), "", false);
        toolWindow.getContentManager().addContent(content);
    }


}
