package algorithm;

public class a1_2_6 {
    public static void main(String[] args) {
        System.out.println(isCyclic("ACTGACGZ", "TGACGAC"));
    }
    public static boolean isCyclic(String s1,String s2){
        return s1.length()==s2.length()&& (s1 + s1).contains(s2);
    }
}
