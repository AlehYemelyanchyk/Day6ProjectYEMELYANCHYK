package by.javatr.task02.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Aleh Yemelyanchyk on 12/11/2019.
 */
public class JaggedArrayServiceTest {

    private JaggedArrayService jaggedArrayService = new JaggedArrayService();
    private int[][] jaggedArray = new int[5][];

    @Before
    public void fillJaggedArray() {
        jaggedArray[0] = new int[]{3, 6, 23}; // 32
        jaggedArray[1] = new int[]{2, 6, 23, 86, 23}; // 140
        jaggedArray[2] = new int[]{32, 2}; // 34
        jaggedArray[3] = new int[]{65, 3, 76, 22}; // 166
        jaggedArray[4] = new int[]{65, 76, 23, 90, 5, 8}; // 267
    }

    @Test
    public void sortLinesUpBySumTest() {
        int[][] expected = new int[5][];
        expected[0] = new int[]{3, 6, 23};
        expected[1] = new int[]{32, 2};
        expected[2] = new int[]{2, 6, 23, 86, 23};
        expected[3] = new int[]{65, 3, 76, 22};
        expected[4] = new int[]{65, 76, 23, 90, 5, 8};
        jaggedArrayService.sortLinesUpAndDownBySum(true, jaggedArray);
        Assert.assertArrayEquals(expected, jaggedArray);
    }

    @Test
    public void sortLinesDownBySumTest() {
        int[][] expected = new int[5][];
        expected[0] = new int[]{65, 76, 23, 90, 5, 8};
        expected[1] = new int[]{65, 3, 76, 22};
        expected[2] = new int[]{2, 6, 23, 86, 23};
        expected[3] = new int[]{32, 2};
        expected[4] = new int[]{3, 6, 23};
        jaggedArrayService.sortLinesUpAndDownBySum(false, jaggedArray);
        Assert.assertArrayEquals(expected, jaggedArray);
    }

    @Test(expected = NullPointerException.class)
    public void sortLinesBySumNullArgumentTest() {
        jaggedArrayService.sortLinesUpAndDownBySum(false, null);
    }

    @Test
    public void sortLinesUpByMaxElementTest() {
        int[][] expected = new int[5][];
        expected[0] = new int[]{3, 6, 23};
        expected[1] = new int[]{32, 2};
        expected[2] = new int[]{65, 3, 76, 22};
        expected[3] = new int[]{2, 6, 23, 86, 23};
        expected[4] = new int[]{65, 76, 23, 90, 5, 8};
        jaggedArrayService.sortLinesUpAndDownByMaxElement(true, jaggedArray);
        Assert.assertArrayEquals(expected, jaggedArray);
    }

    @Test
    public void sortLinesDownByMaxElementTest() {
        int[][] expected = new int[5][];
        expected[0] = new int[]{65, 76, 23, 90, 5, 8};
        expected[1] = new int[]{2, 6, 23, 86, 23};
        expected[2] = new int[]{65, 3, 76, 22};
        expected[3] = new int[]{32, 2};
        expected[4] = new int[]{3, 6, 23};
        jaggedArrayService.sortLinesUpAndDownByMaxElement(false, jaggedArray);
        Assert.assertArrayEquals(expected, jaggedArray);
    }

    @Test(expected = NullPointerException.class)
    public void sortLinesByMaxElementNullArgumentTest() {
        jaggedArrayService.sortLinesUpAndDownByMaxElement(true, null);
    }

    @Test
    public void sortLinesUpByMinElementTest() {
        int[][] expected = new int[5][];
        expected[0] = new int[]{2, 6, 23, 86, 23};
        expected[1] = new int[]{32, 2};
        expected[2] = new int[]{3, 6, 23};
        expected[3] = new int[]{65, 3, 76, 22};
        expected[4] = new int[]{65, 76, 23, 90, 5, 8};
        jaggedArrayService.sortLinesUpAndDownByMinElement(true, jaggedArray);
        Assert.assertArrayEquals(expected, jaggedArray);
    }

    @Test
    public void sortLinesDownByMinElementTest() {
        int[][] expected = new int[5][];
        expected[0] = new int[]{65, 76, 23, 90, 5, 8};
        expected[1] = new int[]{3, 6, 23};
        expected[2] = new int[]{65, 3, 76, 22};
        expected[3] = new int[]{2, 6, 23, 86, 23};
        expected[4] = new int[]{32, 2};
        jaggedArrayService.sortLinesUpAndDownByMinElement(false, jaggedArray);
        Assert.assertArrayEquals(expected, jaggedArray);
    }

    @Test(expected = NullPointerException.class)
    public void sortLinesByMinElementNullArgumentTest() {
        jaggedArrayService.sortLinesUpAndDownByMinElement(true, null);
    }
}