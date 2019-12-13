package by.javatr.task02.service;

/**
 * @author Aleh Yemelyanchyk on 12/9/2019.
 */

public class JaggedArrayService {

    public void sortLinesUpAndDownBySum(boolean sortUp, int[][] multiArray) throws NullPointerException {
        int previousLineSum;
        int lineSum = 0;

        boolean quit = false;
        while (!quit) {
            quit = true;
            for (int i = 0; i < multiArray.length; i++) {
                previousLineSum = lineSum;
                lineSum = 0;
                for (int j = 0; j < multiArray[i].length; j++) {
                    lineSum += multiArray[i][j];
                }
                quit = isQuit(sortUp, multiArray, previousLineSum, lineSum, quit, i);
            }
        }
    }

    public void sortLinesUpAndDownByMaxElement(boolean sortUp, int[][] multiArray) throws NullPointerException {
        sortByMaxOrMin(sortUp, multiArray, true);
    }

    public void sortLinesUpAndDownByMinElement(boolean sortUp, int[][] multiArray) throws NullPointerException {
        sortByMaxOrMin(sortUp, multiArray, false);
    }

    private void sortByMaxOrMin(boolean sortUp, int[][] multiArray, boolean maxElement) {
        int element = (maxElement) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        int previousLineElement;

        boolean quit = false;
        while (!quit) {
            quit = true;
            for (int i = 0; i < multiArray.length; i++) {
                previousLineElement = element;
                element = (maxElement) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                for (int j = 0; j < multiArray[i].length; j++) {
                    if (maxElement) {
                        element = (multiArray[i][j] > element) ? multiArray[i][j] : element;
                    } else {
                        element = (multiArray[i][j] < element) ? multiArray[i][j] : element;
                    }
                }
                quit = isQuit(sortUp, multiArray, previousLineElement, element, quit, i);
            }
        }
    }

    private boolean isQuit(boolean sortUp, int[][] multiArray, int previousElement, int element, boolean quit, int index) {
        if (sortUp && index > 0 && element < previousElement) {
            swapLines(multiArray, index);
            quit = false;
        } else if (!sortUp && index > 0 && element > previousElement) {
            swapLines(multiArray, index);
            quit = false;
        }
        return quit;
    }

    private void swapLines(int[][] multiArray, int i) {
        int[] temp = multiArray[i];
        multiArray[i] = multiArray[i - 1];
        multiArray[i - 1] = temp;
    }
}
