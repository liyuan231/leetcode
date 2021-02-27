package designPattern.visitor2.staff;

import java.util.Random;

public class Manager extends Staff {
    public Manager(String name) {
        super(name);
    }

    @Override
    public void accept(designPattern.visitor2.visit.Visitor visitor) {
        visitor.visit(this);
    }


    public int getProducts() {
        return new Random().nextInt(10);
    }

}
