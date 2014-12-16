package annotation;

import org.junit.Test;

/**
 * Created by Terrance on 2014/12/15 2014/12/15.
 * ${todo} describe
 */
public class testPubServer {


    @Test
    @PubServer(server = "12.12.12.1",port = 12)
    public void main(String server,int port) {
        System.out.println(server+"aaaa"+port);
    }


}
