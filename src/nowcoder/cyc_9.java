package nowcoder;


import java.util.Stack;

public class cyc_9 {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(!stack2.isEmpty()){return stack2.pop();}
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        cyc_9 c = new cyc_9();
        c.push(1);
        c.push(2);
        c.push(3);
        System.out.println(c.pop());
        System.out.println(c.pop());
        c.push(4);
        System.out.println(c.pop());
        c.push(5);
        System.out.println(c.pop());
        System.out.println(c.pop());
    }
}
