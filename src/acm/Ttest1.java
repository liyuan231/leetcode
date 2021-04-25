package acm;

public class Ttest1 {
    public static void main(String[] args) {
        StringBuilder sb1 = new StringBuilder("abc");
        StringBuilder sb2 = new StringBuilder("cef");
        StringBuilder sb3 = sb2;
        sb3 = new StringBuilder("777");
        System.out.println(sb2);
    }
}
