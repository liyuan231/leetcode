package algorithm.sort;

import org.junit.Test;

import java.io.*;
import java.util.Arrays;

public class Quick {
    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int left, int right) {
//        if (left + 10 >= right) {
//            Insertion.sort(a);
//            return;
//        }
        if(left>=right){
            return;
        }
        int par = partition(a, left, right);
        sort(a, left, par - 1);
        sort(a, par + 1, right);
    }

    private static int partition(Comparable[] a, int left, int right) {
        Comparable chosenOne = a[left];
        int i = left;
        int j = right + 1;
        while (true) {
             while (a[++i].compareTo(chosenOne) < 0) {
                if (i == right) {
                    break;
                }
            }
            while (a[--j].compareTo(chosenOne) > 0) {
                if (j == left) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            swap(a, i, j);
        }
        swap(a, left, j);
        System.out.println(Arrays.toString(Arrays.stream(a).toArray()));
        return j;
    }

    private static void swap(Comparable[] a, int i, int j) {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream("leetcode.iml")));
        byte[] bytes = dataInputStream.readAllBytes();
        dataInputStream.close();
        Character[]c = new Character[bytes.length];
        int i=0;
        for (byte aByte : bytes) {
            c[i++] = (char)aByte;
        }
//        Character[] characters = new Character[]{'K', 'R', 'A', 'T', 'E', 'L', 'E', 'P', 'U', 'I', 'M', 'Q', 'C', 'X', 'O', 'S'};
        Long start = System.currentTimeMillis();
        Quick.sort(c);
        Long end = System.currentTimeMillis();
        System.out.println((end-start)+"ms");
        System.out.println(Arrays.toString(Arrays.stream(c).toArray()));
    }
    @Test
    public void test(){
        Integer[]integers = new Integer[]{1,6,3,4,5,2};
        Quick.sort(integers);
        System.out.println(Arrays.toString(Arrays.stream(integers).toArray()));
    }
}
