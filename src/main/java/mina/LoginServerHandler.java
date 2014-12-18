package mina;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Terrance on 2014/12/17.
 */
public class LoginServerHandler extends IoHandlerAdapter {
    private static Logger logger = LoggerFactory.getLogger(LoginServer.class);
    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        String resultMsg = message.toString();
        System.out.println(resultMsg);
        if ("bye".equals(resultMsg)) {
            session.close(true);
        }

        //简单模拟业务逻辑处理
        String[] userInfo = resultMsg.split(",");
        String username = userInfo[0];
        String password = userInfo[1];

        if (username.equals("admin") && password.equals("3")) {
            session.write("login success...");
        } else {
            session.write("login error...");
        }
    }

    @Override
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
        logger.error("dasdada",cause.getCause());
        cause.printStackTrace();
    }

    @Override
    public void messageSent(IoSession session, Object message) throws Exception {
        logger.info("message success sent");
    }
}
