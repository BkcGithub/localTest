package test;

/**
 * Created by bkc on 26/04/2017.
 */
public class MyRunnable implements Runnable {
    public void run() {
        System.out.println("sdufnkjasd");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable());
        thread.start();
    }
}
