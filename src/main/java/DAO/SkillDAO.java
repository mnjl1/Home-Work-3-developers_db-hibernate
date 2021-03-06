package DAO;
import Entity.Skill;
import Utils.AddInteger;

import Entity.Developers;
import connectToDatabase.SessionUnit;
import org.hibernate.query.Query;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class SkillDAO {
    private int skill_id;
    private String skill;

    SessionUnit sessionUnit = new SessionUnit();

    Scanner scanner = new Scanner(System.in);

    public void create(){
        Skill skill = new Skill();
        sessionUnit.openSession();
        sessionUnit.openTransaction();
        System.out.println("Enter first name.");
        String newSkill = scanner.nextLine();
        skill.setSkillName(newSkill);
        sessionUnit.getSession().save(skill);
        sessionUnit.closeTransaction();
    }

    public void getById(){
        sessionUnit.openSession();
        sessionUnit.openTransaction();
        System.out.println("Enter skill id.");
        skill_id = AddInteger.addInteger();
        Skill skill = sessionUnit.getSession().get(Skill.class, skill_id);
        System.out.println(skill);
        sessionUnit.closeTransaction();
    }

    public void update(){
        sessionUnit.openSession();
        sessionUnit.openTransaction();
        System.out.println("Enter skill id to update.");
        skill_id = AddInteger.addInteger();
        Skill skill = sessionUnit.getSession().get(Skill.class, skill_id);
        System.out.println("Enter skill name.");
        String newSkill = scanner.nextLine();
        skill.setSkillName(newSkill);
        sessionUnit.getSession().save(skill);
        sessionUnit.closeTransaction();
    }

    public void delete(){
        sessionUnit.openSession();
        sessionUnit.openTransaction();
        System.out.println("Enter id to delete.");
        skill_id = AddInteger.addInteger();
        Skill  skill= sessionUnit.getSession().get(Skill.class, skill_id);
        sessionUnit.getSession().delete(skill);
        System.out.println("Skill deleted");
        sessionUnit.closeTransaction();
    }

    public void getAll(){
        sessionUnit.openSession();
        sessionUnit.openTransaction();
        Query query = sessionUnit.getSession().createQuery("from Skill ");
        List<Skill> skillList = query.getResultList();
        Iterator iterator = skillList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        sessionUnit.closeTransaction();
    }
}
