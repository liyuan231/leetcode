package designPattern.meditor;

public class Main {
    public static void main(String[] args) {
        ConcreteMeditor concreteMeditor = new ConcreteMeditor();
        Colleague c1 = new ConcreteColleague1();
        Colleague c2 = new ConcreteColleague2();
        concreteMeditor.register(c1);
        concreteMeditor.register(c2);
        c1.send();;
        System.out.println("============");
        c2.send();
    }
}
