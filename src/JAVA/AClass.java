package JAVA;

public class AClass {
    private static String name;
    private String gender;

    private static void sayName() {
        System.out.println(name);
    }

    private void sayGender() {
        System.out.println(gender);
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        AClass.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
