package by.javatr.task01.service;

import by.javatr.reader.FileService;
import by.javatr.scanner.DataScanner;
import by.javatr.task01.model.MyIntArray;

import java.util.Random;

/**
 * @author Aleh Yemelyanchyk on 12/7/2019.
 */
public class MyIntArrayService {

    private DataScanner dataScanner = new DataScanner();
    private FileService fileService = new FileService();

    public void fillArrayFromConsole(MyIntArray intArray) {
        int[] array = intArray.getIntArray();
        int index = 0;
        while (index < array.length) {
            System.out.println("Enter a number: ");
            int number = dataScanner.readInteger();
            add(array, number, index++);
        }
        intArray.setIntArray(array);
    }

    public void fillArrayFromFile(MyIntArray intArray, String fileName) {
        fileService.readArrayFromFile(intArray, fileName);
    }

    public void fillArrayRandom(MyIntArray intArray) {
        Random random = new Random();
        int[] array = intArray.getIntArray();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt();
        }
    }

    private boolean add(int[] array, int number, int index) {
        array[index] = number;
        return true;
    }

    public void mergeSort(MyIntArray intArray) {
        intArray.setIntArray(mergeSort(intArray.getIntArray()));
    }

    public void quickSort(MyIntArray intArray) {
        int[] array = intArray.getIntArray();
        quickSort(array, 0, array.length - 1);
        intArray.setIntArray(array);
    }

    public void heapSort(MyIntArray intArray) {
        int[] array = intArray.getIntArray();

        // Построение кучи (перегруппируем массив)
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            heapify(array, array.length, i);
        }

        // Один за другим извлекаем элементы из кучи
        for (int i = array.length - 1; i >= 0; i--) {
            // Перемещаем текущий корень в конец
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // Вызываем процедуру heapify на уменьшенной куче
            heapify(array, i, 0);
        }
    }

    private void heapify(int array[], int arrayLength, int root) {
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

    public boolean contains(MyIntArray intArray, int element) {
        quickSort(intArray);
        int[] array = intArray.getIntArray();

        int firstIndex = 0;
        int lastIndex = array.length - 1;

        while (firstIndex <= lastIndex) {
            int middleIndex = (firstIndex + lastIndex) / 2;

            if (array[middleIndex] == element) {
                return true;
            } else if (array[middleIndex] < element) {
                firstIndex = middleIndex + 1;
            } else if (array[middleIndex] > element) {
                lastIndex = middleIndex - 1;
            }
        }
        return false;
    }

    public int findMaxElement(MyIntArray intArray) {
        quickSort(intArray);
        int[] array = intArray.getIntArray();
        return array[array.length - 1];
    }

    public int findMinElement(MyIntArray intArray) {
        quickSort(intArray);
        int[] array = intArray.getIntArray();
        return array[0];
    }

    public MyIntArray findPrimeNumbers(MyIntArray intArray) {
        int[] array = intArray.getIntArray();
        int[] primeArray = new int[array.length];
        for (int i = 0; i < primeArray.length; i++) {
            if (isPrime(array[i])) {
                primeArray[i] = array[i];
            }
        }
        return new MyIntArray(trimToSize(primeArray));
    }

    public MyIntArray findFibonacciNumbers(MyIntArray intArray) {
        int maxElement = findMaxElement(intArray);
        int[] fibonacciArray = findFibonacci(intArray.getIntArray().length, maxElement);
        fibonacciArray = trimToSize(fibonacciArray);
        return new MyIntArray(fibonacciArray);
    }

    public MyIntArray findThreeDigitNumbersWithNoSameDigits(MyIntArray intArray) {
        int[] array = intArray.getIntArray();
        int[] threeDigitsArray = new int[array.length];
        int index = 0;
        for (int value : array) {
            if ((value >= 100 && value <= 999) && !hasSameDigits(value)) {
                threeDigitsArray[index++] = value;
            }
        }
        intArray.setIntArray(trimToSize(threeDigitsArray));
        return intArray;
    }

    private void copyArray(int[] arrayOld, int[] arrayNew, int startIndex, int endIndex) {
        for (int i = startIndex; i <= endIndex; i++) {
            arrayNew[i] = arrayOld[i];
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

    private int[] trimToSize(int[] primeArray) {
        int amountOfEmptyBuckets = 0;
        for (int value : primeArray) {
            if (value == 0) {
                amountOfEmptyBuckets++;
            }
        }

        int[] trimmedArray = new int[primeArray.length - amountOfEmptyBuckets];
        int trimmedArrayIndex = 0;
        for (int value : primeArray) {
            if (value != 0) {
                trimmedArray[trimmedArrayIndex++] = value;
            }
        }
        return trimmedArray;
    }

    private boolean isPrime(int number) {
        if (number == 1) {
            return false;
        }

        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private int[] findFibonacci(int arrayLength, int maxElement) {
        int[] array = new int[arrayLength];
        int index = 0;
        array[index++] = 0;
        array[index++] = 1;
        while (array[index - 1] < maxElement) {
            array[index] = array[index - 1] + array[index - 2];
            index++;
            if (index == arrayLength) {
                array = findFibonacci(arrayLength * 2, maxElement);
            }
        }
        array[index - 1] = 0;
        return array;
    }

    private int[] splitNumberToDigits(int number) {
        String str = "" + number;
        int[] digits = new int[str.length()];
        for (int i = 0; i < digits.length; i++) {
            digits[i] = number % 10;
            number /= 10;
        }
        return digits;
    }

    private boolean hasSameDigits(int number) {
        int[] digits = splitNumberToDigits(number);
        for (int value : digits) {
            int match = 0;
            for (int valueCompareTo : digits) {
                if (value == valueCompareTo) {
                    match++;
                    if (match > 1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
