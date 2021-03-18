package designPattern.proxy.cglib;

import designPattern.proxy.jdk.d.SmsServiceImpl;

public class Main {
    public static void main(String[] args) {
        SmsServiceImpl proxy = (SmsServiceImpl) CglibProxyFactory.getProxy(SmsServiceImpl.class);
        proxy.send("你好！");

    }
}
