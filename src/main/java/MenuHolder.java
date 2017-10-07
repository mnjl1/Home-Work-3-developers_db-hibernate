import DAO.DevelopersDAO;

import java.util.Scanner;

public class MenuHolder {
    public void menu(){

        System.out.println("Make your choice.");
        System.out.println("1.Developers.");
        System.out.println("2.Skill");
        System.out.println("3.It Company");
        System.out.println("4. Customer");
        System.out.println("5. Projects");
        System.out.println("6. Exit app.");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case (1) : {
                DevelopersDAO developersDAO = new DevelopersDAO();
                System.out.println("1. Create developer.");
                System.out.println("2. Add skill to developer.");
                System.out.println("3. Get developer by id.");
                System.out.println("4. Update developer.");
                System.out.println("5. Delete developer.");
                System.out.println("6. Get all developers.");
                choice = scanner.nextInt();
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

            }
        }
    }
}
