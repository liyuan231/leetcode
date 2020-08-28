package JAVA.copy;

import JAVA.serialable.School;
import JAVA.serialable.Student;
import org.junit.Test;

public class Copy {
    /**
     * 浅复制
     */
    @Test
    public  void test1() {
        Student student = new Student(new School("GDUFS","番禺区！"),"李源",19);
        Student clone = student;
        student.setName("LIYUAN");
        student.setSchool(new School("GDUFS2","番禺区2"));
        student.setAge(29);
        System.out.println(student.toString());
        System.out.println(clone.toString());
    }
    /**
     * 浅拷贝
     */
    @Test
    public void test2() throws CloneNotSupportedException {
        String name="LIYUAN";
        School school = new School("GDUFS","番禺区！");
        Student student = new Student(school,name,19);
        Student clone = (Student) student.clone();
        name="李源！";
        school.setLocation("广州！");
        System.out.println(student.toString());
        System.out.println(clone.toString());
    }
}
