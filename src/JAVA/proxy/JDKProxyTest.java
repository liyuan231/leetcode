package JAVA.proxy;

import net.sf.cglib.core.DebuggingClassWriter;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxyTest {
    public static void main(String[] args) {
        Student student = new Student("LIYUAN", "GDUFS", 19);
        //CGlib
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\Cache\\IdeaProjects\\leetcode\\src\\JAVA\\proxy");
        //JDK
        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");
        Object o = Proxy.newProxyInstance(Student.class.getClassLoader(),
                Student.class.getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object invoke = method.invoke(student, args);
                        return invoke;
                    }
                });

        SomethingThatAStudentShouldDo somethingThatAStudentShouldDo = (SomethingThatAStudentShouldDo) o;
//        System.out.println();
        System.out.println(o.getClass());
        System.out.println(o.toString());
        ((SomethingThatAPersonShouldDo) o).write();
        somethingThatAStudentShouldDo.drink();
        somethingThatAStudentShouldDo.play();
//        System.out.println(student.toString());
    }

    @Test
    public void test() throws ClassNotFoundException {

    }
}
