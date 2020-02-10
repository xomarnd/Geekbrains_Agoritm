package Lesson_2;

//    1. Создать массив большого размера (миллион элементов).
//    2. Написать методы удаления, добавления, поиска элемента массива.
//    3. Заполнить массив случайными числами.
//    4. Написать методы, реализующие рассмотренные виды сортировок, и проверить скорость выполнения каждой.

import java.util.Arrays;
import java.util.stream.Stream;

public class Task_0 {
    private static int ARRAYLENGTH = 1_000_000;
    private static int MININT = 1000;
    private static int MAXINT = -1000;

    public static void main(String[] args) {
        int[] myArray = new int[ARRAYLENGTH];
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = rnd(MININT, MAXINT);
        }

        printTime( myArray, "insertion");
        printTime( myArray, "selection");
        printTime( myArray, "Bubble");

        printTime( myArray, "Buble");
    }

    //  Del item.
    private int[] deleteItemArray(int[] array, int index){
        Integer[] ar = new Integer[array.length];
        for( int i = 0; i < array.length; i++ ) ar[i] = array[ i ];

        return Arrays.stream(Stream.concat(Arrays.stream(ar).limit(index), Arrays.stream(ar).skip(index+1))
                .toArray(Integer[]::new)).mapToInt(Integer::intValue).toArray();
    }

    //  Add item.
    public static int[] addItemArray(int[] array, int element) {
        final int n = array.length;
        array = Arrays.copyOf( array, n + 1 );
        array[n] = element;
        return array;
    }

    //  Search element.
    public static void searchElement(int[] array, int element) {
        boolean searched = Arrays.stream( array ).anyMatch( a -> element == a );
        System.out.println(element);
    }

    //  Sort insertion.
    public static void sortInsert(int[] array) {
        int out, in;
        for (out = 1; out < array.length; out++) {
            int temp = array[out];
            in = out;
            while (in > 0 && array[in - 1] >= temp) {
                array[in] = array[in - 1];
                --in;
            }
            array[in] = temp;
        }
    }

    //  Sort selection
    public static void sortSelect(int[] array) {
        int out, in, mark;
        for (out = 0; out < array.length; out++) {
            mark = out;
            for (in = out + 1; in < array.length; in++) {
                if (array[in] < array[mark]) {
                    mark = in;
                }
            }
            int tmp = array[out];
            array[out] = array[mark];
            array[mark] = tmp;
        }
    }

    //  Sort bubble
    public static void sortBubble(int[] array) {
        int out, in;
        for (out = array.length - 1; out > 1; out--) {
            for (in = 0; in < out; in++) {
                if (array[in] > array[in + 1]) {
                    int tmp = array[in];
                    array[in] = array[in + 1];
                    array[in + 1] = tmp;
                }
            }
        }
    }


    public static int rnd(int min, int max){
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    private static void printTime(int[] array, String sortTipe) {
        long startTime = System.currentTimeMillis ();

        if (sortTipe.toLowerCase ().equals ("insertion")){
            sortInsert( array );
            System.out.println("Insertion sort: " + ( System.currentTimeMillis() - startTime) + " ms.");
        }else if (sortTipe.toLowerCase ().equals ("selection")){
            sortSelect( array );
            System.out.println("Selection sort: " + ( System.currentTimeMillis() - startTime) + " ms.");
        }else if (sortTipe.toLowerCase ().equals ("bubble")){
            sortBubble( array );
            System.out.println("Bubble sort: " + ( System.currentTimeMillis() - startTime) + " ms.");
        }else {
            System.err.println ("Не верный тип сортировки: " + sortTipe);
        }


    }
}