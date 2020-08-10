package JAVA;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectTest {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> klass = AClass.class;
        klass.newInstance();
//        Method[] methods = klass.getDeclaredMethods();
//        for (Method method : methods) {
//            System.out.println(method);
//        }
        Constructor<?> constructor = klass.getConstructor();
        AClass aClass = (AClass) constructor.newInstance();
//        Method setGender = klass.getDeclaredMethod("setGender", String.class);
//        setGender.invoke(aClass,"男人！");
//
//        Method method = klass.getDeclaredMethod("sayGender");
//        method.setAccessible(true);
//        method.invoke(aClass);
//
//
//        Method sayGender = klass.getDeclaredMethod("sayName");
//        Field[] fields = klass.getDeclaredFields();
//        for (Field field : fields) {
//            System.out.println(field);
//        }
//        Field field = klass.getDeclaredField("name");
//        field.setAccessible(true);
//        field.set(aClass,"李源");
//        sayGender.setAccessible(true);
//        sayGender.invoke(aClass);


    }
}
