package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class l_89 {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(Arrays.toString(grayCode(n).toArray()));
    }

    public static List<Integer> grayCode(int n) {
        //3位二进制，共8中情况
        List<Integer> res = new ArrayList<>();
        int len = (int) Math.pow(2,n);
//        int t = n>>1;
        for (int i = 0; i < len; i++) {
            res.add(i^(i/2));
        }
        return res;
    }
}
