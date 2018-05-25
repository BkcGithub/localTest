package nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class TestFileChannel {

    public static void main(String[] args) {
        try {
            RandomAccessFile file =
                new RandomAccessFile("/Users/bkc/Desktop/activity_old_belt_new_user_action.sql", "rw");

            FileChannel inChannel = file.getChannel();

            ByteBuffer byteBuffer = ByteBuffer.allocate(48);

            try {
                int byteRead = inChannel.read(byteBuffer);

                while (byteRead != -1) {
                    System.out.println("Read " + byteRead);
                    byteBuffer.flip();
                    while (byteBuffer.hasRemaining()) {
                        System.out.println((char) byteBuffer.get());
                    }
                    byteBuffer.clear();
                    byteRead = inChannel.read(byteBuffer);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
