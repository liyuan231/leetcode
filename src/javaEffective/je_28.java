package javaEffective;

import java.util.LinkedList;
import java.util.List;

public class je_28 {
    public static void main(String[] args) {
//        Object[] array = new Long[1];
//        array[0] = "1111";
//        System.out.println(array);

//        List<Long> list = new ArrayList<Long>();
//        list.add("22222");
//        System.out.println(list);
//        List[] lists = new List[1];
//        Object[] objects = lists;
//        objects[0] = +;
//        System.out.println(lists[0].get(0));
        List<Integer> list = new LinkedList<>();
        list.add(1);
        test(list);
    }

    private static void test(List<?> list){
        System.out.println(list);
    }
}
