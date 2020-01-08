package by.javatr.task01.runner;

//Создание типа Array, который является классом оболочкой над массивом целого типа.
//В данном типе должны быть реализованы конструкторы (позволяющие несколькими способами создавать
//объекты типа), get-ы, set-ы и переопределенные методы класса Object (toString(), equals(), hasCode()).
//Программа должна иметь следующие возможности:
//    1. Сортировать массив тремя способами.
//    2. Осуществлять поиск элемента массива (использовать алгоритм бинарного поиска).
//    3. Нахождение максимального и минимального элемента массива.
//    4. Получить все простые числа находящиеся в массиве.
//    5. Получить все числа Фибонначчи находящиеся в массиве.
//    6. Получить все трехзначные числа, в десятичной записи которых нет одинаковых цифр.
//    7. Заполнения элементов массива и с консоли, и с файла и с помощью генерации случайных чисел.

import by.javatr.task01.model.IntArray;
import by.javatr.task01.model.initializator.ArrayInitializator;
import by.javatr.task01.service.IntArrayService;

/**
 * @author Aleh Yemelyanchyk on 12/7/2019.
 */
public class Task01Run {

    private static ArrayInitializator initializator = new ArrayInitializator();
    private static IntArrayService service = new IntArrayService();

    public static void main(String[] args) {
        int[] array = new int[8];
        initializator.fillArrayRandom(array);

        IntArray intArray = new IntArray(array);
        service.findFibonacciNumbers(intArray);
    }
}
