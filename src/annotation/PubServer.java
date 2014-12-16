package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Terrance on 2014/12/15 2014/12/15.
 * ${todo} describe
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)

public @interface PubServer {
    public String server() default "127.0.0.1";
    public int port() default 10001;


}
