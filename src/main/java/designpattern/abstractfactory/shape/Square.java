package designpattern.abstractfactory.shape;

import designpattern.abstractfactory.shape.Shape;

/**
 * Created by bkc on 2017/6/23.
 */
public class Square implements Shape {
    public void draw() {
        System.out.println("square");
    }
}
