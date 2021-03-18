package designPattern.proxy.jdk.s;

public class SmsProxy implements SmsService {
    private final SmsService smsService;

    public SmsProxy(SmsService smsService) {
        this.smsService = smsService;
    }

    @Override
    public String send(String message) {
        System.out.println("before send message!");
        String send = smsService.send(message);
        System.out.println("after send message!");
        return send;
    }
}
