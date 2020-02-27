package Lesson_3;

import java.util.NoSuchElementException;

public class Queue<T> {

    private int size = 0;   //  размер очереди
    private int start = 0;
    private int end = 0;

    private Object[] queue = new Object[1];

    //  вывести количество элиментов очереди
    public int size() {
        return size;
    }

    //  изменение размера массива
    private void resize(int capacity) {
        Object[] temp = new Object[capacity];
        for (int i = 0; i < size; i++) {
            temp[i] = queue[(start + i) % size];
        }
        queue = temp;
        start = 0;
        end = size;
    }

    //  проверка на отсутсвие очереди
    public boolean isEmpty() {
        return size == 0;
    }

    //  поместить элемент в конец очереди
    public void enqueue(T item) {
        if (size == queue.length) {
            resize(2 * queue.length);
        }
        queue[end++] = item;
        size++;
    }

    //  удалить первый элемент
    public T decqueue() {
        if (isEmpty()) {
            throw new NoSuchElementException ();
        }
        T item = (T) queue[start];
        queue[start] = null;
        size--;
        start++;
        start %= queue.length;
        if (size > 0 && size == queue.length / 4) {
            resize(queue.length / 2);
        }
        return item;
    }

    //  вывести первый элемент
    public T peekFront() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return (T) queue[start];
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < size; i++) {
            s = s + queue[(start + i) % queue.length] + ", ";
        }
        return s;
    }

}