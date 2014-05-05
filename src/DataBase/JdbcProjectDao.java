package DataBase;

import BackEnd.LocalUser;
import BackEnd.Project;
import BackEnd.ProjectTask;
import DataBase.Interface.ProjectDao;
import com.sun.deploy.util.StringUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lucas on 04/05/2014.
 */
public class JdbcProjectDao extends JdbcDao implements ProjectDao {
    public JdbcProjectDao() throws Exception {
        connect();
    }

    @Override
    public Boolean createAProject(Project project) {
        try {
            String sql1 =
                    "INSERT INTO projects (name,projectadvencement,employeesOnIt," +
                            "author,beginDate,endDate,description)"
                            + " VALUES (?,?,?,?,?,?,?)";

            PreparedStatement pstmt = connection.prepareStatement(sql1);
            pstmt.setString(1, project.getName());
            pstmt.setInt(2, project.getProjectAdvancement());
            pstmt.setString(3, project.getName());
            pstmt.setString(4, project.getName());
            pstmt.setString(5, project.getName());
            pstmt.setString(6, project.getName());
            pstmt.setString(7, project.getName());
            pstmt.executeUpdate();
            return true;
        } catch (Exception e) {
            //System.out.println("error!"+e.getMessage());

            return false;
        }
    }

    @Override
    public Boolean updateAProject(Project project) {
        try {
            //TODO: plein d'autre parametre a remplir
            String sql1 =
                    "UPDATE project SET name =? WHERE id=?";
            PreparedStatement pstmt = connection.prepareStatement(sql1);
            pstmt.setString(1, project.getName());
            pstmt.setInt(2, project.getId());

            pstmt.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Project> loadProjects(LocalUser user) {
        try {
            String sql1 =
                    "SELECT * FROM  project WHERE UserId=?";
            PreparedStatement pstmt = connection.prepareStatement(sql1);
            pstmt.setInt(1, user.getId());

            ResultSet result = pstmt.executeQuery();

            ArrayList<Project> projectArrayList = new ArrayList<Project>();

            while (result.next()) {
                //TODO: remplir
            }

            return null;//projectArrayList;

        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Project loadAProjectById(int id) {
        try {
            String sql1 =
                    "SELECT * FROM  project WHERE Id=?";
            PreparedStatement pstmt = connection.prepareStatement(sql1);
            pstmt.setInt(1, id);

            ResultSet result = pstmt.executeQuery();

            Project projectToReturn;

            result.next();
            //TODO: remplir projectToReturn


            return null;//projectToReturn;

        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<ProjectTask> loadTasksFromProject(Project project) {
        try {
            String sql1 =
                    "SELECT * FROM  tasks WHERE projectId=?";
            PreparedStatement pstmt = connection.prepareStatement(sql1);
            pstmt.setInt(1, project.getId());

            ResultSet result = pstmt.executeQuery();

            ArrayList<ProjectTask> tasksArrayList = new ArrayList<ProjectTask>();

            while (result.next()) {
                //TODO: remplir
            }
            return tasksArrayList;

        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public ProjectTask loadTaskById(int id, Project project) {
        try {
            String sql1 =
                    "SELECT * FROM tasks WHERE idtasks=?";
            PreparedStatement pstmt = connection.prepareStatement(sql1);
            pstmt.setInt(1, id);

            ResultSet result = pstmt.executeQuery();

            result.next();
            ProjectTask taskToReturn = new ProjectTask(result.getString("name"),
                    result.getString("description"),
                    result.getInt("idtasks"),
                    project,
                    result.getDate("beginDate"),
                    result.getDate("endDate"),
                    result.getString("employeeOnIt").split("-"),
                    new JdbcUserDao().loadUserById(result.getInt("idauthor"))

            );

            return taskToReturn;

        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Boolean createProjectTask(ProjectTask task) {
        try {
            String sql1 =
                    "INSERT INTO tasks (name,description,beginDate,endDate" +
                            ",employeeOnIt,idauthor,idprojects)"
                            + " VALUES (?,?,?,?,?,?,?)";

            PreparedStatement pstmt = connection.prepareStatement(sql1);
            pstmt.setString(1, task.getName());
            pstmt.setString(2, task.getDescription());
            pstmt.setDate(3, (java.sql.Date) task.getBeginDate());
            pstmt.setDate(4, (java.sql.Date) task.getEndDate());
            pstmt.setString(5, StringUtils.join(task.getEmployeesWorkingOnIt(), "-"));
            pstmt.setInt(6, task.getTaskAuthor().getId());
            pstmt.setInt(7, task.getProject().getId());
            pstmt.executeUpdate();
            return true;
        } catch (Exception e) {
            //System.out.println("error!"+e.getMessage());

            return false;
        }
    }

    @Override
    public Boolean updateProjectTask(ProjectTask task) {
        try {
            String sql1 =
                    "UPDATE tasks SET name =? , description=?,beginDate=?,endDate=?" +
                            ",employeeOnIt=?,idauthor=?,idprojects=?";
            PreparedStatement pstmt = connection.prepareStatement(sql1);
            pstmt.setString(1, task.getName());
            pstmt.setString(2, task.getDescription());
            pstmt.setDate(3, (java.sql.Date) task.getBeginDate());
            pstmt.setDate(4, (java.sql.Date) task.getEndDate());
            pstmt.setString(5, StringUtils.join(task.getEmployeesWorkingOnIt(), "-"));
            pstmt.setInt(6, task.getTaskAuthor().getId());
            pstmt.setInt(7, task.getProject().getId());

            pstmt.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
