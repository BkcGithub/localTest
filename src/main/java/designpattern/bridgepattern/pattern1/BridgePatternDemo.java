package designpattern.bridgepattern.pattern1;

/**
 * Created by bkc on 2017/7/27.
 */
public class BridgePatternDemo {
    public static void main(String[] args) {
        Shape redCircle = new Circle(100, 100, 10, new RedCircle());
        Shape greenCircle = new Circle(100, 200, 10, new GreenCircle());

        redCircle.draw();
        greenCircle.draw();
    }
}
