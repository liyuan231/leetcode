package designPattern.factoryMethod;

import designPattern.factoryMethod.factory.ProductFactory;
import designPattern.factoryMethod.product.Product;

public class ProductCFactory implements ProductFactory {

    @Override
    public Product getProduct() {
        return new ProductC();
    }
}
