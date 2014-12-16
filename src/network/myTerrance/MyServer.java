package network.myTerrance;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Terrance on 2014/12/12 2014/12/12.
 * ${todo} describe
 */
public class MyServer {

    public void startServer(int port) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream inputStream = null;
        OutputStream os = null;
        try {
            serverSocket = new ServerSocket(port);
            while (true) {
                socket = serverSocket.accept();
                inputStream = socket.getInputStream();

                byte[] b = new byte[1024];
                int n = inputStream.read(b);
                System.out.println("客户端发送内容为：" + new String(b, 0, n));
            }
            /*os = socket.getOutputStream();
            os.write(b, 0, n);*/
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                os.close();
                inputStream.close();
                socket.close();
               // serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MyServer myServer = new MyServer();
        myServer.startServer(10001);
    }
}
