package designPattern.simpleFactory;

public class test {
    public static void main(String[] args) {
        Product productA = ProductFactory.getProduct("productA");
        System.out.println(productA.toString());
        Product productB = ProductFactory.getProduct("productB");
        System.out.println(productB.toString());
        //当我想要扩展ProductC时，我需要修改ProductFactory的方法，增多一个判断条件，不符合开闭原则
    }
}
