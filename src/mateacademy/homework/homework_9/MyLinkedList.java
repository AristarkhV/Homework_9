package mateacademy.homework.homework_9;

import java.util.NoSuchElementException;

public class MyLinkedList<T> implements List<T> {

    private Node<T> firstNode;
    private Node<T> lastNode;
    private Node<T> currentNode;
    private Node<T> buffer;
    private int size;

    @Override
    public T get(int index) {
        if (indexOutOfBounds(index)) {
            currentNode = firstNode;
            for (int i = 0; i < size(); i++) {
                if (i == index) {
                    return currentNode.item;
                }
                currentNode = currentNode.next;
            }
        }
        throw new NoSuchElementException();
    }

    @Override
    public void add(T value) {
        if (size == 0) {
            currentNode = new Node<>(null, value, null);
            firstNode = currentNode;
            lastNode = currentNode;
        } else {
            currentNode = new Node<>(lastNode, value, null);
            currentNode.prev.next = currentNode;
            lastNode = currentNode;
        }
        size++;
    }

    @Override
    public void add(T value, int index) {
        if (indexOutOfBounds(index)) {
            if (index == 0) {
                currentNode = new Node<>(null, value, firstNode);
                firstNode = currentNode;
            }
            if (index == size() - 1) {
                currentNode = new Node<>(lastNode, value, null);
                lastNode = currentNode;
            }
            buffer = firstNode;
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
        MyLinkedList<T> temp = new MyLinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            temp.add(list.get(i));
        }
        lastNode.next = temp.firstNode;
        lastNode = temp.lastNode;
        size = size + temp.size();
    }

    @Override
    public T remove(int index) {
        if (indexOutOfBounds(index)) {
            size--;
            if (index == 0) {
                firstNode = firstNode.next;
                firstNode.next.prev = null;
                return firstNode.item;
            }
            if (index == (size())) {
                lastNode = lastNode.prev;
                lastNode.prev.next = null;
                return lastNode.item;
            }
            buffer = firstNode;
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
        buffer = firstNode;
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
        buffer = firstNode;
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
