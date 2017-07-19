package designpattern.singleton;

/**
 * Created by bkc on 2017/7/10.
 * safe
 */
public class Singleton3 {
    private static class SingletonHolder {
        private static final Singleton3 INSTANCE = new Singleton3();
    }

    private Singleton3() {

    }

    public static final Singleton3 getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
