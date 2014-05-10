package FrontEnd.PopUp;

import BackEnd.Project;
import DataBase.JdbcProjectDao;
import FrontEnd.Controls.FormulaireProject;
import FrontEnd.Controls.ProjectControl;
import FrontEnd.Controls.TitleLabel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by lucas on 09/05/2014.
 */
public class ModifProject extends JFrame {

    private FormulaireProject formulaireProject;
    private Project project;
    private Component FenetreMere;

    public ModifProject(final Project project, final ProjectControl FenetreMere) {

        this.project = project;
        this.FenetreMere = FenetreMere;
        setTitle("Modifier le projet " + project.getName());
        setMinimumSize(new Dimension(550, 350));
        setBounds(100, 100, 550, 300);
        JPanel panel = new JPanel();
        setContentPane(panel);
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));


        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        getContentPane().setLayout(new BorderLayout(5, 5));
        getContentPane().add(new TitleLabel("Modifier le projet " + project.getName()), BorderLayout.NORTH);
        formulaireProject = new FormulaireProject(new Project(project.getName(),
                project.getEmployeesWorkingOnItJoin().split("-"),
                project.getProjectAdvancement(),
                project.getId(),
                project.getAuthor(),
                project.getBeginDate(),
                project.getEndDate(),
                project.getDescription()));
        getContentPane().add(formulaireProject, BorderLayout.CENTER);

        JButton btnSave = new JButton("sauvegarder");
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Project p = formulaireProject.getProject();
                project.setName(p.getName());
                project.setAuthor(p.getAuthor());
                project.setDescription(p.getDescription());
                project.setBeginDate(p.getBeginDate());
                project.setEndDate(p.getEndDate());
                project.setEmployeesWorkingOnIt(p.getEmployeesWorkingOnIt());

                if (!new JdbcProjectDao().updateAProject(project))
                    JOptionPane.showMessageDialog((Component) e.getSource(), "Erreur d'enregistrement en base de donnée.");

                FenetreMere.updateValues();

                dispose();
            }
        });
        getContentPane().add(btnSave, BorderLayout.SOUTH);

        validate();
        setVisible(true);
    }
}
