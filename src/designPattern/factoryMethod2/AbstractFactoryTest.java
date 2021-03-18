package designPattern.factoryMethod2;

import designPattern.factoryMethod2.factory.AbstractFactory;
import designPattern.factoryMethod2.product.Product;

public class AbstractFactoryTest {
    public static void main(String[] args) {
        AbstractFactory abstractFactory = SupportProductFactory.retrieveFactory("2");
        Product product = abstractFactory.newProduct();
        product.show();
    }
}
