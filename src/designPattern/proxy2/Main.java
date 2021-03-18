package designPattern.proxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        RealImage realImage = new RealImage("fileName");
        Image image = (Image) Proxy.newProxyInstance(Image.class.getClassLoader(), new Class[]{Image.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object invoke = method.invoke(realImage, args);
                return invoke;
            }
        });
        image.display();
    }
}
