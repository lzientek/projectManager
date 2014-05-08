package FrontEnd.Controls;

import BackEnd.Project;

import javax.swing.*;
import java.awt.*;

/**
 * Created by lucas on 08/05/2014.
 */
public class FormulaireProject extends JPanel {
    private final JTextField textField_name;
    private final JTextArea textArea;
    private final JTextField textField_DateDebut_Jour;
    private final JTextField textField_DateDebut_Mois;
    private final JTextField textField_DateDebut_Annee;
    private final JTextField textField_DateFin_Jour;
    private final JTextField textField_DateFin_Mois;
    private final JTextField textField_DateFin_Annee;
    private Project project;

    public FormulaireProject(Project project) {
        this.project = project;
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);

        JLabel lblNom = new JLabel("Nom : ");
        GridBagConstraints gbc_lblNom = new GridBagConstraints();
        gbc_lblNom.anchor = GridBagConstraints.EAST;
        gbc_lblNom.insets = new Insets(0, 0, 5, 5);
        gbc_lblNom.gridx = 1;
        gbc_lblNom.gridy = 1;
        add(lblNom, gbc_lblNom);

        textField_name = new JTextField();
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

        textArea = new JTextArea();
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

        textField_DateDebut_Jour = new JTextField();
        panel_dateDebut.add(textField_DateDebut_Jour);
        textField_DateDebut_Jour.setColumns(10);

        textField_DateDebut_Mois = new JTextField();
        panel_dateDebut.add(textField_DateDebut_Mois);
        textField_DateDebut_Mois.setColumns(10);

        textField_DateDebut_Annee = new JTextField();
        panel_dateDebut.add(textField_DateDebut_Annee);
        textField_DateDebut_Annee.setColumns(10);

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

        textField_DateFin_Jour = new JTextField();
        textField_DateFin_Jour.setColumns(10);
        panel_DateDebut.add(textField_DateFin_Jour);

        textField_DateFin_Mois = new JTextField();
        textField_DateFin_Mois.setColumns(10);
        panel_DateDebut.add(textField_DateFin_Mois);

        textField_DateFin_Annee = new JTextField();
        textField_DateFin_Annee.setColumns(10);
        panel_DateDebut.add(textField_DateFin_Annee);

        JLabel lblEmploySurLe = new JLabel("employ\u00E9 sur le projet:");
        GridBagConstraints gbc_lblEmploySurLe = new GridBagConstraints();
        gbc_lblEmploySurLe.anchor = GridBagConstraints.EAST;
        gbc_lblEmploySurLe.insets = new Insets(0, 0, 0, 5);
        gbc_lblEmploySurLe.gridx = 1;
        gbc_lblEmploySurLe.gridy = 5;
        add(lblEmploySurLe, gbc_lblEmploySurLe);

        Panel panel_employee = new Panel();
        GridBagConstraints gbc_panel_employee = new GridBagConstraints();
        gbc_panel_employee.insets = new Insets(0, 0, 0, 5);
        gbc_panel_employee.gridx = 2;
        gbc_panel_employee.gridy = 5;
        add(panel_employee, gbc_panel_employee);
    }
}
