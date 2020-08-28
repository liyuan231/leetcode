package JAVA.annotation;

public class AClass {
    private String NAME;
    private int AGE;

    public AClass() {
    }

    public AClass(String NAME, int AGE) {
        this.NAME = NAME;
        this.AGE = AGE;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public int getAGE() {
        return AGE;
    }

    public void setAGE(int AGE) {
        this.AGE = AGE;
    }

    public static class AStaticInnerClass {
        private String name;
        private int age;

        public AStaticInnerClass() {
        }

        public AStaticInnerClass(String name, int age) {
            this.name = name;
            this.age = age;
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

        @Override
        public String toString() {
            return "AStaticInnerClass{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

    }

    @Override
    public String toString() {
        return "AClass{" +
                "NAME='" + NAME + '\'' +
                ", AGE=" + AGE +
                '}';
    }

    class AInnerClas{
        private int a;
        private int b;


        public  int max(){
            throw new UnsupportedOperationException();
        }
    }
    public static void main(String[] args) {
        AClass aClass = new AClass();
        System.out.println(aClass.toString());
        AClass.AStaticInnerClass aStaticInnerClass = new AStaticInnerClass();
        System.out.println(aStaticInnerClass.toString());

    }
}
