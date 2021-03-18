package designPattern.filter;

public class Person {
    private String name;
    private String gender;
    private Integer age;

    public Person(String name, String gender, Integer materialStatus) {
        this.name = name;
        this.gender = gender;
        this.age = materialStatus;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                '}';
    }
}
