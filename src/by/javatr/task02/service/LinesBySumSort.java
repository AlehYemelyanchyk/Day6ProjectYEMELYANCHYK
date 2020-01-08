package by.javatr.task02.service;

/**
 * @author Aleh Yemelyanchyk on 12/18/2019.
 */
public class LinesBySumSort extends AbstractBubbleSort {
    public LinesBySumSort(boolean sortUp) {
        super(sortUp);
    }

    @Override
    protected int[] createArrayOfArguments(int[][] intMultiArray) {
        int[] array = new int[intMultiArray.length];
        for (int i = 0; i < intMultiArray.length; i++) {
            int sum = 0;
            for (int number : intMultiArray[i]) {
                sum += number;
            }
            array[i] = sum;
        }
        return array;
    }
}
