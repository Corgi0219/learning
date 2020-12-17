package singleton;

/**
 * @author Chengliming
 * @create 2020-12-11 3:17 下午
 **/
public class Foo1 {
    private int tryBlock;
    private int catchBlock;
    private int finallyBlock;
    private int methodExit;

    public void test() {
        try {
            tryBlock = 0;
        } catch (Exception e) {
            catchBlock = 1;
        } finally {
            finallyBlock = 2;
        }
        methodExit = 3;
    }
}
