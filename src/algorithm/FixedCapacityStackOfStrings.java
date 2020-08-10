package algorithm;

public class FixedCapacityStackOfStrings<Item> {
    private Item[] a;
    private int N;

    public FixedCapacityStackOfStrings(int cap) {
//        a = new Item[cap];
        a = (Item[]) new Object[cap];
    }

    public boolean isFull() {
        if (a.length == N) {
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        a[N++] = item;
    }

    public Item pop() {
        return a[--N];
    }

    public static void main(String[] args) {
        FixedCapacityStackOfStrings<String> s = new FixedCapacityStackOfStrings<>(100);

    }
}
