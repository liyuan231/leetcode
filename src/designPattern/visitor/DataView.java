package designPattern.visitor;

import designPattern.visitor.user.User;
import designPattern.visitor.user.impl.Student;
import designPattern.visitor.user.impl.Teacher;
import designPattern.visitor.visitor.Visitor;
import designPattern.visitor.visitor.impl.Parent;
import designPattern.visitor.visitor.impl.Principal;

import java.util.ArrayList;
import java.util.List;

public class DataView {
    List<User> userList = new ArrayList<>();

    public DataView() {
        userList.add(new Student("学生1", "理科班", "A班"));
        userList.add(new Student("学生2", "文科班", "B班"));
        userList.add(new Student("学生3", "理科班", "A班"));
        userList.add(new Student("学生4", "文科班", "B班"));
        userList.add(new Teacher("老师1", "高级教师", "文科班A班"));
        userList.add(new Teacher("老师2", "特级教师", "文科班B班"));
        userList.add(new Teacher("老师3", "普通教师", "理科班A班"));
    }

    public void show(Visitor visitor) {
        for (User user : userList) {
            user.accept(visitor);
        }
    }


    public static void main(String[] args) {
        DataView dataView = new DataView();
        dataView.show(new Parent());
        dataView.show(new Principal());
    }
}
