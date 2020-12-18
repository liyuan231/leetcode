package javaEffective;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.function.ToIntFunction;

public class je_03 {
    public static void main(String[] args) {
//        Math.s
        TreeSet<BigDecimal> treeSet = new TreeSet<>();
        BigDecimal bigDecimal1 = new BigDecimal("1.0");
        BigDecimal bigDecimal2 = new BigDecimal("1.00");
        treeSet.add(bigDecimal1);
        treeSet.add(bigDecimal2);


        System.out.println(treeSet.size());

        HashSet<BigDecimal> hashSet = new HashSet<>();
        hashSet.add(bigDecimal1);
        hashSet.add(bigDecimal2);
        System.out.println(hashSet.size());
    }

//    private static final Comparator<PhoneNumber> COMPARATOR =
//           Comparator.comparingInt()
}
