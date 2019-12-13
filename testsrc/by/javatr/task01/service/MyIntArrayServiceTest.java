package by.javatr.task01.service;

import by.javatr.task01.model.MyIntArray;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Aleh Yemelyanchyk on 12/7/2019.
 */
public class MyIntArrayServiceTest {

    private int[] array;
    private MyIntArray myIntArray;
    private MyIntArrayService myIntArrayService;

    @Before
    public void createIntArray() {
        array = new int[]{5, 3, 323, 123, 76, 1, 432, 59, 159, 8, 1000};
        myIntArrayService = new MyIntArrayService();
        myIntArray = new MyIntArray(array);
    }

    @Test
    public void fillArrayFromConsole() {
    }

    @Test (expected = IllegalArgumentException.class)
    public void fillArrayFromFileIllegalArgumentTest() {
        myIntArrayService.fillArrayFromFile(new MyIntArray(10), "ArrayStrings.txt");
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void fillArrayFromFileOutOfBoundsTest() {
        myIntArrayService.fillArrayFromFile(new MyIntArray(10), "Array.txt");
    }

    @Test
    public void fillArrayFromFileTest() {
        int[] expectedArray = {5, 3, 323, 123, 76, 1, 432, 59, 159, 8, 1000};
        MyIntArray expected = new MyIntArray(expectedArray);
        MyIntArray actual = new MyIntArray(11);
        myIntArrayService.fillArrayFromFile(actual, "Array.txt");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void fillArrayRandom() {
        int[] newArray = array.clone();
        MyIntArray newMyIntArray = new MyIntArray(newArray);
        myIntArrayService.fillArrayRandom(newMyIntArray);
        int[] expected = array;
        Assert.assertNotNull(expected);
        int[] actual = newMyIntArray.getIntArray();
        Assert.assertNotNull(actual);
        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void mergeSort() {
        int[] expectedArray = {1, 3, 5, 8, 59, 76, 123, 159, 323, 432, 1000};
        MyIntArray expected = new MyIntArray(expectedArray);
        myIntArrayService.mergeSort(myIntArray);
        Assert.assertEquals(expected, myIntArray);
    }

    @Test
    public void quickSort() {
        int[] expectedArray = {1, 3, 5, 8, 59, 76, 123, 159, 323, 432, 1000};
        MyIntArray expected = new MyIntArray(expectedArray);
        myIntArrayService.quickSort(myIntArray);
        Assert.assertEquals(expected, myIntArray);
    }

    @Test
    public void heapSort() {
        int[] expectedArray = {1, 3, 5, 8, 59, 76, 123, 159, 323, 432, 1000};
        MyIntArray expected = new MyIntArray(expectedArray);
        myIntArrayService.quickSort(myIntArray);
        Assert.assertEquals(expected, myIntArray);
    }

    @Test
    public void findMaxElementTest() {
        int expected = 1000;
        int actual = myIntArrayService.findMaxElement(myIntArray);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findMinElementTest() {
        int expected = 1;
        int actual = myIntArrayService.findMinElement(myIntArray);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findPrimeNumbersTest() {
        int[] expectedArray = {5, 3, 59};
        MyIntArray expected = new MyIntArray(expectedArray);
        MyIntArray actual = myIntArrayService.findPrimeNumbers(myIntArray);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findFibonacciNumbersTest() {
        int[] expectedArray = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987};
        MyIntArray expected = new MyIntArray(expectedArray);
        MyIntArray actual = myIntArrayService.findFibonacciNumbers(myIntArray);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findThreeDigitNumbersWithNoSameDigitsTest() {
        int[] expectedArray = {123, 432, 159};
        MyIntArray expected = new MyIntArray(expectedArray);
        MyIntArray actual = myIntArrayService.findThreeDigitNumbersWithNoSameDigits(myIntArray);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void contains() {
        int[] result = myIntArray.getIntArray();
        int number = 123;
        Assert.assertNotNull(result);
        Assert.assertTrue(myIntArrayService.contains(myIntArray, number));
    }
}