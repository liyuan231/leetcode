package designPattern.visitor.visitor;

import designPattern.visitor.user.User;
import designPattern.visitor.user.impl.Student;
import designPattern.visitor.user.impl.Teacher;

public interface Visitor {
    public void visit(Student student);

    public void visit(Teacher teacher);
}
