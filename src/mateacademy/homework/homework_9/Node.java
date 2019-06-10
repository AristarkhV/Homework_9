package mateacademy.homework.homework_9;

public class Node<T> {
    public T item;
    public Node<T> prev;
    public Node<T> next;

    public Node(Node<T> prev, T item, Node<T> next) {
        this.item = item;
        this.prev = prev;
        this.next = next;
    }
}
