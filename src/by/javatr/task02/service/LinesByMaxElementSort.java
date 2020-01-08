package by.javatr.task02.service;

/**
 * @author Aleh Yemelyanchyk on 12/19/2019.
 */
public class LinesByMaxElementSort extends AbstractBubbleSort {

    public LinesByMaxElementSort(boolean sortUp) {
        super(sortUp);
    }

    @Override
    protected int[] createArrayOfArguments(int[][] intMultiArray) {
        int[] array = new int[intMultiArray.length];
        for (int i = 0; i < intMultiArray.length; i++) {
            int maxElement = Integer.MIN_VALUE;
            for (int number : intMultiArray[i]) {
                if (maxElement < number) {
                    maxElement = number;
                }
            }
            array[i] = maxElement;
        }
        return array;
    }
}