package designPattern.visitor2.visit;

import designPattern.visitor2.staff.Engineer;
import designPattern.visitor2.staff.Manager;

public interface Visitor {
    void visit(Engineer engineer);

    void visit(Manager manager);

}
