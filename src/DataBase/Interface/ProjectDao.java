package DataBase.Interface;


import BackEnd.LocalUser;
import BackEnd.Project;
import BackEnd.ProjectTask;

import java.util.List;

/**
 * Created by lucas on 04/05/2014.
 */
public interface ProjectDao {
    public Boolean createAProject(Project project);

    public Boolean updateAProject(Project project);

    public List<Project> loadProjects(LocalUser user);

    public Project loadAProjectById(int id);

    public List<ProjectTask> loadTasksFromProject(Project project);

    public ProjectTask loadTaskById(int id, Project project);

    public Boolean createProjectTask(ProjectTask task);

    public Boolean updateProjectTask(ProjectTask task);
}
