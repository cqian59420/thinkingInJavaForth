package annotation;

import java.lang.annotation.*;

/**
 * Created by Terrance on 2014/12/15 2014/12/15.
 * ${todo} describe
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitColor {

   public enum Color{BLUE,RED,GREEN};

   Color fruitColor() default Color.GREEN;
}
