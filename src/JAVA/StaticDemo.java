package JAVA;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class StaticDemo {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException, ClassNotFoundException {
//        StaticBean s1 = new StaticBean("1");
//        StaticBean s2 = new StaticBean("2");
//
//        StaticBean.age = -1;
//        System.out.println(s1.toString());
//        System.out.println(s2.toString());
//        StaticBean.sayHello();

        //1.获取class对象
        //(1)TargetObject.class

//        Class<String> s = String.class;
//        Class<String> s = (Class<String>) Class.forName("java.lang.String");
        Class<?> s = ClassLoader.getSystemClassLoader().loadClass("java.lang.String");
        Constructor<String> constructor = (Constructor<String>) s.getConstructor();
        String s1 = constructor.newInstance();
        Field value = s.getDeclaredField("value");
        value.setAccessible(true);
        value.set(s1, new byte[]{97, 98, 99});
        System.out.println(s1);

        System.out.println("------------");
        Class<?> aClass = Class.forName("JAVA.TargetObject");
        TargetObject obj = (TargetObject) aClass.getConstructor().newInstance();
        Method publishMethod = aClass.getDeclaredMethod("publishMethod", String.class);
        publishMethod.invoke(obj,"yuanxi");

        Method privateMethod = aClass.getDeclaredMethod("privateMethod");
        privateMethod.setAccessible(true);
        privateMethod.invoke(obj);
    }
}
