import DAO.*;

import java.util.Scanner;
import Utils.AddInteger;

public class MenuHolder {
    public void menu(){

        System.out.println("Make your choice.");
        System.out.println("1.Developers.");
        System.out.println("2.Skills");
        System.out.println("3.Projects");
        System.out.println("4. Customers");
        System.out.println("5. It Company");
        System.out.println("6. Exit app.");

        Scanner scanner = new Scanner(System.in);
        int choice = AddInteger.addInteger();
        switch (choice) {
            case (1) : {
                DevelopersDAO developersDAO = new DevelopersDAO();
                System.out.println("1. Create developer.");
                System.out.println("2. Add skill to developer.");
                System.out.println("3. Get developer by id.");
                System.out.println("4. Update developer.");
                System.out.println("5. Delete developer.");
                System.out.println("6. Get all developers.");
                choice = AddInteger.addInteger();
                switch (choice) {
                    case (1) : {
                        developersDAO.createDeveloper();
                        break;
                    }
                    case (2) : {
                        developersDAO.addSkill();
                        break;
                    }
                    case (3) : {
                        developersDAO.getById();
                        break;
                    }
                    case (4) : {
                        developersDAO.update();
                        break;
                    }
                    case (5) : {
                        developersDAO.delete();
                        break;
                    }
                    case (6) : {
                        developersDAO.getAll();
                        break;
                    }
                }
            }
            case (2) : {
                SkillDAO skillDAO = new SkillDAO();
                System.out.println("1. Create skill.");
                System.out.println("2. Get skill by id.");
                System.out.println("3. Update skill.");
                System.out.println("4. Delete skill.");
                System.out.println("5. Get all skills.");
                choice = AddInteger.addInteger();
                switch (choice){
                    case (1) : {
                        skillDAO.create();
                        break;
                    }
                    case (2) : {
                        skillDAO.getById();
                        break;
                    }
                    case (3) : {
                        skillDAO.update();
                        break;
                    }
                    case (4) : {
                        skillDAO.delete();
                        break;
                    }
                    case (5) : {
                        skillDAO.getAll();
                        break;
                    }

                }
            }

            case (3) : {
                ProjectDAO project = new ProjectDAO();
                System.out.println("1. Create project.");
                System.out.println("2. Appoint project to developer.");
                System.out.println("3. Get project by id.");
                System.out.println("4. Update project.");
                System.out.println("5. Delete project.");
                System.out.println("6. Get all projects.");
                choice = AddInteger.addInteger();

                switch (choice) {
                    case(1) : {
                        project.create();
                        break;
                    }
                    case (2) : {
                        project.appointProject();
                        break;
                    }
                    case (3) : {
                        project.getById();
                        break;
                    }
                    case (4) : {
                        project.update();
                        break;
                    }
                    case (5) : {
                        project.deleteProject();
                        break;
                    }
                    case (6) : {
                        project.getAll();
                        break;
                    }
                }
            }
            case(4) : {
                CustomerDAO customerDAO = new CustomerDAO();
                System.out.println("1. Create customer.");
                System.out.println("2. Order project.");
                System.out.println("3. Get customer by id.");
                System.out.println("4. Update customer.");
                System.out.println("5. Delete customer.");
                System.out.println("6. Get all customers.");
                choice = AddInteger.addInteger();

                switch (choice) {
                    case (1) : {
                        customerDAO.create();
                        break;
                    }
                    case (2) : {
                        customerDAO.orderProject();
                        break;
                    }
                    case (3) : {
                        customerDAO.getById();
                        break;
                    }
                    case (4) : {
                        customerDAO.update();
                        break;
                    }
                    case (5) : {
                        customerDAO.delete();
                        break;
                    }
                    case (6) : {
                        customerDAO.getAll();
                        break;
                    }
                }
            }
            case (5) : {
                ItCompanyDAO itCompanyDAO = new ItCompanyDAO();
                System.out.println("1. Create company.");
                System.out.println("2. Get company by id.");
                System.out.println("3. Update company.");
                System.out.println("4. Delete company.");
                System.out.println("5. Get all companies.");
                choice = AddInteger.addInteger();

                switch (choice) {
                    case (1) : {
                        itCompanyDAO.create();
                        break;
                    }
                    case (2) : {
                        itCompanyDAO.getByiD();
                        break;
                    }
                    case (3) : {
                        itCompanyDAO.update();
                        break;
                    }
                    case(4) : {
                        itCompanyDAO.delete();
                        break;
                    }
                    case (5) : {
                        itCompanyDAO.getAll();
                        break;
                    }
                }
            }

            case (6) : {
                System.exit(0);
            }
        }

    }
}
