package designpattern.prototypepattern;

/**
 * Created by bkc on 2017/7/27.
 */
public class Rectangle extends Shape {
    public Rectangle() {
        type = "Rectangle";
    }

    void draw() {
        System.out.println("Rectangle draw method");
    }
}
