package designPattern.singleton;

public class FinalWrapper<T> {
    public final T value;

    public FinalWrapper(T value) {
        this.value = value;
    }
}

class FinalSingleton {
    private FinalWrapper<FinalSingleton> helperWrapper = null;
    public FinalSingleton getHelper(){
        FinalWrapper<FinalSingleton> wrapper = helperWrapper;
        if(wrapper==null){
            synchronized (this){
                if(helperWrapper==null){
                    helperWrapper = new FinalWrapper<>(new FinalSingleton());
                }
            }
        }
        return helperWrapper.value;
    }
    private Object readResolve(){
        return helperWrapper.value;
    }
}
