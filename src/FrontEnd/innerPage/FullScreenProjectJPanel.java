package FrontEnd.innerPage;

import FrontEnd.AppFrame;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        projectsPanel = new JPanel();
        projectsPanel.setLayout(new FlowLayout(FlowLayout.LEADING));

        JLabel lblProjects = new JLabel(appFrame.getSelectedProject().getName());
        projectsPanel.add(lblProjects);

        JButton buttonRetour = new JButton("Retour au projets");
        buttonRetour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                appFrame.setContent(new ProjectJPanel(appFrame.getProjects(), appFrame));
            }
        });
        projectsPanel.add(buttonRetour);
        add(projectsPanel);
        setVisible(true);
        //important pour actualiser l'interface
        revalidate();
        appFrame.getContentPane().revalidate();
    }
}
