package leetcode;

public class l_88 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0,0};
        int[] nums2 = new int[]{2, 5, 6,8};
        merge(nums1, 3, nums2, 4);
        for(int i=0;i<nums1.length;i++){
            System.out.print(nums1[i]+" ");
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] num = new int[m];
        for (int i = 0; i < num.length; i++) {
            num[i] = nums1[i];
        }
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < m && j < n) {
            if (num[i] < nums2[j]) {
                nums1[k++] = num[i++];
            }else{
                nums1[k++] = nums2[j++];
            }
        }
        while (i<m){
            nums1[k++] = num[i++];
        }
        while (j<n){
            nums1[k++] = nums2[j++];
        }
    }
}
