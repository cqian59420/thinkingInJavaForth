package mina;

import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.LineDelimiter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

public class LoginClient {
    private static Logger logger = LoggerFactory.getLogger(LoginServer.class);
    private static String HOST = "127.0.0.1";
    private static int PORT = 3005;  
  
    public static void main(String[] args) {  
        IoConnector connector = new NioSocketConnector();
        connector.setConnectTimeoutMillis(3000);  
        connector.getFilterChain().addLast("codec",  
                new ProtocolCodecFilter(
                        new TextLineCodecFactory(Charset.forName("UTF-8"))
                        ));  
  
        connector.setHandler(new LoginClientHandler());  
        IoSession session = null;
          
        try {  
            ConnectFuture future = connector.connect(new InetSocketAddress(HOST, PORT));
              
            future.awaitUninterruptibly();  
            session = future.getSession();  
            session.write("admin,3");  
        } catch (Exception e) {
            logger.error("connecting error...", e);
        }  
        session.getCloseFuture().awaitUninterruptibly();  
        connector.dispose();  
    }  
}  
  