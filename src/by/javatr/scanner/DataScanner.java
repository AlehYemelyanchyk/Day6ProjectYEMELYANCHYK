package by.javatr.scanner;

import java.util.Scanner;

/**
 * @author Aleh Yemelyanchyk on 11/14/2019.
 */
public class DataScanner {

    private Scanner scanner = new Scanner(System.in);

    public int readInteger() {
        while (!scanner.hasNextInt()) {
            scanner.next();
        }
        return scanner.nextInt();
    }

    public double readDouble() {
        while (!scanner.hasNextDouble()) {
            scanner.next();
        }
        return scanner.nextDouble();
    }

    public String readString() {
        return scanner.nextLine();
    }
}
