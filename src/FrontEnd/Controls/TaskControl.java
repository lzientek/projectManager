package FrontEnd.Controls;

import BackEnd.ProjectTask;
import DataBase.JdbcProjectDao;
import FrontEnd.AppFrame;
import FrontEnd.PopUp.ModifTask;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lucas on 12/05/2014.
 */
public class TaskControl extends JPanel {

    private JLabel lblName;
    private JLabel lblPourcentage;
    private JList lblNumberOfEmployees;
    private JLabel lblBeginDate;
    private JLabel lblEndDate;
    private JButton btnModify;
    private ProjectTask task;
    private AppFrame appFrame;
    private JCheckBox chckbxTerminer;

    public AppFrame getAppFrame() {
        return appFrame;
    }

    public TaskControl(final ProjectTask task, AppFrame frame) {
        this.task = task;
        appFrame = frame;
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{1.0, 2.0, 0.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);

        setBorder(BorderFactory.createLineBorder(Color.lightGray, 1));
        updateValues();

        validate();
    }

    public void updateValues() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        lblName = new TitleLabel(task.getName(), 18);

        lblNumberOfEmployees = new JList(task.getEmployeesWorkingOnIt().toArray());
        lblBeginDate = new JLabel(formatter.format(task.getBeginDate()) + " -> ");
        lblEndDate = new JLabel(formatter.format(task.getEndDate()));
        final TaskControl tc = this;
        btnModify = new JButton("Modifier");
        btnModify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ModifTask(task, tc);
            }
        });


        chckbxTerminer = new JCheckBox("terminer");
        chckbxTerminer.setEnabled(new Date().getTime() < task.getEndDate().getTime());
        chckbxTerminer.setSelected(!chckbxTerminer.isEnabled());
        chckbxTerminer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (chckbxTerminer.isSelected()) {
                    task.setEndDate(new Date());
                    new JdbcProjectDao().updateProjectTask(task);
                    updateValues();
                    appFrame.reload();
                }

            }
        });

        removeAll();
        setGridBagConstraints();

        revalidate();
        appFrame.getContentPane().revalidate();
    }

    private void setGridBagConstraints() {
        GridBagConstraints gbc_lblName = new GridBagConstraints();
        gbc_lblName.fill = GridBagConstraints.HORIZONTAL;
        gbc_lblName.insets = new Insets(0, 0, 5, 5);
        gbc_lblName.gridx = 0;
        gbc_lblName.gridy = 0;
        add(lblName, gbc_lblName);

        GridBagConstraints gbc_checkBox = new GridBagConstraints();
        gbc_checkBox.anchor = GridBagConstraints.EAST;
        gbc_checkBox.insets = new Insets(0, 0, 5, 5);
        gbc_checkBox.gridx = 2;
        gbc_checkBox.gridy = 0;
        add(chckbxTerminer, gbc_checkBox);


        GridBagConstraints gbc_lblNumberOfEmployees = new GridBagConstraints();
        gbc_lblNumberOfEmployees.gridheight = 2;
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
        add(btnModify, gbc_btnModify);

    }

}
