package JAVA.serialable;

import org.junit.Test;

import java.io.*;

public class test {
    @Test
    public void test0() throws IOException {
        Student student = new Student(new School("GDUFS", "番禺区"), "Liyuan", 19);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("student.info"));
        objectOutputStream.writeObject(student);
        objectOutputStream.close();
    }

    @Test
    public void test1() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("student.info"));
        Student student = (Student) objectInputStream.readObject();
        System.out.println(student.toString());

    }
}
