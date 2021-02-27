package designPattern.visitor3.visitor;

import designPattern.visitor3.user.impl.Student;
import designPattern.visitor3.user.impl.Teacher;

public interface Visit {


    public void visit(Teacher teacher);

    public void visit(Student student);
}
