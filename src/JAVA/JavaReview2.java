package JAVA;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Collections.reverse;

public class JavaReview2 {
    public static void main(String[] args) {
        String str = null;
        if (Objects.equals(null, str)) {
            System.out.println("1");
        } else {
            System.out.println(2);
        }

        double d1 = 1.3d - 1.2d;
        double d2 = 1.2d - 1.1d;
        System.out.println(d1);
        System.out.println(d2);
        System.out.println(d1 == d2);
        System.out.println(Double.NaN);
        System.out.println("==================");
        BigDecimal b0 = new BigDecimal("1.2");
        BigDecimal b1 = new BigDecimal("1.3");
        BigDecimal b2 = new BigDecimal("0.1");
        BigDecimal b3 = new BigDecimal("0.2");
        System.out.println(b3.setScale(10));
        System.out.println(b1.subtract(b3).equals(b0.subtract(b2)));
//        System.out.println(b0.subtract(b2));


        String[] strings = new String[]{"liyuan", "yuanxi", "LIYUAN"};
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("yuanxi");
        List<String> str2 = Arrays.asList(strings);
        List<Integer> integers = Arrays.asList(1, 2, 3, 4);
        System.out.println(integers.size());
        System.out.println(integers);
//        str2.add("lll");
        new ArrayList<>(Arrays.asList(1, 2, 3, 4));

        Integer[] ints = new Integer[]{4, 3, 2, 1};
        List<Integer> collect = Arrays.stream(ints).collect(Collectors.toList());
        System.out.println(Arrays.toString(Arrays.stream(ints).toArray()));
        System.out.println(collect);

    }

    public Boolean equals_(Integer i1, Integer i2) {
        return i1.equals(i2);
    }

    @Test
    public void test02() {
//        List<String> list1 = ImmutableList.of("liyuan","yuanxi");
        List<Character> strings = Arrays.asList('l', 'i', 'y', 'u', 'a', 'n');
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println(strings);
        System.out.println(integers);

        reverse(strings);
        reverse(integers);
        System.out.println(Arrays.toString(strings.toArray()));
        System.out.println(Arrays.toString(integers.toArray()));
        strings.removeIf(v -> v % 2 == 0);
        integers.removeIf(v -> true);
        System.out.println(Arrays.toString(strings.toArray()));
        System.out.println(Arrays.toString(integers.toArray()));
    }

    @Test
    public void test03() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            if ("1".equals(next)) {
                iterator.remove();
            }
        }
        System.out.println(list);


        for (String s : list) {
            if ("2".equals(s)) {
                list.remove(s);
            }
        }

    }
}
