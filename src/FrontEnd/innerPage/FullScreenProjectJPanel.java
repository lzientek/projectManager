package FrontEnd.innerPage;

import FrontEnd.AppFrame;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Created by lucas on 09/05/2014.
 */
public class FullScreenProjectJPanel extends JPanel {


    private final AppFrame appFrame;
    private final JPanel projectsPanel;

    public FullScreenProjectJPanel(AppFrame app) {
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(new BorderLayout(5, 5));
        appFrame = app;
        JLabel lblProjects = new JLabel(appFrame.getSelectedProject().getName());
        add(lblProjects, BorderLayout.NORTH);

        projectsPanel = new JPanel();
        projectsPanel.setLayout(new FlowLayout(FlowLayout.LEADING));

    }
}
