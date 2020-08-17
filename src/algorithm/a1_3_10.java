package algorithm;

/**
 * 将算术中序表达式转化为后序表达式
 */
public class a1_3_10 {
    public static void main(String[] args) {
        String str = "2*3/(2-1)+3*(4-1)";
        System.out.println(InfixToPostfix(str));
    }

    private static String InfixToPostfix(String str) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
//            return null;
        }
        return null;
    }
}
