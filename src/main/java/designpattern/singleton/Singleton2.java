package designpattern.singleton;

/**
 * Created by bkc on 2017/7/10.
 * safe
 */
public class Singleton2 {
    private static Singleton2 instance = new Singleton2();

    private Singleton2() {
    }

    public static Singleton2 getInstance() {
        return instance;
    }
}
