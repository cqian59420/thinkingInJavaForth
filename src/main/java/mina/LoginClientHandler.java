package mina;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by Terrance on 2014/12/17.
 */
public class LoginClientHandler extends IoHandlerAdapter {

    private static Logger logger = LoggerFactory.getLogger(LoginServer.class);
    @Override
    public void messageSent(IoSession session, Object message) throws Exception {
        String msgFServer = message.toString();
        logger.info(msgFServer);
    }

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        super.messageReceived(session, message);
    }
}
