package designPattern.template;

import java.util.Map;

public abstract class NetMall {

    String uId;
    String uPwd;

    public NetMall(String uId, String uPwd) {
        this.uId = uId;
        this.uPwd = uPwd;
    }

    public String generateGoodsPoster(String skuUrl){
        if(!login(uId,uPwd)){return null;}//1.login
        Map<String,String> reptile = reptile(skuUrl);//2.reptile goods
        return createBase64(reptile);//3.package poster
    }

    protected abstract String createBase64(Map<String, String> reptile);

    protected abstract boolean login(String uId, String uPwd);

    protected abstract Map<String, String> reptile(String skuUrl);
}
