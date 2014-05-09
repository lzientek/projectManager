package FrontEnd;

import BackEnd.Project;
import BackEnd.StockageUser;
import DataBase.JdbcProjectDao;
import FrontEnd.PopUp.AjouterProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lucas on 08/05/2014.
 */


public class AppFrame extends JFrame {

    private JPanel contentPane;

    private List<Project> projects;

    /**
     * Create the frame.
     */
    public AppFrame() {
        setTitle("Projects");

        setUndecorated(true);
        setSize(getToolkit().getScreenSize());
        setLocationRelativeTo(null);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        projects = new JdbcProjectDao().loadProjects(StockageUser.user);

        menuBar();
        validate();
        setVisible(true);
        add(new ProjectJPanel(projects));
        revalidate();
    }

    private void menuBar() {
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mnAjouter = new JMenu("ajouter");
        menuBar.add(mnAjouter);

        JMenuItem mntmNouveauProjet = new JMenuItem("nouveau projet");
        mntmNouveauProjet.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                AjouterProject ajouterProject = new AjouterProject((Component) e.getSource());
            }
        });
        mnAjouter.add(mntmNouveauProjet);
    }

    public void setContentPane(JPanel contentPane) {
        this.contentPane = contentPane;
        setContentPane(contentPane);
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}

