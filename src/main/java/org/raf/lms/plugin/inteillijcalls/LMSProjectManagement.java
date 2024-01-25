package org.raf.lms.plugin.inteillijcalls;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManager;

import java.io.File;

public class LMSProjectManagement {

    static private Project project;

    public static String clearAndGetCurrentProjectPath(){
        project = ProjectManager.getInstance().getOpenProjects()[0];
        File projectRoot = new File(project.getBasePath());
        deleteSubDirectoriesAndFiles(projectRoot);

        return project.getBasePath();
    }

    public static Project getProject(){
        return project;
    }

    private static void deleteSubDirectoriesAndFiles(File dir){
        File[] subFiles = dir.listFiles();
        for(File f:subFiles) {
            if (f.isDirectory()) {
                deleteSubDirectoriesAndFiles(f);
            }
            f.delete();

        }
    }
}
