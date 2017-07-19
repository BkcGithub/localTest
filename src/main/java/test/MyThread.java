package test;

/**
 * Created by bkc on 26/04/2017.
 */
public class MyThread extends Thread{

    @Override public void run() {
        System.out.println("sdsd");
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.run();
    }
}
