package by.javatr.task02.service;

/**
 * @author Aleh Yemelyanchyk on 12/19/2019.
 */
public class LinesByLength extends AbstractBubbleSort {

    public LinesByLength(boolean sortUp) {
        super(sortUp);
    }

    @Override
    protected int[] createArrayOfArguments(int[][] intMultiArray) {
        int[] array = new int[intMultiArray.length];
        for (int i = 0; i < intMultiArray.length; i++) {
            array[i] = intMultiArray[i].length;
        }
        return array;
    }
}
