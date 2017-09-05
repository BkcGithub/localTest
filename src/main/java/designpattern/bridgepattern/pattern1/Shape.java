package designpattern.bridgepattern.pattern1;

/**
 * Created by bkc on 2017/7/27.
 */
public abstract class Shape {
    protected DrawApi drawApi;
    protected Shape(DrawApi drawApi) {
        this.drawApi = drawApi;
    }

    protected abstract void draw();
}

