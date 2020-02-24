package Lesson_3;

//      4 Дополнительная задача на сортировку. На плоскости с декартовыми координатами в точке (0; 0) стоит охотник вокруг
//        которого летают галки. Нам известно, что в данный момент времени галки находятся в точках с некоторыми
//        координатами вокруг охотника (координаты целочисленные).Нужно посчитать какое максимальное количество
//        галок может подстрелить охотник в этот момент времени.

import java.util.Arrays;

public class Task_1 {
    private static int ARRAYLENGTH = 60;
    private static int RADIUS = 2;

    public static void main(String[] args) {
        double[][] birdData = new double[ARRAYLENGTH][2];
        for (int i = 0; i < birdData.length; i++) {
            for (int j = 0; j < birdData[i].length; j++) {
                birdData[i][j] = (double) rnd (-RADIUS, RADIUS);
            }

        }
        System.out.println ("Выпускаем птичек:");
        System.out.println (Arrays.deepToString (birdData));
        System.out.println ("\nНа изготовку:");

        System.out.println ("\nПли!");
        System.out.printf ("Охотник подстрелил: %d", shotBird (atan (birdData)));

    }

    private static int shotBird(double[] atanArr) {
        int n=0;
        int frec=0;
        for(double temp:atanArr){
            double narr=frequensy(atanArr, temp);
            if(frec<narr){
                n= (int) temp;
                frec= (int) narr;
            }
        }

        return frec;
    }

    static int frequensy(double[] arr,double x){
        int n=0;
        for(double temp:arr){
            if(x==temp){
                n++;
            }
        }
        return n;
    }


    public static double[] atan(double[][] arr){
        double[] arrOut = new double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arrOut[i] = Math.atan2(arr[i][0],arr[i][1]);
            System.out.println ( Math.atan2(arr[i][0],arr[i][1]));
        }

        return arrOut;
    }

    public static int rnd(int min, int max){
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
}

