package JAVA;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTest {
    public static void main(String[] args) throws InterruptedException {
        String a = "Liyuan";
        String b = "Liyuan";
        System.out.println( Integer.toHexString(a.hashCode()));
        System.out.println(Integer.toHexString(b.hashCode()));
        String c = "LIYUAN";
        System.out.println(a==b);
//        Thread.sleep(100_000);


        Pattern pattern = Pattern.compile("LIYUAN");
        Matcher matcher = pattern.matcher("LIYUAN123456789LIYUANYUANXI");
        System.out.println(matcher.replaceAll("Java"));
        System.out.println(matcher.replaceFirst("JAVA"));
    }

    public void test(String str){
        String s1 = "a"+"b";
        System.out.println(s1);

        String s2 = str+s1;
        System.out.println(s2);
    }
    @Test public void test2(){
        String z = new String("li");
        String a="liyuan";
        byte[] bytes = a.getBytes();
        String b="李源";
        byte[] bytes1 = b.getBytes();
        System.out.println(System.getProperty("file.encoding"));
        System.out.println(1);
    }

}
