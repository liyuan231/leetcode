package JAVA;

public class AClass implements AInterafce {
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

    @Override
    public void play() {
        System.out.println("AClass is playing!");
    }

//    @Override
//    public void test() {
//        System.out.println("AClass is testing!");
//    }

    public static void main(String[] args) {
        int i=10;
        System.out.println(i);
        AClass aClass = new AClass();
        aClass.play();
        aClass.test();
    }
}
