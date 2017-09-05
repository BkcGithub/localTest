package designpattern.bridgepattern.pattern1;

/**
 * Created by bkc on 2017/7/27.
 */
public class RedCircle implements DrawApi {
    public void drawCircle(int radius, int x, int y) {
        System.out.println("red, " + radius + " ," + x + " ," + y);
    }
}
