package designPattern.proxy.jdk.d;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        SmsService smsService = new SmsServiceImpl();
        SmsService s = (SmsService) Proxy.newProxyInstance(smsService.getClass().getClassLoader(), new Class[]{SmsService.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("发送短信前:");
                Object invoke = method.invoke(smsService, args);
                System.out.println("发送短信后:");
                return invoke;
            }
        });
        s.send("nihao");
    }
}
