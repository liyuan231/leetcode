package JAVA;

import java.io.*;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
//        Test test = new Test();
//        System.out.println(test.hashCode());
        Student s1 = new Student("20181003114", "liyuan", 20);
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("./student.ser"))) {
            System.out.println(s1);
            objectOutputStream.writeObject(s1);
        }
        Student s2 = null;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("./student.ser"))) {
            s2 = (Student) objectInputStream.readObject();
            System.out.println(s2);
        }
//        Scanner scanner = new Scanner(System.in);
//        String next = scanner.next();
//        System.out.println(next);

//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String s = reader.readLine();
//        System.out.println(s);

        String s="liyuan";
        System.out.println(s+": "+s.hashCode());
        Field value = s.getClass().getDeclaredField("value");
        value.setAccessible(true);
        byte[] o = (byte[]) value.get(s);
        o[0] = '1';
        o[1]='2';
        o[2]='3';
        o[3]='4';

        System.out.println(s+" "+s.hashCode());
        System.out.println(testFinally());

    }

    public static int testFinally(){
        try{
            return -1;
        }finally {
            return -2;
        }
    }

    @org.junit.Test
    public void retrieveInput() {

    }

}
class TestException extends RuntimeException{

}

class Student implements Serializable {
//    @Serial
    private static final long serialVersionUID = 4256990102826690838L;

    private final transient String number;
    private String name;
    private int age;


    public Student(String number, String name, int age) {
        this.number = number;
        this.name = name;
        this.age = age;
    }

    public String getNumber() {
        return number;
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

    public void setAge(int age) {
        this.age = age;
    }
}
