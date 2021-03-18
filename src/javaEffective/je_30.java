//package javaEffective;
//
//import java.util.HashSet;
//import java.util.Set;
//import java.util.function.UnaryOperator;
//
//public class je_30 {
//    private static UnaryOperator<Object> IDENTITY_FN = (o) -> o;
//
//    @SuppressWarnings("unchecked")
//    public static <T> UnaryOperator<T> identityFUnction() {
//        return (UnaryOperator<T>) IDENTITY_FN;
//    }
//
//    public static void main(String[] args) {
//        Set<String> s1 = Set.of("1", "2", "3", "4", "5");
//        Set<String> s2 = Set.of("6", "-11", "8", "9");
//        Set<String> union = union(s1, s2);
//        System.out.println(union);
//        System.out.println("==================");
//        String[] strings = {"liyuan", "yuanli", "ly", "yl"};
//        UnaryOperator<String> sameString = identityFUnction();
//        for (String string : strings) {
//            System.out.println(sameString.apply(string));
//        }
//    }
//
//
//    public static <E> Set<E> union(Set<E> s1, Set<E> s2) {
//        Set<E> result = new HashSet<>(s1);
//        result.addAll(s2);
//        return result;
//    }
//
//}
