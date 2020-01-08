package by.javatr.task01.service;

import by.javatr.task01.model.IntArray;
import by.javatr.task01.model.initializator.ArrayInitializator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Aleh Yemelyanchyk on 12/7/2019.
 */
public class IntArrayServiceTest {

    private int[] array;
    private IntArray intArray;
    private IntArrayService intArrayService;
    private ArrayInitializator initializator;

    @Before
    public void createIntArray() {
        array = new int[]{5, 3, 323, 123, 76, 1, 432, 59, 159, 8, 1000};
        intArrayService = new IntArrayService();
        intArray = new IntArray(array);
    }

    @Test
    public void fillArrayFromConsole() {
    }

    @Test (expected = IllegalArgumentException.class)
    public void fillArrayFromFileIllegalArgumentTest() {
        initializator.fillArrayFromFile(array, "ArrayStrings.txt");
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void fillArrayFromFileOutOfBoundsTest() {
        initializator.fillArrayFromFile(new int[10], "Array.txt");
    }

    @Test
    public void fillArrayFromFileTest() {
//        int[] expectedArray = {5, 3, 323, 123, 76, 1, 432, 59, 159, 8, 1000};
//        IntArray expected = new IntArray(expectedArray);
//        IntArray actual = new IntArray(11);
//        initializator.fillArrayFromFile(actual, "Array.txt");
//        Assert.assertEquals(expected, actual);
    }

    @Test
    public void fillArrayRandom() {
//        int[] newArray = array.clone();
//        initializator.fillArrayRandom(array);
//        int[] expected = array;
//        Assert.assertNotNull(actual);
//        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void mergeSort() {
//        int[] expectedArray = {1, 3, 5, 8, 59, 76, 123, 159, 323, 432, 1000};
//        IntArray expected = new IntArray(expectedArray);
//        intArrayService.mergeSort(intArray);
//        Assert.assertEquals(expected, intArray);
    }

    @Test
    public void quickSort() {
//        int[] expectedArray = {1, 3, 5, 8, 59, 76, 123, 159, 323, 432, 1000};
//        IntArray expected = new IntArray(expectedArray);
//        intArrayService.quickSort(intArray);
//        Assert.assertEquals(expected, intArray);
    }

    @Test
    public void heapSort() {
//        int[] expectedArray = {1, 3, 5, 8, 59, 76, 123, 159, 323, 432, 1000};
//        IntArray expected = new IntArray(expectedArray);
//        intArrayService.quickSort(intArray);
//        Assert.assertEquals(expected, intArray);
    }

    @Test
    public void findMaxElementTest() {
        int expected = 1000;
        int actual = intArrayService.findMaxElement(intArray);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findMinElementTest() {
        int expected = 1;
        int actual = intArrayService.findMinElement(intArray);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findPrimeNumbersTest() {
        int[] expectedArray = {5, 3, 59};
        IntArray expected = new IntArray(expectedArray);
        IntArray actual = intArrayService.findPrimeNumbers(intArray);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findFibonacciNumbersTest() {
        int[] expectedArray = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987};
        IntArray expected = new IntArray(expectedArray);
        IntArray actual = intArrayService.findFibonacciNumbers(intArray);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findThreeDigitNumbersWithNoSameDigitsTest() {
        int[] expectedArray = {123, 432, 159};
        IntArray expected = new IntArray(expectedArray);
        IntArray actual = intArrayService.findThreeDigitNumbersWithNoSameDigits(intArray);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void contains() {
//        int[] result = intArray.getIntArray();
//        int number = 123;
//        Assert.assertNotNull(result);
//        Assert.assertTrue(intArrayService.contains(intArray, number));
    }
}