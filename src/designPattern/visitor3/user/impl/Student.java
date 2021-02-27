package designPattern.visitor3.user.impl;

import designPattern.visitor3.user.AbstractUser;
import designPattern.visitor3.visitor.Visit;

public class Student extends AbstractUser {

    public Student(String name, int age) {
        super(name, age);
    }

    @Override
    public void accept(Visit visit) {
        visit.visit(this);
    }
}
