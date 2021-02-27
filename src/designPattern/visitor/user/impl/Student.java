package designPattern.visitor.user.impl;

import designPattern.visitor.user.User;
import designPattern.visitor.visitor.Visitor;

public class Student extends User {

    public Student(String name, String identity, String clazz) {
        super(name, identity, clazz);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public int ranking() {
        return (int) (Math.random() * 100);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", identity='" + identity + '\'' +
                ", clazz='" + clazz + '\'' +
                '}';
    }
}
