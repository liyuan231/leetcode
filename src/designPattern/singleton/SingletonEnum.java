package designPattern.singleton;

public enum  SingletonEnum {
    INSTANCE;
    SingletonEnum(){}
    private Object readResolve(){
        return INSTANCE;
    }
}
