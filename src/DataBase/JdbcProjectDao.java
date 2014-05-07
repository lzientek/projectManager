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
            pstmt.setString(3, project.getEmployeesWorkingOnItJoin());
            pstmt.setInt(4, project.getAuthor().getId());
            pstmt.setDate(5, new java.sql.Date(project.getBeginDate().getTime()));
            pstmt.setDate(6, new java.sql.Date(project.getEndDate().getTime()));
            pstmt.setString(7, project.getDescription());
            pstmt.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("error!" + e.getMessage());

            return false;
        }
    }

    @Override
    public Boolean updateAProject(Project project) {
        try {
            String sql1 =
                    "UPDATE projects SET name =?,projectadvencement=?,employeesOnIt=?,author=?" +
                            ",beginDate=?,endDate=?,description=? WHERE idprojects=?";
            PreparedStatement pstmt = connection.prepareStatement(sql1);
            pstmt.setString(1, project.getName());
            pstmt.setInt(2, project.getProjectAdvancement());
            pstmt.setString(3, StringUtils.join(project.getEmployeesWorkingOnIt(), "-"));
            pstmt.setInt(4, project.getAuthor().getId());
            pstmt.setDate(5, new java.sql.Date(project.getBeginDate().getTime()));
            pstmt.setDate(6, new java.sql.Date(project.getEndDate().getTime()));
            pstmt.setString(7, project.getDescription());
            pstmt.setInt(8, project.getId());

            pstmt.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Project> loadProjects(LocalUser user) {
        try {
            String regex = "^(" + user.getId() + ")-|-(" + user.getId() + ")-|-(" + user.getId() + ")$";

            String sql1 =
                    "SELECT * FROM  projects WHERE employeesOnIt REGEXP '" + regex + "' OR employeesOnIt = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql1);
            pstmt.setString(1, String.valueOf(user.getId()));

            ResultSet result = pstmt.executeQuery();
            ArrayList<Project> projectArrayList = new ArrayList<Project>();

            while (result.next()) {
                projectArrayList.add(new Project(
                        result.getString("name"), result.getString("employeesOnIt").split("-"),
                        result.getInt("projectadvencement"), result.getInt("idprojects"),
                        new JdbcUserDao().loadUserById(result.getInt("author")),
                        result.getDate("beginDate"),
                        result.getDate("endDate"),
                        result.getString("description")));
            }

            return projectArrayList;

        } catch (Exception e) {
            return new ArrayList<Project>();
        }
    }

    @Override
    public Project loadAProjectById(int id) {
        try {
            String sql1 =
                    "SELECT * FROM  projects WHERE idprojects=?";
            PreparedStatement pstmt = connection.prepareStatement(sql1);
            pstmt.setInt(1, id);

            ResultSet result = pstmt.executeQuery();

            result.next();
            Project projectToReturn = new Project(result.getString("name"), result.getString("employeesOnIt").split("-"),
                    result.getInt("projectadvencement"), id,
                    new JdbcUserDao().loadUserById(result.getInt("author")),
                    result.getDate("beginDate"),
                    result.getDate("endDate"),
                    result.getString("description"));


            return projectToReturn;

        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<ProjectTask> loadTasksFromProject(Project project) {
        try {
            String sql1 =
                    "SELECT * FROM  tasks WHERE idprojects=?";
            PreparedStatement pstmt = connection.prepareStatement(sql1);
            pstmt.setInt(1, project.getId());

            ResultSet result = pstmt.executeQuery();

            ArrayList<ProjectTask> tasksArrayList = new ArrayList<ProjectTask>();

            while (result.next()) {
                tasksArrayList.add(new ProjectTask(result.getString("name"),
                        result.getString("description"),
                        result.getInt("idtasks"),
                        project,
                        result.getDate("beginDate"),
                        result.getDate("endDate"),
                        result.getString("employeeOnIt").split("-"),
                        new JdbcUserDao().loadUserById(result.getInt("idauthor"))
                ));

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
            pstmt.setDate(3, new java.sql.Date(task.getBeginDate().getTime()));
            pstmt.setDate(4, new java.sql.Date(task.getEndDate().getTime()));
            pstmt.setString(5, task.getEmployeesWorkingOnItJoin());
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
                            ",employeeOnIt=?,idauthor=?,idprojects=? WHERE idtasks=?";
            PreparedStatement pstmt = connection.prepareStatement(sql1);
            pstmt.setString(1, task.getName());
            pstmt.setString(2, task.getDescription());
            pstmt.setDate(3, (java.sql.Date) task.getBeginDate());
            pstmt.setDate(4, (java.sql.Date) task.getEndDate());
            pstmt.setString(5, StringUtils.join(task.getEmployeesWorkingOnIt(), "-"));
            pstmt.setInt(6, task.getTaskAuthor().getId());
            pstmt.setInt(7, task.getProject().getId());
            pstmt.setInt(8, task.getId());

            pstmt.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
