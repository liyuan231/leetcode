package designPattern.simpleFactory;

public class ProductFactory {
    public static Product getProduct(String productName) {
        if (productName.equals("productA")) {
            return new ProductA();
        } else if (productName.equals("productB")) {
            return new ProductB();
        }
        //若我在加一种产品ProductC，则需要在此处多些一个判断语句
        else if (productName.equals("productC")) {
            return new ProductC();
        }
        throw new RuntimeException("ProductName not found!");
    }
}
