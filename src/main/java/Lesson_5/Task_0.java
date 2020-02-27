package Lesson_5;

/**
 * 1. Написать программу по возведению числа в степень с помощью рекурсии.
 */

public class Task_0 {

    private static int exponentiation(int number, int power){
        if (power == 1){
            return number;
        }
            return exponentiation (number * number, power - 1);
    }
    public static void main(String[] args) {
        System.out.println (exponentiation(3, 2));
    }
}
