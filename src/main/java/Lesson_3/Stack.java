package Lesson_3;

import java.util.NoSuchElementException;

public class Stack<T> {

    private int size = 0;
    private Object[] stack = new Object[1];

    //  вывести количество элиментов стеке
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //  изменение размера массива
    private void resize(int capacity) {
        Object[] temp = new Object[capacity];
        for (int i = 0; i < size; i++) {
            temp[i] = stack[i];
        }
        stack = temp;
    }

    //  удалить элемент
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T item = (T) stack[size-1];
        stack[size-1] = null;
        size--;
        if (size > 0 && size == stack.length / 4) {
            resize(stack.length / 2);
        }
        return item;
    }

    //  вставить элемент
    public void push(T item) {
        if (size == stack.length) {
            resize(2 * stack.length);
        }
        stack[size++] = item;
    }

    //  вывести крайний элемент
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException ();
        }
        return (T) stack[size-1];
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < size; i++) {
            s = s + stack[i] + ", ";
        }
        return s;
    }
}