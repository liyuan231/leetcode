package JVM;

public class StringTest3 {
    public static void main(String[] args) {
//        System.out.println("+:"+method0());//931
        System.out.println("stringBuilder.append():"+method1());//8
    }

    private static long method0() {
        long start = System.currentTimeMillis();
        String s = "";
//        StringBuilder
        for (int i = 0; i < 100000; i++) {
            s += "a";
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    private static long method1() {
        long start = System.currentTimeMillis();
        StringBuilder s = new StringBuilder(100000);
        for (int i = 0; i < 100000; i++) {
            s.append("a");
        }
        long end = System.currentTimeMillis();
        String ans=s.toString();
        return end - start;
    }
}

