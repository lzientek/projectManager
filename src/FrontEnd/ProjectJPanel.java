package FrontEnd;

import BackEnd.Project;
import FrontEnd.Controls.ProjectControl;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.*;

/**
 * Created by lucas on 08/05/2014.
 */
public class ProjectJPanel extends JPanel {
    public ProjectJPanel(java.util.List<Project> projects) {
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(new BorderLayout(5, 5));

        JLabel lblProjects = new JLabel("Projects");
        add(lblProjects, BorderLayout.NORTH);

        JPanel projectsPanel = new JPanel();
        projectsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        for (int i = 0; i < projects.size(); i++) {
            projectsPanel.add(new ProjectControl(projects.get(i)));
        }

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.add(projectsPanel);
        add(scrollPane, BorderLayout.CENTER);
    }
}
