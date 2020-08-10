package leetcode;

public class l_84 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        System.out.println("ans:" + largestRectangleArea(nums));
    }

    public static int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        int[] book = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            book[i] = heights[i];
            int height = heights[i];
            int width = 1;
            for (int j = i + 1; j < heights.length; j++) {
                height = Math.min(height,heights[j]);
                width = j-i+1;
                book[i] = Math.max(book[i],height*width);
            }
        }
        int ans = -1;
        for(int i=0;i< book.length;i++){
            ans = Math.max(book[i],ans);
        }
        return ans;
    }
}
