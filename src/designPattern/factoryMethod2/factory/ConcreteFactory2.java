package designPattern.factoryMethod2.factory;

import designPattern.factoryMethod2.product.ConcreteProduct2;
import designPattern.factoryMethod2.product.Product;

public class ConcreteFactory2 implements AbstractFactory {
    @Override
    public Product newProduct() {
        return new ConcreteProduct2();
    }
}
