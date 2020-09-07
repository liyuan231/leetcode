package JAVA.proxy;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxyTest {
    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,"D:\\Cache\\IdeaProjects\\leetcode\\src\\JAVA\\proxy");
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Student.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("BEFORE");
                Object o1 = methodProxy.invokeSuper(o, objects);
                System.out.println("AFTER");
                return o1;
            }
        });
        Student o = (Student) enhancer.create();
        System.out.println(o.toString());

    }
}
