package FrontEnd.PopUp;

import BackEnd.Project;
import BackEnd.ProjectTask;
import BackEnd.StockageUser;
import DataBase.JdbcProjectDao;
import FrontEnd.AppFrame;
import FrontEnd.Controls.FormulaireProject;
import FrontEnd.Controls.FormulaireTask;
import FrontEnd.Controls.TitleLabel;
import FrontEnd.innerPage.FullScreenProjectJPanel;
import FrontEnd.innerPage.ProjectJPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * Created by lucas on 09/05/2014.
 */
public class AjouterTask extends JFrame {

    private FormulaireTask formulaireTask;
    private final AppFrame FenetreMere;
    private final Project project;

    public AjouterTask(AppFrame fenetreMere) {
        FenetreMere = fenetreMere;
        this.project = fenetreMere.getSelectedProject();
        setTitle("Nouvelle task");
        setMinimumSize(new Dimension(550, 350));
        setBounds(100, 100, 550, 300);
        JPanel panel = new JPanel();
        setContentPane(panel);
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        getContentPane().setLayout(new BorderLayout(5, 5));

        getContentPane().add(new TitleLabel("Creation d'une task: "), BorderLayout.NORTH);
        formulaireTask = new FormulaireTask(
                new ProjectTask("Nom de la task", "Description", 0, project, new Date(), new Date(),
                        new String[]{String.valueOf(StockageUser.user.getId())},
                        StockageUser.user)
        );
        getContentPane().add(formulaireTask, BorderLayout.CENTER);


        final JButton btnSave = new JButton("enregistrer");
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProjectTask t = formulaireTask.getProject();
                if (new JdbcProjectDao().createProjectTask(t)) {
                    project.getProjectTasks().add(t);
                    //TODO: bug a voir

                    dispose();
                } else
                    JOptionPane.showMessageDialog((Component) e.getSource(), "Erreur d'enregistrement en BDD.");

                //todo reload la page et ajouter la requete au serveur
            }
        });
        getContentPane().add(btnSave, BorderLayout.SOUTH);

        validate();
        setVisible(true);
    }
}
