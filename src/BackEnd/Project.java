package BackEnd;

import DataBase.JdbcProjectDao;
import DataBase.JdbcUserDao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by lucas on 04/05/2014.
 */
public class Project {
    private int id;
    private String name;
    private int projectAdvancement;
    private List<User> employeesWorkingOnIt;
    private List<ProjectTask> projectTasks;

    private User author;
    private Date beginDate;
    private Date endDate;


    private String description;

    public Project() {
        employeesWorkingOnIt = new ArrayList<User>();
        projectTasks = new ArrayList<ProjectTask>();
    }

    public Project(String name, String[] employeesWorkingOnIt, int projectAdvancement,
                   int id, User author, Date beginDate,
                   Date endDate, String description) {

        this.projectAdvancement = projectAdvancement;
        this.id = id;
        this.author = author;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.description = description;
        this.name = name;
        try {
            this.employeesWorkingOnIt = new JdbcUserDao().loadUserByFromProject(employeesWorkingOnIt);
            this.projectTasks = new JdbcProjectDao().loadTasksFromProject(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProjectTask> getProjectTasks() {
        return projectTasks;
    }

    public void setProjectTasks(List<ProjectTask> projectTasks) {
        this.projectTasks = projectTasks;
    }

    public List<User> getEmployeesWorkingOnIt() {
        return employeesWorkingOnIt;
    }

    public String getEmployeesWorkingOnItJoin() {
        String toReturn = "";
        for (int i = 0; i < employeesWorkingOnIt.size(); i++) {
            if (i == 0)
                toReturn = String.valueOf(employeesWorkingOnIt.get(i).getId());
            else
                toReturn += "-" + employeesWorkingOnIt.get(i).getId();
        }
        return toReturn;
    }


    public void setEmployeesWorkingOnIt(List<User> employeesWorkingOnIt) {
        this.employeesWorkingOnIt = employeesWorkingOnIt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProjectAdvancement() {
        return projectAdvancement;
    }

    public void setProjectAdvancement(int projectAdvancement) {
        this.projectAdvancement = projectAdvancement;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addEmployeebyid(int id) {
        try {
            employeesWorkingOnIt.add(new JdbcUserDao().loadUserById(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteByEmployeeId(int id) {
        for (int i = 0; i < employeesWorkingOnIt.size(); i++) {
            if (employeesWorkingOnIt.get(i).getId() == id) {
                employeesWorkingOnIt.remove(i);
                break;
            }
        }
    }
}
