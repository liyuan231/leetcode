package algorithm;

/**
 * 中序表达式转后序表达式
 * 中序表达式：2*3/(2-1)+3*(4-1)
 * 后序表达式：23*21-/341-*+
 */
public class a1_4_0 {
    public static void main(String[] args) {
        String str = "2*3/(2-1)+3*(4-1)";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c>='0'&&c<='9'){
                System.out.print(c);
            }else if(c=='('){
                stack.push(c);
            }else if(c==')'){
                while (!stack.isEmpty()&&stack.peek()!='('){
                    System.out.print(stack.pop());
                }
            }else {
                while (!stack.isEmpty()&&stack.peek()>=c){
                    
                }
            }
        }
    }
}
