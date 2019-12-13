package by.javatr.task01.model;

/**
 * @author Aleh Yemelyanchyk on 12/7/2019.
 */
public class MyIntArray {

    private static final int DEFAULT_INITIAL_CAPACITY = 10;
    private int[] intArray;
    /**
     * Empty integer array instance used for empty instances.
     */
    private static final int[] EMPTY_ELEMENT_DATA = {};

    public MyIntArray() {
        this.intArray = new int[DEFAULT_INITIAL_CAPACITY];
    }

    public MyIntArray(int initialCapacity) {
        if (initialCapacity > 0) {
            this.intArray = new int[initialCapacity];
        } else if (initialCapacity == 0) {
            this.intArray = EMPTY_ELEMENT_DATA;
        } else {
            throw new IllegalArgumentException("Illegal initial capacity: " +
                    initialCapacity + ". It can not be negative value.");
        }
    }

    public MyIntArray(int[] arrayOfIntegers) {
        setIntArray(arrayOfIntegers);
    }

    public int[] getIntArray() {
        return intArray;
    }

    public void setIntArray(int[] arrayOfIntegers) {
        this.intArray = ((arrayOfIntegers == null)) ? new int[DEFAULT_INITIAL_CAPACITY] : arrayOfIntegers;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }

        MyIntArray newIntArray = (MyIntArray) object;
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

    private String arrayToString(int[] array) {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            string.append(array[i]);
            string.append(((i + 1) < array.length) ? ", " : "");
        }
        return string.toString();
    }
}
