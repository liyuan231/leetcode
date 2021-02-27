package javaEffective;

import java.util.*;

public class Stack<E> {
    private E[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    @SuppressWarnings("unchecked")
    public Stack() {
        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E e) {
//        ensureCapacity();
        elements[size++] = e;
    }


    public E pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        E element = elements[--size];
        elements[size] = null;
        return element;
    }

    public void pushAll(Iterable<? extends E> src) {
        for (E e : src) {
            push(e);
        }
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void popAll(Collection<? super E> dst) {
        while (!isEmpty()) {
            dst.add(pop());
        }
    }

    public static void main(String[] args) {
        Stack<Number> stack = new Stack<>();
        stack.push(123);
        stack.push(234);
//        System.out.println(stack.pop());
//        Stack<Number> stack = new Stack<>();
        Iterable<Number> integers = () -> null;
        stack.pushAll(integers);
        ArrayList<Number> numbers = new ArrayList<>();
        stack.popAll(numbers);
        System.out.println(Arrays.toString(numbers.toArray()));
    }
}
