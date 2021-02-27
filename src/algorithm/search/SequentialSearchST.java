package algorithm.search;

import java.util.Iterator;

public class SequentialSearchST<Key, Value> {
    private Node first;

    private class Node implements Iterable<Key> {
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public Iterator<Key> iterator() {
            return new Iterator<Key>() {
                @Override
                public boolean hasNext() {
                    return first != null;
                }

                @Override
                public Key next() {
                    Key key = first.key;
                    first = first.next;
                    return key;
                }
            };
        }
    }

    public Value get(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return x.value;
            }
        }
        return null;
    }

    public void put(Key key, Value value) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.value = value;
                return;
            }
        }
        first = new Node(key, value, first);
    }

    public int size() {
        int size = 0;
        for (Node x = first; x != null; x = x.next) {
            size++;
        }
        return size;
    }

    public void delete(Key key) {
        Node pre = null;
        for (Node x = first; x != null; x = x.next) {
            if (x.key.equals(key)) {
                if (pre == null) {
                    first = first.next;
                    return;
                }
                pre.next = x.next;
                return;
            }
            pre = x;
        }
    }

    public Iterator<Key> keys() {
        return first.iterator();
    }

    public static void main(String[] args) {
        SequentialSearchST<Integer, String> st = new SequentialSearchST<>();
        st.put(1, "1");
        st.put(2, "2");
        st.put(3, "3");
        st.delete(33);
        Iterator<Integer> keys = st.keys();
        while (keys.hasNext()) {
            System.out.println(keys.next());
        }

    }
}
