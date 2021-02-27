package designPattern.visitor.visitor.impl;

import designPattern.visitor.user.impl.Student;
import designPattern.visitor.user.impl.Teacher;
import designPattern.visitor.visitor.Visitor;

public class Parent implements Visitor {
    @Override
    public void visit(Student student) {
        System.out.println("家长访问 -> " + student.toString());
    }

    @Override
    public void visit(Teacher teacher) {
        System.out.println("家长访问 -> " + teacher.toString());
    }
}
