package leetcode;

import java.util.ArrayList;
import java.util.List;

public class l_89 {
    public static void main(String[] args) {
        int n = 2;
        List<Integer> integers = grayCode(n);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }

    public static List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<Math.pow(2,n);i++){
            result.add(i^(i>>1));
        }
        return result;
    }
}
