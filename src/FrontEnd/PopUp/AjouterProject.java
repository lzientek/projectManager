package FrontEnd.PopUp;

import BackEnd.Project;
import BackEnd.StockageUser;
import ConnectionServeur.NotifServeur;
import DataBase.JdbcProjectDao;
import FrontEnd.AppFrame;
import FrontEnd.Controls.FormulaireProject;
import FrontEnd.Controls.TitleLabel;
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
public class AjouterProject extends JFrame {
    private FormulaireProject formulaireProject;
    private final AppFrame FenetreMere;

    public AjouterProject(AppFrame fenetreMere) {
        FenetreMere = fenetreMere;
        setTitle("Nouveau Projet");
        setMinimumSize(new Dimension(550, 450));
        setBounds(100, 100, 550, 300);
        JPanel panel = new JPanel();
        setContentPane(panel);
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        getContentPane().setLayout(new BorderLayout(5, 5));
        getContentPane().add(new TitleLabel("Creation d'un nouveau projet: "), BorderLayout.NORTH);
        formulaireProject = new FormulaireProject(
                new Project("Nom du projet",
                        new String[]{String.valueOf(StockageUser.user.getId())},
                        0, 0,
                        StockageUser.user,
                        new Date(), new Date(),
                        "Description")
        );
        getContentPane().add(formulaireProject, BorderLayout.CENTER);

        final JButton btnSave = new JButton("enregistrer");
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Project p = formulaireProject.getProject();
                if (new JdbcProjectDao().createAProject(p)) {
                    FenetreMere.getProjects().add(p);
                    NotifServeur.getNotifServeur().emission("np"); //on notifie le serveur
                    ProjectJPanel contenu = (ProjectJPanel) FenetreMere.getContenu();
                    contenu.addToProjectList(p);
                    dispose();
                }
                else
                    JOptionPane.showMessageDialog((Component) e.getSource(), "Erreur d'enregistrement en BDD.");

                //todo reload la page et ajouter la requete au serveur
            }
        });
        getContentPane().add(btnSave, BorderLayout.SOUTH);

        validate();
        setVisible(true);
    }
}
