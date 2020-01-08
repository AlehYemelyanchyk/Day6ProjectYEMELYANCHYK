package by.javatr.task02.service;

/**
 * @author Aleh Yemelyanchyk on 12/18/2019.
 */
public abstract class AbstractBubbleSort implements Transformator {

    private boolean sortUp;

    protected AbstractBubbleSort(boolean sortUp) {
        this.sortUp = sortUp;
    }

    @Override
    public void sort(int[][] intMultiArray) {

        int[] arrayOfArguments = createArrayOfArguments(intMultiArray);

        boolean quit = false;
        while (!quit) {
            quit = true;
            for (int i = 1; i < intMultiArray.length; i++) {
                boolean compareCondition = (sortUp) ? arrayOfArguments[i] < arrayOfArguments[i - 1]
                        : arrayOfArguments[i] > arrayOfArguments[i - 1];
                if (compareCondition) {
                    swap(intMultiArray, i);
                    swap(arrayOfArguments, i);
                    quit = false;
                }
            }
        }
    }

    protected abstract int[] createArrayOfArguments(int[][] intMultiArray);

    private void swap(int[][] multiArray, int i) {
        int[] temp = multiArray[i];
        multiArray[i] = multiArray[i - 1];
        multiArray[i - 1] = temp;
    }

    private void swap(int[] multiArray, int i) {
        int temp = multiArray[i];
        multiArray[i] = multiArray[i - 1];
        multiArray[i - 1] = temp;
    }
}
