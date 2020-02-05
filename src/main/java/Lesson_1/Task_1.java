package Lesson_1;

//Есть массив целых чисел. Найти два наибольших значения в массиве

public class Task_1 {
    private static int ARRAYLENGTH = 20;
    private static int MININT = -6;
    private static int MAXINT = 50;
    public static void main(String[] args) {

            int[] myArray = new int[ARRAYLENGTH];
            for (int i = 0; i < myArray.length; i++) {
                myArray[i] = rnd(MININT, MAXINT);
            }

    }

    public static int rnd(int min, int max){
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
}

