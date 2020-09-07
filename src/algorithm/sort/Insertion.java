package algorithm.sort;

public class Insertion {
    public static void main(String[] args) {
        Double[] doubles = new Double[10];
        for (int i = 0; i < doubles.length; i++) {
            doubles[i] = Math.random() * doubles.length;
        }
        Insertion.sort_(doubles);
        for (Double aDouble : doubles) {
            System.out.println(aDouble);
        }
    }

    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j].compareTo(a[j - 1]) > 0) {
                    continue;
                } else {
                    Comparable tmp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = tmp;
                }
            }
        }
    }

    public static void sort_(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            for(int j=i;j>0;j--){
                if(a[j].compareTo(a[j-1])<0){
                    Comparable tmp = a[j];
                    a[j] = a[j-1];
                    a[j-1]=tmp;
                }
            }
        }
    }
}
