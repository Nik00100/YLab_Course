import java.io.*;
import java.util.*;

public class RandomGen {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static int next = 1;
    // диапазон псевдослучайных чисел от -randMax до randMax
    private static int randMax;

    public static void setRandMax(int randMax) {
        RandomGen.randMax = randMax;
    }

    // генератор псевдослучайных чисел
    public static int getNextRandom() {
        next = next * 1103515245 + 12345;
        return (next/65536) % (randMax + 1);
    }

    // считать число с консоли
    public static int readInt() {
        while (true) {
            try {
                Integer result = Integer.parseInt(reader.readLine());
                if (result != null) return result;
            } catch (NumberFormatException | IOException e) {
                System.out.println("Произошла ошибка при попытке ввода числа. Попробуйте еще раз.");
            }
        }
    }

    // заполнить двумерный массив размерностью [n][n]
    public static Integer[][] fillArray (int n) {
        Integer[][] array = new Integer[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                array[i][j] = getNextRandom();
            }
        }
        return array;
    }

    // минимальное значение
    public static int getMinimumValueFromArray(Integer[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<array.length; i++) {
            list.add(Collections.min(Arrays.asList(array[i])));
        }
        return Collections.min(list);
    }

    // максимальное значение
    public static int getMaximumValueFromArray(Integer[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<array.length; i++) {
            list.add(Collections.max(Arrays.asList(array[i])));
        }
        return Collections.max(list);
    }

    // среднее арифметическое значение элементов в массиве
    public static double getAverageValueFromArray(Integer[][] array) {
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        int quantity = array.length*array.length;
        // вычисляем сумму всех элементов массива
        for (int i=0; i<array.length; i++) {
            list.add(Arrays.asList(array[i]).stream().mapToInt(Integer::intValue).sum());
        }
        sum = list.stream().mapToInt(Integer::intValue).sum();
        return (double) sum/quantity;
    }

    // вывод элементов массива в консоль
    public static void printArray(Integer[][] array) {
        for (int i=0; i<array.length; i++){
            for (int j=0; j<array.length; j++) {
                System.out.printf(array[i][j] + "   ");
                if (j == array.length-1) {
                    System.out.println();
                    System.out.println();
                }
            }
        }
    }

    public static void main(String[] args)
    {
        System.out.println("Введите число n - размерность массива " +
                "(будет сформирован двумерный массив размером) [n][n]");
        int n = readInt();

        System.out.println("Введите число randMax - диапазон псевдослучайных чисел от -randMax до randMax");
        setRandMax(readInt());
        // заполняем массив
        Integer[][] array = fillArray(n);

        System.out.println();
        System.out.printf("Полученный массив размерностью [%d][%d]:",n,n);
        System.out.println();
        printArray(array);

        System.out.println("Минимальное значение массива:");
        System.out.println(getMinimumValueFromArray(array));

        System.out.println("Максимальное значение массива:");
        System.out.println(getMaximumValueFromArray(array));

        System.out.println("Среднее арифметическое значение элементов массива:");
        System.out.println(getAverageValueFromArray(array));
    }
}