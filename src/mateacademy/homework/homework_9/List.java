package mateacademy.homework.homework_9;

public interface List<T> {

    void add(T value);

    T get(int index);

    boolean isEmpty();

    int size();

    void add(T value, int index);

    T remove(int index);

    void set(T value, int index);
/*
    T remove(T t);

    void addAll(List<T> list);
    */
}
