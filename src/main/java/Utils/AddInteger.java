package Utils;

import java.util.Scanner;

public class AddInteger {
    public static int addInteger(){
        int intNumber = 0;
        Scanner scanner = new Scanner(System.in);
        boolean isInteger = false;
        while (!isInteger){
            try {
                intNumber = Integer.parseInt(scanner.next());
                isInteger = true;
            }catch (NumberFormatException e){
                System.out.println("Not integer, try again!");
            }
        }
        return intNumber;
    }
}
