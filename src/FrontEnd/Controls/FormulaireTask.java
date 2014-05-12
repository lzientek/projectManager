package FrontEnd.Controls;

import BackEnd.Project;
import BackEnd.ProjectTask;
import BackEnd.User;
import DataBase.JdbcProjectDao;
import FrontEnd.ActionListeners.DeleteUserlistener;
import FrontEnd.PopUp.AjouterUser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by lucas on 08/05/2014.
 */
public class FormulaireTask extends JPanel implements FormulaireAvecDesUsers {
    private final SimpleDateFormat dateFormatter;
    private JTextField textField_name;
    private JTextArea textArea;
    private JTextField textField_DateDebut_Jour;
    private JTextField textField_DateDebut_Mois;
    private JTextField textField_DateDebut_Annee;
    private JTextField textField_DateFin_Jour;
    private JTextField textField_DateFin_Mois;
    private JTextField textField_DateFin_Annee;
    private JPanel panel_employee;
    private ProjectTask task;


    public FormulaireTask(ProjectTask task) {


        dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat dayformatter = new SimpleDateFormat("dd");
        SimpleDateFormat moisformatter = new SimpleDateFormat("MM");
        SimpleDateFormat anneeformatter = new SimpleDateFormat("yyyy");

        this.task = task;
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0, 300, 0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);
        //affcihage----------
        JLabel lblNom = new JLabel("Nom : ");


        textField_name = new JTextField(task.getName());
        textArea = new JTextArea(task.getDescription());
        textField_DateDebut_Jour = new JTextField(dayformatter.format(task.getBeginDate()));
        textField_DateDebut_Mois = new JTextField(moisformatter.format(task.getBeginDate()));
        textField_DateDebut_Annee = new JTextField(anneeformatter.format(task.getBeginDate()));
        textField_DateFin_Jour = new JTextField(dayformatter.format(task.getEndDate()));
        textField_DateFin_Mois = new JTextField(moisformatter.format(task.getEndDate()));
        textField_DateFin_Annee = new JTextField(anneeformatter.format(task.getEndDate()));

        panel_employee = new JPanel();
        loadUsers();


        GridBagConstraints gbc_textField = new GridBagConstraints();
        gbc_textField.insets = new Insets(0, 0, 5, 5);
        gbc_textField.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField.gridx = 2;
        gbc_textField.gridy = 1;
        add(textField_name, gbc_textField);
        textField_name.setColumns(10);

        JLabel lblDescription = new JLabel("Description :");
        GridBagConstraints gbc_lblDescription = new GridBagConstraints();
        gbc_lblDescription.anchor = GridBagConstraints.EAST;
        gbc_lblDescription.insets = new Insets(0, 0, 5, 5);
        gbc_lblDescription.gridx = 1;
        gbc_lblDescription.gridy = 2;
        add(lblDescription, gbc_lblDescription);


        textArea.setRows(2);
        GridBagConstraints gbc_textArea = new GridBagConstraints();
        gbc_textArea.insets = new Insets(0, 0, 5, 5);
        gbc_textArea.fill = GridBagConstraints.BOTH;
        gbc_textArea.gridx = 2;
        gbc_textArea.gridy = 2;
        add(textArea, gbc_textArea);

        JLabel lblDateDebut = new JLabel("date debut :");
        GridBagConstraints gbc_lblDateDebut = new GridBagConstraints();
        gbc_lblDateDebut.anchor = GridBagConstraints.EAST;
        gbc_lblDateDebut.insets = new Insets(0, 0, 5, 5);
        gbc_lblDateDebut.gridx = 1;
        gbc_lblDateDebut.gridy = 3;
        add(lblDateDebut, gbc_lblDateDebut);

        JPanel panel_dateDebut = new JPanel();
        GridBagConstraints gbc_panel = new GridBagConstraints();
        gbc_panel.insets = new Insets(0, 0, 5, 5);
        gbc_panel.fill = GridBagConstraints.BOTH;
        gbc_panel.gridx = 2;
        gbc_panel.gridy = 3;
        add(panel_dateDebut, gbc_panel);

        panel_dateDebut.add(textField_DateDebut_Jour);
        textField_DateDebut_Jour.setColumns(2);

        panel_dateDebut.add(textField_DateDebut_Mois);
        textField_DateDebut_Mois.setColumns(2);

        panel_dateDebut.add(textField_DateDebut_Annee);
        textField_DateDebut_Annee.setColumns(4);

        JLabel lblDateFin = new JLabel("date fin :");
        GridBagConstraints gbc_lblDateFin = new GridBagConstraints();
        gbc_lblDateFin.anchor = GridBagConstraints.EAST;
        gbc_lblDateFin.insets = new Insets(0, 0, 5, 5);
        gbc_lblDateFin.gridx = 1;
        gbc_lblDateFin.gridy = 4;
        add(lblDateFin, gbc_lblDateFin);

