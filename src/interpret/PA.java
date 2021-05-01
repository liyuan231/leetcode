package interpret;

import java.util.*;

/**
 * prediction analysis
 * Ԥ�������
 */
public class PA {
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
        //�ս��
        Set<Character> set = new HashSet<>(Arrays.asList('(', 'i', ')', 'x', 'y', '*', '+', '~'));
        Map<Character, List<String>> map = new HashMap<>();//�����������ʽ
        Map<Character, List<String>> mapAssistance = new HashMap<>();//����HashMap����Ű���key��List<String>, ����follow���ж�
        Map<Character, List<Character>> first = new HashMap<>();//first����
        Map<Character, List<Character>> follow = new HashMap<>();
        Map<String, Character> reverseMapAssistance = new HashMap<>();// Te -> E
        for (int i = 0; i < strings.length; i++) {
            String[] ss = strings[i].split("->");
            map.computeIfAbsent(ss[0].charAt(0), l -> new ArrayList<>()).add(ss[1]);
            reverseMapAssistance.put(ss[1], ss[0].charAt(0));
            for (int i2 = 0; i2 < ss[1].length(); i2++) {
                char c = ss[1].charAt(i2);
                if (!set.contains(c) && c != '~') {
                    mapAssistance.computeIfAbsent(c, l -> new ArrayList<>()).add(ss[1]);
                }
            }
        }
        for (Map.Entry<Character, List<String>> entry : map.entrySet()) {
            Character key = entry.getKey();
            solveFirst(first, key, map, set);
        }
        for (Map.Entry<Character, List<String>> entry : mapAssistance.entrySet()) {
            Character key = entry.getKey();
            solveFollow(follow, key, mapAssistance, set, reverseMapAssistance, first);
        }

    }

    private static List<Character> solveFollow(Map<Character, List<Character>> follow, Character key, Map<Character, List<String>> mapAssistance, Set<Character> finalSet, Map<String, Character> reverseMapAssistance, Map<Character, List<Character>> first) {
//        if (follow.containsKey(key)) {
//            return follow.get(key);
//        }
        List<String> vals = mapAssistance.get(key);
        for (int i = 0; i < vals.size(); i++) {
            int index = vals.get(i).indexOf(key);
            Character trueKey = reverseMapAssistance.get(vals.get(i));
            //����Ϊ���һ��Ԫ���Ҳ�����������Ƶ��Ĺ�ʽ��e.g.E->aE'��follow(E')����follow(E);
            if (index == vals.get(i).length() - 1) {
                if (trueKey != vals.get(i).charAt(index)) {
                    List<Character> characters = solveFollow(follow, reverseMapAssistance.get(vals.get(i)), mapAssistance, finalSet, reverseMapAssistance, first);
                    follow.putIfAbsent(key, characters);
                }
                //e.g. E-> E'T ��follow(E')����� first(T);
            } else if (!finalSet.contains(vals.get(i).charAt(index + 1))) {
                char c = vals.get(i).charAt(index + 1);
                List<Character> characters2 = trim(first.get(c));
                follow.putIfAbsent(key, characters2);
                //�� ~����first(T) ,�� follow(E')�����follow(E);
                if (first.get(c).contains('~')) {
                    List<Character> characters = solveFollow(follow, reverseMapAssistance.get(vals.get(i)), mapAssistance, finalSet, reverseMapAssistance, first);
                    follow.putIfAbsent(key, characters);
                }
            } else {
                //e.g. E->E'a  ��follow(E')Ӧ���� a
                char next = vals.get(i).charAt(index + 1);
//                if (finalSet.contains(next) || next == '~') {
                follow.computeIfAbsent(key, l -> new ArrayList<>()).add(next);
//                }
            }
        }
        return follow.get(key);

    }

    private static List<Character> trim(List<Character> characters1) {
        ArrayList<Character> characters = new ArrayList<>(characters1);
        for (int i1 = 0; i1 < characters.size(); i1++) {
            if (characters.get(i1).equals('~')) {
                characters.remove(i1);
                break;
            }
        }
        return characters;
    }

    private static List<Character> solveFirst(Map<Character, List<Character>> first, Character key, Map<Character, List<String>> map, Set<Character> finalSet) {
        if (first.containsKey(key)) {
            return first.get(key);
        }
        List<String> vals = map.get(key);
        for (int i = 0; i < vals.size(); i++) {
            char symbol = vals.get(i).charAt(0);
            if (finalSet.contains(symbol) || symbol == '~') {
                first.computeIfAbsent(key, l -> new ArrayList<>()).add(symbol);
            } else {
                List<Character> solve = solveFirst(first, symbol, map, finalSet);
                first.putIfAbsent(key, solve);
            }
        }
        return first.get(key);
    }

}
