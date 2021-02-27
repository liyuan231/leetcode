package designPattern.visitor2.staff;

import java.util.Random;

public class Engineer extends Staff {

    @Override
    public void accept(designPattern.visitor2.visit.Visitor visitor) {
        visitor.visit(this);
    }

    public Engineer(String name) {
        super(name);
    }

    public Integer getCodeLines() {
        return new Random().nextInt(10 * 1000);
    }

}
