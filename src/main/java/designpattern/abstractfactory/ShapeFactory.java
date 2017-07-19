package designpattern.abstractfactory;

import designpattern.abstractfactory.color.Color;
import designpattern.abstractfactory.shape.Circle;
import designpattern.abstractfactory.shape.Rectangle;
import designpattern.abstractfactory.shape.Shape;
import designpattern.abstractfactory.shape.Square;

/**
 * Created by bkc on 2017/6/23.
 */
public class ShapeFactory extends AbstractFactory{
    Color getColor(String color) {

        return null;
    }

    Shape getShape(String shape) {
        if (null == shape
            || "".equalsIgnoreCase(shape)) {
            return null;
        }
        if ("circle".equalsIgnoreCase(shape)) {
            return new Circle();
        }
        if ("rectangle".equalsIgnoreCase(shape)) {
            return new Rectangle();
        }
        if ("square".equalsIgnoreCase(shape)) {
            return new Square();
        }
        return null;
    }
}
