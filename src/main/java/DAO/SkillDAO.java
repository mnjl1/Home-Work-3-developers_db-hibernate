package DAO;

import Entity.Developers;
import connectToDatabase.SessionUnit;
import org.hibernate.query.Query;
import sun.plugin.com.Utils;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class SkillDAO {
    private int skill_id;
    private String skill;

    SessionUnit sessionUnit = new SessionUnit();

    Scanner scanner = new Scanner(System.in);

    public void create(){
        Utils utils = new Utils();
        Developers developers = new Developers();
        sessionUnit.openSession();
        sessionUnit.openTransaction();
        System.out.println("Enter first name.");
        skill = scanner.nextLine();
        developers.setFirstName(skill);
    }

    public void getById(){
        sessionUnit.openSession();
        sessionUnit.openTransaction();
        System.out.println("Enter developer' id.");
        skill_id = scanner.nextInt();
        Developers developer = sessionUnit.getSession().get(Developers.class, skill_id);
        System.out.println(developer);
        sessionUnit.closeTransaction();
    }

    public void update(){
        sessionUnit.openSession();
        sessionUnit.openTransaction();
        System.out.println("Enter developer' id to update.");
        skill_id = scanner.nextInt();
        scanner.nextLine();
        Developers developer = sessionUnit.getSession().get(Developers.class, skill_id);
        System.out.println("Enter first name.");
        skill = scanner.nextLine();
        developer.setFirstName(skill);
    }

    public void delete(){
        sessionUnit.openSession();
        sessionUnit.openTransaction();
        System.out.println("Enter id to delete.");
        skill_id = scanner.nextInt();
        scanner.nextLine();
        Developers developer = sessionUnit.getSession().get(Developers.class, skill_id);
        sessionUnit.getSession().delete(developer);
        sessionUnit.closeTransaction();
    }

    public void getAll(){
        sessionUnit.openSession();
        sessionUnit.openTransaction();
        Query query = sessionUnit.getSession().createQuery("from Skill ");
        List<Developers> developersList = query.getResultList();
        Iterator iterator = developersList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        sessionUnit.closeTransaction();
    }
}
