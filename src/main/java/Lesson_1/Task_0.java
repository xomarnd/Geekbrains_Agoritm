package Lesson_1;

//  Есть массив целых чисел. Найти все тройки чисел, которые в сумме дают ноль.

// Сложность - O(n3)

public class Task_0 {
    private static int ARRAYLENGTH = 60;
    private static int MININT = 20;
    private static int MAXINT = -3;

    public static void main(String[] args) {
        int[] myArray = new int[ARRAYLENGTH];
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = rnd(MININT, MAXINT);
        }

        sum(myArray);

    }
    private static void sum(int[] arr){
        int count = 0;
        for (int a = 0; a < arr.length; a++) {
            for (int b = a + 1; b < arr.length; b++) {
                for (int c = b + 1; c < arr.length; c++) {
                    if(arr[a] + arr[b] + arr[c] == 0){
                        count++;
                        System.out.println (arr[a] + "+" + arr[b] + "+" + arr[c] + " = 0;");
                    }
                }
            }
        }
        if (count == 0){
            System.out.println ("Нет результата");
        }else{
            System.out.println ("\nНайдено: " + count);
        }
    }

    public static int rnd(int min, int max){
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
}
