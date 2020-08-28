package JAVA.serialable;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Student implements Serializable,Cloneable{
    private static final long serialVersionUID = -5043817884728065170L;
    private School school;

    private String name;
    private int age;

    public Student() {
    }

    public Student(School school, String name, int age) {
        this.school = school;
        this.name = name;
        this.age = age;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }



    public void test() {
        System.out.println("test");
    }

    public static void testStatic() {
        System.out.println("testStatic");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }


    @Override
    public String toString() {
        return "Student{" +
                "school=" + school.toString() +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        System.out.println("调用自定义的writeObject方法！");
        out.writeObject(school);
        out.writeObject(name);
        out.writeInt(age);
    }
    private void readObject(ObjectInputStream in){
        System.out.println("调用自定义的readObject方法！");
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
