package concurrent.ch2;

/**
 * @author Chengliming
 * @create 2021-01-20 4:42 PM
 **/
public class VolatileExample {
    static int x = 0;
    volatile boolean v = false;

    public void write() {
        x = 42;
        v = true;
    }

    public void reader() {
        if (v) {
            System.out.println(x);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
//            synchronized (this){
                x = 77;
//            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        thread.join();
        System.out.println(x);
    }
}
