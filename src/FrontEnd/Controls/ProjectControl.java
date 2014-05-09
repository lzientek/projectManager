package FrontEnd.Controls;

import BackEnd.Project;
import BackEnd.StockageUser;
import FrontEnd.PopUp.ModifProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

/**
 * Created by lucas on 08/05/2014.
 */
public class ProjectControl extends JPanel {
    private JLabel lblName;
    private JLabel lblPourcentage;
    private JLabel lblNumberOfEmployees;
    private JLabel lblBeginDate;
    private JLabel lblEndDate;
    private JButton btnModify;
    private Project project;

    public ProjectControl(final Project project) {
        this.project = project;

        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);
        setBorder(BorderFactory.createLineBorder(Color.gray, 1, true));

        //todo : ajouter le click

        updateValues();
        btnModify = new JButton("Modifier");

        btnModify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ModifProject(project, (Component) e.getSource());
                //todo : recuperer le close pour executer update values
            }
        });

        setGridBagConstraints();


    }

    public void updateValues() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        lblName = new JLabel(project.getName());
        lblPourcentage = new JLabel("avancement : " + project.getProjectAdvancement() + "%");
        lblNumberOfEmployees = new JLabel("Nombre d'employés :" + project.getEmployeesWorkingOnIt().size());
        lblBeginDate = new JLabel(formatter.format(project.getBeginDate()) + " -> ");
        lblEndDate = new JLabel(formatter.format(project.getEndDate()));
    }

    private void setGridBagConstraints() {
        GridBagConstraints gbc_lblName = new GridBagConstraints();
        gbc_lblName.fill = GridBagConstraints.HORIZONTAL;
        gbc_lblName.insets = new Insets(0, 0, 5, 5);
        gbc_lblName.gridx = 0;
        gbc_lblName.gridy = 0;
        add(lblName, gbc_lblName);

        GridBagConstraints gbc_lblPourcentage = new GridBagConstraints();
        gbc_lblPourcentage.fill = GridBagConstraints.HORIZONTAL;
        gbc_lblPourcentage.insets = new Insets(0, 0, 5, 0);
        gbc_lblPourcentage.gridx = 2;
        gbc_lblPourcentage.gridy = 0;
        add(lblPourcentage, gbc_lblPourcentage);

        GridBagConstraints gbc_lblNumberOfEmployees = new GridBagConstraints();
        gbc_lblNumberOfEmployees.fill = GridBagConstraints.HORIZONTAL;
        gbc_lblNumberOfEmployees.insets = new Insets(0, 0, 5, 5);
        gbc_lblNumberOfEmployees.gridx = 0;
        gbc_lblNumberOfEmployees.gridy = 1;
        add(lblNumberOfEmployees, gbc_lblNumberOfEmployees);

        GridBagConstraints gbc_lblBeginDate = new GridBagConstraints();
        gbc_lblBeginDate.anchor = GridBagConstraints.EAST;
        gbc_lblBeginDate.insets = new Insets(0, 0, 5, 5);
        gbc_lblBeginDate.gridx = 1;
        gbc_lblBeginDate.gridy = 1;
        add(lblBeginDate, gbc_lblBeginDate);

        GridBagConstraints gbc_lblEndDate = new GridBagConstraints();
        gbc_lblEndDate.fill = GridBagConstraints.HORIZONTAL;
        gbc_lblEndDate.insets = new Insets(0, 0, 5, 0);
        gbc_lblEndDate.gridx = 2;
        gbc_lblEndDate.gridy = 1;
        add(lblEndDate, gbc_lblEndDate);

        GridBagConstraints gbc_btnModify = new GridBagConstraints();
        gbc_btnModify.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnModify.gridx = 2;
        gbc_btnModify.gridy = 2;
        if (StockageUser.user.getIsManager())
            add(btnModify, gbc_btnModify);

    }
}
