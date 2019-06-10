package mateacademy.homework.homework_9;

public class Main {

    public static void main(String[] args) {

        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("first");
        list.add("second");
        list.add("third");
        list.add("fourth");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
