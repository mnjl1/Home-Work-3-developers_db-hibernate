package DAO;

import Entity.Developers;
import connectToDatabase.SessionUnit;
import Entity.ItCompany;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import Utils.AddInteger;

import javax.management.Query;

public class ItCompanyDAO {
    private int companyID;
    private String companyName;

    SessionUnit sessionUnit = new SessionUnit();
    Scanner scanner = new Scanner(System.in);

    public void create(){
        ItCompany itCompany = new ItCompany();
        sessionUnit.openSession();
        sessionUnit.openTransaction();
        System.out.println("Enter company name.");
        companyName = scanner.nextLine();
        itCompany.setCompanyName(companyName);
        sessionUnit.getSession().save(itCompany);
        sessionUnit.closeTransaction();
    }

    public void update(){
        sessionUnit.openSession();
        sessionUnit.openTransaction();
        ItCompany itCompany = new ItCompany();
        System.out.println("Enter new company name.");
        companyName = scanner.nextLine();
        itCompany.setCompanyName(companyName);
        sessionUnit.getSession().save(itCompany);
        sessionUnit.closeTransaction();
    }

    public void getByiD(){
        sessionUnit.openSession();
        sessionUnit.openTransaction();
        System.out.println("Enter company id.");
        companyID = AddInteger.addInteger();
        ItCompany itCompany = sessionUnit.getSession().get(ItCompany.class, companyID);
        System.out.println(itCompany);
        sessionUnit.closeTransaction();
    }

    public void delete(){
        sessionUnit.openSession();
        sessionUnit.openTransaction();
        System.out.println("Enter company id.");
        companyID = AddInteger.addInteger();
        ItCompany itCompany = sessionUnit.getSession().get(ItCompany.class, companyID);
        sessionUnit.getSession().delete(itCompany);
        sessionUnit.closeTransaction();
        System.out.println("Company deleted.");
    }

    public void getAll(){
        sessionUnit.openSession();
        sessionUnit.openTransaction();
        org.hibernate.query.Query query = sessionUnit.getSession().createQuery("from ItCompany ");
        List<ItCompany> companyList = query.getResultList();
        Iterator iterator = companyList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        sessionUnit.closeTransaction();
    }
}
