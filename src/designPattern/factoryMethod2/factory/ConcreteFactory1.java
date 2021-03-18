package designPattern.factoryMethod2.factory;

import designPattern.factoryMethod2.product.ConcreteProduct1;
import designPattern.factoryMethod2.product.Product;

public class ConcreteFactory1 implements AbstractFactory {
    @Override
    public Product newProduct() {
        return new ConcreteProduct1();
    }
}
