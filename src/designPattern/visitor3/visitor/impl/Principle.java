package designPattern.visitor3.visitor.impl;

import designPattern.visitor3.user.impl.Student;
import designPattern.visitor3.user.impl.Teacher;
import designPattern.visitor3.visitor.Visit;

public class Principle implements Visit {
    @Override
    public void visit(Teacher teacher) {
        System.out.println("校长->"+teacher.toString());
    }

    @Override
    public void visit(Student student) {
        System.out.println("校长->"+student.toString());
    }
}
