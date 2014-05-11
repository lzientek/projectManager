package FrontEnd.innerPage;

import BackEnd.Project;
import FrontEnd.AppFrame;
import FrontEnd.Controls.ProjectControl;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

/**
 * Created by lucas on 08/05/2014.
 */
public class ProjectJPanel extends JPanel {

    private final JPanel projectsPanel;
    private AppFrame appFrame;

    public ProjectJPanel(java.util.List<Project> projects, AppFrame app) {
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(new BorderLayout(5, 5));
        appFrame = app;
        //JLabel lblProjects = new JLabel("Projects");
        //add(lblProjects, BorderLayout.NORTH);

        projectsPanel = new JPanel();

        projectsPanel.setLayout(new BoxLayout(projectsPanel, BoxLayout.Y_AXIS));

        setProjectList(projects);

        JScrollPane scrollPane = new JScrollPane(projectsPanel,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        add(scrollPane, BorderLayout.CENTER);
        appFrame.getContentPane().revalidate();
    }

    public void setProjectList(List<Project> projects) {
        for (int i = 0; i < projects.size(); i++) {
            projectsPanel.add(new ProjectControl(projects.get(i), appFrame));
            projectsPanel.add(Box.createVerticalStrut(10));//marge e pixel
        }
    }

    public void addToProjectList(Project project) {

        projectsPanel.add(new ProjectControl(project, appFrame));
    }
}
