package mateacademy.homework.homework_9;

import java.util.NoSuchElementException;

public class MyLinkedList<T> implements List<T> {

    private Node<T> head;
    private Node<T> tail;
    private Node<T> currentNode;
    private Node<T> buffer;
    private int size;

    @Override
    public T get(int index) {
        if (indexOutOfBounds(index)) {
            buffer = head;
            for (int i = 0; i < size(); i++) {
                if (i == index) {
                    return buffer.item;
                }
                buffer = buffer.next;
            }
        }
        throw new NoSuchElementException();
    }

    @Override
    public void add(T value) {
        if (size == 0) {
            currentNode = new Node<>(null, value, null);
            head = currentNode;
            tail = currentNode;
        } else {
            currentNode = new Node<>(tail, value, null);
            currentNode.prev.next = currentNode;
            tail = currentNode;
        }
        size++;
    }

    @Override
    public void add(T value, int index) {
        if (indexOutOfBounds(index)) {
            if (index == 0) {
                currentNode = new Node<>(null, value, head);
                head = currentNode;
            }
            if (index == size() - 1) {
                currentNode = new Node<>(tail, value, null);
                tail = currentNode;
            }
            buffer = head;
            for (int i = 1; i < size - 1; i++) {
                if (i == index) {
                    currentNode = new Node<>(buffer.prev, value, buffer.next);
                    buffer.prev.next = currentNode;
                    buffer.prev = currentNode;
                }
                buffer = buffer.next;
            }
        }
    }

    @Override
    public void addAll(List<T> list) {
        for (int i = 0; i < list.size(); i++) {
            add(list.get(i));
        }
    }

    @Override
    public T remove(int index) {
        if (indexOutOfBounds(index)) {
            size--;
            if (index == 0) {
                head = head.next;
                head.next.prev = null;
                return head.item;
            }
            if (index == (size())) {
                tail = tail.prev;
                tail.prev.next = null;
                return tail.item;
            }
            buffer = head;
            for (int i = 0; i < size(); i++) {
                if (i == index) {
                    buffer.next.prev = buffer.prev;
                    buffer.prev.next = buffer.next;
                    return buffer.item;
                }
                buffer = buffer.next;
            }
        }
        throw new NoSuchElementException();
    }

    @Override
    public T remove(T t) {
        buffer = head;
        for (int i = 0; i < size(); i++) {
            if (buffer.item.equals(t)) {
                remove(i);
                return buffer.item;
            }
            buffer = buffer.next;
        }
        throw new NoSuchElementException();
    }

    @Override
    public void set(T value, int index) {
        buffer = head;
        for (int i = 0; i < size - 1; i++) {
            if (i == index) {
                buffer.item = value;
            }
            buffer = buffer.next;
        }
    }

    public int size() {
        return size;
    }

    private boolean indexOutOfBounds(int index) {
        if (index < 0 || index > this.size()) {
            throw new ArrayIndexOutOfBoundsException("out of bounds");
        }
        return true;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
}
