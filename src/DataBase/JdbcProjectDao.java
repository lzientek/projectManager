package DataBase;

import BackEnd.LocalUser;
import BackEnd.Project;
import BackEnd.ProjectTask;
import DataBase.Interface.ProjectDao;

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
                    "INSERT INTO project (Name)"      //TODO: ajouter les parametres
                            + " VALUES (?)";

            PreparedStatement pstmt = connection.prepareStatement(sql1);
            pstmt.setString(1, project.getName());
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
    public ProjectTask loadTaskById(int id) {
        try {
            String sql1 =
                    "SELECT * FROM  tasks WHERE Id=?";
            PreparedStatement pstmt = connection.prepareStatement(sql1);
            pstmt.setInt(1, id);

            ResultSet result = pstmt.executeQuery();

            ProjectTask taskToReturn;

            result.next();
            //TODO: remplir taskToReturn


            return null;//taskToReturn;

        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Boolean createProjectTask(ProjectTask task) {
        try {
            String sql1 =
                    "INSERT INTO tasks (Name)"      //TODO: ajouter les parametres
                            + " VALUES (?)";

            PreparedStatement pstmt = connection.prepareStatement(sql1);
            pstmt.setString(1, task.getName());
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
                    "UPDATE tasks SET name =? WHERE id=?";
            PreparedStatement pstmt = connection.prepareStatement(sql1);
            pstmt.setString(1, task.getName());
            pstmt.setInt(2, task.getId());

            pstmt.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
