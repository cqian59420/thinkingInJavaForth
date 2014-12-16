package annotation;

import java.lang.reflect.Field;

/**
 * Created by Terrance on 2014/12/15 2014/12/15.
 * ${todo} describe
 */
public class FruitInfoUtil {

    public static void getFruitInfo(Class<?> clazz){
        String strFruitName="水果的名字";
        String strFruitColor="水果的颜色";
        String strFruitProvider="供应商名称";

        Field[] fields = clazz.getDeclaredFields();

        for (Field field:fields) {
            if (field.isAnnotationPresent(FruitName.class)){
                FruitName fruitName = (FruitName) field.getAnnotation(FruitName.class);
                strFruitName = strFruitName+fruitName.value();
                System.out.println(strFruitName);
            }else if(field.isAnnotationPresent(FruitColor.class)){
                FruitColor fruitColor =(FruitColor) field.getAnnotation(FruitColor.class);
                strFruitColor = strFruitColor+fruitColor.fruitColor().toString();
                System.out.println(strFruitColor);
            }else if(field.isAnnotationPresent(FruitProvider.class)){
                FruitProvider fruitProvider =(FruitProvider) field.getAnnotation(FruitProvider.class);
                strFruitProvider = strFruitProvider+fruitProvider.id()+fruitProvider.address()+fruitProvider.name();
                System.out.println(strFruitProvider);
            }
        }
    }
}
