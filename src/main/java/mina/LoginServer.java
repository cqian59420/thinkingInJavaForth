package mina;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.LineDelimiter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

/**
 * Created by Terrance on 2014/12/17.
 */
public class LoginServer {
    public static final int port = 3005;
    private static Logger logger = LoggerFactory.getLogger(LoginServer.class);

    public static void main(String[] args) {
        IoAcceptor acceptor = null;

        try {
            acceptor = new NioSocketAcceptor();
            //acceptor.getFilterChain().addLast("logger",new LoggingFilter());
            acceptor.getFilterChain().addLast("codec", new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8"))));

            acceptor.getSessionConfig().setReadBufferSize(2048);
            acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 10);

            acceptor.setHandler(new LoginServerHandler());

            acceptor.bind(new InetSocketAddress(port));

            logger.info("server start up ok ,port = " + port);
        } catch (IOException e) {
            logger.error("server startup error...", e);
            e.printStackTrace();
        }
    }
}
