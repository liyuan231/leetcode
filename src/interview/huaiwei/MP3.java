//package interview.huaiwei;
//
//import java.util.Scanner;
//
//public class MP3 {
//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        int sum = input.nextInt();//总共有多少首歌曲
//        String commands = input.next();
//        int size = 4;//屏幕可容纳多少首歌曲
//        int[] nums = new int[sum];
//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = i + 1;
//        }
//        int cp = 0, start = 0, end = size - 1;
//        for (int i = 0; i < commands.length(); i++) {
//            System.out.println(nums[start] + "~" + nums[end]);
//            char command = commands.charAt(i);
//            if (command == 'U') {
//                cp = cp - 1;
//                //第一条向上
//                if (cp == -1) {
//                    cp = sum;
//                    end = sum - 1;
//                    start = end - size - 1;
//                    continue;
//                }
//                if (cp<nums[start] && nums[end] - size) {
//
//                }
//            } else if (command == 'D') {
//                cp = cp + 1; //到了末尾
//                if (cp == sum + 1) {
//                    //回到第一页
//                    cp = 1;
//                    start = 0;
//                    end = size - 1;
//                    continue;
//                }
//                if (cp > nums[end] && nums[start] + size <= sum) {
//                    start++;
//                    end++;
//                }
//            }
//        }
//    }
//
////    @Test
////    public void t() throws IOException {
////        Set<String> classmates = new HashSet<>();
////        try (BufferedReader dnow = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\Administrator\\Desktop\\now.txt")))) {
////            String line = null;
////            while ((line = dnow.readLine()) != null) {
////                classmates.add(line);
////            }
////
////        }
////        try (BufferedReader dclazz = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\Administrator\\Desktop\\classmates.txt"), "gbk"));) {
////            String line = null;
////            while ((line = dclazz.readLine()) != null) {
////                if(!classmates.contains(line)){
////                    System.out.println(line);
////                }
////            }
////        }
////    }
//}
