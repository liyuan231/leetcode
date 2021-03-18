package JAVA;

public class TargetObject {
    private String value;

    public TargetObject() {
        this.value = "java guide";
    }

    public void publishMethod(String s) {
        System.out.println("I love " + s);
    }

    private void privateMethod() {
        System.out.println("value is " + value);
    }
}
