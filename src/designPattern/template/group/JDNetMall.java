package designPattern.template.group;

import designPattern.template.HttpClient;
import designPattern.template.NetMall;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JDNetMall extends NetMall {

    public JDNetMall(String uId, String uPwd) {
        super(uId, uPwd);
    }

    @Override
    protected String createBase64(Map<String, String> reptile) {
        System.out.println("模拟生成京东商品base64海报");
        return "京东海报";
    }

    @Override
    protected boolean login(String uId, String uPwd) {
        System.out.println("模拟京东登录！");
        return true;
    }

    @Override
    protected Map<String, String> reptile(String skuUrl) {
        String str = HttpClient.doGet(skuUrl);
        Pattern p9 = Pattern.compile("(?<=title>).*(?=</title)");
        Matcher m9 = p9.matcher(str);
        Map<String, String> map = new ConcurrentHashMap<>();
        if (m9.find()) {
            map.put("name", m9.group());
        }
        map.put("price", "99");
        System.out.println(String.format("模拟京东爬虫解析:%s | %s 元 %s", map.get("name"), map.get("price"), skuUrl));
        return map;
    }

}
