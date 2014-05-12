package FrontEnd.innerPage;

import BackEnd.ProjectTask;
import FrontEnd.AppFrame;
import FrontEnd.Controls.TaskControl;
import FrontEnd.Controls.TitleLabel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

/**
 * Created by lucas on 09/05/2014.
 */
public class FullScreenProjectJPanel extends FullPage {


    private final AppFrame appFrame;
    private JList list;
    private JLabel lblName;
    private JProgressBar progressBar;
    private JLabel lblBegindate;
    private JLabel lblEnddate;
    private JPanel panelTache;
    private JScrollPane scrollPane;
    private JLabel lblProjects;
    private JButton btnRetour;

    public FullScreenProjectJPanel(AppFrame app) {
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(new BorderLayout(5, 5));
        appFrame = app;


        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{1.0, 2.0, 0.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);

        setValues();

        gridBagConstraints();
    }

    private void setValues() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        lblName = new TitleLabel(appFrame.getProject().getName());
        progressBar = new JProgressBar();
        progressBar.setValue(appFrame.getProject().getProjectAdvancement());
        progressBar.setToolTipText("Avancement");
        lblBegindate = new JLabel(formatter.format(appFrame.getProject().getBeginDate()));
        lblEnddate = new JLabel(formatter.format(appFrame.getProject().getEndDate()));
        list = new JList(appFrame.getProject().getEmployeesWorkingOnIt().toArray());

        panelTache = new JPanel();
        panelTache.setLayout(new BoxLayout(panelTache, BoxLayout.Y_AXIS));
        setTaskList(appFrame.getSelectedProject().getProjectTasks());
        scrollPane = new JScrollPane(panelTache,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        btnRetour = new JButton("Retour au projets");
        btnRetour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                appFrame.setContent(new ProjectJPanel(appFrame.getProjects(), appFrame));
            }
        });

    }

    private void gridBagConstraints() {
        GridBagConstraints gbc_lblName = new GridBagConstraints();
        gbc_lblName.insets = new Insets(0, 0, 5, 5);
        gbc_lblName.anchor = GridBagConstraints.WEST;

        gbc_lblName.gridx = 0;
        gbc_lblName.gridy = 0;
        add(lblName, gbc_lblName);

        GridBagConstraints gbc_progressBar = new GridBagConstraints();
        gbc_progressBar.insets = new Insets(0, 0, 5, 5);
        gbc_progressBar.fill = GridBagConstraints.HORIZONTAL;
        gbc_progressBar.gridx = 1;
        gbc_progressBar.gridy = 0;
        add(progressBar, gbc_progressBar);

        GridBagConstraints gbc_lblBegindate = new GridBagConstraints();
        gbc_lblBegindate.insets = new Insets(0, 0, 5, 5);
        gbc_lblBegindate.gridx = 2;
        gbc_lblBegindate.gridy = 0;
        add(lblBegindate, gbc_lblBegindate);

        GridBagConstraints gbc_lblEnddate = new GridBagConstraints();
        gbc_lblEnddate.insets = new Insets(0, 0, 5, 0);
        gbc_lblEnddate.gridx = 3;
        gbc_lblEnddate.gridy = 0;
        add(lblEnddate, gbc_lblEnddate);

        JLabel lblEmployeeDessu = new TitleLabel("Employees sur le projet:", 16);
        GridBagConstraints gbc_lblEmployeeDessu = new GridBagConstraints();
        gbc_lblEmployeeDessu.anchor = GridBagConstraints.WEST;
        gbc_lblEmployeeDessu.insets = new Insets(0, 0, 5, 5);
        gbc_lblEmployeeDessu.gridx = 0;
        gbc_lblEmployeeDessu.gridy = 1;
        add(lblEmployeeDessu, gbc_lblEmployeeDessu);

        JLabel lblTask = new TitleLabel("Taches :", 16);
        GridBagConstraints gbc_lblTask = new GridBagConstraints();
        gbc_lblTask.anchor = GridBagConstraints.WEST;
        gbc_lblTask.insets = new Insets(0, 0, 5, 5);
        gbc_lblTask.gridx = 1;
        gbc_lblTask.gridy = 1;
        add(lblTask, gbc_lblTask);

        GridBagConstraints gbc_list = new GridBagConstraints();
        gbc_list.anchor = GridBagConstraints.NORTH;
        gbc_list.insets = new Insets(0, 0, 0, 5);
        gbc_list.fill = GridBagConstraints.HORIZONTAL;
        gbc_list.gridx = 0;
        gbc_list.gridy = 2;
        add(list, gbc_list);

        GridBagConstraints gbc_scrollPane = new GridBagConstraints();
        gbc_scrollPane.fill = GridBagConstraints.BOTH;
        gbc_scrollPane.gridwidth = 3;
        gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
        gbc_scrollPane.gridx = 1;
        gbc_scrollPane.gridy = 2;
        add(scrollPane, gbc_scrollPane);

        GridBagConstraints gbc_btnRetour = new GridBagConstraints();
        gbc_btnRetour.gridx = 3;
        gbc_btnRetour.gridy = 3;
        add(btnRetour, gbc_btnRetour);

        setVisible(true);
        //important pour actualiser l'interface
        revalidate();
        appFrame.getContentPane().revalidate();
    }

    public void setTaskList(java.util.List<ProjectTask> ts) {
        for (int i = 0; i < ts.size(); i++) {
            panelTache.add(new TaskControl(ts.get(i), appFrame));
            panelTache.add(Box.createVerticalStrut(10));//marge e pixel
        }
    }

    @Override
    public void reloadInterface() {
        removeAll();
        setValues();
        gridBagConstraints();
        revalidate();
        appFrame.getContentPane().revalidate();

    }

    public void addToTaskList(ProjectTask t) {
        appFrame.getProject().getProjectTasks().add(t);
        panelTache.add(new TaskControl(t, appFrame));
        panelTache.add(Box.createVerticalStrut(10));//marge e pixel

    }
}
