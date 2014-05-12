package FrontEnd.ActionListeners;

import BackEnd.Project;
import FrontEnd.AppFrame;
import FrontEnd.innerPage.FullScreenProjectJPanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by lucas on 09/05/2014.
 */
public class ProjectMouseClick extends MouseAdapter {

    private AppFrame appFrame;
    private Project project;

    public ProjectMouseClick(AppFrame appFrame, Project p) {
        this.appFrame = appFrame;
        project = p;
    }

    public void mouseClicked(MouseEvent arg0) {
        appFrame.setOnProject(true);
        appFrame.setSelectedProject(project);
        appFrame.setContent(new FullScreenProjectJPanel(appFrame));
    }

}
