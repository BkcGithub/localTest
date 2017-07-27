package designpattern.prototypepattern;

/**
 * Created by bkc on 2017/7/27.
 */
public class Circle extends Shape {
    public Circle() {
        type = "Circle";
    }
    void draw() {
        System.out.println("Circle draw method");
    }
}
