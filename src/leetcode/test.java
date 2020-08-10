package leetcode;

public class test {
    public static void main(String[] args) {
        System.out.println("a的ASCII为"+(int)'a');
        System.out.println("空格的ASCII为"+(int)' ');
        System.out.println("'a'|' ':"+('a'|' '));
        System.out.println("'A'|' ':"+('A'|' '));


        System.out.println("------");
        System.out.println("a:"+Integer.toBinaryString('a'));
        System.out.println("_:"+Integer.toBinaryString('_'));
        System.out.println((int)'A'+"&"+(int)'_'+":"+('A'&'_'));
        System.out.println((char)(65&97));

        System.out.println(~0);

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Math.pow(2,31));
    }
}
