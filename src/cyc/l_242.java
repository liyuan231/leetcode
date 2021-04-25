package cyc;

public class l_242 {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] nums1 = new int[26];
        int[] nums2 = new int[26];
        for (int i = 0; i < s.length(); i++) {
            nums1[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            nums2[t.charAt(i) - 'a']++;
        }
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] != nums2[i]) {
                return false;
            }
        }
        return true;
    }
}
