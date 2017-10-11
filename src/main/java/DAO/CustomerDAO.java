package DAO;

import Entity.Customer;
import Entity.Project;
import connectToDatabase.SessionUnit;
import Utils.AddInteger;
import java.util.Scanner;

public class CustomerDAO {
    private int customerId;
    private String customerName;

    SessionUnit sessionUnit = new SessionUnit();
    Scanner scanner = new Scanner(System.in);

    public void create(){
        sessionUnit.openSession();
        sessionUnit.closeTransaction();
        Customer customer = new Customer();
        System.out.println("Enter customer name.");
        customerName = scanner.nextLine();
        customer.setCustomerName(customerName);
        sessionUnit.getSession().save(customer);
        sessionUnit.closeTransaction();
    }

    public void orderProject(){
        sessionUnit.openSession();
        sessionUnit.openTransaction();
        System.out.println("Enter customer id to set project.");
        customerId = AddInteger.addInteger();
        Customer customer = sessionUnit.getSession().get(Customer.class, customerId);
        System.out.println("Enter project id to order.");
        int projectId = AddInteger.addInteger();
        Project project = sessionUnit.getSession().get(Project.class, projectId);
        customer.addProject(project);
        sessionUnit.closeTransaction();
    }

    public void getById(){
        sessionUnit.openSession();
        sessionUnit.openTransaction();
        System.out.println("Enter customer id.");
        customerId = AddInteger.addInteger();
        Customer customer = sessionUnit.getSession().get(Customer.class, customerId);
        System.out.println(customer);
        sessionUnit.closeTransaction();
    }

    public void update(){
        sessionUnit.openSession();
        sessionUnit.openTransaction();
        System.out.println("Enter customer id to update.");
        customerId = AddInteger.addInteger();
        Customer customer = sessionUnit.getSession().get(Customer.class, customerId);
        customerName = scanner.nextLine();
        customer.setCustomerName(customerName);
    }

    public void delete(){
        sessionUnit.openSession();
        sessionUnit.openTransaction();
        System.out.println("Enter customer id to delete");
        customerId = AddInteger.addInteger();
        Customer customer = sessionUnit.getSession().get(Customer.class, customerId);
        sessionUnit.getSession().delete(customer);
        sessionUnit.closeTransaction();
        System.out.println("Customer deleted.");
        
    }
}
