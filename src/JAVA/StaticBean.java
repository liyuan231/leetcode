package JAVA;

public class StaticBean {
    String name;
    static int age;

    public StaticBean(String name) {
        this.name = name;
    }

    static void sayHello() {
        System.out.println("Hello i am java!");
    }

    @Override
    public String toString() {
        return "StaticBean{" +
                "name='" + name + ",age=" + age + '\'' +
                '}';
    }
}
