package JVM;

import java.util.Arrays;

public class StringExer {
    String s = new String("good");
    char[] ch = {'t', 'e', 's', 't'};

    public void change(String s, char[] ch) {
        s = "Liyuan";
        ch[0] = 'b';
    }

    public static void main(String[] args) {
        StringExer stringExer = new StringExer();
        stringExer.change(stringExer.s,stringExer.ch);
        System.out.println("string:"+stringExer.s);
        System.out.println("ch:"+ Arrays.toString(stringExer.ch));
    }
}
