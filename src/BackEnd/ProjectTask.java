package BackEnd;

import java.util.Date;
import java.util.List;

/**
 * Created by lucas on 04/05/2014.
 */
public class ProjectTask {
    private String name;
    private String description;
    private int id;
    private Project project;
    private Date beginDate;
    private Date endDate;
    private List<User> employeesWorkingOnIt;
    private User taskAuthor;
    private Boolean isCompleted;

    public ProjectTask(String name, String description, int id, Project project,
                       Date beginDate, Date endDate,
                       List<User> employeesWorkingOnIt,
                       User taskAuthor, Boolean isCompleted) {
        this.name = name;
        this.description = description;
        this.id = id;
        this.project = project;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.employeesWorkingOnIt = employeesWorkingOnIt;
        this.taskAuthor = taskAuthor;
        this.isCompleted = isCompleted;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(Boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public User getTaskAuthor() {
        return taskAuthor;
    }

    public void setTaskAuthor(User taskAuthor) {
        this.taskAuthor = taskAuthor;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<User> getEmployeesWorkingOnIt() {
        return employeesWorkingOnIt;
    }

    public void setEmployeesWorkingOnIt(List<User> employeesWorkingOnIt) {
        this.employeesWorkingOnIt = employeesWorkingOnIt;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }
}
