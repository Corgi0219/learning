package concurrent.ch1;

/**
 * @author Chengliming
 * @create 2021-01-23 2:41 PM
 **/
public class Test {
    private long count = 0;

    private void add10K() {
        int idx = 0;
        while (idx++ < 10000) {
            count++;
        }
    }

    public static long clac() throws InterruptedException {
        final Test test = new Test();

        Thread t1 = new Thread(test::add10K);
        Thread t2 = new Thread(test::add10K);

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        return test.count;
    }

    public static void main(String[] args) {
        try {
            System.out.println(clac());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
