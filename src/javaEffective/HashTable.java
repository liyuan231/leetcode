package javaEffective;

public class HashTable implements Cloneable {
    private Entry[] buckets;

    private static class Entry {
        final Object key;
        Object value;
        Entry next;


        public Entry(Object key, Object value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        Entry deepCopy() {
            return new Entry(key, value, next == null ? null : next.deepCopy());
        }

    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        try {
            HashTable clone = (HashTable) super.clone();
            clone.buckets = new Entry[buckets.length];
            for (int i = 0; i < this.buckets.length; i++) {
                if (buckets[i] != null) {
                    clone.buckets[i] = buckets[i].deepCopy();
                }
            }
            return clone;
        } catch (CloneNotSupportedException e) {
            throw e;
        }
    }
}
