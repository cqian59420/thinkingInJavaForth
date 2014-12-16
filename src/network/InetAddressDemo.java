package network;

import javax.net.SocketFactory;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by Terrance on 2014/12/11 2014/12/11.
 * ${todo} describe
 */
public class InetAddressDemo {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress inet1 = InetAddress.getByName("www.163.com");
        System.out.println(inet1);
        //使用IP创建对象
        InetAddress inet2 = InetAddress.getByName("127.0.0.1");
        System.out.println(inet2);
        //获得本机地址对象
        InetAddress inet3 = InetAddress.getLocalHost();
        System.out.println(inet3);
        //获得对象中存储的域名
        String host = inet3.getHostName();
        System.out.println("域名：" + host);
        //获得对象中存储的IP
        String ip = inet3.getHostAddress();
        System.out.println("IP:" + ip);


        Socket socket = new Socket();
    }
}
