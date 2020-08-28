package JAVA.annotation;

public class Apple {
    @FruitProvider(id = 1,name = "苹果供应商",address = "广州")
    private String appleProvider;

    public void setAppleProvider(String appleProvider) {
        this.appleProvider = appleProvider;
    }

    public String getAppleProvider() {
        return appleProvider;
    }
}
