package rmi;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingException;
import java.util.Enumeration;

/**
 * Created by Terrance on 2014/12/15 2014/12/15.
 * ${todo} describe
 */
public class Client {

    public static void main(String[] args) throws NamingException {
        Context namingContext = new InitialContext();
        Enumeration<NameClassPair> e = namingContext.list("rmi://127.0.0.1/");
        while(e.hasMoreElements()){
            System.out.println(e.nextElement().getName());
        }
    }
}