        JPanel panel_DateDebut = new JPanel();
        GridBagConstraints gbc_panel_1 = new GridBagConstraints();
        gbc_panel_1.insets = new Insets(0, 0, 5, 5);
        gbc_panel_1.fill = GridBagConstraints.BOTH;
        gbc_panel_1.gridx = 2;
        gbc_panel_1.gridy = 4;
        add(panel_DateDebut, gbc_panel_1);

        textField_DateFin_Jour.setColumns(2);
        panel_DateDebut.add(textField_DateFin_Jour);

        textField_DateFin_Mois.setColumns(2);
        panel_DateDebut.add(textField_DateFin_Mois);

        textField_DateFin_Annee.setColumns(4);
        panel_DateDebut.add(textField_DateFin_Annee);

        JLabel lblEmploySurLe = new JLabel("employ\u00E9 sur le projet:");
        GridBagConstraints gbc_lblEmploySurLe = new GridBagConstraints();
        gbc_lblEmploySurLe.anchor = GridBagConstraints.EAST;
        gbc_lblEmploySurLe.insets = new Insets(0, 0, 0, 5);
        gbc_lblEmploySurLe.gridx = 1;
        gbc_lblEmploySurLe.gridy = 5;
        add(lblEmploySurLe, gbc_lblEmploySurLe);
        panel_employee.setSize(new Dimension(400, 1));
        WrapLayout mgr = new WrapLayout(WrapLayout.LEADING, 5, 5);

        panel_employee.setLayout(mgr);

        JScrollPane scrollBar = new JScrollPane(panel_employee,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        GridBagConstraints gbc_panel_employee = new GridBagConstraints();
        gbc_panel_employee.fill = GridBagConstraints.VERTICAL;
        gbc_panel_employee.insets = new Insets(0, 0, 0, 5);
        gbc_panel_employee.gridx = 2;
        gbc_panel_employee.gridy = 5;
        add(scrollBar, gbc_panel_employee);


        GridBagConstraints gbc_lblNom = new GridBagConstraints();
        gbc_lblNom.anchor = GridBagConstraints.EAST;
        gbc_lblNom.insets = new Insets(0, 0, 5, 5);
        gbc_lblNom.gridx = 1;
        gbc_lblNom.gridy = 1;
        add(lblNom, gbc_lblNom);

        //fin affichage

        validate();
    }

    public void loadUsers() {

        final FormulaireTask ft = this;


        panel_employee.removeAll();
        for (int i = 0; i < task.getEmployeesWorkingOnIt().size(); i++) {

            UserDeleteControl userDeleteControl = new UserDeleteControl(
                    task.getEmployeesWorkingOnIt().get(i),
                    new DeleteUserlistener(
                            task.getEmployeesWorkingOnIt().get(i),
                            task.getEmployeesWorkingOnIt(), ft)
            );
            panel_employee.add(
                    userDeleteControl
            );
        }
        revalidate();


        JButton btnInvite = new JButton("invite");
        btnInvite.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                java.util.List<User> employeesWorkingOnIt = task.getProject().getEmployeesWorkingOnIt();
                for (int i = employeesWorkingOnIt.size() - 1; i >= 0; i--)
                    for (int j = 0; j < task.getEmployeesWorkingOnIt().size(); j++) {
                        if (task.getEmployeesWorkingOnIt().get(j).getId() ==
                                task.getProject().getEmployeesWorkingOnIt().get(i).getId())
                            employeesWorkingOnIt.remove(i);
                    }
                if (employeesWorkingOnIt.size() > 0) {
                    final AjouterUser ajouterUser = new AjouterUser(employeesWorkingOnIt, false);
                    ajouterUser.setLocationRelativeTo(ft);
                    //on recupere le close de la fenetre pour metre a jour
                    ajouterUser.getBtnEnregistrer().addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            task.getEmployeesWorkingOnIt().add(ajouterUser.getSelectedItem());
                            ft.loadUsers();
                            ajouterUser.dispose();
                        }
                    });
                } else
                    JOptionPane.showMessageDialog((Component) e.getSource(), "Tout les utilisateurs possible ajouter!");

            }
        });
        panel_employee.add(btnInvite);
        if (this.isValid())
            JOptionPane.showMessageDialog(this, "Erreur d'enregistrement en base de donnée.");

    }

    public ProjectTask getProject() {
        task.setName(textField_name.getText());
        task.setDescription(textArea.getText());

        try {
            task.setBeginDate(dateFormatter.parse(textField_DateDebut_Jour.getText() + "/" +
                    textField_DateDebut_Mois.getText() + "/" +
                    textField_DateDebut_Annee.getText()));
            task.setEndDate(dateFormatter.parse(textField_DateFin_Jour.getText() + "/" +
                    textField_DateFin_Mois.getText() + "/" +
                    textField_DateFin_Annee.getText()));
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "date non valide.(bien mettre sous la forme 01)");

        }
        return task;
    }
}
