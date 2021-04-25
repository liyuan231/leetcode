package cyc;

public class l_476 {
    public static void main(String[] args) {
        System.out.println(findComplement(5));
    }

    /**
     * a^b=c
     * c^b =a
     * 101^010 = 111
     * 111^101 = 010
     *
     * @param num
     * @return
     */
    public static int findComplement(int num) {
        int res = 0;
        int tmp = num;
        while (num != 0) {
            res = res << 1;
            res += 1;
            num = num >> 1;
        }
        return res ^ tmp;
    }
}
