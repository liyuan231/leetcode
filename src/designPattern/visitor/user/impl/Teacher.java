package designPattern.visitor.user.impl;

import designPattern.visitor.user.User;
import designPattern.visitor.visitor.Visitor;

import java.math.BigDecimal;

public class Teacher extends User {

    public Teacher(String name, String identity, String clazz) {
        super(name, identity, clazz);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }


    public double entranceRatio() {
        return BigDecimal.valueOf(Math.random() * 100).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", identity='" + identity + '\'' +
                ", clazz='" + clazz + '\'' +
                '}';
    }
}
