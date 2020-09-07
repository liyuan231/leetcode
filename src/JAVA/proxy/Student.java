package JAVA.proxy;

public class Student implements SomethingThatAStudentShouldDo,SomethingThatAPersonShouldDo {
    private String name;
    private String school;
    private Integer age;

    public Student() {
    }

    public Student(String name, String school, Integer age) {
        this.name = name;
        this.school = school;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", school='" + school + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public void study() {
        System.out.println(this + " is studying!");
    }

    @Override
    public void play() {
        System.out.println(this + " is playing!");
    }

    @Override
    public void write() {
        System.out.println(this+" is writing!");
    }
}
