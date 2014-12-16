package annotation;

import java.lang.annotation.*;

/**
 * Created by Terrance on 2014/12/15 2014/12/15.
 * ${todo} describe
 */
@Target(ElementType.FIELD)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface FruitProvider {

    public int id() default -1;
    public String name() default "";
    public String address() default "";
}
