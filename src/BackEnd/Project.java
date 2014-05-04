package BackEnd;

import java.util.Date;
import java.util.List;

/**
 * Created by lucas on 04/05/2014.
 */
public class Project {
    private int id;
    private double projectAdvancement;
    private List<User> employeesWorkingOnIt;
    private List<ProjectTask> projectTasks;

    private User author;
    private Date beginDate;
    private Date endDate;


    private String description;

    public Project(List<User> employeesWorkingOnIt, double projectAdvancement,
                   int id, User author, Date beginDate,
                   Date endDate, String description) {
        this.employeesWorkingOnIt = employeesWorkingOnIt;
        this.projectAdvancement = projectAdvancement;
        this.id = id;
        this.author = author;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getProjectAdvancement() {
        return projectAdvancement;
    }

    public void setProjectAdvancement(double projectAdvancement) {
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
}
