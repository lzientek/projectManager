package FrontEnd;

import BackEnd.Project;
import BackEnd.StockageUser;
import DataBase.JdbcProjectDao;
import FrontEnd.PopUp.AjouterProject;
import FrontEnd.PopUp.AjouterTask;
import FrontEnd.innerPage.FullPage;
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
    private FullPage contenu;
    private JMenuItem mntmNouveauTask;

    public void setOnProject(Boolean b) {
        mntmNouveauTask.setEnabled(b);
        mntmNouveauTask.revalidate();
        revalidate();
    }

    /**
     * Create the frame.
     */
    public AppFrame() {
        setTitle("Projects");

        setUndecorated(true);
        setBounds(100, 100, 800, 500);
        setLocationRelativeTo(null);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        reloadProjects();

        menuBar();

        validate();
        setVisible(true);
        setContent(new ProjectJPanel(projects, this));
        revalidate();
    }

    public void reloadProjects() {
        projects = new JdbcProjectDao().loadProjects(StockageUser.user);
    }


    private void menuBar() {
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        final AppFrame af = this;
        JMenu mnAjouter = new JMenu("ajouter");
        menuBar.add(mnAjouter);

        JMenuItem mntmNouveauProjet = new JMenuItem("nouveau projet");
        mntmNouveauProjet.setEnabled(StockageUser.user.getIsManager());
        mntmNouveauProjet.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                AjouterProject ajouterProject = new AjouterProject(af);
            }
        });
        mnAjouter.add(mntmNouveauProjet);
        mntmNouveauTask = new JMenuItem("nouvelle task");
        mntmNouveauTask.setEnabled(true);
        mntmNouveauTask.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AjouterTask ajouterProject = new AjouterTask(af);
            }
        });
        mnAjouter.add(mntmNouveauTask);
    }

    public void setSelectedProject(Project selectedProject) {
        this.selectedProject = selectedProject;
    }

    public void setContent(FullPage contentPane) {
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

    public Project getProject() {
        return selectedProject;
    }

    public void reload() {
        contenu.reloadInterface();
    }
}

