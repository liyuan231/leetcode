package dp;

public class l_392 {

    int[] book;

    public l_392() {

    }

    public static void main(String[] args) {
        l_392 l_392 = new l_392(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(l_392.sumRange(0, 2));
        System.out.println(l_392.sumRange(2, 5));
        System.out.println(l_392.sumRange(0, 5));

    }

    public l_392(int[] nums) {
        book = new int[nums.length + 1];
        for (int i = 1; i < book.length; i++) {
            book[i] =book[i-1] +nums[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        return book[right+1] - book[left];
    }
}
