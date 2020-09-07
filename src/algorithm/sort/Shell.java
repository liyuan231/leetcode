package algorithm.sort;

public class Shell {
    public static void main(String[] args) {
        int N=100;
        Integer[] integers1 = new Integer[N];
        for (int i = 0; i < integers1.length; i++) {
            integers1[i] = integers1.length - i;
        }

        Integer[] integers2 = new Integer[N];
        for (int i = 0; i < integers2.length; i++) {
            integers2[i] = integers2.length - i;
        }


        long start1 = System.currentTimeMillis();
        Shell.sort(integers1);
        long end1 = System.currentTimeMillis();

        long start2 = System.currentTimeMillis();
        Shell.sort_(integers2);
        for (Integer integer : integers2) {
            System.out.print(integer+" ");
        }
        long end2 = System.currentTimeMillis();

        System.out.println("=====Integers1=======->" + (end1 - start1));
//        for (Integer integer : integers1) {
//            System.out.print(integer + " ");
//        }
        System.out.println();
        System.out.println("=====Integers2=======->" + (end2 - start2));
//        for (Integer integer : integers2) {
//            System.out.print(integer + " ");
//        }
    }

    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                //此步为标准的插入排序，这也说明希尔排序也就只是插入排序的升级版
                for (int j = i; j >= h; j = j - h) {
                    if (a[j].compareTo(a[j - h]) < 0) {
                        Comparable tmp = a[j];
                        a[j] = a[j - h];
                        a[j - h] = tmp;
                    }
                }
            }
            h = h / 3;
        }
    }

    public static void sort_(Comparable[] a) {
        //此为h=1的希尔排序
        int h=1;
        int N=a.length;
        while (h<N/3){
            h=h*3+1;
        }
        while (h!=0){
            for (int i = h; i < a.length; i++) {
                for (int j = i; j >=h; j=j-h) {
                    if (a[j].compareTo(a[j - h]) < 0) {
                        Comparable tmp = a[j];
                        a[j] = a[j -h];
                        a[j - h] = tmp;
                    }
                }
            }
            h=h/3;
        }
    }
}
