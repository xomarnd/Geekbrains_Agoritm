package Lesson_4;

import java.util.Iterator;

public class SingleLinkedList<T> implements Iterable<T> {

    private Node<T> head;
    private Node<T> tail;

    public void insertHead(T value) {
        Node<T> newNode = new Node<>(value);

        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void insertTail(T value) {
        Node<T> newNode = new Node<>(value);

        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public T deleteHead() {
        T deletedValue = head.value;
        head = head.next;

        if (head == null) {
            tail = null;
        }

        return deletedValue;
    }

    public T deleteTail() {
        T deletedValue = tail.value;
        Node<T> prev = findPrev(tail);
        tail = prev;
        if ( tail == null) {
            head = null;
        } else {
            prev.next = null;
        }
        return deletedValue;
    }

    public void insertAt(int index, T value) {
        if (index == 0) {
            insertHead(value);
            return;
        }

        Node<T> curr = head;
        Node<T> prev = null;
        for (int i = 0; i < index && curr != null; i++) {
            prev = curr;
            curr = curr.next;
        }
        if (curr == null) {
            insertTail(value);
            return;
        }

        Node<T> newNode = new Node<>(value);
        if (prev != null) {
            prev.next = newNode;
        }
        newNode.next = curr;
    }

    public T deleteAt(int index) {
        //TODO реализовать в качестве ДЗ
        return null;
    }

    private Node<T> findPrev(Node<T> node) {
        Node<T> prev = head;
        while (prev != null && prev.next != node) {
            prev = prev.next;
        }
        return prev;
    }

    public void push(T value) {
        //TODO реализовать в качестве ДЗ
    }

    public T pop() {
        //TODO реализовать в качестве ДЗ
        return null;
    }

    public T peek() {
        //TODO реализовать в качестве ДЗ
        return null;
    }

    public void enqueue(T value) {
        //TODO реализовать в качестве ДЗ
    }

    public T dequeue() {
        //TODO реализовать в качестве ДЗ
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            Node<T> curr = head;

            @Override
            public boolean hasNext() {
                return curr != null;
            }

            @Override
            public T next() {
                T value = curr.value;
                curr = curr.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<>();
        singleLinkedList.insertHead(1);
        singleLinkedList.insertTail(2);
        singleLinkedList.insertHead(3);
        singleLinkedList.insertTail(4);
        singleLinkedList.insertHead(5);
        singleLinkedList.insertTail(6);
        singleLinkedList.insertHead(7);
        singleLinkedList.insertTail(8);
        singleLinkedList.insertTail(9);
        singleLinkedList.insertAt(0, 11);
        singleLinkedList.insertAt(4, 12);
        singleLinkedList.insertAt(12, 13);

        singleLinkedList.forEach(System.out::println);

        singleLinkedList.deleteHead();
        singleLinkedList.deleteTail();

        System.out.println("After delete head and tail");
        singleLinkedList.forEach(System.out::println);

        singleLinkedList.deleteHead();
        singleLinkedList.deleteTail();
        singleLinkedList.deleteHead();
        singleLinkedList.deleteTail();
        singleLinkedList.deleteHead();

        System.out.println("After delete all");
        singleLinkedList.forEach(System.out::println);
    }
}
