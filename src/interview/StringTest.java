package interview;

import java.util.Arrays;

public class StringTest {
    public static void main(String[] args) {
        String str = "李源123";
        //汉字占三个字节
        //字母占一个字节
        System.out.println(Arrays.toString(str.getBytes()));
    }

}
