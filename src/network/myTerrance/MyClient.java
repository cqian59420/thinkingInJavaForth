package network.myTerrance;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by Terrance on 2014/12/12 2014/12/12.
 * ${todo} describe
 */
public class MyClient {

    void sendMessage(final String host,final int port,final String message) {
        Socket socket = null;
        OutputStream os = null;
        InputStream is = null;
        try {
            socket = new Socket(host,port);
            os = socket.getOutputStream();
            os.write(message.getBytes());
            /*//接收数据
            is = socket.getInputStream();
            byte[] b = new byte[1024];
            int n = is.read(b);
            //输出反馈数据
            System.out.println("服务器反馈：" + new String(b, 0, n));*/
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            /*try {
                is.close();
                os.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }*/
        }

    }

    @Test
    public void start(){
        sendMessage("127.0.0.1",10001,"你们好啊");
    }

}
