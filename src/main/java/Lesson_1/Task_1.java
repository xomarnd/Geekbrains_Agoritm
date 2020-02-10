package Lesson_1;

//Есть массив целых чисел. Найти два наибольших значения в массиве

// Сложность - n

public class Task_1 {
    private static int ARRAYLENGTH = 20;
    private static int MININT = -6;
    private static int MAXINT = 50;
    public static void main(String[] args) {

            int[] myArray = new int[ARRAYLENGTH];
            for (int i = 0; i < myArray.length; i++) {
                myArray[i] = rnd(MININT, MAXINT);
            }
            twoMax(myArray);
    }
    public static void twoMax(int[] arr) {
        if (arr.length < 2) {
            System.out.println("Invalid array length");
            return;
        }

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        for (int i=0; i < arr.length; i++) {
            if (arr[i] > first) {
                second = first;
                first = arr[i];
            } else if (arr[i] > second && arr[i] != first) {
                second = arr[i];
            }
        }

        if (second == Integer.MIN_VALUE) {
            System.out.println("Нет второго максимального значения");
        } else {
            System.out.printf("Первое значение: " + first + "\nВторое значение: " + second);
        }
    }

    public static int rnd(int min, int max){
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
}

