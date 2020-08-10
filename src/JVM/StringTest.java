package JVM;

public class StringTest {
    public static void main(String[] args) {
        System.out.println("Liyuan开始！");
        String s0="Liyuan";
        String s1="Liyuan";
        System.out.println(s1.hashCode()+":"+s0.hashCode());
        try {
            Thread.sleep(10000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
