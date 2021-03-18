package interview;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TestTravsel {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Java");
        map.put(2, "JDK");
        map.put(3, "Spring Framework");
        map.put(4, "Mybatis Framework");
        map.put(5, "Java中文社区");
        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> next = iterator.next();
            System.out.println(next);
        }
        Iterator<Integer> iterator1 = map.keySet().iterator();
        while (iterator1.hasNext()) {
            Integer next = iterator1.next();
            System.out.println(next + "-" + map.get(next));
        }

        System.out.println("fro each entrySet");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
//            System.out.println(entry.getValue());
        }

        System.out.println("for each");
        for (Integer key : map.keySet()) {
            System.out.println(key + " - " + map.get(key));
        }

        System.out.println("lambda");
        map.forEach((k, v) -> {
            System.out.println(k + " - " + v);
        });

        System.out.println("single thread -> stream");
        map.entrySet().stream().forEach((entry) -> {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        });

        System.out.println("parallel thread -> stream");
        map.entrySet().parallelStream().forEach((entry)->{
            System.out.println(entry.getKey() + " - " + entry.getValue());
        });

    }
}
