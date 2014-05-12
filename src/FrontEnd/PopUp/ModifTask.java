package FrontEnd.PopUp;

import BackEnd.ProjectTask;
import ConnectionServeur.NotifServeur;
import DataBase.JdbcProjectDao;
import FrontEnd.Controls.FormulaireTask;
import FrontEnd.Controls.TaskControl;
import FrontEnd.Controls.TitleLabel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by lucas on 09/05/2014.
 */
public class ModifTask extends JFrame {

    private FormulaireTask formulaireProject;
    private ProjectTask task;
    private Component FenetreMere;

    public ModifTask(final ProjectTask task, final TaskControl FenetreMere) {

        this.task = task;
        this.FenetreMere = FenetreMere;
        setTitle("Modifier la task " + task.getName());
        setMinimumSize(new Dimension(550, 450));
        setBounds(100, 100, 550, 300);
        JPanel panel = new JPanel();
        setContentPane(panel);
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));


        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        getContentPane().setLayout(new BorderLayout(5, 5));
        getContentPane().add(new TitleLabel("Modifier le projet " + task.getName()), BorderLayout.NORTH);
        formulaireProject = new FormulaireTask(
                new ProjectTask(task.getName(), task.getDescription(), task.getId(), task.getProject(),
                        task.getBeginDate(), task.getEndDate(),
                        task.getEmployeesWorkingOnItJoin().split("-"), task.getTaskAuthor())
        );
        getContentPane().add(formulaireProject, BorderLayout.CENTER);

        JButton btnSave = new JButton("sauvegarder");
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProjectTask t = formulaireProject.getProject();
                task.setName(t.getName());
                task.setTaskAuthor(t.getTaskAuthor());
                task.setDescription(t.getDescription());
                task.setBeginDate(t.getBeginDate());
                task.setEndDate(t.getEndDate());
                task.setEmployeesWorkingOnIt(t.getEmployeesWorkingOnIt());

                if (!new JdbcProjectDao().updateProjectTask(task))
                    JOptionPane.showMessageDialog((Component) e.getSource(), "Erreur d'enregistrement en base de donnée.");
                if (NotifServeur.isOnline)
                    NotifServeur.getNotifServeur().emission("mt"); //on notifie le serveur

                FenetreMere.updateValues();
                FenetreMere.getAppFrame().reload();

                dispose();
            }
        });
        getContentPane().add(btnSave, BorderLayout.SOUTH);

        validate();
        setVisible(true);
    }
}
