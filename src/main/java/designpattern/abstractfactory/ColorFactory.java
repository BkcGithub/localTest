package designpattern.abstractfactory;

import designpattern.abstractfactory.color.Blue;
import designpattern.abstractfactory.color.Color;
import designpattern.abstractfactory.color.Green;
import designpattern.abstractfactory.color.Red;
import designpattern.abstractfactory.shape.Shape;

/**
 * Created by bkc on 2017/6/23.
 */
public class ColorFactory extends AbstractFactory {
    Color getColor(String color) {
        if (null == color
            || "".equals(color)) {

            return null;
        }
        if ("green".equalsIgnoreCase(color)) {
            return new Green();
        }
        if ("red".equalsIgnoreCase(color)) {
            return new Red();
        }
        if ("blue".equalsIgnoreCase(color)) {
            return new Blue();
        }
        return null;
    }

    Shape getShape(String shape) {
        return null;
    }
}
