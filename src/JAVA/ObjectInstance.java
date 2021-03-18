package JAVA;

//import java.io.Serial;
import java.io.Serializable;

public class ObjectInstance implements Serializable {
//    @Serial
    private static final long serialVersionUID = -1363270264511515744L;
    private static volatile ObjectInstance instance;

    public Object getInstance() {
        if (instance == null) {
            synchronized (ObjectInstance.class) {
                if (instance == null) {
                    instance = new ObjectInstance();
                }
            }
        }
        return instance;
    }

//    @Serial
    public Object readResolve() {
        return getInstance();
    }

    public static void main(String[] args) {
        System.out.println(Pizza.PizzaStatus.ORDERED.ordinal());
    }


}
