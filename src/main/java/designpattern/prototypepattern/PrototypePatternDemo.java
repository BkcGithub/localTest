package designpattern.prototypepattern;

/**
 * Created by bkc on 2017/7/27.
 */
public class PrototypePatternDemo {
    public static void main(String[] args) {
        ShapeCache.loadShape();

        Shape cloneShape1 = ShapeCache.getShape("1");

        System.out.println(cloneShape1.getType());

        Shape cloneShape2 = ShapeCache.getShape("2");
        System.out.println(cloneShape2.getType());
    }
}
