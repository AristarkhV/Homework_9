package mateacademy.homework.homework_9;

public class Main {

    public static void main(String[] args) {

        MyLinkedList<String> list = new MyLinkedList<>();
        System.out.println("add test: \n");
        list.add("first");
        list.add("second");
        list.add("third");
        list.add("fourth");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("\n size = " + list.size());
        System.out.println("\n add [index] test:");
        list.add("new", 3);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("\n size = " + list.size());

        System.out.println("\n remove [index] test:");
        list.remove(2);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("\n size = " + list.size());

        System.out.println("\n set [value, index] test:");
        list.set("set", 2);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("\n size = " + list.size());
        System.out.println("\n size = " + list.size());
    }
}
