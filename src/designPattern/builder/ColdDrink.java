package designPattern.builder;

public abstract class ColdDrink implements Item {

    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();
}
