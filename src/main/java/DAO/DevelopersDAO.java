package DAO;

import Entity.Developers;
import Entity.ItCompany;
import Entity.Skill;
import connectToDatabase.SessionUnit;
import org.hibernate.query.Query;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import Utils.AddInteger;

public class DevelopersDAO {
    private int developer_id;
    private String firstName;
    private String lastName;
    private int salary;

    SessionUnit sessionUnit = new SessionUnit();

    Scanner scanner = new Scanner(System.in);

    public void createDeveloper(){
        Developers developer = new Developers();
        sessionUnit.openSession();
        sessionUnit.openTransaction();
        System.out.println("Enter first name.");
        firstName = scanner.nextLine();
        developer.setFirstName(firstName);
        System.out.println("Enter last name.");
        lastName = scanner.nextLine();
        developer.setLastName(lastName);
        System.out.println("Enter salary.");
        salary = AddInteger.addInteger();
        developer.setSalary(salary);
        sessionUnit.getSession().save(developer);
        sessionUnit.closeTransaction();
    }

    public void addSkill(){
        sessionUnit.openSession();
        sessionUnit.openTransaction();
        System.out.println("Adding skill to developer.");
        System.out.println("Enter developer' id.");
        int developerId = AddInteger.addInteger();
        Developers developer = sessionUnit.getSession().get(Developers.class, developerId);
        Skill skill = new Skill();
        System.out.println("Enter developer's skill.");
        String devSkill = scanner.nextLine();
        skill.setSkillName(devSkill);
        developer.addSkill(skill);
        sessionUnit.getSession().save(developer);
        sessionUnit.closeTransaction();
    }

    public void getById(){
        sessionUnit.openSession();
        sessionUnit.openTransaction();
        System.out.println("Enter developer' id.");
        developer_id = AddInteger.addInteger();
        Developers developer = sessionUnit.getSession().get(Developers.class, developer_id);
        System.out.println(developer);
        sessionUnit.closeTransaction();
    }

    public void update(){
        sessionUnit.openSession();
        sessionUnit.openTransaction();
        System.out.println("Enter developer' id to update.");
        developer_id = AddInteger.addInteger();
        scanner.nextLine();
        Developers developer = sessionUnit.getSession().get(Developers.class, developer_id);
        System.out.println("Enter first name.");
        firstName = scanner.nextLine();
        developer.setFirstName(firstName);
        System.out.println("Enter last name");
        lastName = scanner.nextLine();
        developer.setLastName(lastName);
        int itCompanyId = AddInteger.addInteger();
        System.out.println("Enter It company id.");
        ItCompany itCompany = sessionUnit.getSession().get(ItCompany.class, itCompanyId);
        developer.addItCompany(itCompany);
        System.out.println("Enter salary");
        salary = AddInteger.addInteger();
        developer.setSalary(salary);
        sessionUnit.getSession().save(developer);
        sessionUnit.closeTransaction();
    }

    public void delete(){
        sessionUnit.openSession();
        sessionUnit.openTransaction();
        System.out.println("Enter id to delete.");
        developer_id = AddInteger.addInteger();
        scanner.nextLine();
        Developers developer = sessionUnit.getSession().get(Developers.class, developer_id);
        sessionUnit.getSession().delete(developer);
        sessionUnit.closeTransaction();
    }

    public void getAll(){
        sessionUnit.openSession();
        sessionUnit.openTransaction();
        Query query = sessionUnit.getSession().createQuery("from Developers ");
        List<Developers> developersList = query.getResultList();
        Iterator iterator = developersList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        sessionUnit.closeTransaction();
    }
}
