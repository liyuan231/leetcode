package JVM.OOM;

public class RUntimeConstantPoolOOM {
    public static void main(String[] args) {
//        Set<String> strings = new HashSet<>();
//        short i = 0;
//        while (true) {
//            try {
//                strings.add(String.valueOf(i++).intern());
//            } catch (OutOfMemoryError error) {
//                System.out.println(i);
//                error.printStackTrace();
//            }
//        }
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() ==  str1);

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2==str2.intern());
    }

}
