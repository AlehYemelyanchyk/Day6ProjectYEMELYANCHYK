package by.javatr.task01.model;

/**
 * @author Aleh Yemelyanchyk on 12/7/2019.
 */
public class IntArray {

    private static final int DEFAULT_INITIAL_CAPACITY = 10;
    private final int[] intArray;

    public IntArray() {
        this.intArray = new int[DEFAULT_INITIAL_CAPACITY];
    }

    public IntArray(int[] array) {
        this.intArray = array;
    }

    public IntArray(int initialCapacity) {
        if (initialCapacity > 0) {
            this.intArray = new int[initialCapacity];
        } else {
            throw new IllegalArgumentException("Illegal initial capacity: " +
                    initialCapacity + ". The valuer can not be less than 1.");
        }
    }

    public boolean contains(int element) {
        for (int i : intArray) {
            if (i == element) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the index of the first occurrence of the specified element.
     * in this list, or -1 if this list does not contain the element.
     */

    public int indexOf(int element) {
        for (int i = 0; i < intArray.length; i++) {
            if (i == element) {
                return i;
            }
        }
        return -1;
    }

    public int get(int index) {
        if (index < 0 || index >= intArray.length) {
            throw new IllegalArgumentException("The array doesn't have such index.");
        } else {
            return intArray[index];
        }
    }

    public int set(int index, int element) {
        if (index < 0 || index >= intArray.length) {
            throw new IllegalArgumentException("The array doesn't have such index.");
        } else {
            int oldElement = intArray[index];
            intArray[index] = element;
            return oldElement;
        }
    }

    public void mergeSort() {
        int[] sortedArray = mergeSort(intArray);
        copyArray(intArray, sortedArray, 0, intArray.length - 1);
    }

    public void quickSort() {
        int[] newArray = new int[intArray.length];
        quickSort(intArray, 0, intArray.length - 1);
        copyArray(intArray, newArray, 0, intArray.length - 1);
    }

    public void heapSort() {
        int[] newArray = new int[intArray.length];
        // Построение кучи (перегруппируем массив)
        for (int i = intArray.length / 2 - 1; i >= 0; i--) {
            heapify(intArray, intArray.length, i);
        }

        // Один за другим извлекаем элементы из кучи
        for (int i = intArray.length - 1; i >= 0; i--) {
            // Перемещаем текущий корень в конец
            int temp = intArray[0];
            intArray[0] = intArray[i];
            intArray[i] = temp;

            // Вызываем процедуру heapify на уменьшенной куче
            heapify(intArray, i, 0);
        }
        copyArray(intArray, newArray, 0, intArray.length - 1);
    }

    public int[] getIntArray() {
        return intArray.clone();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }

        IntArray newIntArray = (IntArray) object;
        return compareArrays(this.getIntArray(), newIntArray.getIntArray());
    }

    @Override
    public int hashCode() {
        return countArrayHashCode(this.getIntArray());
    }

    @Override
    public String toString() {
        return getClass().getName() + '@' + "intArray: [" + arrayToString(intArray) + ']';
    }

    private void heapify(int[] array, int arrayLength, int root) {
        int largest = root; // Инициализируем наибольший элемент как корень
        int leftChild = 2 * root + 1; // левый = 2*i + 1
        int rightChild = 2 * root + 2; // правый = 2*i + 2

        // Если левый дочерний элемент больше корня
        if (leftChild < arrayLength && array[leftChild] > array[largest]) {
            largest = leftChild;
        }

        // Если правый дочерний элемент больше, чем самый большой элемент на данный момент
        if (rightChild < arrayLength && array[rightChild] > array[largest]) {
            largest = rightChild;
        }
        // Если самый большой элемент не корень
        if (largest != root) {
            int swap = array[root];
            array[root] = array[largest];
            array[largest] = swap;

            // Рекурсивно преобразуем в двоичную кучу затронутое поддерево
            heapify(array, arrayLength, largest);
        }
    }

    private int[] mergeSort(int[] array) {
        if (array.length == 1) {
            return array;
        }

        int midIndex = array.length / 2;
        int[] left = new int[midIndex];
        int[] right = (array.length % 2 == 0) ? new int[midIndex] : new int[midIndex + 1];

        for (int i = 0; i < midIndex; i++) {
            left[i] = array[i];
        }

        for (int i = midIndex, j = 0; i < array.length; i++, j++) {
            right[j] = array[i];
        }

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    private int[] merge(int[] arrayLeft, int[] arrayRight) {
        int[] result = new int[arrayLeft.length + arrayRight.length];

        int leftPointer = 0;
        int rightPointer = 0;
        int resultPointer = 0;

        while ((resultPointer < result.length)) {
            if ((leftPointer < arrayLeft.length && rightPointer < arrayRight.length)) {
                result[resultPointer++] = (arrayLeft[leftPointer] < arrayRight[rightPointer])
                        ? arrayLeft[leftPointer++] : arrayRight[rightPointer++];
            } else if (leftPointer < arrayLeft.length) {
                result[resultPointer++] = arrayLeft[leftPointer++];
            } else {
                result[resultPointer++] = arrayRight[rightPointer++];
            }
        }
        return result;
    }

    private void quickSort(int[] source, int leftBorder, int rightBorder) {
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        int pivot = source[(leftMarker + rightMarker) / 2];
        do {
            while (source[leftMarker] < pivot) {
                leftMarker++;
            }
            while (source[rightMarker] > pivot) {
                rightMarker--;
            }
            if (leftMarker <= rightMarker) {
                if (leftMarker < rightMarker) {
                    int tmp = source[leftMarker];
                    source[leftMarker] = source[rightMarker];
                    source[rightMarker] = tmp;
                }
                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);

        if (leftMarker < rightBorder) {
            quickSort(source, leftMarker, rightBorder);
        }
        if (leftBorder < rightMarker) {
            quickSort(source, leftBorder, rightMarker);
        }
    }

    private String arrayToString(int[] array) {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            string.append(array[i]);
            string.append(((i + 1) < array.length) ? ", " : "");
        }
        return string.toString();
    }

    private boolean compareArrays(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            return false;
        }

        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }

    private int countArrayHashCode(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int hashCode = 1;
        for (int value : array) {
            hashCode = 31 * hashCode + value;
        }
        return hashCode;
    }

    private void copyArray(int[] arrayOld, int[] arrayNew, int startIndex, int endIndex) {
        for (int i = startIndex; i <= endIndex; i++) {
            arrayNew[i] = arrayOld[i];
        }
    }
}
