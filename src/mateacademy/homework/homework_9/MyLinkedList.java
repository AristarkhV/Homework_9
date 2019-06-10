package mateacademy.homework.homework_9;

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
            for (int i = 0; i < size; i++) {
                if (i == index) {
                    return buffer.item;
                }
                buffer = this.buffer.next;
            }
        }
        throw new ArrayIndexOutOfBoundsException("INVALID INDEX");
    }

    @Override
    public void add(T value) {
        if (size == 0) {
            currentNode = new Node<>(null, value, null);
            head = currentNode;
            tail = currentNode;
        } else {
            buffer = new Node<>(tail, value, null);
            currentNode.next = buffer;
            currentNode.prev = tail;
            tail = buffer;
            currentNode = buffer;
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
            size++;
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
    public T remove(int index) {
        if (indexOutOfBounds(index)) {
            if (index == 0) {
                head = head.next;
                head.next.prev = null;
            }
            if (index == (size() - 1)) {
                tail = tail.prev;
                tail.prev.next = null;
            }
            size--;
            buffer = head;
            for (int i = 1; i < size - 1; i++) {
                if (i == index) {
                    buffer.next = buffer.next.next;
                    buffer.next.next.prev = buffer;
                }
                buffer = buffer.next;
            }
        }
        return buffer.item;
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
        if (this.size() == 0) {
            return true;
        } else {
            return false;
        }
    }
}
