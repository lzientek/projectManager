package FrontEnd;

import BackEnd.Project;
import BackEnd.StockageUser;
import DataBase.JdbcProjectDao;

import javax.swing.*;
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


        validate();
        setVisible(true);
        add(new ProjectJPanel(projects));
        revalidate();
    }

    public void setContentPane(JPanel contentPane) {
        this.contentPane = contentPane;
        setContentPane(contentPane);
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}

