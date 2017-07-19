package designpattern.abstractfactory;

/**
 * Created by bkc on 2017/6/23.
 */
public class FactoryProducer {
    public static AbstractFactory getFactory(String choice) {
        if (null == choice
            || "".equals(choice)) {
            return null;
        }

        if ("color".equalsIgnoreCase(choice)) {
            return new ColorFactory();
        }

        if ("shape".equalsIgnoreCase(choice)) {
            return new ShapeFactory();
        }
        return null;
    }
}
