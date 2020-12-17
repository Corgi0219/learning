package cn.com.mcfly.gctest;

/**
 * @author Chengliming
 * @create 2020-12-14 4:01 PM
 **/
public class SafePointTest {
    static double sum = 0;

    public static void foo() {
        for (int i = 0; i < 0x77777777; i++) {
            sum += Math.sqrt(i);
        }
    }

    public static void bar() {
        for (int i = 0; i < 50000000; i++) {
            new Object().hashCode();
        }
    }

    public static void main(String[] args) {
        new Thread(SafePointTest::foo).start();
//        new Thread(SafePointTest::bar).start();
    }
}
