package javaEffective;

import java.util.*;

public class je_26 {
    public static void main(String[] args) {
        Collection collection = new HashSet();
        collection.add(1);
        collection.add("liyuan");

        for (Iterator iterator = collection.iterator(); iterator.hasNext(); ) {
            System.out.println(iterator.next().getClass().getName());
//            System.out.println(next);
        }
        List<String> strings = new ArrayList<>();
//        unsafeAdd(strings, Integer.valueOf(42));
//
//        for (Iterator iterator = strings.iterator(); iterator.hasNext(); ) {
//            System.out.println(iterator.next().getClass().getName());
//            System.out.println(next);
//        }

        Collection<?> c = new ArrayList<>();
//        c.add;


    }

    private static void unsafeAdd(List<Object> list, Object o) {
        list.add(o);
    }

    private static int numElementsInCommon(Set<?> s1, Set<?> s2) {
        int result=0;
        for (Object o : s1) {
            if(s2.contains(o)){
                result++;
            }
        }
        return result;

    }
}
