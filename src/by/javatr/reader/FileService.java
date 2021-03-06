package by.javatr.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Aleh Yemelyanchyk on 12/9/2019.
 */
public class FileService {

    public void readArrayFromFile(int [] array, String fileName) {
        int index = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                array[index] = Integer.parseInt(line);
                index++;
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("The file contains not only integers.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readTextFromFile(String fileName) throws FileNotFoundException {
        StringBuilder text = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                text.append(line);
                text.append("\n");
            }
        } catch (IllegalArgumentException e) {
            e.getMessage();
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text.toString();
    }
}
