package interview;

public class GenericTest {
    public static void main(String[] args) {
        Integer[] ints = {1, 2, 3, 5, 4};
        String[] strings = {"1", "2", "3", "4"};
        test(ints);
        test(strings);
        Integer integer = new Integer(10);
        test(integer);
    }


    private static <T> void test(T[] t) {
        for (T t1 : t) {
            System.out.println(t1);
        }
    }

    private static Integer test(int i) {
        System.out.println(i);
        return i;
    }
}
