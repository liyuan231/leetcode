package algorithm;

import java.util.Iterator;
import java.util.Stack;

public class Bag<Item> implements Iterable<Item> {
    private Node first;

    private  class Node {
        Item item;
        Node next;
    }

    public void add(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator<Item>();
    }

    private static class StaticClass {
        int age;
        String name;
    }

    private class ListIterator<Item> implements Iterator {
        private Node current;

        public ListIterator() {
            this.current = first;
        }

        @Override
        public void remove() {

        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Object next() {
            Item item = (Item) current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        StaticClass staticClass = new StaticClass();
        System.out.println(staticClass);
        Stack<String> stack = new Stack<>();
        stack.push(null);
        System.out.println(stack.size());
    }
}
