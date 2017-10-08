package DAO;

import Entity.Developers;
import Entity.Project;
import connectToDatabase.SessionUnit;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import Utils.AddInteger;

import javax.management.Query;

public class ProjectDAO {
    private int project_id;
    private String projectName;

    SessionUnit sessionUnit = new SessionUnit();
    Scanner scanner = new Scanner(System.in);

    public void create(){
        sessionUnit.openSession();
        sessionUnit.openTransaction();
        Project project = new Project();
        System.out.println("Enter project name");
        projectName = scanner.nextLine();
        project.setProjectName(projectName);
        sessionUnit.getSession().save(project);
        sessionUnit.closeTransaction();
    }

    public void appointProject(){
        sessionUnit.openSession();
        sessionUnit.openTransaction();
        System.out.println("Enter developer ID to appoint project.");
        int developerId = AddInteger.addInteger();
        Developers developer = sessionUnit.getSession().get(Developers.class, developerId);
        Project project = new Project();
        System.out.println("Enter project name to appoint.");
        projectName = scanner.nextLine();
        project.setProjectName(projectName);
        developer.addProject(project);
        sessionUnit.getSession().save(developer);
        sessionUnit.closeTransaction();
    }

    public void getById(){
        sessionUnit.openSession();
        sessionUnit.openTransaction();
        System.out.println("Enter project id to print.");
        project_id = AddInteger.addInteger();
        Project project = sessionUnit.getSession().get(Project.class, project_id);
        System.out.println(project);
        sessionUnit.closeTransaction();
    }

    public void update(){
        sessionUnit.openSession();
        sessionUnit.openTransaction();
        System.out.println("Enter project id to update.");
        project_id = AddInteger.addInteger();
        Project project = sessionUnit.getSession().get(Project.class, project_id);
        System.out.println("Enter new project name.");
        projectName = scanner.nextLine();
        project.setProjectName(projectName);
        sessionUnit.getSession().save(project);
        sessionUnit.closeTransaction();
    }

    public void deleteProject(){
        sessionUnit.openSession();
        sessionUnit.openTransaction();
        System.out.println("Enter project id to delete");
        project_id = AddInteger.addInteger();
        Project project = sessionUnit.getSession().get(Project.class, project_id);
        sessionUnit.getSession().delete(project_id);
        sessionUnit.closeTransaction();
        System.out.println("Project deleted.");
    }

    public void getAll(){
        org.hibernate.query.Query query = sessionUnit.getSession().createQuery("from Project ");
        List<Developers> projectsList = query.getResultList();
        Iterator iterator = projectsList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        sessionUnit.closeTransaction();
    }
}
