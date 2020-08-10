package algorithm;

public class a1_3_9 {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        String s = "1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )";
        String[] strings = s.split(" ");
        for (int i = 0; i < strings.length; i++) {
            String s1 = strings[i];
            if (s1.equals(")")) {
                String num2 = stack.pop();
                String operator = stack.pop();
                String num1 = stack.pop();
                stack.push("("+num1+operator+num2+")");
            }else {
                stack.push(s1);
            }
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }

}
