package test;

import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.MultimediaInfo;

import java.io.File;

public class TestMediaUtil {
    public static void main(String[] args) {
        Encoder encoder = new Encoder();
        String filePath = "/Users/bkc/Documents/WeChatSight314.mp4";
        File source = new File(filePath);

        String s = source.getAbsolutePath();
        boolean b = source.exists();
        MultimediaInfo m = null;
        try {
            m = encoder.getInfo(source);
            if (source.exists()) {
                source.delete();
            }
        } catch (EncoderException e) {
            e.printStackTrace();
        }
        long ls = m.getDuration();

        System.out.println(ls);
    }
}
