package algorithm.sort;

public class Selection {
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            Comparable<?> tmp;
            for (int j = i + 1; j < N; j++) {
                if (a[min].compareTo(a[j]) > 0) {
                    min = j;
                }
            }
            tmp = a[i];
            a[i] = a[min];
            a[min] = tmp;
        }
    }

    public static void main(String[] args){
        Integer[]nums = new Integer[100];
        for(int i=0;i<nums.length;i++){
            nums[i] = (int) (Math.random()*100);
        }
        Selection.sort(nums);
        for (Integer num : nums) {
            System.out.print(num+" ");
        }
    }
}
