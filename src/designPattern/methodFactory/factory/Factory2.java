package designPattern.methodFactory.factory;

import designPattern.methodFactory.Product;
import designPattern.methodFactory.Product2;

public class Factory2 implements AbstractFactory{
    @Override
    public Product newProduct() {
        return new Product2();
    }
}
