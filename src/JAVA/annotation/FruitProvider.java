package JAVA.annotation;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitProvider {
    /**
     * 供应商id
     * @return
     */
    public int id() default -1;

    /**
     * 供应商名称
     * @return
     */
    public String name() default "";


    /**
     * 供应商地址
     * @return
     */
    public String address() default "";
}
