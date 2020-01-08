package by.javatr.task02.service;

/**
 * @author Aleh Yemelyanchyk on 12/19/2019.
 */
public class LinesByMinElementSort extends AbstractBubbleSort {

    public LinesByMinElementSort(boolean sortUp) {
        super(sortUp);
    }

    @Override
    protected int[] createArrayOfArguments(int[][] intMultiArray) {
        int[] array = new int[intMultiArray.length];
        for (int i = 0; i < intMultiArray.length; i++) {
            int minElement = Integer.MAX_VALUE;
            for (int number : intMultiArray[i]) {
                if (minElement > number) {
                    minElement = number;
                }
            }
            array[i] = minElement;
        }
        return array;
    }
}
