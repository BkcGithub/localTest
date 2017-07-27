package designpattern.prototypepattern;

/**
 * Created by bkc on 2017/7/27.
 */
public class Square extends Shape {
    public Square() {
        type = "Square";
    }
    void draw() {
        System.out.println("Square draw method");
    }
}
