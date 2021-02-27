package designPattern.visitor2;

import designPattern.visitor2.staff.Engineer;
import designPattern.visitor2.staff.Manager;
import designPattern.visitor2.staff.Staff;
import designPattern.visitor2.visit.CEO;
import designPattern.visitor2.visit.CTO;
import designPattern.visitor2.visit.Visitor;

import java.util.LinkedList;
import java.util.List;

public class DataView {

    private List<Staff> staff = new LinkedList<>();

    public DataView() {
        staff.add(new Manager("经理-A"));
        staff.add(new Engineer("工程师-A"));
        staff.add(new Engineer("工程师-B"));
        staff.add(new Engineer("工程师-C"));
        staff.add(new Manager("经理-B"));
        staff.add(new Engineer("工程师-D"));
    }


    public void show(Visitor visitor) {
        for (Staff s : staff) {
            s.accept(visitor);
        }
    }

    public static void main(String[] args) {
        DataView dataView = new DataView();
        dataView.show(new CEO());
        System.out.println("==========");
        dataView.show(new CTO());
    }
}
