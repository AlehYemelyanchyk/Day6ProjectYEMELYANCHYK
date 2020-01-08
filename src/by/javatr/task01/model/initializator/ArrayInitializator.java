package by.javatr.task01.model.initializator;

import by.javatr.reader.FileService;
import by.javatr.scanner.DataScanner;
import java.util.Random;

/**
 * @author Aleh Yemelyanchyk on 12/22/2019.
 */
public class ArrayInitializator {

    private DataScanner dataScanner = new DataScanner();
    private FileService fileService = new FileService();

    public void fillArrayFromConsole(int[] array) {
        int index = 0;
        while (index < array.length) {
            System.out.println("Enter a number: ");
            int number = dataScanner.readInteger();
            array[index++] = number;
        }
    }

    public void fillArrayFromFile(int[] array, String fileName) {
        fileService.readArrayFromFile(array, fileName);
    }

    public void fillArrayRandom(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt();
        }
    }
}
