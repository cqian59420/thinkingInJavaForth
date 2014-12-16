package annotation;

import org.junit.Test;

public class SayHell {
    @HelloWorld(name = " 小明 ")
    public void sayHello(String name){
        if(name == null || name.equals("")){
            System.out.println("hello world!");
        }else{
            System.out.println(name + "say hello world!");
        }
    }
    
   /* public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, SecurityException, NoSuchMethodException, InstantiationException {
        ParseAnnotation parse = new ParseAnnotation();
        parse.parseMethod(SayHell.class);
        parse.parseType(SayHell.class);
    }*/
}