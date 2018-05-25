package nio;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

public class TestSelector {
    public static void main(String[] args) {
        try {
            Selector selector = Selector.open();
            SocketChannel channel = SocketChannel.open( );
            channel.configureBlocking(false);
            SelectionKey selectionKey = channel.register(selector, SelectionKey.OP_READ);

            selectionKey = channel.register(selector, SelectionKey.OP_CONNECT);

            int interestSet = selectionKey.interestOps();

            int connect = interestSet & SelectionKey.OP_CONNECT;


            int read = interestSet & SelectionKey.OP_READ;

            System.out.println(read);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
