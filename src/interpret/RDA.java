package interpret;

/**
 * Recursive descent analysis
 * 递归下降分析
 */

import java.util.*;

/**
 * 约定使用
 * ~:127代表空串
 * 小写字母代表相应大写字母加一撇
 * 约定空串需要排到
 */
public class RDA {
    public static void main(String[] args) {
        String input = "(i+i)*(i+i)#";
        String[] strings = new String[]{
                "t->~",
                "E->Te",
                "e->+Te",
                "e->~",
                "T->Ft",
                "t->*Ft",
                "F->(E)",
                "F->i",
                "F->x",
                "F->y"
        };
        Set<Character> set = new HashSet<>();//终结符
        set.add('(');
        set.add('i');
        set.add(')');
        set.add('x');
        set.add('y');
        set.add('*');
        set.add('+');
        Map<Character, List<String>> map = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            String[] split = strings[i].split("->");
            map.computeIfAbsent(split[0].charAt(0), l -> new ArrayList<>()).add(split[1]);
        }
        map.forEach((k, v) -> {
            v.sort((o1, o2) -> o1.compareTo(o2));
        });
        LinkedList<Character> list = new LinkedList<>();
        list.addFirst('E');
        LinkedList<LinkedList<Character>> res = new LinkedList<>();
        res.add(new LinkedList<>(list));
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            l1:
            while (list.size() > 0 && list.getFirst() != c) {
                List<String> ss = map.get(list.getFirst());
                for (int i1 = 0; i1 < ss.size(); i1++) {
                    String s = ss.get(i1);
                    if (set.contains(ss.get(i1).charAt(0)) && ss.get(i1).charAt(0) != c) {
//                        list.removeFirst();
                        continue;
                    }

                    list.removeFirst();
                    for (int j = s.length() - 1; j >= 0; j--) {
                        list.addFirst(s.charAt(j));
                    }
                    while (list.size() > 0 && list.get(0) == '~') {
                        list.removeFirst();
                    }
                    if (list.size() > 0 && ss.get(i1).charAt(0) == c) {
                        break l1;
                    }
//                backtrack(res, list, map, c);
                    System.out.println(Arrays.toString(list.toArray()));
                }
            }
            if (list.size() > 0) {
                list.removeFirst();
            }
//            res.get(0).removeFirst();
        }
        System.out.println(1);
    }

//    private static Boolean lock = Boolean.FALSE;

//    private static void backtrack(LinkedList<LinkedList<Character>> res, LinkedList<Character> list, Map<Character, List<String>> map, char target) {
//        List<String> strs = map.get(list.getFirst());
//        if (list.getFirst() == target) {
//            res.set(0,new LinkedList<>(list));
//            lock = !lock;
//            return;
//        }
//        list.removeFirst();
//        for (int i = 0; i < strs.size(); i++) {
//            if (lock) {
//                continue;
//            }
//            String s = strs.get(i);
//            for (int j = s.length() - 1; j >= 0; j--) {
//                list.addFirst(s.charAt(j));
//            }
//            backtrack(res, list, map, target);
//            list.removeFirst();
//        }
//
//    }

}
