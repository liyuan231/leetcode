package JVM;

import org.junit.Test;

public class StringInternTest {
    public static void main(String[] args) {
//        String s3 = "1" + "1";
//        s3.intern();
//        String s4 = "11";
//        System.out.println(s3 == s4);
//
//        String s = new String("liyuan");
//        String s2 = new String("li") + new String("yuan");
//        String s3 = new String("liyuanzz");
//        String s0 = new String("li");
//        String s1 = new String("yuan");
//        String s2 = s0 + s1;
        String s2 = new String("li") + new String("yuan");
//        String s00 = "li";
//        String s11 = "yuan";
//        System.out.println(s0.hashCode() + ":" + s00.hashCode());
//        System.out.println(s1.hashCode() + ":" + s11.hashCode());
        String s22 = "liyuan";
        System.out.println(s2 == s22);
    }

    @Test
    public void test1() {
        String s1 = new String("li") + new String("yuan");
        String s2 = "liyuan";
        System.out.println();
    }

    @Test
    public void test2() {
        String s = new String("a") + new String("b");
        String s1 = s.intern();
        System.out.println(s=="ab");
        System.out.println(s1=="ab");
    }
}
