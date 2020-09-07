package JAVA.packaging;

import org.junit.Test;

import java.util.WeakHashMap;

public class IntegerTest {
    public static void main(String[] args) {
        WeakHashMap<Character, String> weakHashMap = new WeakHashMap<>();
        weakHashMap.put('\u0000', "0");
        weakHashMap.put('\u0001', "1");
        weakHashMap.put('\u007f',"?");
        weakHashMap.put('\u0080',"??");
        weakHashMap.put('\u1111', "2");
        System.gc();
        System.out.println(weakHashMap);
    }

    @Test
    public void test1() {
        WeakHashMap<Integer, String> weakHashMap = new WeakHashMap<>();
        for (int i = 0; i < 200; i++) {
            weakHashMap.put(i, "i" + i);
        }
        System.gc();
        System.out.println(weakHashMap);
    }
    @Test public void test2(){
        WeakHashMap<Boolean,String> weakHashMap = new WeakHashMap<>();
        weakHashMap.put(false,"FALSE");
        weakHashMap.put(true,"TRUE");
        System.gc();
        System.out.println(weakHashMap);
    }
}
