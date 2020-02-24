package Lesson_3;


import java.util.NoSuchElementException;

public class Deque<T> {

    int size = 0;   //рамер Дека
    int head = 0;   //индек начально элемента
    int tail = 0;   //индек последнего элемента

    private Object[] Deque = new Object[1000];

    // возвращаем размер дека
    public int size() {
        return size;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    // добавление в конец очереди
    public void PushBack(T value){
        if (++tail == size)
            tail = 0;
        Deque[tail] = value;
    }

    //  добавление в начало очереди
    void PushFront(int value){
        Deque[head] = value;
        if (--head < 0)
            head = size - 1;
    }

    //  выборка с конца очереди
    public Object PopBack(){
        Object ret = Deque[tail];

        if (--tail < 0)
            tail = size - 1;
        return ret;
    }

    // выборка с начала очереди
    public Object PopFront(){
        if (++head == size)
            head = 0;
        return Deque[head];
    }

    //  вывести последний элемент
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return (T) Deque[size - 1];
    }

    //  вывести первый элемент
    public T peekFront() {
        if (isEmpty()) {
            throw new NoSuchElementException ();
        }
        return (T) Deque[head];
    }

    //  изменение размера массива
    private void resize(int index) {
        Object[] newDeque = new Object[index];
        for (int i = 0; i < size; i++) {
            newDeque[i] = Deque[(head + i) % Deque.length];
        }
        Deque = newDeque;
        head = 0;
        tail = size;
    }

    @Override
    public String toString() {
        StringBuilder strB = new StringBuilder("");
        for (int i = 0; i < size; i++) {
            strB.append(Deque[(head + i) % Deque.length] + " ");
        }
        return new String(strB);
    }
}
