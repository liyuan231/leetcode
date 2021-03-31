package interview;

public class cyc_14 {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println(cutRope(i));
        }
    }

    /**
     * 尽量剪成长度为3和2的段
     *
     * @param target
     * @return
     */
    public static int cutRope(int target) {
        int ans = 1;
        if (target == 1) {
            return 1;
        }
        while (target != 0) {
             if (target!=4&&target >= 3) {
                target = target - 3;
                ans *= 3;
            } else if (target >= 2) {
                target = target - 2;
                ans *= 2;
            }
        }
        return ans;
    }
}
