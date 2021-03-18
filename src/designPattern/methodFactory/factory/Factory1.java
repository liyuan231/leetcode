package designPattern.methodFactory.factory;

import designPattern.methodFactory.Product;
import designPattern.methodFactory.Product1;

public class Factory1 implements AbstractFactory {
    @Override
    public Product newProduct() {
        return new Product1();
    }
}
