package CLI;

import BackEnd.Project;
import BackEnd.StockageUser;
import DataBase.JdbcProjectDao;

import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * Created by lucas on 06/05/2014.
 */
public class Command {
    public static void addProject() {
        Project project = new Project();
        Scanner sc = new Scanner(System.in);
        System.out.println("Ajout d'un projet");

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            project.setAuthor(StockageUser.user);
            project.getEmployeesWorkingOnIt().add(StockageUser.user);
            project.setProjectAdvancement(0);

            project.setName(getAnswer("Nom du projet:", sc));
            project.setDescription(getAnswer("description du projet:", sc));

            project.setBeginDate(formatter.parse(getAnswer("begin date (dd/MM/yyyy):", sc)));
            project.setEndDate(formatter.parse(getAnswer("end date (dd/MM/yyyy):", sc)));

            if (new JdbcProjectDao().createAProject(project))
                System.out.println("enregistrer!");
            else
                System.out.println("error bitch!");


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void modifyProject() {
        Scanner sc = new Scanner(System.in);
        int projectId = Integer.parseInt(getAnswer("project id to modify", sc));
        try {
            Project project = new JdbcProjectDao().loadAProjectById(projectId);
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

            int number = Integer.parseInt(getAnswer("modify :\r\n" +
                    "1:nom du projet \r\n" +
                    "2:description \r\n" +
                    "3:begin Date\r\n" +
                    "4:end date\r\n" +
                    "5:add a employee\r\n" +
                    "6:delete a employee", sc));
            switch (number) {
                case 1:
                    project.setName(getAnswer("new project name", sc));
                    break;
                case 2:
                    project.setDescription(getAnswer("new project description", sc));
                    break;
                case 3:
                    project.setBeginDate(formatter.parse(getAnswer("new project begin date", sc)));
                    break;
                case 4:
                    project.setName(getAnswer("new project end date", sc));
                    break;
                case 5:
                    project.addEmployeebyid(Integer.parseInt(getAnswer("project add a employee id", sc)));
                    break;
                case 6:
                    project.deleteByEmployeeId(Integer.parseInt(getAnswer("delete a employee by id", sc)));
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static String getAnswer(String question, Scanner sc) {
        System.out.println(question);
        return sc.nextLine();
    }
}
