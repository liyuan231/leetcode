package algorithm;

import java.util.Iterator;

public class a1_3_2 {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        String s = "it was - the best - of times - - - it was - the - -";
        String[] split = s.split(" ");
        for (String s1 : split) {
            if (s1.equals("-")) {
                stack.pop();
            } else {
                stack.push(s1);
            }
        }
        Iterator<String> iterator = stack.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
