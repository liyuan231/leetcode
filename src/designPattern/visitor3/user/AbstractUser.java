package designPattern.visitor3.user;

import designPattern.visitor3.visitor.Visit;

public abstract class AbstractUser {
    public String name;
    public int age;

    public AbstractUser(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public abstract void accept(Visit visit);


    @Override
    public String toString() {
        return "AbstractUser{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
