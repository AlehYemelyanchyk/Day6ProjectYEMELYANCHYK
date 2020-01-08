package by.javatr.task01.service;

import by.javatr.task01.model.IntArray;

/**
 * @author Aleh Yemelyanchyk on 12/7/2019.
 */
public class IntArrayService {

    public int findMaxElement(IntArray intArray) {
        intArray.quickSort();
        int[] array = intArray.getIntArray();
        return array[array.length - 1];
    }

    public int findMinElement(IntArray intArray) {
        intArray.quickSort();
        int[] array = intArray.getIntArray();
        return array[0];
    }

    public IntArray findPrimeNumbers(IntArray intArray) {
        int[] array = intArray.getIntArray();
        int[] primeArray = new int[array.length];
        for (int i = 0; i < primeArray.length; i++) {
            if (isPrime(array[i])) {
                primeArray[i] = array[i];
            }
        }
        return new IntArray(trimToSize(primeArray));
    }

    public IntArray findFibonacciNumbers(IntArray intArray) {
        int maxElement = findMaxElement(intArray);
        int[] fibonacciArray = findFibonacci(intArray.getIntArray().length, maxElement);
        fibonacciArray = trimToSize(fibonacciArray);
        return new IntArray(fibonacciArray);
    }

    public IntArray findThreeDigitNumbersWithNoSameDigits(IntArray intArray) {
        int[] array = intArray.getIntArray();
        int[] threeDigitsArray = new int[array.length];
        int index = 0;
        for (int value : array) {
            if ((value >= 100 && value <= 999) && !hasSameDigits(value)) {
                threeDigitsArray[index++] = value;
            }
        }
        return new IntArray(trimToSize(threeDigitsArray));
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
