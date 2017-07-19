package designpattern.abstractfactory;

import designpattern.abstractfactory.color.Color;
import designpattern.abstractfactory.shape.Shape;

/**
 * Created by bkc on 2017/6/23.
 */
public abstract class AbstractFactory {
    abstract Color getColor(String color);
    abstract Shape getShape(String shape);
}
