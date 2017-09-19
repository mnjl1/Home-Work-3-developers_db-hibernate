package connectToDatabase;

import java.util.Scanner;

public class Utils {
    public int addInteger(int number) {
        Scanner scanner = new Scanner(System.in);
        boolean isInteger = false;
        while (!isInteger) {
            try {
                number = Integer.parseInt(scanner.next());
                isInteger = true;
            }catch (NumberFormatException e){
                System.out.println("Not Integer!");
            }
        }
        return number;
    }
}
