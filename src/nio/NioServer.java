package nio;

import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.Iterator;

/**
 * Created by Terrance on 2014/12/16 2014/12/16.
 * ${todo} describe
 */
public class NioServer {
    public static final int port = 10001;
    int clientCount;

    protected Selector selector;

    protected Charset charset = Charset.forName("UTF-8");
    protected CharsetEncoder charsetEncoder = charset.newEncoder();
    protected CharsetDecoder charsetDecoder = charset.newDecoder();

    public NioServer() throws Exception {
        //静态方法，创建一个selector实例
        selector = Selector.open();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(port));
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        System.out.println("Server：localhost " + port + "开始等待服务请求");

        while (true) {
            //selector通过调用select()，将注册的channel中有事件发生的取出来进行处理。监控所有注册的channel，当其中有注册的IO操作可以进行时，该函数返回，并将对应的SelectionKey加入selected-key set。
            selector.select();
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                iterator.remove();
                handleSelectedKeys(selectionKey);
            }

        }
    }

    private void handleSelectedKeys(SelectionKey selectionKey) throws Exception {

        if (selectionKey.isAcceptable()) {
            System.out.println("通道已准备好接受新的套接字连接");
            clientCount++;

            ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
            SocketChannel socketChannel = serverSocketChannel.accept();
            socketChannel.configureBlocking(false);
            Socket socket = socketChannel.socket();

            SelectionKey key = socketChannel.register(selector, SelectionKey.OP_READ);
            key.attach("第 " + clientCount + " 个客户端 [" + socket.getRemoteSocketAddress() + "]: ");

        } else if (selectionKey.isReadable()) {
            System.out.println("通道已准备好进行读取");
            // 有消息进来

            ByteBuffer byteBuffer = ByteBuffer.allocate(100);
            SocketChannel socketChannel = (SocketChannel) selectionKey.channel();

            try {
                int len = socketChannel.read(byteBuffer);

                // 如果len>0，表示有输入。如果len==0, 表示输入结束。需要关闭 socketChannel
                if (len > 0) {

                    byteBuffer.flip();
                    String msg = charsetDecoder.decode(byteBuffer).toString();

                    // 根据客户端的消息，查找到对应的输出
                    String newMsg = "哈哈";//talks.getProperty(msg);
                    if (newMsg == null)
                        newMsg = "Sorry? I don't understand your message. ";

                    // UTF-8 格式输出到客户端，并输出一个'n'

                    socketChannel.write(charsetEncoder.encode(CharBuffer.wrap(newMsg + "\n")));
                    p(selectionKey.attachment() + "\t[recieved]: " + msg + " ----->\t[send]: " + newMsg);

                } else {
                    // 输入结束，关闭 socketChannel
                    p(selectionKey.attachment() + "read finished. close socketChannel. ");
                    socketChannel.close();
                }

            } catch (Exception e) {

                // 如果read抛出异常，表示连接异常中断，需要关闭 socketChannel
                e.printStackTrace();

                p(selectionKey.attachment() + "socket closed? ");
                socketChannel.close();
            } finally {
                socketChannel.close();
            }

        } else if (selectionKey.isWritable()) {
            p(selectionKey.attachment() + "TODO: isWritable() ???????????????????????????? ");
        } else if (selectionKey.isConnectable()) {
            p(selectionKey.attachment() + "TODO: isConnectable() ????????????????????????? ");
        } else {
            p(selectionKey.attachment() + "TODO: else. ");
        }

    }


    private void p(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) throws Exception {
        NioServer nioServer = new NioServer();
    }
}
