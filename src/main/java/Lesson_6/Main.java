package Lesson_6;
/**
 * Урок 6. Деревья
 * Создать и запустить программу для построения двоичного дерева.
 * В цикле построить двадцать деревьев с глубиной в 6 уровней.
 * Данные, которыми необходимо заполнить узлы деревьев, представляются в виде чисел типа int.
 * Число, которое попадает в узел, должно генерироваться случайным образом в диапазоне от -100 до 100.
 */

import java.util.Random;


public class Main {

    private static final int TREE_COUNT = 30;
    private static final int MIN_VALUE = -100;
    private static final int MAX_VALUE = 100;
    private static final int TREE_HEIGHT = 6;

    public static void main(String[] args) {
        Random rn = new Random();
        int bound = MAX_VALUE - MIN_VALUE + 1;
        Tree<Integer, Integer> assArr = new Tree<>();

        int balancedCount = 0;

        int tmp;
        for (int i = 0; i < TREE_COUNT; i++) {
            while (assArr.heightOfBinaryTree() < TREE_HEIGHT) {
                tmp = rn.nextInt(bound);
                assArr.put(tmp, 10);
            }
            if(assArr.isBalance()){
                System.out.println("Balance: true");
                balancedCount++;
            }else {
                System.out.println("Balance: false");

            }

            System.out.println();
            assArr = new Tree<>();

        }
        System.out.printf("Получилось %d сбалансированных дерева из %d (%d%%)", balancedCount, TREE_COUNT, balancedCount * 100 / TREE_COUNT);
    }
}


