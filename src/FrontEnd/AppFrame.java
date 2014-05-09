package FrontEnd;

import BackEnd.Project;
import BackEnd.StockageUser;
import DataBase.JdbcProjectDao;
import FrontEnd.PopUp.AjouterProject;
import FrontEnd.innerPage.ProjectJPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by lucas on 08/05/2014.
 */


public class AppFrame extends JFrame {


    private List<Project> projects;
    private Project selectedProject;
    private JPanel contenu;

    /**
     * Create the frame.
     */
    public AppFrame() {
        setTitle("Projects");

        setUndecorated(true);
        setSize(getToolkit().getScreenSize());
        setLocationRelativeTo(null);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        reloadProjects();

        menuBar();

        validate();
        setVisible(true);
        setContent(new ProjectJPanel(projects, this));
        revalidate();
    }

    private void reloadProjects() {
        projects = new JdbcProjectDao().loadProjects(StockageUser.user);
    }

    private void menuBar() {
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        final AppFrame af = this;
        JMenu mnAjouter = new JMenu("ajouter");
        menuBar.add(mnAjouter);

        JMenuItem mntmNouveauProjet = new JMenuItem("nouveau projet");
        mntmNouveauProjet.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                AjouterProject ajouterProject = new AjouterProject(af);

            }
        });
        mnAjouter.add(mntmNouveauProjet);
    }

    public void setSelectedProject(Project selectedProject) {
        this.selectedProject = selectedProject;
    }

    public void setContent(JPanel contentPane) {
        contenu = contentPane;
        getContentPane().removeAll();
        getContentPane().add(contenu);
    }

    public JPanel getContenu() {
        return contenu;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public Project getSelectedProject() {
        return selectedProject;
    }
}

