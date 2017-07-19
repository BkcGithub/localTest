package designpattern.normalfactory;

/**
 * Created by bkc on 2017/6/23.
 */
public class ShapeFactory {
    public Shape getShape(String shapeType) {
        if (null == shapeType
            || "".equals(shapeType)) {
            return null;
        }

        if (shapeType.equalsIgnoreCase("circle")) {
            return new Circle();
        }

        if (shapeType.equalsIgnoreCase("rectangle")) {
            return new Rectangle();
        }

        if (shapeType.equalsIgnoreCase("square")) {
            return new Square();
        }

        return null;
    }
}
