package designPattern.template.group;

import designPattern.template.NetMall;

import java.util.HashMap;
import java.util.Map;

public class TaoBaoNetMall extends NetMall {
    public TaoBaoNetMall(String uId, String uPwd) {
        super(uId, uPwd);
    }

    @Override
    protected String createBase64(Map<String, String> reptile) {
        System.out.println("模拟淘宝生成海报！");
        return "淘宝海报！";
    }

    @Override
    protected boolean login(String uId, String uPwd) {
        System.out.println("模拟淘宝登陆");
        return true;
    }

    @Override
    protected Map<String, String> reptile(String skuUrl) {
        Map<String, String> map = new HashMap<>();
        System.out.println("模拟淘宝爬虫");
        return map;
    }
}
