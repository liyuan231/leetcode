package designPattern.template;

import designPattern.template.group.DangDangNetMall;
import designPattern.template.group.JDNetMall;
import designPattern.template.group.TaoBaoNetMall;

public class TemplateTest {
    public static void main(String[] args) {
        NetMall netMall = new DangDangNetMall("liyuan", "123456");
        netMall.generateGoodsPoster("https://...");
    }
}
