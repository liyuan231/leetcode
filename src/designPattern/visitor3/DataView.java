package designPattern.visitor3;

import designPattern.visitor3.user.AbstractUser;
import designPattern.visitor3.user.impl.Student;
import designPattern.visitor3.user.impl.Teacher;
import designPattern.visitor3.visitor.Visit;
import designPattern.visitor3.visitor.impl.Parent;
import designPattern.visitor3.visitor.impl.Principle;

import java.util.LinkedList;
import java.util.List;

public class DataView {
    private List<AbstractUser> userList = new LinkedList<>();

    public DataView() {
        userList.add(new Teacher("teacher1", 34));
        userList.add(new Teacher("teacher2", 65));
        userList.add(new Student("liyuan", 19));
    }


    public void show(Visit visit) {
        for (AbstractUser abstractUser : userList) {
            abstractUser.accept(visit);
        }
    }

    public static void main(String[] args) {
        DataView dataView = new DataView();
        dataView.show(new Principle());
        System.out.println("======================");
        dataView.show(new Parent());
    }
}
