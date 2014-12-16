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
public @interface ValueBind {
    enum fieldBind{String,INT};
    fieldBind type();
    String value();
}
