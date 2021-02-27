package javaEffective;

public class je_24 {
    public void test() {
        System.out.println("test!");
    }

    public class Inner {
        public void test() {
            System.out.println("test-inner!");
        }

        public M_Car getCar() {
            class BMW extends M_Car {
                @Override
                public void paint() {
                    System.out.println("BMW");
                }
            }
            return new BMW();
        }
    }

    public static void main(String[] args) {
        Inner inner = new je_24().new Inner();
        inner.test();
        System.out.println(inner.getCar());
        inner.getCar().paint();
    }

}

class M_Car {
    public void paint() {
        System.out.println("car!");
    }
}
