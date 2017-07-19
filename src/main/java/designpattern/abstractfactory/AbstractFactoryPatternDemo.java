package designpattern.abstractfactory;

import designpattern.abstractfactory.color.Color;
import designpattern.abstractfactory.shape.Shape;

/**
 * Created by bkc on 2017/6/23.
 */
public class AbstractFactoryPatternDemo {
    public static void main(String[] args) {
        AbstractFactory shapeFactory = FactoryProducer.getFactory("Shape");

        try {
            Shape shape1 = shapeFactory.getShape("circle");
            shape1.draw();

            /*Color color1 = shapeFactory.getColor("blue");
            color1.fill();*/
        } catch (Exception e) {
            e.printStackTrace();
        }


        AbstractFactory colorFactory = FactoryProducer.getFactory("color");
        try {
            /*Shape shape2 = colorFactory.getShape("circle");
            shape2.draw();*/

            Color color2 = colorFactory.getColor("red");
            color2.fill();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
